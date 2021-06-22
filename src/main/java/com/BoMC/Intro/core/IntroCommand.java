package com.BoMC.Intro.core;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.BoMC.Intro.Intro;

public class IntroCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender instanceof Player && sender.hasPermission("bomci.intro")) {
			
			Intro.display((Player) sender);
			return true;
			
		}
		
		return false;
		
	}

}
