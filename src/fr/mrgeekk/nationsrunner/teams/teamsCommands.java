package fr.mrgeekk.nationsrunner.teams;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class teamsCommands implements CommandExecutor {
		
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
				
		if(label.equalsIgnoreCase("teams")) {
									
			if(args.length < 1) {
				sender.sendMessage("�7[NationsRunner] Usage: /teams add/list/lists/remove/whitelist/unwhitelist/get/point");
				return false;
			}
			
			if(args[0].equalsIgnoreCase("add")) {
				if((args.length >= 2)) {
					
					String team = args[1];
					String player = args[2];
					
					if(!new TeamsManager().playerhasteam(player)) {
						new TeamsManager().addplayertoteam(player, team);
					} else {
						sender.sendMessage("�7[NationsRunner] Le joueur a d�j� une �quipe");
						return false;
					}
					
					sender.sendMessage("�7[NationsRunner] Vous avez ajout� " + player + " � l'�quipe " + team);
					
					return false;
				}
			}
			
			if(args[0].equalsIgnoreCase("list")) {
				
				if(!(args.length >= 2)) {
					sender.sendMessage("�7[NationsRunner] Usage: /teams list <team>");
					return false;
				}
				
				String team = args[1];
				
				sender.sendMessage("�7[NationsRunner] L'�quipe " + args[1] + " contient: " + new TeamsManager().getteam(team));
				
				return true;
				
			}
			
			if(args[0].equalsIgnoreCase("remove")) {
				
				if(args.length < 3) {
					sender.sendMessage("�7[NationsRunner] Usage: /teams remove <team> <pseudo>");
					return false;
				}
				
				String player = args[2];
				
				if(new TeamsManager().playerhasteam(player)) {
					new TeamsManager().removeplayertoteam(player);
					sender.sendMessage("�7[NationsRunner] Le retrait a �t� effectu�");
					return false;
				} else {
					sender.sendMessage("�7[NationsRunner] Le joueur n'a pas de team");
					return false;
				}
			}
			
			if(args[0].equalsIgnoreCase("lists")) {
				
				sender.sendMessage("�7[NationsRunner] Voici la liste des teams: " + new TeamsManager().getteams());
				return false;
				
			}
			
			if(args[0].equalsIgnoreCase("whitelist")) {
				
				if(args.length < 2) {
					sender.sendMessage("�7[NationsRunner] Usage: /teams whitelist <team>");
					return false;
				}
				
				String team = args[1];
				
				String[] players = new TeamsManager().getteam(team).split(",");
				
				for(int i = 0; players.length > i; i++) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "whitelist add " + players[i]);
				}
				sender.sendMessage("�7[NationsRunner] Ajout de l'�quipe � la Whitelist");
				return false;
			}
			
			if(args[0].equalsIgnoreCase("unwhitelist")) {
				
				if(args.length < 2) {
					sender.sendMessage("�7[NationsRunner] Usage: /teams unwhitelist <team>");
					return false;
				}
				
				String team = args[1];
				String[] players = new TeamsManager().getteam(team).split(",");	
				
				for(int i = 0; players.length > i; i++) {
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "whitelist remove " + players[i]);
				}
				sender.sendMessage("�7[NationsRunner] Retrait de l'�quipe � la Whitelist");
				return false;
			}
			
			if(args[0].equalsIgnoreCase("get")) {
				
				if(args.length < 2) {
					sender.sendMessage("�7[NationsRunner] Usage: /teams get <player>");
					return false;
				}
				
				String player = args[1];
				
				sender.sendMessage("�7[NationsRunner] Le joueur fait partie de l'�quipe " + new TeamsManager().getplayerteam(player));
				return false;
			}
			
			if(args[0].equalsIgnoreCase("point")) {
				
				if(args.length < 2) {
					sender.sendMessage("�7[NationsRunner] Usage: /teams point <team>");
					return false;
				}
				
				String team = args[1];
				
				sender.sendMessage("�7[NationsRunner] L'�quipe a " + new points().getteampoint(team) + " points");
				return false;
			}
			
		}
		
		
		return false;
	}

}
