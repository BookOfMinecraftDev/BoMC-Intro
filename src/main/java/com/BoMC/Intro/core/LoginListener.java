package com.BoMC.Intro.core;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.BoMC.Intro.Intro;

public class LoginListener implements Listener {

	@EventHandler
	public void onPlayerLogin(PlayerJoinEvent event) {
		
		if (!Intro.seen.contains(event.getPlayer().getUniqueId())) {

			Intro.display(event.getPlayer());

			Intro.seen.add(event.getPlayer().getUniqueId());
			
		}
		
	}
	
}
