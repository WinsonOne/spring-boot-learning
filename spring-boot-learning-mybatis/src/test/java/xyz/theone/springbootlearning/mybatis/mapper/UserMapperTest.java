package xyz.theone.springbootlearning.mybatis.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.theone.springbootlearning.mybatis.SpringBootLearningMybatisApplication;
import xyz.theone.springbootlearning.mybatis.model.User;

import static org.junit.Assert.*;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @outhor winson
 * @create 2018-01-04 23:21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootLearningMybatisApplication.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() throws Exception {
        int count = userMapper.insert("AAA", 10);
        Assert.assertEquals(1, count);
    }

    @Test
    public void findByName() throws Exception {
        User user = userMapper.findByName("AAA");
        Assert.assertEquals(10, user.getAge().intValue());
    }

}