package com.BoMC.Intro;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.BoMC.Intro.core.IO;
import com.BoMC.Intro.core.IntroCommand;
import com.BoMC.Intro.core.LoginListener;
import com.BoMC.Intro.core.Title;

public class Intro extends JavaPlugin {

	public static List<Title> titles;
	public static List<UUID> seen;

	public static int totalLength;
	public static boolean blindness;

	public static FileConfiguration intro;

	public static FileConfiguration config() {

		return Bukkit.getPluginManager().getPlugin("BoMC-Intro").getConfig();

	}

	@Override
	public void onEnable() {

		// Save intro.yml
		saveResource("intro.yml", false);

		intro = YamlConfiguration.loadConfiguration(new File(getDataFolder(), "intro.yml"));

		// Config data
		saveDefaultConfig();
		IO.load(intro);

		/*
		 * Stream<String> file = new BufferedReader(new
		 * InputStreamReader(getResource("intro.txt"))).lines(); paragraphs =
		 * file.collect(Collectors.toList());
		 *
		 * int i = 1; for (String s : paragraphs) {
		 *
		 * getLogger().info("Message " + i + ": '" + s + "'");
		 *
		 * }
		 */

		// Register listeners and commands
		getServer().getPluginManager().registerEvents(new LoginListener(), this);
		getCommand("intro").setExecutor(new IntroCommand());

	}

	@Override
	public void onDisable() {

		IO.save();
		saveConfig();

	}

	public static void display(Player player) {

		for (int i = 0; i < titles.size(); i++) {
			titles.set(i, titles.get(i).clone());
		}

		if (blindness) {

			player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, totalLength, 3));

		}

		int timeIncrement = 10;

		for (Title t : titles) {

			Title run = t;

			run.setPlayer(player);
			run.runTaskLater(Bukkit.getPluginManager().getPlugin("BoMC-Intro"), timeIncrement);

			timeIncrement += t.getTotalLength();

		}

	}

}
