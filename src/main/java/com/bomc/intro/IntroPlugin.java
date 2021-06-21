package com.bomc.intro;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class IntroPlugin extends JavaPlugin {

	private List<String> paragraphs;

	private List<UUID> displayed;

	private int time;

	@Override
	public void onEnable() {
		saveDefaultConfig();
		saveResource("intro.txt", false);

		Stream<String> file = new BufferedReader(new InputStreamReader(getResource("intro.txt"))).lines();
		paragraphs = file.collect(Collectors.toList());

		int i = 1;
		for (String s : paragraphs) {
			getLogger().info("Message " + i + ": '" + s + "'");
		}

		displayed = convertStringToUUID(getConfig().getStringList("players-who-have-seen-intro"));

		time = getConfig().getInt("time-between-messages");

		getServer().getPluginManager().registerEvents(new LoginListener(this), this);

		getCommand("intro").setExecutor(new IntroCommand(this));

		getLogger().info("Enabled!");
	}

	@Override
	public void onDisable() {
		getConfig().set("players-who-have-seen-intro", convertUUIDToString(displayed));
		saveConfig();
		getLogger().info("Disabled!");
	}

	public boolean hasDisplayed(Player player) {
		return displayed.contains(player.getUniqueId());
	}

	public void addDisplayed(Player player) {
		displayed.add(player.getUniqueId());
	}

	public List<String> getParagraphs() {
		return paragraphs;
	}

	public int getTime() {
		return time;
	}

	public void display(Player player) {
		new TitleTask(this, player, paragraphs, time * 5, time * 10, time * 5).runTaskTimer(this, 0, time * 20);
	}

	public List<String> convertUUIDToString(List<UUID> list) {
		List<String> newList = new ArrayList<String>();
		for (UUID id : list) {
			newList.add(id.toString());
		}
		return newList;
	}

	public List<UUID> convertStringToUUID(List<String> list) {
		List<UUID> newList = new ArrayList<UUID>();
		for (String s : list) {
			newList.add(UUID.fromString(s));
		}
		return newList;
	}
}
