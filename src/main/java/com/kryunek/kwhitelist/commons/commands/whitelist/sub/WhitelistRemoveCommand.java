package com.kryunek.kwhitelist.commons.commands.whitelist.sub;

import com.kryunek.kwhitelist.utils.CC;
import com.kryunek.kwhitelist.utils.command.BaseCommand;
import com.kryunek.kwhitelist.utils.command.Command;
import com.kryunek.kwhitelist.utils.command.CommandArgs;
import org.bukkit.command.CommandSender;
import com.kryunek.kwhitelist.kWhiteList;

public class WhitelistRemoveCommand extends BaseCommand {


    @Command(name = "whitelist.remove", permission = "kwhitelist.command.whitelist.remove", inGameOnly = false)
    @Override
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();
        String[] args = command.getArgs();

        if (args.length < 1) {
            sender.sendMessage(CC.translate("&cUsage /whitelist remove <name>"));
            return;
        }
        String name = args[0];
        if (!kWhiteList.get().getWhitelistManager().isWhitelisted(name)) {
            sender.sendMessage(CC.translate("&4" + name + " &cis not in the whitelist."));

        } else {
            kWhiteList.get().getWhitelistManager().removeWhitelist(name);
            sender.sendMessage(CC.translate("&7" + name + " &fhas been removed from the whitelist."));
        }

    }
}
