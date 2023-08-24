package com.jeff_media.lightpermsx.permission.condition;

import com.jeff_media.lightpermsx.entity.XPlayer;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;


@ToString
@EqualsAndHashCode(callSuper = true)
public class WorldCondition extends SimpleStringCondition {

    public WorldCondition(String value, boolean negate) {
        super("world", value, negate);
    }

    @Override
    public boolean isSatisified(@NotNull XPlayer player) {
        return super.isSatisified(player.getWorldName());
    }
}
