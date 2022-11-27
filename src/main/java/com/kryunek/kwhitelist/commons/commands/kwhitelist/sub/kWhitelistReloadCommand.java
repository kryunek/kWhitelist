package com.kryunek.kwhitelist.commons.commands.kwhitelist.sub;

import com.kryunek.kwhitelist.kWhiteList;
import com.kryunek.kwhitelist.utils.CC;
import com.kryunek.kwhitelist.utils.command.BaseCommand;
import com.kryunek.kwhitelist.utils.command.Command;
import com.kryunek.kwhitelist.utils.command.CommandArgs;
import org.bukkit.command.CommandSender;

public class kWhitelistReloadCommand extends BaseCommand {

    @Command(name = "kwhitelist.reload", permission = "kwhitelist.command.reload", inGameOnly = false)
    @Override
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();

        kWhiteList.get().getMainConfig().reload();
        kWhiteList.get().getWhitelistManager().load();
        sender.sendMessage(CC.translate("&akWhitelist has been reloaded."));
    }
}