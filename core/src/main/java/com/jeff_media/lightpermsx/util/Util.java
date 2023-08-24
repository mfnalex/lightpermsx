package com.jeff_media.lightpermsx.util;

import com.jeff_media.lightpermsx.LightPermsX;
import lombok.experimental.UtilityClass;

import java.io.InputStream;

@UtilityClass
public class Util {
    public InputStream getFileAsIOStream(final String fileName) {
        InputStream ioStream = LightPermsX.class
                .getClassLoader()
                .getResourceAsStream("/" + fileName);

        if (ioStream == null) {
            throw new IllegalArgumentException(fileName + " is not found");
        }
        return ioStream;
    }
}
