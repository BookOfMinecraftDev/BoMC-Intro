package com.BoMC.Intro.core;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.md_5.bungee.api.ChatColor;

public class Conversion {

	public static List<String> convertUUIDListToString(List<UUID> list) {
		
		List<String> newList = new ArrayList<String>();
		
		for (UUID id : list) {
			
			newList.add(id.toString());
			
		}
		
		return newList;
	}

	public static List<UUID> convertStringListToUUID(List<String> list) {
		
		List<UUID> newList = new ArrayList<UUID>();
		
		for (String s : list) {
			
			newList.add(UUID.fromString(s));
			
		}
		
		return newList;
		
	}

	public static ChatColor convertColor(String color) {
		
		return ChatColor.of(color);
		
	}
	
}
