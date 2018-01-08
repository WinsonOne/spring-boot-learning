package xyz.theone.springbootlearning.multidatasource.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @outhor winson
 * @create 2018-01-08 21:47
 */
@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "secondEntityManageFactory",
        transactionManagerRef = "secondTransactionManager",
        basePackages = "xyz.theone.springbootlearning.multidatasource.s.dao")
@EnableTransactionManagement
public class SecondConfig {

    @Autowired
    @Qualifier("secondDataSource")
    private DataSource secondDataSource;

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Primary
    @Bean(name = "secondTransactionManager")
    public PlatformTransactionManager secondTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(secondEntityManageFactory(builder).getObject());
    }

    @Bean(name = "secondEntityManageFactory")
    public LocalContainerEntityManagerFactoryBean secondEntityManageFactory(EntityManagerFactoryBuilder builder){
        return builder.dataSource(secondDataSource)
                .properties(getVendorProperties(secondDataSource))
                .packages("xyz.theone.springbootlearning.multidatasource.s")
                .persistenceUnit("secondPersistenceUnit")
                .build();
    }

    @Bean(name = "secondEntityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder){
        return secondEntityManageFactory(builder).getObject().createEntityManager();
    }
}
