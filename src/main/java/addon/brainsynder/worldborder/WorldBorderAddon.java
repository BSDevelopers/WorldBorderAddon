package addon.brainsynder.worldborder;

import com.google.common.collect.Lists;
import com.wimbli.WorldBorder.BorderData;
import com.wimbli.WorldBorder.Config;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import simplepets.brainsynder.addon.presets.RegionAddon;
import simplepets.brainsynder.api.Namespace;
import simplepets.brainsynder.api.plugin.SimplePets;
import simplepets.brainsynder.api.user.PetUser;
import simplepets.brainsynder.debug.DebugLevel;

import java.util.List;

@Namespace(namespace = "WorldBorder")
public class WorldBorderAddon extends RegionAddon {

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
    public double getVersion() {
        return 0.1;
    }

    @Override
    public String getAuthor() {
        return "brainsynder";
    }

    @Override
    public List<String> getDescription() {
        return Lists.newArrayList(
                "&7This addon hooks into",
                "&7WorldBorder so you can",
                "&7stop specific pet events from",
                "&7occurring when outside of borders",
                "&r ",
                "&cNOT FULLY TESTED any issues report",
                "&cthem on discord https://pluginwiki.us/discord/"
        );
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
