package com.kryunek.kwhitelist.commons.commands.whitelist.sub;

import com.kryunek.kwhitelist.kWhiteList;
import com.kryunek.kwhitelist.utils.CC;
import com.kryunek.kwhitelist.utils.command.BaseCommand;
import com.kryunek.kwhitelist.utils.command.Command;
import com.kryunek.kwhitelist.utils.command.CommandArgs;
import org.bukkit.command.CommandSender;

public class WhitelistListCommand extends BaseCommand {


    @Command(name = "whitelist.list", permission = "kwhitelist.command.whitelist.list", inGameOnly = false)
    @Override
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();


        StringBuilder playerList = new StringBuilder();
        kWhiteList.get().getWhitelistManager().getWhiteLists().forEach(players -> {
            if (kWhiteList.get().getWhitelistManager().getWhiteLists().contains(players)) {
                if (playerList.length() > 0) {
                    playerList.append(", ");
                }
                playerList.append(players);
            }
        });
        sender.sendMessage(CC.CHAT_BAR);
        sender.sendMessage(CC.translate("&f&lWhitelisted Players"));
        sender.sendMessage(CC.translate("&7" + playerList));
        sender.sendMessage(CC.CHAT_BAR);

    }
}

