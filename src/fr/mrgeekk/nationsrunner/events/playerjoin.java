package fr.mrgeekk.nationsrunner.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.mrgeekk.nationsrunner.teams.TeamsManager;

public class playerjoin implements Listener {
		
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		if(new TeamsManager().playerhasteam(p.getDisplayName()) && !p.hasPermission("nationsrunner.team")){
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + p.getDisplayName() + " " + new TeamsManager().getplayerteam(p.getDisplayName()));
		}
		
	}

}
