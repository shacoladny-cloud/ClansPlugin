package com.artic.clans.bukkit.command;

import org.bukkit.entity.Player;

public interface SubCommand {
    void execute(Player player, String[] args);
}