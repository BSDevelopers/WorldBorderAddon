package addon.brainsynder.worldborder;

import com.wimbli.WorldBorder.BorderData;
import com.wimbli.WorldBorder.Config;
import org.bukkit.Location;
import simplepets.brainsynder.addon.presets.RegionModule;
import simplepets.brainsynder.api.Namespace;
import simplepets.brainsynder.api.user.PetUser;

@Namespace(namespace = "WorldBorder")
public class WorldBorderAddon extends RegionModule {

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
