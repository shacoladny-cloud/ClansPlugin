package com.artic.clans.bukkit.command;

import com.artic.clans.api.ClanManager;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.*;

public class ClanCommand implements CommandExecutor {
    private final ClanManager manager;
    private final Map<String, SubCommand> subCommands = new HashMap<>();

    public ClanCommand(ClanManager manager) {
        this.manager = manager;
        subCommands.put("create", new CreateCommand(manager));
        subCommands.put("invite", new InviteCommand(manager));
        subCommands.put("accept", new AcceptCommand(manager));
        subCommands.put("info", new InfoCommand(manager));
        // добавьте другие подкоманды по мере необходимости
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Только для игроков");
            return true;
        }
        if (args.length == 0) {
            player.sendMessage("Использование: /clan create|invite|accept|info");
            return true;
        }
        SubCommand sub = subCommands.get(args[0].toLowerCase());
        if (sub == null) {
            player.sendMessage("Неизвестная подкоманда");
            return true;
        }
        sub.execute(player, Arrays.copyOfRange(args, 1, args.length));
        return true;
    }
}