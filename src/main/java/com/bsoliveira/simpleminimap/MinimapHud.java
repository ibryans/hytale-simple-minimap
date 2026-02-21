package com.bsoliveira.simpleminimap;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.entities.player.hud.CustomUIHud;
import com.hypixel.hytale.server.core.ui.builder.UICommandBuilder;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import javax.annotation.Nonnull;

public class MinimapHud extends CustomUIHud {
    public MinimapHud(@NonNullDecl PlayerRef playerRef) {
        super(playerRef);
    }

    public void updateTime(String currentTime) {
        UICommandBuilder uiCommandBuilder = new UICommandBuilder();
        uiCommandBuilder.set("#TimeLabel.TextSpans", Message.raw(currentTime));

        update(false, uiCommandBuilder);
    }

    @Override
    public void build(@Nonnull UICommandBuilder uiCommandBuilder) {
        uiCommandBuilder.append("MinimapUI.ui");
    }
}
