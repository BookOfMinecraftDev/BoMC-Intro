package com.BoMC.Intro.core;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.BoMC.Intro.Intro;

public class TitleTask extends BukkitRunnable {

	private Intro plugin;
	private Player player;
	private int count;
	private List<String> paragraphs;
	private int fadeIn;
	private int time;
	private int fadeOut;

	public TitleTask(Intro p, Player pl, List<String> pa, int fi, int t, int fo) {
		plugin = p;
		player = pl;
		count = 0;
		paragraphs = pa;
		fadeIn = fi;
		time = t;
		fadeOut = fo;
	}

	@Override
	public void run() {
		String line = paragraphs.get(count);
		String[] halves = line.split("[|]");
		plugin.getLogger().info("Displaying message " + count + " with title " + halves[0] + " and sub " + halves[1]);
		player.sendTitle(halves[0], halves[1], fadeIn, time, fadeOut);
		count++;
		if (count >= paragraphs.size()) {
			cancel();
		}
	}

}
