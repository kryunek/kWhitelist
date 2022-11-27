package com.kryunek.kwhitelist.commons.commands.whitelist;

import com.kryunek.kwhitelist.commons.commands.whitelist.sub.WhitelistAddCommand;
import com.kryunek.kwhitelist.commons.commands.whitelist.sub.WhitelistListCommand;
import com.kryunek.kwhitelist.commons.commands.whitelist.sub.WhitelistRemoveCommand;
import com.kryunek.kwhitelist.commons.commands.whitelist.sub.WhitelistToggleCommand;
import com.kryunek.kwhitelist.utils.CC;
import com.kryunek.kwhitelist.utils.command.BaseCommand;
import com.kryunek.kwhitelist.utils.command.Command;
import com.kryunek.kwhitelist.utils.command.CommandArgs;
import org.bukkit.command.CommandSender;

public class WhitelistCommand extends BaseCommand {

    public WhitelistCommand() {
        new WhitelistAddCommand();
        new WhitelistRemoveCommand();
        new WhitelistListCommand();
        new WhitelistToggleCommand();
    }

    @Command(name = "whitelist", inGameOnly = false)
    @Override
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();
        String label = command.getLabel();

        sender.sendMessage(CC.CHAT_BAR);
        sender.sendMessage(CC.translate("&7&lWhitelist Help"));
        sender.sendMessage(CC.translate(""));
        sender.sendMessage(CC.translate("&f/" + label + " toggle <on/off> &7Toggle the whitelist."));
        sender.sendMessage(CC.translate("&f/" + label + " add <player> &7Add a player to the whitelist."));
        sender.sendMessage(CC.translate("&f/" + label + " remove <player>  &7Remove a player from the whitelist."));
        sender.sendMessage(CC.translate("&f/" + label + " list &7Get the players that are in the whitelist."));
        sender.sendMessage(CC.CHAT_BAR);
    }

}