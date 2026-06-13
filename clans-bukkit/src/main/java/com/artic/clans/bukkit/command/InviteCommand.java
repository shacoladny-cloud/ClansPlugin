package com.artic.clans.bukkit.command;

import com.artic.clans.api.ClanManager;
import org.bukkit.entity.Player;

public class InviteCommand implements SubCommand {
    private final ClanManager manager;
    public InviteCommand(ClanManager manager) { this.manager = manager; }
    @Override
    public void execute(Player player, String[] args) {
        player.sendMessage("§cКоманда /clan invite пока не реализована");
    }
}