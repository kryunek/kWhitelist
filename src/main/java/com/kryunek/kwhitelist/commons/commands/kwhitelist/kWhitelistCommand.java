package com.kryunek.kwhitelist.commons.commands.kwhitelist;

import com.kryunek.kwhitelist.utils.CC;
import com.kryunek.kwhitelist.utils.command.BaseCommand;
import com.kryunek.kwhitelist.utils.command.Command;
import com.kryunek.kwhitelist.utils.command.CommandArgs;
import org.bukkit.command.CommandSender;
import com.kryunek.kwhitelist.kWhiteList;
import com.kryunek.kwhitelist.commons.commands.kwhitelist.sub.kWhitelistInfoCommand;
import com.kryunek.kwhitelist.commons.commands.kwhitelist.sub.kWhitelistReloadCommand;

public class kWhitelistCommand extends BaseCommand {

    public kWhitelistCommand() {
        new kWhitelistInfoCommand();
        new kWhitelistReloadCommand();
    }

    @Command(name = "kwhitelist", inGameOnly = false)
    @Override
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();
        String label = command.getLabel();

        sender.sendMessage(CC.CHAT_BAR);
        sender.sendMessage(CC.translate("&7&lkWhitelist Help"));
        sender.sendMessage(CC.translate(""));
        sender.sendMessage(CC.translate("&f/" + label + " info &7Gives you info of the plugin."));
        sender.sendMessage(CC.translate("&f/" + label + " reload  &7Reloads plugin files."));
        sender.sendMessage(CC.CHAT_BAR);
    }

}