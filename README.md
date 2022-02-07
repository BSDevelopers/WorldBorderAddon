# WorldBorderAddon
This is an addon for the SimplePets v5 plugin.

This addon was not 100% tested but from code testing SHOULD work fine... `(I hope...)`

### Requirements:
- [WorldBorder](https://www.spigotmc.org/resources/80466/) Plugin `(At least v2.1.4)`

### Default configuration (Located in `plugins/SimplePets/Addons/config/WorldBorder.yml`)
```yaml
# What should the bypass permission be set to?
bypass-permission: pet.worldborder.bypass

checks:
  spawning:
    # Should the addon check when a pet is spawned?
    enabled: true
    # This message is only visible when you hover over the 'pet failed to spawn' message
    # You can make this blank or 'null' if you want no message
    reason: '&cYour pet is not able to be spawned in this area'
    
  mounting:
    # Should the addon check when the player mounts the pet?
    enabled: true
    # Should the pet be removed or should it just be canceled?
    remove-pet: true
    
  moving:
    # Should the addon check when a pet moves?
    enabled: true
    # Should the pet be removed or should it just be canceled?
    remove-pet: true
    
  riding:
    # Should the addon check when the pets owner is riding it?
    enabled: true
    # Should the pet be removed or should it just be canceled?
    remove-pet: true
    # Should the player be dismounted (if remove-pet is set to true this is ignored)?
    dismount: true
```