# BasicTPA
A basic Spigot-API Minecraft plugin for a
You can feel free to modify the code for your own use (just make sure to credit me for my code), and use the plugin for your own server!
Any suggestions for improvements or features are welcome!
# Features
- tprequest command
  - request to teleport to player YEET
  - players have permission to use this command by
- tphere command
  - request a player teleports to you
  - players have permission to use this command by default
- tpaccept command
  - accept current teleport request, teleports immediately
  - players have permission to use this command by default, no wait x seconds without moving
- tpdeny command
  - denies
  - players have permission to use this comma
- tpview command
  - prints current te
  - players have permission to use this command by default
- tpback command
  - teleports you back to where you were before the last teleport you accept
  - players have permission to use this command by default
# Things to note
- teleport requests dont have any queueing, a new request overwrites a previous
  - For Example, if Player1 sends a teleport request (tphere or tprequest) to Player3, and then Player2 sends another request (tphere or tprequest), the only request Player3 has to accept or deny is Player2's, and if they deny it they have no requests left.
- tpback also doesnt queue or track multiple teleports, it will only take you back to where you where before your most recent teleport
- tpback also doesnt track death locations or locations before teleports by other means, it only tracks teleports through this plugin
- teleport requests do not expire
# To-Do
- [x] write this readme
- [ ] comment my code
- [x] error handling
yeet
