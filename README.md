# WarpDeDorp
A basic Spigot-API Minecraft plugin for a warp system.
You can feel free to modify the code for your own use (just make sure to credit me for my code), and use the plugin for your own server!
Any suggestions for improvements or features are welcome!
# Features
- warp command
  - request to warp to the named warp point
  - all players have permission to use this command by default
  - usage: /warp \[name\]
  - offers tab completion for existing warp points
- addwarp command
  - add a warp point
  - ops have permission to use this command by default
  - usage: /addwarp \[name\] (worldname xcord ycord zcord) (yaw pitch)
  - if command sender is a player and a location isn't explicitly specified then it uses the player's location as the warp location
  - if just a world and coords are specified then the yaw and pitch default to 0
  - offers tab completion for all the available worlds and if the sender is a player the player's coords and yaw/pitch to the number of decimals displayed in the f3 menu for each (the numbers are sometimes slightly off from the f3 menu but its usually right, also it sometimes suggests the tab completion for yaw as the negative inverse, ie 130 is suggested as -230)
  - will override an existing warp point with the same name
- delwarp command
  - removes a warp point
  - ops have permission to use this command by default
  - usage: /warp \[name\]
  - offers tab completion for existing warp points
# To-Do
- [x] write this readme
- [ ] comment my code
