package com.credi.config;

import org.springframework.stereotype.Component;
import org.hibernate.resource.jdbc.spi.StatementInspector;

@Component
public class HibernateInterceptor implements StatementInspector {
    @Override
    public String inspect(String sql) {
        System.out.println("Query Executada: " + sql);
        return sql;
    }
}
