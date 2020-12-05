package games.skweekychair.warpdedorp;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandDelWarp implements CommandExecutor {
	 
	WarpDDPlugin mainInstance;
	HashMap<String, Location> teleportLocations;
	
	public CommandDelWarp (WarpDDPlugin mainPlugin) {
		mainInstance = mainPlugin;
		teleportLocations = mainPlugin.teleportLocations;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (args.length == 1 && teleportLocations.containsKey(args[0])) {
	       	teleportLocations.remove(args[0]);
	       	mainInstance.getConfig().set(args[0], null);
			mainInstance.saveConfig();
			return true;
		}
		return false;
	}
}
