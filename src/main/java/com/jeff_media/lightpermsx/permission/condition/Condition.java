package com.jeff_media.lightpermsx.permission.condition;

import com.jeff_media.lightpermsx.entity.XPlayer;
import lombok.*;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


@ToString
@EqualsAndHashCode
public abstract class Condition {

    public static final String CHAR_NEGATE = "!";
    public static final String CHAR_KEY_VALUE_SEPARATOR = "=";
    public static final String CHAR_CONDITIONS_SEPARATOR = ",";

    @Getter
    private final String key;

    protected Condition(String key) {
        this.key = key;
    }

    public abstract boolean isSatisified(@NotNull String value);

    public abstract boolean isSatisified(@NotNull XPlayer player);

    public abstract String getAsKeyEqualsValueString();
}
