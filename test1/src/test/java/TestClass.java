import javax.servlet.ServletContext;

import com.test.wjq.controller.FirstClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by Administrator on 2016/11/25.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:config/spring-mvc.xml","classpath*:config/applicationContext.xml"})
public class TestClass {

    @Autowired
    private FirstClass fc;
    @Autowired
    ServletContext context;
    MockMvc mockMvc;
    @Before
    public  void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(fc).build();
    }

    @Test
    public  void test(){
        try {
            ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/firstClass/firstMethod").param("userName","liubeibei").accept(MediaType.APPLICATION_JSON));
            MvcResult mvcResult = resultActions.andReturn();
            String result = mvcResult.getResponse().getContentAsString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
