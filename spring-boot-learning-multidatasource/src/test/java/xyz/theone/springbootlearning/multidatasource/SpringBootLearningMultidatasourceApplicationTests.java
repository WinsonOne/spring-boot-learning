package xyz.theone.springbootlearning.multidatasource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.theone.springbootlearning.multidatasource.p.dao.UserRepository;
import xyz.theone.springbootlearning.multidatasource.p.model.User;
import xyz.theone.springbootlearning.multidatasource.s.dao.SecondUserRepository;
import xyz.theone.springbootlearning.multidatasource.s.model.SecondUser;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootLearningMultidatasourceApplication.class)
public class SpringBootLearningMultidatasourceApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SecondUserRepository secondUserRepository;

	@Test
	public void test(){
		userRepository.deleteAll();
		userRepository.save(new User("ABC", 10));
		userRepository.save(new User("BBB", 20));
		Assert.assertEquals(2, userRepository.findAll().size());

		secondUserRepository.deleteAll();
		secondUserRepository.save(new SecondUser("ABC", 10));
		Assert.assertEquals(1, secondUserRepository.findAll().size());
	}

}
