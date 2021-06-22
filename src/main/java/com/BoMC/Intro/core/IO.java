package com.BoMC.Intro.core;

import java.util.ArrayList;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import com.BoMC.Intro.Intro;

public class IO {
	
	public static void save() {
		
		Intro.config().set("seen", Conversion.convertUUIDListToString(Intro.seen));
		
	}
	
	public static void load(FileConfiguration intros) {
		
		Intro.seen = Conversion.convertStringListToUUID(Intro.config().getStringList("seen"));
		Intro.titles = new ArrayList<Title>();
		
		int totalTime = 0;
		Intro.blindness = intros.getBoolean("blindness");
		
		for(String s : intros.getKeys(false)) {
			
			if(!s.equals("blindness")) {
				
				ConfigurationSection section = intros.getConfigurationSection(s);
				
				if(section.getBoolean("fade")) {
					
					Intro.titles.add(new Title(section.getString("title"), section.getString("sub"),
						Conversion.convertColor(section.getString("title-color")), Conversion.convertColor(section.getString("sub-color")),
						section.getInt("fade-in"), section.getInt("time"), section.getInt("fade-out")));
					
					totalTime += section.getInt("time");
					
				} else {
					
					Intro.titles.add(new Title(section.getString("title"), section.getString("sub"),
							Conversion.convertColor(section.getString("title-color")), Conversion.convertColor(section.getString("sub-color")), section.getInt("time")));
					
					totalTime += section.getInt("time");
					totalTime += section.getInt("fade-in");
					totalTime += section.getInt("fade-out");
					
				}
				
			}
			
		}
		
		Intro.totalLength = totalTime;
		
	}

}
