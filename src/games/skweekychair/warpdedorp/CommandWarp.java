package games.skweekychair.warpdedorp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

public class CommandWarp implements TabExecutor {
    
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
    
	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		List<String> names = new ArrayList<String>();
		if (args.length > 1) {return names;}
		Set<String> namesSet = teleportLocations.keySet();
		names.addAll(namesSet);
		return names;
	}
	

}
