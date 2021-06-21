package com.bomc.intro;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class LoginListener implements Listener {

	private IntroPlugin plugin;

	public LoginListener(IntroPlugin pl) {
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
