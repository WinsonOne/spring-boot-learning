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
 * @create 2018-01-08 21:28
 */
@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "primaryEntityManageFactory",
        transactionManagerRef = "primaryTransactionManager",
        basePackages = "xyz.theone.springbootlearning.multidatasource.p.dao")
@EnableTransactionManagement
public class PrimaryConfig {

    @Autowired
    @Qualifier("primaryDataSource")
    private DataSource primaryDataSource;

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Primary
    @Bean(name = "primaryTransactionManager")
    public PlatformTransactionManager primaryTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(primaryEntityManageFactory(builder).getObject());
    }

    @Bean(name = "primaryEntityManageFactory")
    public LocalContainerEntityManagerFactoryBean primaryEntityManageFactory(EntityManagerFactoryBuilder builder){
        return builder.dataSource(primaryDataSource)
                .properties(getVendorProperties(primaryDataSource))
                .packages("xyz.theone.springbootlearning.multidatasource.p")
                .persistenceUnit("primaryPersistenceUnit")
                .build();
    }

    @Bean(name = "primaryEntityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder){
        return primaryEntityManageFactory(builder).getObject().createEntityManager();
    }
}
