package xyz.theone.springbootlearning.jpa.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.theone.springbootlearning.jpa.SpringBootLearningJpaApplication;
import xyz.theone.springbootlearning.jpa.model.User;


/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @outhor winson
 * @create 2018-01-01 23:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootLearningJpaApplication.class)
public class UserRepositoryTest {
    @Test
    public void findByName() throws Exception {
        userRepository.save(new User("AAA", 10));
        User user = userRepository.findByName("AAA");
        Assert.assertEquals(10, user.getAge().longValue());
    }

    @Test
    public void findByNameAndAge() throws Exception {
        userRepository.save(new User("AAA", 10));
        User user = userRepository.findByNameAndAge("AAA", 10);
        Assert.assertEquals("AAA", user.getName());
    }

    @Autowired
    private UserRepository userRepository;
}