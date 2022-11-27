package com.kryunek.kwhitelist;

import com.kryunek.kwhitelist.commons.commands.whitelist.WhitelistCommand;
import com.kryunek.kwhitelist.commons.listener.LoginListener;
import com.kryunek.kwhitelist.commons.whitelist.WhitelistManager;
import com.kryunek.kwhitelist.utils.command.CommandManager;
import com.kryunek.kwhitelist.utils.file.FileConfig;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.plugin.java.JavaPlugin;
import com.kryunek.kwhitelist.commons.commands.kwhitelist.kWhitelistCommand;

import java.util.Arrays;

@Getter
@Setter
public final class kWhiteList extends JavaPlugin {

    @Getter
    public static kWhiteList instance;

    private WhitelistManager whitelistManager;

    private FileConfig mainConfig;

    @Override
    public void onEnable() {
        loadConfig();
        loadWhitelist();
        registerCommands();
        registerListeners();
        this.whitelistManager.load();
    }

    @Override
    public void onDisable() {
    // tetas
    }
    private void loadWhitelist() {
        this.whitelistManager = new WhitelistManager();
    }

    private void registerCommands() {
        new CommandManager(this);
        new kWhitelistCommand();
        new WhitelistCommand();
    }
    private void registerListeners() {
        Arrays.asList(
                new LoginListener()
        ).forEach(listener -> getServer().getPluginManager().registerEvents(listener, this));
    }

    private void loadConfig() {
        this.mainConfig = new FileConfig(this, "config.yml");
    }
    public static kWhiteList get() {
        return getPlugin(kWhiteList.class);
    }

}
