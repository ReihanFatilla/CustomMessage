package com.reift.message;

import com.reift.message.command.MessageCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Message extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        new MessageCommand(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
