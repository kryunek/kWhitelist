package com.kryunek.kwhitelist.commons.commands.whitelist.sub;

import com.kryunek.kwhitelist.kWhiteList;
import com.kryunek.kwhitelist.utils.CC;
import com.kryunek.kwhitelist.utils.command.BaseCommand;
import com.kryunek.kwhitelist.utils.command.Command;
import com.kryunek.kwhitelist.utils.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class WhitelistToggleCommand extends BaseCommand {


    @Command(name = "whitelist.toggle", permission = "kwhitelist.command.whitelist.toggle", inGameOnly = false)
    @Override
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();
        String[] args = command.getArgs();

        if (args.length < 1) {
            sender.sendMessage(CC.translate("&cUsage /whitelist toggle <on/off>"));
            return;
        }
        if (args[0].equals("on")) {
            if (kWhiteList.get().getWhitelistManager().isWhitelisted()) {
                sender.sendMessage(CC.translate("&cThe whitelist is already enabled."));
                return;
            }
            if (kWhiteList.get().getMainConfig().getBoolean("kick-enabled")) {
                Bukkit.getOnlinePlayers().forEach(players -> {
                    if (!kWhiteList.get().getWhitelistManager().isWhitelisted(players.getDisplayName())) {
                        players.kickPlayer(kWhiteList.get().getMainConfig().getString("no-whitelisted"));
                    }
                });
            }
            kWhiteList.get().getWhitelistManager().setWhitelist(true);
            sender.sendMessage(CC.translate("&aThe whitelist has been enabled."));
        } else if (args[0].equals("off")){
            if (!kWhiteList.get().getWhitelistManager().isWhitelisted()) {
                sender.sendMessage(CC.translate("&cThe whitelist is already disabled."));
                return;
            }
            kWhiteList.get().getWhitelistManager().setWhitelist(false);
            sender.sendMessage(CC.translate("&cThe whitelist has been disabled."));
        }

    }
}