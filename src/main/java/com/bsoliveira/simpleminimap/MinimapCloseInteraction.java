package com.bsoliveira.simpleminimap;

import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.component.CommandBuffer;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.protocol.InteractionType;
import com.hypixel.hytale.server.core.entity.InteractionContext;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.modules.interaction.interaction.CooldownHandler;
import com.hypixel.hytale.server.core.modules.interaction.interaction.config.SimpleInstantInteraction;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class MinimapCloseInteraction extends SimpleInstantInteraction {

    // É obrigatório definir um CODEC próprio para que o servidor consiga converter o JSON na sua classe
    public static final BuilderCodec<MinimapCloseInteraction> CODEC = BuilderCodec.builder(
            MinimapCloseInteraction.class, MinimapCloseInteraction::new, SimpleInstantInteraction.CODEC
    ).build();

    @Override
    protected void firstRun(@NonNullDecl InteractionType interactionType, @NonNullDecl InteractionContext interactionContext, @NonNullDecl CooldownHandler cooldownHandler) {
        CommandBuffer<EntityStore> commandBuffer = interactionContext.getCommandBuffer();

        if (commandBuffer == null) {
            return;
        }

        Ref<EntityStore> ref = interactionContext.getEntity();
        Player player = commandBuffer.getComponent(ref, Player.getComponentType());
        PlayerRef playerRef = commandBuffer.getComponent(ref, PlayerRef.getComponentType());

        if (player != null && playerRef != null) {
            // Substitui o HUD atual pelo EmptyHud, escondendo o minimapa da tela
            player.getHudManager().setCustomHud(playerRef, new EmptyHud(playerRef));
        }
    }
}