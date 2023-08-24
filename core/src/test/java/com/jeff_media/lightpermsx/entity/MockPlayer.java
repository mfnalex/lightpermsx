package com.jeff_media.lightpermsx.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class MockPlayer extends XPlayer {

    public static MockPlayer mfnalex(){
        return new MockPlayer(
                UUID.fromString("2214115f-fb07-49da-a954-8c757801be03"),
                "mfnalex",
                MockWorld.WORLD,
                XGameMode.SURVIVAL);
    }

    private final UUID uniqueId;
    private final String name;
    private final XWorld world;
    private final XGameMode gameMode;

}
