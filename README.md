
# CompressedBlocks
![Spigot](https://img.shields.io/badge/Spigot-1.21--1.21.4-yellow.svg)
![PaperMC](https://img.shields.io/badge/PaperMC-1.21--1.21.4-blue.svg)
![Version](https://img.shields.io/badge/Version-0.1.0-gray.svg)
![MIT License](https://img.shields.io/badge/License-MIT-green.svg)

**CompressedBlocks** is a Minecraft plugin that adds support for crafting and decompressing compressed blocks in the game. Players can compress materials such as stone, dirt, cobblestone, and more into multiple levels of compressed blocks.




## Features
- **Crafting and Decompressing Compressed Blocks**: Players can craft compressed versions of materials up to 16 (named) levels (Compressed, Double Compressed, Triple Compressed Quadruple Compressed and more...).
- **Customizable Compressible Materials**: Server administrators can specify which materials are compressible via a simple configuration file (`config.yml`).
- **Permissions**: Permission system to control who can craft compressed blocks.
- **Lore**: Each compressed block has a custom lore displaying how many base blocks it contains. 

## Installation

1. Download the plugin `.jar` file.
2. Place the `.jar` file in your server's `plugins` directory.
3. Restart the server to load the plugin.
    
## Configuration

Once the plugin is loaded for the first time, it will generate a `config.yml` file in the plugin's directory. The default configuration looks like this:

```yaml
# List of materials that can be compressed
compressed_blocks:
  - "STONE"
  - "DIRT"
  - "COBBLESTONE"
  # Add more materials here as needed
  ````

In this file, you can define which materials should be compressible. Simply add or remove materials from the `compressed_blocks` list.
## Crafting Recipes

**The following crafting recipes are added for each compressible material:**

**1. Compression:** Combine 9 blocks of the base material to craft a compressed block.

- Example: 9 Stone = Compressed Stone
- Example: 9 Compressed Stone = Double Compressed Stone

**2. Decompression:** Craft a block back from a compressed version by placing the compressed block in a crafting grid.

- Example: Compressed Stone → 9 Stone

Each level of compression requires 9 of the previous compressed block to craft.
## Permissions

The plugin only has a single permission so far:
`compressedblocks.craft`

## Usage

Once the plugin is installed and configured, players can craft compressed blocks using the recipes defined. You can view the compressed blocks in the crafting menu, and each compressed block has a custom name and lore that details how many base blocks it contains.


## Developer Notes

- The plugin supports dynamic material registration through the configuration file, so adding new compressible materials is simple.
- The compressed blocks are stored with a custom compressed_level tag, which makes it easy to handle the different levels of compression.
## Contributing

Feel free to contribute or open issues on GitHub if you have suggestions or encounter problems!


## License

This project is licensed under the [MIT License](LICENSE).

