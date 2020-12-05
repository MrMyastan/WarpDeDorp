package games.skweekychair.warpdedorp;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandWarp implements CommandExecutor {
    
	HashMap<String, Location> teleportLocations;
	
	public CommandWarp (HashMap<String, Location> storedLocations) {
		teleportLocations = storedLocations;
	}
	
	// This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	if (args.length == 0) {return false;}
    	
    	if (sender instanceof Player) {
            Player player = (Player) sender;
            Location toLocation = teleportLocations.get(args[0]);
            if (toLocation == null) {
            	return false;
            }
            player.teleport(teleportLocations.get(args[0]));
            return true;
        }
    	return false;
    }
}
