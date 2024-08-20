package nourl.mythicmetalsdecorations.compat;

import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.widget.Bounds;
import nourl.mythicmetalsdecorations.screen.MythicChestScreen;

public class MythicMetalsDecorationsEmiPlugin implements EmiPlugin {
    @Override
    public void register(EmiRegistry registry) {
        registry.addExclusionArea(MythicChestScreen.class, (screen, consumer) -> {
            if (!screen.getSize().needsScrolling()) return;

            int x = screen.getHandledScreenX() + screen.getBackgroundWidth();
            int y = screen.getHandledScreenY();
            consumer.accept(new Bounds(x, y, 16, screen.getSize().paddedHeight() + 15));
        });
    }
}
