package com.reift.message.command;

import com.reift.message.Message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCommand implements CommandExecutor {

    Message plugin;

    public MessageCommand(Message plugin){
        this.plugin = plugin;
        plugin.getCommand("msg").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if(args.length <= 2){
            Player targetPlayer = Bukkit.getPlayerExact(args[1]);
            StringBuilder msg = new StringBuilder();

            for(int i = 1 ; i < args.length ; i++){
                msg.append(args[i]);
                msg.append(" ");
            }

            String finalMSg = msg.toString();

            targetPlayer.sendMessage(getConfigMessage("fromMsg", targetPlayer.toString(), finalMSg));
            player.sendMessage(getConfigMessage("toMsg", targetPlayer.toString(), finalMSg));

        } else {
            player.sendMessage(plugin.getConfig().getString("erroMsg"));
        }

        return true;
    }

    private String getConfigMessage(String path, String targetPlayer, String message){
        return plugin.getConfig().getString(path)
                .replace("<Player>", targetPlayer)
                .replace("<Message>", message);
    }

}
