package me.redth.visiblebarrier;

import cc.polyfrost.oneconfig.utils.commands.CommandManager;
import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = VisibleBarrier.MODID, name = VisibleBarrier.NAME, version = VisibleBarrier.VERSION)
@Command(value = "barrier", description = "Toggle Barrier Visibility")
public class VisibleBarrier {
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";

    @Mod.Instance(MODID)
    public static VisibleBarrier INSTANCE;

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        new VBConfig();
        CommandManager.register(this);
    }

    @Main
    private void command() {
        VBConfig.enabled = !VBConfig.enabled;
        reloadChunks();
    }

    public static void reloadChunks() {
        Minecraft.getMinecraft().renderGlobal.loadRenderers();
    }
}
