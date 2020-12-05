package games.skweekychair.warpdedorp;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public class WarpDDPlugin extends JavaPlugin {
    // Fired when plugin is first enabled
	
	HashMap<String, Location> teleportLocations = new HashMap<String, Location>();
	
    @Override
    public void onEnable() {
    	saveDefaultConfig();
        this.getCommand("warp").setExecutor(new CommandWarp(teleportLocations));
        this.getCommand("addwarp").setExecutor(new CommandAddWarp(this));
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {

    }
}
