package me.redth.barriervisibility;

import cc.polyfrost.oneconfig.utils.commands.CommandManager;
import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = BarrierVisibility.MODID, name = BarrierVisibility.NAME, version = BarrierVisibility.VERSION)
@Command(value = "barrier", description = "Toggle Barrier Visibility")
public class BarrierVisibility {
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";

    @Mod.Instance(MODID)
    public static BarrierVisibility INSTANCE;
    public static ModConfig config;

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        config = new ModConfig();
        CommandManager.register(this);
    }

    @Main
    private void command() {
        config.enabled = !config.enabled;
        reloadChunks();
    }

    public static void reloadChunks() {
        Minecraft.getMinecraft().renderGlobal.loadRenderers();
    }
}
