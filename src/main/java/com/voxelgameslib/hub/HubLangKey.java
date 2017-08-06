package com.voxelgameslib.hub;

import com.voxelgameslib.voxelgameslib.lang.ExternalTranslatable;
import com.voxelgameslib.voxelgameslib.lang.Translatable;

import java.util.UUID;
import javax.annotation.Nonnull;

public enum HubLangKey implements ExternalTranslatable {

    DUMMY("dummy"),

    LADDERKING_NEW("{yellow}{king}{aqua} is the new LadderKing!", "king"),
    LADDERKING_NEW_OTHER("{yellow}{oldking}{aqua} is no longer the LadderKing. {yellow}{king}{aqua} is the new LadderKing!", "oldking", "king"),
    LADDERKING_LEFT_THRONE("{yellow}{king}{aqua} left his throne", "king");

    @Nonnull
    private final String defaultValue;

    @Nonnull
    private final String[] args;

    private static UUID uuid = UUID.randomUUID();

    HubLangKey(@Nonnull String defaultValue, @Nonnull String... args) {
        this.defaultValue = defaultValue;
        this.args = args;
    }

    /**
     * @return the default value for this lang key, in english
     */
    @Override
    @Nonnull
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * @return the arguments that this key requires
     */
    @Override
    @Nonnull
    public String[] getArgs() {
        return args;
    }

    @Override
    @Nonnull
    public UUID getUuid() {
        return uuid;
    }

    @Override
    @Nonnull
    public Translatable[] getValues() {
        return values();
    }
}
