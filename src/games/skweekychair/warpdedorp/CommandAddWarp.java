package games.skweekychair.warpdedorp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

public class CommandAddWarp implements TabExecutor {
	 
	WarpDDPlugin mainInstance;
	HashMap<String, Location> teleportLocations;
	
	public CommandAddWarp (WarpDDPlugin mainPlugin) {
		mainInstance = mainPlugin;
		teleportLocations = mainPlugin.teleportLocations;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if ((1 < args.length && args.length < 5) || args.length == 6) {return false;} 
		
		if (sender instanceof Player && args.length == 1) {
			Player player = (Player) sender;
			Location playerLoc = player.getLocation();
			teleportLocations.put(args[0], playerLoc);
			mainInstance.getConfig().set(args[0], playerLoc);
			mainInstance.saveConfig();
			return true;
		}
		
		World world = Bukkit.getWorld(args[1]);
		double xCord;
		double yCord;
		double zCord;
		
		try {
		xCord = Double.parseDouble(args[2]);
		yCord = Double.parseDouble(args[3]);
		zCord = Double.parseDouble(args[4]);
		} catch (NumberFormatException nfe) {return false;}
		
		Location warpPoint = new Location(world, xCord, yCord, zCord);
		
		if (args.length == 7) {
			float yaw;
			float pitch;
			
			try {
			yaw = Float.parseFloat(args[5]);
			pitch = Float.parseFloat(args[6]);
			} catch (NumberFormatException nfe) {return false;}
			
			warpPoint.setYaw(yaw);
			warpPoint.setPitch(pitch);
		}
		
		teleportLocations.put(args[0], warpPoint);
		mainInstance.getConfig().set(args[0], warpPoint);
		mainInstance.saveConfig();
		
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		List<String> completes = new ArrayList<String>();
		List<String> returns = new ArrayList<String>();
		
		if (args.length == 2) {
			List<World> worlds = Bukkit.getWorlds();
			for (World element : worlds) {
				completes.add(element.getName());
			}
		}
		else if (2 < args.length && args.length < 8 ) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				Location playerLoc = player.getLocation();
				switch (args.length) {
					case 3:
						completes.add(String.format("%.3f", playerLoc.getX())); break;
					case 4:
						completes.add(String.format("%.5f", playerLoc.getY())); break;
					case 5:
						completes.add(String.format("%.3f", playerLoc.getZ())); break;
					case 6:
						completes.add(String.format("%.1f", playerLoc.getYaw())); break;
					case 7:
						completes.add(String.format("%.1f", playerLoc.getPitch())); break;
				}
					
			}
		}
		
		StringUtil.copyPartialMatches(args[args.length - 1], completes, returns);
		Collections.sort(returns);
		
		return returns;
	}
}
