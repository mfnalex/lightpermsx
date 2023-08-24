package com.jeff_media.lightpermsx.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MockWorld implements XWorld {

    public static final MockWorld WORLD = new MockWorld("world", XEnvironment.NORMAL);
    public static final MockWorld NETHER = new MockWorld("world_nether", XEnvironment.NETHER);
    public static final MockWorld THE_END = new MockWorld("world_the_end", XEnvironment.THE_END);

    private final String name;
    private final XEnvironment dimension;

}
