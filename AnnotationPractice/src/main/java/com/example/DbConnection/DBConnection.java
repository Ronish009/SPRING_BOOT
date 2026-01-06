package com.example.DbConnection;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBConnection {

    DBConnection() {
        System.out.println("DBConnection");
    }
    @Autowired
    MySQLConnection mySQLConnection;

    @Autowired(required = false)
    NoNSqlConnection noNSqlConnection;

    @PostConstruct
    void init(){
        System.out.println("MySQL Connection"+mySQLConnection);
        System.out.println("noNSqlConnection"+noNSqlConnection);
    }
}
