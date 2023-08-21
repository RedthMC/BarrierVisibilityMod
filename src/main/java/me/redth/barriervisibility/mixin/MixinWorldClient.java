package me.redth.barriervisibility.mixin;

import me.redth.barriervisibility.ModConfig;
import me.redth.barriervisibility.BarrierVisibility;
import net.minecraft.client.multiplayer.WorldClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldClient.class)
public class MixinWorldClient {
    @Inject(method = "doVoidFogParticles", at = @At("HEAD"), cancellable = true)
    public void getRenderType(CallbackInfo ci) {
        if (BarrierVisibility.config.enabled && ModConfig.hideBarrierParticles)
            ci.cancel();
    }

}
