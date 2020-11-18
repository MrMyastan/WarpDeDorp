package games.skweekychair.warpdedorp;

import org.bukkit.plugin.java.JavaPlugin;

public class WarpDDPlugin extends JavaPlugin {
    // Fired when plugin is first enabled
    @Override
    public void onEnable() {
        this.getCommand("warp").setExecutor(new CommandWarp());
        this.getCommand("addwarp").setExecutor(new CommandAddWarp(this));
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {

    }
}
