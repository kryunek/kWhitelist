package com.kryunek.kwhitelist.commons.commands.kwhitelist.sub;

import com.kryunek.kwhitelist.kWhiteList;
import com.kryunek.kwhitelist.utils.CC;
import com.kryunek.kwhitelist.utils.command.BaseCommand;
import com.kryunek.kwhitelist.utils.command.Command;
import com.kryunek.kwhitelist.utils.command.CommandArgs;
import org.bukkit.command.CommandSender;

public class kWhitelistInfoCommand extends BaseCommand {

    @Command(name = "kwhitelist.info", inGameOnly = false)
    @Override
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();

        sender.sendMessage(CC.CHAT_BAR);
        sender.sendMessage(CC.translate("&f✩ &7&lkWhitelist &f✩"));
        sender.sendMessage(CC.translate(""));
        sender.sendMessage(CC.translate("&fAuthor: &7" + kWhiteList.get().getDescription().getAuthors()));
        sender.sendMessage(CC.translate("&fVersion: &7" + kWhiteList.get().getDescription().getVersion()));
        sender.sendMessage(CC.CHAT_BAR);
    }
}