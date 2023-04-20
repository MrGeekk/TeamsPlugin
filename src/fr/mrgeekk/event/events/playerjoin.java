package fr.mrgeekk.event.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.mrgeekk.event.teams.TeamsManager;

public class playerjoin implements Listener {
	
	/*
	 * Le nationsevent.team a pour but de ne pas spam les manuadd si le joueur a déjà un grade qui possède la perm
	 */
		
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		if(new TeamsManager().playerhasteam(p.getDisplayName()) && !p.hasPermission("nationsevent.team")){
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuadd " + p.getDisplayName() + " " + new TeamsManager().getplayerteam(p.getDisplayName()));
		}
		
	}

}
