# ItemVoid
A Bukkit plugin that removes blacklisted items from players.

## Features
- One-command GUI
- Works with special NBT data
- Lightweight

## Using ItemVoid
`/itemblacklist` will open the blacklisted item inventory. Items can be placed and removed from this container freely.
Any items inside will automatically be removed from players who do not have the `itemvoid.bypass` permission.
Items are stored in `itemblackList.txt`, though you shouldn't edit the file directly unless you are sure you know what
you're doing.

#### Commands
- `/itemblacklist` (Requires permission `itemvoid.manageblacklist`) - Opens the item blacklist GUI

[A demo of the plugin functionality](https://github.com/Stonley890/ItemVoid/blob/main/ItemVoidDemoSmall.GIF)
