import com.wecash.wjq.controller.FirstClass;
import com.wecash.wjq.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Administrator on 2016/11/25.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:config/spring-mvc.xml","classpath*:config/applicationContext.xml"})
public class TestClass1 {


    @Mock
    private UserService userService;
    @InjectMocks
    private FirstClass fc;
    private MockMvc mockMvc;

    @Before
    public  void setup(){
        // initialize mock object
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(fc).build();

    }


    @Test
    public  void test(){
       /* Long id = userService.getIdByName("liubeibei");
        System.out.print(id);*/

        try {
            when(userService.getIdByName("liubeibei")).thenReturn(1l);
            mockMvc.perform(post("/firstClass/firstMethod")
                    .param("userName", "liubeibei"))
                    .andExpect(status().isOk());

          /*  ResultActions resultActions = mockMvc.perform(post("/firstClass/firstMethod").accept(MediaType.APPLICATION_JSON));
            MvcResult mvcResult = resultActions.andReturn();
            String result = mvcResult.getResponse().getContentAsString();
            System.out.println(result);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        //FirstClass firstClass = new FirstClass();
        //firstClass.firstMethod();
        System.out.print("ddd");
    }

}
