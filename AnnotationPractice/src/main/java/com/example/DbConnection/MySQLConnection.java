package com.example.DbConnection;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "sqlconnection",
        value = "enabled",
        havingValue = "true",
        matchIfMissing = false
       )
public class MySQLConnection {

    public MySQLConnection() {
        System.out.println("MySQLConnection constructor");
    }
}
