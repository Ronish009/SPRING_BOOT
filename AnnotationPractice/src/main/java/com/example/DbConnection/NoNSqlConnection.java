package com.example.DbConnection;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "nosqlconnection",
        value = "enabled",
        havingValue = "true",
        matchIfMissing = false
       )
public class NoNSqlConnection {
    public NoNSqlConnection() {
        System.out.println("NoNSqlConnection()");
    }
}
