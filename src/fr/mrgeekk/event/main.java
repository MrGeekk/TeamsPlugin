package fr.mrgeekk.event;

import org.bukkit.plugin.java.JavaPlugin;

import fr.mrgeekk.event.teams.PointCommand;
import fr.mrgeekk.event.teams.teamsCommands;

public class main extends JavaPlugin{
	
	private static main instance;
	private dbmanager data;
		
	@Override
	public void onEnable() {
		instance = this;
		System.out.println("[NationsEvent] Enable");
		new eventmanagers().register();
		
		getCommand("teams").setExecutor(new teamsCommands());
		getCommand("points").setExecutor(new PointCommand());
		data = new dbmanager("jdbc:mysql://", "mysql2.ouiheberg.com:3306", "s2229_ngrunner", "u2229_k1zBn2fQMs", "EzgU=An1lUPT!HUNSbQCGx!i");
		data.connection();
		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {

		System.out.println("[NationsEvent] Disable");
		data.deconnection();
				
		super.onDisable();
	}
	
	public static main getInstance() {
		return instance;
	}
	
}
