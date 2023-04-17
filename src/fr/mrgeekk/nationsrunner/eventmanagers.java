package fr.mrgeekk.nationsrunner;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import fr.mrgeekk.nationsrunner.events.playerchat;
import fr.mrgeekk.nationsrunner.events.playerjoin;

public class eventmanagers {

	public void register() {
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new playerjoin(), main.getInstance());
		pm.registerEvents(new playerchat(), main.getInstance());
		
	}
	
}
