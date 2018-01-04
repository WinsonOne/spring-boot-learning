package xyz.theone.springbootlearning.mybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xyz.theone.springbootlearning.mybatis.model.User;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @outhor winson
 * @create 2018-01-04 23:15
 */
@Mapper
public interface UserMapper {

    /**
     * 新增用户
     * @param name
     * @param age
     * @return
     */
    @Insert("insert into tb_user(name,age) values(#{name},#{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    /**
     * 根据用户名查找用户
     * @param name
     * @return
     */
    @Select("select id,name,age from tb_user where name = #{name}")
    User findByName(@Param("name") String name);
}
