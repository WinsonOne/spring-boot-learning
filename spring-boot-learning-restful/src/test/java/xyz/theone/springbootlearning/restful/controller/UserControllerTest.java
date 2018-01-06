package xyz.theone.springbootlearning.restful.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import xyz.theone.springbootlearning.restful.SpringBootLearningRestfulApplication;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @outhor winson
 * @create 2018-01-05 23:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringBootLearningRestfulApplication.class, MockServletContext.class})
public class UserControllerTest {

    @Test
    public void testUserController() throws Exception {
        // 新增用户
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/add")
                .param("id","1")
                .param("name", "AAA")
                .param("age", "10");
        mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content().string("true"));
        // 查找用户
        requestBuilder = MockMvcRequestBuilders.get("/user/1");
        mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content().string("{\"id\":1,\"name\":\"AAA\",\"age\":10}"));
        // 修改用户
        requestBuilder = MockMvcRequestBuilders.post("/user/update")
                .param("id","1")
                .param("name", "AAA")
                .param("age", "12");
        mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content().string("true"));
        // 删除用户
        requestBuilder = MockMvcRequestBuilders.get("/user/delete/1");
        mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content().string("true"));
        // 查找所有用户
        requestBuilder = MockMvcRequestBuilders.get("/user/list");
        mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Before
    public void before(){
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    private MockMvc mockMvc;

}