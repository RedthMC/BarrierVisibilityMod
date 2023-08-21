package me.redth.barriervisibility;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.Switch;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;

public class ModConfig extends Config {
    @Switch(name = "Hide Barrier Particles")
    public static boolean hideBarrierParticles = true;

    public ModConfig() {
        super(new Mod(BarrierVisibility.NAME, ModType.UTIL_QOL), BarrierVisibility.MODID + ".json");
        initialize();
    }


}
