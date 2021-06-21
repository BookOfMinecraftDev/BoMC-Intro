package com.BoMC.Intro.core;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import com.BoMC.Intro.Intro;

public class LoginListener implements Listener {

	private Intro plugin;

	public LoginListener(Intro pl) {
		plugin = pl;
	}

	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent event) {
		if (!plugin.hasDisplayed(event.getPlayer())) {

			plugin.display(event.getPlayer());

			plugin.addDisplayed(event.getPlayer());
		}
	}
}
