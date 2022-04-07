package addon.brainsynder.worldborder;

import com.wimbli.WorldBorder.BorderData;
import com.wimbli.WorldBorder.Config;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import simplepets.brainsynder.addon.presets.RegionModule;
import simplepets.brainsynder.api.Namespace;
import simplepets.brainsynder.api.plugin.SimplePets;
import simplepets.brainsynder.api.user.PetUser;
import simplepets.brainsynder.debug.DebugLevel;

@Namespace(namespace = "WorldBorder")
public class WorldBorderAddon extends RegionModule {

    @Override
    public boolean shouldEnable() {
        Plugin worldBorder = Bukkit.getPluginManager().getPlugin("WorldBorder");
        if (worldBorder == null) {
            SimplePets.getDebugLogger().debug(DebugLevel.ERROR, "WorldBorder wasn't found!");
            SimplePets.getDebugLogger().debug(DebugLevel.ERROR, "Please download it from: https://www.spigotmc.org/resources/80466/");
            return false;
        }
        return true;
    }

    private boolean isAllowedInRegion(PetUser petUser, Location location) {
        BorderData border = Config.Border(location.getWorld().getName());
        if (border == null) return true; // No World Border data
        return border.insideBorder(location);
    }

    @Override
    public boolean isSpawningAllowed(PetUser petUser, Location location) {
        return isAllowedInRegion(petUser, location);
    }

    @Override
    public boolean isMovingAllowed(PetUser petUser, Location location) {
        return isAllowedInRegion(petUser, location);
    }

    @Override
    public boolean isRidingAllowed(PetUser petUser, Location location) {
        return isAllowedInRegion(petUser, location);
    }

    @Override
    public boolean isMountingAllowed(PetUser petUser, Location location) {
        return isAllowedInRegion(petUser, location);
    }
}
