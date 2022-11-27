package com.kryunek.kwhitelist.commons.commands.whitelist.sub;

import com.kryunek.kwhitelist.utils.CC;
import com.kryunek.kwhitelist.utils.command.BaseCommand;
import com.kryunek.kwhitelist.utils.command.Command;
import com.kryunek.kwhitelist.utils.command.CommandArgs;
import org.bukkit.command.CommandSender;
import com.kryunek.kwhitelist.kWhiteList;

public class WhitelistAddCommand extends BaseCommand {


    @Command(name = "whitelist.add", permission = "kwhitelist.command.whitelist.add", inGameOnly = false)
    @Override
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();
        String[] args = command.getArgs();

        if (args.length < 1) {
            sender.sendMessage(CC.translate("&cUsage /whitelist add <name>"));
            return;
        }
        String name = args[0];
        if (kWhiteList.get().getWhitelistManager().isWhitelisted(name)) {
            sender.sendMessage(CC.translate("&4" + name + " &cis already in the whitelist."));
            
        } else {
            kWhiteList.get().getWhitelistManager().addWhitelist(name);
            sender.sendMessage(CC.translate("&7" + name + " &fhas been added to the whitelist."));
        }

    }
}
