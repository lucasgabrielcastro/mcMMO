package com.gmail.nossr50.commands.mc;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.nossr50.commands.CommandHelper;
import com.gmail.nossr50.datatypes.PlayerProfile;
import com.gmail.nossr50.locale.LocaleLoader;
import com.gmail.nossr50.util.Users;

public class McgodCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (CommandHelper.noConsoleUsage(sender)) {
            return true;
        }

        if (CommandHelper.noCommandPermissions(sender, "mcmmo.tools.mcgod")) {
            return true;
        }

        PlayerProfile PP = Users.getProfile((Player) sender);

        if (PP.getGodMode()) {
            sender.sendMessage(LocaleLoader.getString("Commands.GodMode.Disabled"));
        }
        else {
            sender.sendMessage(LocaleLoader.getString("Commands.GodMode.Enabled"));
        }

        PP.toggleGodMode();

        return true;
    }
}
