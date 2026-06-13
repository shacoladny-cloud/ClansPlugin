package com.artic.clans.bukkit.command;

import com.artic.clans.api.ClanManager;
import org.bukkit.entity.Player;

public class CreateCommand implements SubCommand {
    private final ClanManager manager;

    public CreateCommand(ClanManager manager) { this.manager = manager; }

    @Override
    public void execute(Player player, String[] args) {
        if (args.length < 2) {
            player.sendMessage("§c/clan create <название> <тег>");
            return;
        }
        String name = args[0];
        String tag = args[1];
        manager.createClan(name, tag, player.getUniqueId())
                .thenAccept(clan -> {
                    player.sendMessage("§aКлан " + clan.getName() + " создан!");
                })
                .exceptionally(ex -> {
                    player.sendMessage("§cОшибка: " + ex.getMessage());
                    return null;
                });
    }
}