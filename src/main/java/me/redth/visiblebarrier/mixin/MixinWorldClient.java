package me.redth.visiblebarrier.mixin;

import me.redth.visiblebarrier.VBConfig;
import me.redth.visiblebarrier.VisibleBarrier;
import net.minecraft.client.multiplayer.WorldClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldClient.class)
public class MixinWorldClient {
    @Inject(method = "doVoidFogParticles", at = @At("HEAD"), cancellable = true)
    public void getRenderType(CallbackInfo ci) {
        if (VisibleBarrier.config.enabled && VBConfig.hideBarrierParticles)
            ci.cancel();
    }

}
