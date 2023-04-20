package fr.mrgeekk.event.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import fr.mrgeekk.event.teams.TeamsManager;

public class playerchat implements Listener{
	
	// Optimiser pour de la production
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		
		Player p = e.getPlayer();
		
		e.setCancelled(true);
		
		if(p.hasPermission("nationsevent.chatmuted") && !p.hasPermission("nationsrunner.mod")) {
			p.sendMessage("§cLe chat est désactivé !");
			return;
		}
		if(!new TeamsManager().playerhasteam(p.getDisplayName())) {
			if(!p.hasPermission("nationsevent.chat")) {
				p.sendMessage("§cVous n'avez pas d'équipe, vous ne pouvez donc pas parler");
				return;
			}
		}
		
		if(e.getMessage().startsWith("!") && p.hasPermission("nationsrunner.mod")) {
			for(Player all : Bukkit.getOnlinePlayers()) {
				if(all.hasPermission("nationsevent.mod")) {
					all.sendMessage("§a[Chat-Staff] §7• " + p.getDisplayName() + " ➜§f " + e.getMessage());
				}
			}
			return;
		}
		
		if(e.getMessage().startsWith(":")  && p.hasPermission("nationsevent.mod") || !new TeamsManager().playerhasteam(p.getDisplayName())) {
			for(Player all : Bukkit.getOnlinePlayers()) {
				all.sendMessage("§a[*banner id=\"staff\"] §7" + p.getDisplayName() + " ➜§f " + e.getMessage());
				}
			return;
		}
		
		p.sendMessage("§6["+new TeamsManager().getplayerteam(p.getDisplayName())+"] §7• " + p.getDisplayName() + " ➜§f " + e.getMessage());
		for(Player all : Bukkit.getOnlinePlayers()) {
			if(new TeamsManager().getplayerteam(all.getDisplayName()) == new TeamsManager().getplayerteam(p.getDisplayName())) {
				all.sendMessage("§6["+new TeamsManager().getplayerteam(p.getDisplayName())+"] §7• " + p.getDisplayName() + " ➜§f " + e.getMessage());
			}
		}
		
	}

}
