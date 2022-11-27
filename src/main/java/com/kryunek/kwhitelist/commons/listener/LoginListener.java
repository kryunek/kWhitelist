package com.kryunek.kwhitelist.commons.listener;

import com.kryunek.kwhitelist.commons.whitelist.WhitelistManager;
import com.kryunek.kwhitelist.utils.CC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import com.kryunek.kwhitelist.kWhiteList;

public class LoginListener implements Listener {


    @EventHandler
    private void onLogin(PlayerLoginEvent event) {

        WhitelistManager whitelist = kWhiteList.get().getWhitelistManager();
        Player player = event.getPlayer();

        if (whitelist.isWhitelisted()) {
            if (!whitelist.isWhitelisted(player.getDisplayName())) {

                event.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, kWhiteList.get().getMainConfig().getString("no-whitelisted"));
            }
        }
    }
}
