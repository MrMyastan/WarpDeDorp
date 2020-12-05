package games.skweekychair.warpdedorp;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandAddWarp implements CommandExecutor {
	 
	WarpDDPlugin mainInstance;
	HashMap<String, Location> teleportLocations;
	
	public CommandAddWarp (WarpDDPlugin mainPlugin) {
		mainInstance = mainPlugin;
		teleportLocations = mainPlugin.teleportLocations;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player && args.length == 1) {
	       	Player player = (Player) sender;
	       	Location playerLoc = player.getLocation();
	       	teleportLocations.put(args[0], playerLoc);
	       	mainInstance.getConfig().set(args[0], playerLoc);
			mainInstance.saveConfig();
		}
		return false;
	}
}
