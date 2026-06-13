package com.artic.clans.bukkit.database;

import com.zaxxer.hikari.HikariDataSource;

public class DatabaseManager {
    private final HikariDataSource dataSource;

    public DatabaseManager(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    // Методы для выполнения запросов
}