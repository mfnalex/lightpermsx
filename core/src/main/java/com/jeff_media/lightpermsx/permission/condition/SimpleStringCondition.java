package com.jeff_media.lightpermsx.permission.condition;

import com.jeff_media.lightpermsx.entity.XPlayer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@ToString
@EqualsAndHashCode(callSuper = true)
public class SimpleStringCondition extends Condition {

    private final String value;
    private final boolean negate;

    public SimpleStringCondition(String key, String value, boolean negate) {
        super(key);
        this.value = value;
        this.negate = negate;
    }

    @Override
    public boolean isSatisified(@NotNull String value) {
        boolean equals = this.value.equals(value);
        return negate != equals;
    }

    @Override
    public boolean isSatisified(@NotNull XPlayer player) {
        throw new UnsupportedOperationException("SimpleStringCondition cannot be used with Players");
    }

    @Override
    public String getAsKeyEqualsValueString() {
        StringBuilder builder = new StringBuilder(getKey());
        builder.append(CHAR_KEY_VALUE_SEPARATOR);
        if(negate) {
            builder.append(CHAR_NEGATE);
        }
        builder.append(value);
        return builder.toString();
    }
}
