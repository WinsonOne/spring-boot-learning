package xyz.theone.springbootlearning.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.theone.springbootlearning.jpa.model.User;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @outhor winson
 * @create 2018-01-01 23:21
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findByName(String name);

    User findByNameAndAge(String name, Integer age);
}
