package com.BoMC.Intro.core;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatColor;

public class Title extends BukkitRunnable {

	private Player player;
	private String title;
	private String sub;
	private ChatColor titleColor;
	private ChatColor subColor;
	private int fadeIn;
	private int time;
	private int fadeOut;
	private int totalLength;

	public Title(String title, String sub, ChatColor titleColor, ChatColor subColor, int time) {

		this.title = "";
		this.sub = "";
		this.titleColor = ChatColor.WHITE;
		this.subColor = ChatColor.WHITE;

		if (title != null) {
			this.title = title;
		}
		if (sub != null) {
			this.sub = sub;
		}
		if (titleColor != null) {
			this.titleColor = titleColor;
		}
		if (subColor != null) {
			this.subColor = subColor;
		}
		fadeIn = 0;
		this.time = time;
		fadeOut = 0;

		totalLength = time;

	}

	public Title(String title, String sub, ChatColor titleColor, ChatColor subColor, int fadeIn, int time,
			int fadeOut) {

		this.title = "";
		this.sub = "";
		this.titleColor = ChatColor.WHITE;
		this.subColor = ChatColor.WHITE;

		if (title != null) {
			this.title = title;
		}
		if (sub != null) {
			this.sub = sub;
		}
		if (titleColor != null) {
			this.titleColor = titleColor;
		}
		if (subColor != null) {
			this.subColor = subColor;
		}
		this.fadeIn = fadeIn;
		this.time = time;
		this.fadeOut = fadeOut;

		totalLength = fadeIn + time + fadeOut;

	}

	public void setPlayer(Player player) {

		this.player = player;

	}

	public int getTotalLength() {

		return totalLength;

	}

	@Override
	public void run() {

		player.sendTitle(titleColor + title, subColor + sub, fadeIn, time, fadeOut);

	}

	@Override
	public Title clone() {
		return new Title(title, sub, titleColor, subColor, fadeIn, time, fadeOut);
	}

}
