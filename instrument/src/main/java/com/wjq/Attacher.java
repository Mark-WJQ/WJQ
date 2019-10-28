package com.wjq;



import com.sun.management.ThreadMXBean;
import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import sun.tools.jar.resources.jar;

import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.util.Set;

public class Attacher {


    public static void main(String[] args) throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException, MalformedObjectNameException {
        VirtualMachine vm = VirtualMachine.attach("21614");
        vm.loadAgent("/Users/wangjianqiang/IdeaProjects/WJQ/instrument/target/sandbox-agent-1.0-SNAPSHOT-jar-with-dependencies.jar","agent");
        vm.detach();



/*
        String connectorAddr = vm.getAgentProperties().getProperty(
                "com.sun.management.jmxremote.localConnectorAddress");
        if (connectorAddr == null) {
            String agent = vm.getSystemProperties().getProperty(
                    "java.home")+ File.separator+"lib"+File.separator+
                    "management-agent.jar";
            vm.loadAgent(agent);
            connectorAddr = vm.getAgentProperties().getProperty(
                    "com.sun.management.jmxremote.localConnectorAddress");
        }
        JMXServiceURL serviceURL = new JMXServiceURL(connectorAddr);
        JMXConnector connector = JMXConnectorFactory.connect(serviceURL);
        MBeanServerConnection mbsc = connector.getMBeanServerConnection();
        ObjectName objName = new ObjectName(
                ManagementFactory.THREAD_MXBEAN_NAME);
        Set<ObjectName> mbeans = mbsc.queryNames(objName, null);
        for (ObjectName name: mbeans) {
            ThreadMXBean threadBean;
            threadBean = ManagementFactory.newPlatformMXBeanProxy(
                    mbsc, name.toString(), ThreadMXBean.class);
            long threadIds[] = threadBean.getAllThreadIds();
            for (long threadId: threadIds) {
                ThreadInfo threadInfo = threadBean.getThreadInfo(threadId);
                System.out.println (threadInfo.getThreadName() + " / " +
                        threadInfo.getThreadState());
            }

        }*/



    }
}
