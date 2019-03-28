package com.akash.cassandra.config;

import com.datastax.driver.core.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${cassandra.contactpoints}")
    private String contactPoints;

    @Value("${cassandra.port}")
    private int port;

    @Value("${cassandra.keyspace}")
    private String keySpace;

    @Value("${cassandra.basepackages}")
    private String basePackages;

    public SchemaAction getSchemaAction() {
        return SchemaAction.RECREATE_DROP_UNUSED;
    }

    @Override
    protected String getKeyspaceName() {
        return keySpace;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{basePackages};
    }

    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setJmxReportingEnabled(false);
        cluster.setContactPoints(contactPoints);
        cluster.setPort(port);
        return cluster;
    }

    @Bean("cassandraSession")
    public Session cassandraSession() {
        return getRequiredSession();
    }
}