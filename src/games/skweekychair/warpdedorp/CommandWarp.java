package games.skweekychair.warpdedorp;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandWarp implements CommandExecutor {
    
	HashMap<String, Location> teleportLocations = new HashMap<String, Location>();
	
	// This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	teleportLocations.put("endportal", new Location(Bukkit.getWorld("world"), 999.5, 23, -2121.5, -90, 35));
    	teleportLocations.put("hub", new Location(Bukkit.getWorld("world"), -661.5, 88, 1139.5, 180, -21));
    	if (sender instanceof Player) {
            Player player = (Player) sender;
            player.teleport(teleportLocations.get(args[0]));
        }
    	
    	return false;
    }
}
