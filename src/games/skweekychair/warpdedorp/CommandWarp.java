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
    	if (sender instanceof Player) {
            Player player = (Player) sender;
            player.teleport(teleportLocations.get(args[0]));
        }
    	return false;
    }
}
