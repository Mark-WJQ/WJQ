package com.wjq.stateMachine;

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.test.StateMachineTestPlan;
import org.springframework.statemachine.test.StateMachineTestPlanBuilder;

import static org.hamcrest.Matchers.*;

public class TestMachine {

    private static StateMachine<String, String> buildMachine() throws Exception {
        StateMachineBuilder.Builder<String, String> builder = StateMachineBuilder.builder();

        builder.configureConfiguration()
                .withConfiguration()
                .autoStartup(true);

        builder.configureStates()
                .withStates()
                .initial("SI")
                .state("S1").state("S2");

        builder.configureTransitions()
                .withExternal()
                .source("SI").target("S1")
                .event("E1").guard(c -> false)
                .action(c -> {
                    c.getExtendedState().getVariables().put("key1", "value1");
                    System.out.println(c.getMessageHeader("数据"));
                });
        builder.configureTransitions().withExternal().event("E1").target("S1").source("S2").action(c ->{
            System.out.println("--------------");
        });


        return builder.build();
    }


    public static void main(String[] args) throws Exception {
        StateMachine<String, String> machine = buildMachine();
        StateMachineTestPlan<String, String> plan =
                StateMachineTestPlanBuilder.<String, String>builder()
                        .defaultAwaitTime(2)
                        .stateMachine(machine)
                        .step()
                        .expectStates("SI")
                        .and()
                        .step()
                        .sendEvent(MessageBuilder.withPayload("E1").setHeader("数据", "有数据在").build())
                        .expectStateChanged(1)
                        .expectStates("S1")
                        .expectVariable("key1")
                        .expectVariable("key1", "value1")
                        .expectVariableWith(hasKey("key1"))
                        .expectVariableWith(hasValue("value1"))
                        .expectVariableWith(hasEntry("key1", "value1"))
                        .expectVariableWith(not(hasKey("key2")))
                        .and()
                        .build();
        plan.test();
    }
}
