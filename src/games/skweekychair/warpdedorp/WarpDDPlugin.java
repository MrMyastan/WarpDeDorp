package games.skweekychair.warpdedorp;

import java.util.HashMap;
import java.util.Set;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public class WarpDDPlugin extends JavaPlugin {
	// Fired when plugin is first enabled
	
	HashMap<String, Location> teleportLocations = new HashMap<String, Location>();
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		Set<String> locationNames = getConfig().getKeys(false);
		
		for (String name : locationNames) {
			teleportLocations.put(name, getConfig().getLocation(name));
		}
		
		this.getCommand("warp").setExecutor(new CommandWarp(teleportLocations));
		this.getCommand("addwarp").setExecutor(new CommandAddWarp(this));
		this.getCommand("delwarp").setExecutor(new CommandDelWarp(this));
	}
	// Fired when plugin is disabled
	@Override
	public void onDisable() {
		saveConfig();
	}
}
