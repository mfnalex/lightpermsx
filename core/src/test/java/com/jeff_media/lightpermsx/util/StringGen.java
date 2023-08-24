package com.jeff_media.lightpermsx.util;

import com.jeff_media.lightpermsx.util.Util;
import org.apache.commons.io.IOUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class StringGen {

    private final ThreadLocalRandom random = ThreadLocalRandom.current();
    private final List<String> nouns;
    private final List<String> adjectives;

    private StringGen(List<String> nouns, List<String> adjectives) {
        this.nouns = nouns;
        this.adjectives = adjectives;
    }

    StringGen() {
        nouns = IOUtils.readLines(Util.getFileAsIOStream("nouns.txt"), StandardCharsets.UTF_8);
        adjectives = IOUtils.readLines(Util.getFileAsIOStream("adjectives.txt"), StandardCharsets.UTF_8);
    }

    public String getString() {
        return getAdjective() + getNoun();
    }

    private String getAdjective() {
        return nouns.get(random.nextInt(nouns.size()));
    }

    private String getNoun() {
        return adjectives.get(random.nextInt(adjectives.size()));
    }

    public String getDigit() {
        return String.valueOf(random.nextInt(0,99));
    }

}
