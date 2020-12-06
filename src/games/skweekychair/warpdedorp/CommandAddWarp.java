package games.skweekychair.warpdedorp;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
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
		double xCord = Double.parseDouble(args[2]);
		double yCord = Double.parseDouble(args[3]);
		double zCord = Double.parseDouble(args[4]);
		
		Location warpPoint = new Location(world, xCord, yCord, zCord);
		
		if (args.length == 7) {
			float yaw = Float.parseFloat(args[5]);
			float pitch = Float.parseFloat(args[6]);
			warpPoint.setYaw(yaw);
			warpPoint.setPitch(pitch);
		}
		
       	teleportLocations.put(args[0], warpPoint);
       	mainInstance.getConfig().set(args[0], warpPoint);
		mainInstance.saveConfig();
		
		return true;
	}
}
