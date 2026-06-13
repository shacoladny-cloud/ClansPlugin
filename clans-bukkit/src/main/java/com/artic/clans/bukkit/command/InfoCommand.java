package com.artic.clans.bukkit.command;

import com.artic.clans.api.ClanManager;
import org.bukkit.entity.Player;

public class InfoCommand implements SubCommand {
    private final ClanManager manager;
    public InfoCommand(ClanManager manager) { this.manager = manager; }
    @Override
    public void execute(Player player, String[] args) {
        player.sendMessage("§cКоманда /clan info пока не реализована");
    }
}