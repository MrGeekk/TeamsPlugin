package fr.mrgeekk.nationsrunner.events;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import fr.mrgeekk.nationsrunner.teams.TeamsManager;

public class playerdamage implements Listener{
	
	public void onDamage(EntityDamageByEntityEvent e) {
		if(e instanceof Player) {
			Player p = ((Player) e).getPlayer();
			
			if(e.getDamager().getType() == EntityType.PLAYER) {
				Player damager = (Player) e.getDamager();
				
				if(new TeamsManager().getplayerteam(damager.getDisplayName()) == new TeamsManager().getplayerteam(p.getDisplayName())) {
					e.setCancelled(true);
				}
			}
		}
	}

}
