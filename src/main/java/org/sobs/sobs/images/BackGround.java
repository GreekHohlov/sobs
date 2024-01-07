package org.sobs.sobs.images;

public enum BackGround {
    START_BACKGROUND("resources\\images\\textures\\background\\start_background.png"),
    HISTORY_BACKGROUND("resources\\images\\textures\\background\\history_background.png");
    final String path;
    BackGround(String path) {
        this.path = path;
    }
    public String getPath() {
        return this.path;
    }
}
