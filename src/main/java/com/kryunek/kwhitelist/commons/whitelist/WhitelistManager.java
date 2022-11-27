package com.kryunek.kwhitelist.commons.whitelist;

import com.kryunek.kwhitelist.kWhiteList;
import com.kryunek.kwhitelist.utils.CC;
import com.kryunek.kwhitelist.utils.file.FileConfig;

import java.util.ArrayList;

public class WhitelistManager {

    private ArrayList<String> whitelist = new ArrayList<>();

    private boolean whitelistEnabled = false;



    public void save() {
        FileConfig config = kWhiteList.get().getMainConfig();
        config.getConfiguration().set("whitelist-players", this.whitelist);
        config.getConfiguration().set("whitelist-enabled", isWhitelisted());
        config.save();
        config.reload();
    }
    public void load() {
        FileConfig config = kWhiteList.get().getMainConfig();
        this.whitelist = new ArrayList<>(config.getStringList("whitelist-players"));
        this.whitelistEnabled = config.getBoolean("whitelist-enabled");
    }

    public boolean isWhitelisted(String name) {
        return this.whitelist.contains(name);
    }

    public void addWhitelist(String name) {
        if (this.whitelist.contains(name))
            return;
        this.whitelist.add(name);
        save();
    }

    public void removeWhitelist(String name) {
        if (!this.whitelist.contains(name))
            return;
        this.whitelist.remove(name);
        save();
    }

    public void setWhitelist(boolean bol) {
        this.whitelistEnabled = bol;
        save();
    }

    public ArrayList<String> getWhiteLists() {
        return this.whitelist;
    }

    public boolean isWhitelisted() {
        return this.whitelistEnabled;
    }

}
