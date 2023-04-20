package fr.mrgeekk.event;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import fr.mrgeekk.event.events.playerchat;
import fr.mrgeekk.event.events.playerjoin;

public class eventmanagers {

	public void register() {
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new playerjoin(), main.getInstance());
		pm.registerEvents(new playerchat(), main.getInstance());
		
	}
	
}
