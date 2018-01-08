package xyz.theone.springbootlearning.multidatasource.p.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.theone.springbootlearning.multidatasource.p.model.User;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @outhor winson
 * @create 2018-01-08 21:59
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
