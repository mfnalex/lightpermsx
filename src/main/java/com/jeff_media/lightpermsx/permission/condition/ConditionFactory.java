package com.jeff_media.lightpermsx.permission.condition;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ConditionFactory {

    public static List<Condition> createConditionsFromString(@NotNull String commaSeparatedConditionList) {
        String[] splitByCommas = commaSeparatedConditionList.split(Condition.CHAR_CONDITIONS_SEPARATOR);
        List<Condition> conditions = new ArrayList<>();
        for(String conditionKeyValue : splitByCommas) {
            conditions.add(createSingleConditionFromString(conditionKeyValue));
        }
        return conditions;
    }

    public static Condition createSingleConditionFromString(@NotNull String conditionKeyValue) {
        String[] splitByEquals = conditionKeyValue.split(Condition.CHAR_KEY_VALUE_SEPARATOR);
        if(splitByEquals.length != 2) {
            throw new InvalidConditionStringException("Conditions must be in the format \"key=value\" but got \"" + conditionKeyValue + "\"");
        }
        String key = splitByEquals[0];
        String value = splitByEquals[1];
        return createSingleCondition(key, value);
    }

    public static Condition createSingleCondition(@NotNull String key, @NotNull String value) {
        boolean negate = false;
        if(value.startsWith(Condition.CHAR_NEGATE)) {
            negate = true;
            value = value.substring(1);
        }
        switch (key) {
            case "world":
                return new WorldCondition(value, negate);
            default:
                throw new InvalidConditionStringException("Unknown condition key \"" + key + "\"");
        }
    }
}
