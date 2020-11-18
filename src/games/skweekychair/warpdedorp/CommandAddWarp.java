package games.skweekychair.warpdedorp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandAddWarp implements CommandExecutor {
	 
	WarpDDPlugin mainInstance;
	
	public CommandAddWarp (WarpDDPlugin mainPlugin) {
		mainInstance = mainPlugin;
	}
	
	 @Override
	 public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		 return false;
	 }
}
