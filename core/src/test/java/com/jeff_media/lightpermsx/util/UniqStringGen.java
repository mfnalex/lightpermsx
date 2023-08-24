package com.jeff_media.lightpermsx.util;

import java.util.HashSet;
import java.util.Set;

public class UniqStringGen extends StringGen {

    private final Set<String> depletedStrings = new HashSet<>();

    @Override
    public String getString() {
        String string = super.getString();
        while (depletedStrings.contains(string)) {
            string = super.getString() + getDigit();
        }
        depletedStrings.add(string);
        return string;
    }
}
