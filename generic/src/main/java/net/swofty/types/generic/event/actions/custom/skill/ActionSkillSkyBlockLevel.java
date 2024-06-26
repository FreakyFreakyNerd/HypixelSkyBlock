package net.swofty.types.generic.event.actions.custom.skill;

import net.kyori.adventure.text.Component;
import net.minestom.server.event.Event;
import net.swofty.types.generic.event.EventNodes;
import net.swofty.types.generic.event.EventParameters;
import net.swofty.types.generic.event.SkyBlockEvent;
import net.swofty.types.generic.event.custom.SkillUpdateEvent;
import net.swofty.types.generic.levels.SkyBlockLevelCause;
import net.swofty.types.generic.levels.causes.SkillLevelCause;
import net.swofty.types.generic.skill.SkillCategories;
import net.swofty.types.generic.skill.SkillCategory;
import net.swofty.types.generic.user.SkyBlockPlayer;
import net.swofty.types.generic.utility.StringUtility;

import java.util.Arrays;

@EventParameters(description = "Handles the level up message in regards to Skills",
        node = EventNodes.CUSTOM,
        requireDataLoaded = false)
public class ActionSkillSkyBlockLevel extends SkyBlockEvent {
    @Override
    public Class<? extends Event> getEvent() {
        return SkillUpdateEvent.class;
    }

    @Override
    public void run(Event tempEvent) {
        SkillUpdateEvent event = (SkillUpdateEvent) tempEvent;
        if (event.getNewValueRaw() <= event.getOldValueRaw()) return;

        SkyBlockPlayer player = event.getPlayer();
        SkillCategories skillCategory = event.getSkillCategory();

        int oldLevel = skillCategory.asCategory().getLevel(event.getOldValueRaw());
        int newLevel = skillCategory.asCategory().getLevel(event.getNewValueRaw());

        if (oldLevel == newLevel) return;

        player.getSkyBlockExperience().addExperience(SkyBlockLevelCause.getSkillCause(skillCategory, newLevel));
    }
}
