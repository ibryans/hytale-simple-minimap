package com.bsoliveira.simpleminimap;

import com.hypixel.hytale.server.core.modules.interaction.interaction.config.Interaction;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;

import javax.annotation.Nonnull;

public class MinimapPlugin extends JavaPlugin {
    public MinimapPlugin(@Nonnull JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {
        this.getCodecRegistry(Interaction.CODEC).register("minimap_interaction", MinimapInteraction.class, MinimapInteraction.CODEC);
        this.getCodecRegistry(Interaction.CODEC).register("minimap_close_interaction", MinimapCloseInteraction.class, MinimapCloseInteraction.CODEC);
    }
}
