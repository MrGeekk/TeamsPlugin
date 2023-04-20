package fr.mrgeekk.event.teams;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PointCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(label.equalsIgnoreCase("points")) {
			
			if(args.length < 1) {
				sender.sendMessage("§7[NationsEvent] Usage: /points set/get");
				return false;
			}
			
			if(args[0].equalsIgnoreCase("set")) {
				
				if(args.length < 3) {
					sender.sendMessage("§7[NationsEvent] Usage: /points set <player> <points>");
					return false;
				}
				
				String player = args[1];
				int point = Integer.parseInt(args[2]);
				
				new points().setpoint(player, point);
				sender.sendMessage("§7[NationsEvent] Modification effectuées");
				
			}
			
			if(args[0].equalsIgnoreCase("get")) {
				
				if(args.length < 2) {
					sender.sendMessage("§7[NationsEvent] Usage: /points get <player>");
					return false;
				}
				
				String player = args[1];
				
				sender.sendMessage("§7[NationsEvent] Le joueur a " + new points().getpoint(player) + " points");
				return false;
			}
		}
		
		return false;
	}
	
	

}
