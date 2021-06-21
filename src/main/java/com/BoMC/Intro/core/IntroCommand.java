package com.BoMC.Intro.core;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.BoMC.Intro.Intro;

public class IntroCommand implements CommandExecutor {

	private Intro plugin;

	public IntroCommand(Intro p) {
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
