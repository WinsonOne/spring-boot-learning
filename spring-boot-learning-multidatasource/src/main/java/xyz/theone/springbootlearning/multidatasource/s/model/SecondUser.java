package xyz.theone.springbootlearning.multidatasource.s.model;

import javax.persistence.*;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @outhor winson
 * @create 2018-01-08 21:53
 */
@Entity
@Table(name = "tb_second_user")
public class SecondUser {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public SecondUser(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public SecondUser() {
    }
}
