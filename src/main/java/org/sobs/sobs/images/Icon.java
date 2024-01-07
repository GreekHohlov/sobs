package org.sobs.sobs.images;

public enum Icon {
    COIN("resources\\images\\icons\\coin.png"),
    HEART("resources\\images\\icons\\heart.png");
    final String path;
    Icon(String path) {
        this.path = path;
    }
    public String getPath() {
        return this.path;
    }
}
