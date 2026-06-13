package com.artic.clans.bukkit;

import com.artic.clans.bukkit.command.ClanCommand;
import com.artic.clans.bukkit.manager.BukkitClanManager;
import com.artic.clans.bukkit.redis.RedisManager;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.bukkit.plugin.java.JavaPlugin;

public class ClanPlugin extends JavaPlugin {
    private static ClanPlugin instance;
    private HikariDataSource dataSource;
    private RedisManager redisManager;
    private BukkitClanManager clanManager;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        // Инициализация HikariCP (пул соединений с MySQL)
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(getConfig().getString("database.url"));
        hikariConfig.setUsername(getConfig().getString("database.user"));
        hikariConfig.setPassword(getConfig().getString("database.password"));
        hikariConfig.setMaximumPoolSize(10);
        dataSource = new HikariDataSource(hikariConfig);

        // Инициализация Redis
        String redisHost = getConfig().getString("redis.host");
        int redisPort = getConfig().getInt("redis.port");
        redisManager = new RedisManager(redisHost, redisPort);

        // Менеджер кланов
        clanManager = new BukkitClanManager(dataSource, redisManager);

        // Регистрация команды
        getCommand("clan").setExecutor(new ClanCommand(clanManager));

        getLogger().info("ClansPlugin enabled!");
    }

    @Override
    public void onDisable() {
        if (dataSource != null) dataSource.close();
        if (redisManager != null) redisManager.close();
        getLogger().info("ClansPlugin disabled.");
    }

    public static ClanPlugin getInstance() { return instance; }
    public BukkitClanManager getClanManager() { return clanManager; }
}