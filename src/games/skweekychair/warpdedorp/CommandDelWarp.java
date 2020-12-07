package games.skweekychair.warpdedorp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.util.StringUtil;

public class CommandDelWarp implements TabExecutor {
	 
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
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		List<String> names = new ArrayList<String>();
		if (args.length > 1) {return names;}
		Set<String> namesSet = teleportLocations.keySet();
		names.addAll(namesSet);
		List<String> returns = new ArrayList<String>();
		StringUtil.copyPartialMatches(args[0], names, returns);
		Collections.sort(returns);
		return returns;
	}
}
