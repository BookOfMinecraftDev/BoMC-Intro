package com.bomc.intro;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IntroCommand implements CommandExecutor {

	private IntroPlugin plugin;

	public IntroCommand(IntroPlugin p) {
		plugin = p;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to access that command!");
			return false;
		}
		Player player = (Player) sender;
		plugin.display(player);
		player.sendMessage("Displaying introduction");
		return true;
	}

}
