package me.redth.visiblebarrier;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.Switch;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;

public class VBConfig extends Config {
    @Switch(name = "Hide Barrier Particles")
    public static boolean hideBarrierParticles = true;

    public VBConfig() {
        super(new Mod(VisibleBarrier.NAME, ModType.UTIL_QOL), "visibleconfig.json");
        initialize();
        addListener("enabled", VisibleBarrier::reloadChunks);
    }


}
