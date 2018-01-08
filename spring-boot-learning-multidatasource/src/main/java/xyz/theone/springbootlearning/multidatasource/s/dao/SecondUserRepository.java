package xyz.theone.springbootlearning.multidatasource.s.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.theone.springbootlearning.multidatasource.s.model.SecondUser;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @outhor winson
 * @create 2018-01-08 22:02
 */
public interface SecondUserRepository extends JpaRepository<SecondUser,Long> {
}
