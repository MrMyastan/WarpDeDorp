[![License: MIT](https://img.shields.io/badge/License-MIT-brightgreen.svg)](https://opensource.org/licenses/MIT) [![Tested on: Spigot 1.16.1](https://img.shields.io/badge/Tested%20on-Spigot%201.16.1-yellow.svg?logo=minecraft)](https://www.spigotmc.org/) [![Languag: Java](https://img.shields.io/badge/Language-Java-red?logo=java)](https://www.java.com/en/) ![API Jar: 1.16.1-R0.1](https://img.shields.io/badge/API%20Jar-1.16.1--R0.1-blueviolet) ![Version: v1.1](https://img.shields.io/badge/Version-v1.1-blue) ![Why am I doing this?: I don't know](https://img.shields.io/badge/Why%20am%20I%20doing%20this%3F-I%20don't%20know-lightgrey)
# WarpDeDorp
A basic Spigot-API Minecraft plugin for a warp system.
You can feel free to modify the code for your own use (just make sure to credit me for my code), and use the plugin for your own server!
Any suggestions for improvements or features are welcome!
# Compatibility
I've tested the plugin using a Spigot 1.16.1 server and made the plugin using the 1.16.1-R0.1 Spigot-API jar
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
