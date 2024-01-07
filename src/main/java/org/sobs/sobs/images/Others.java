package org.sobs.sobs.images;

public enum Others {
    LOGO ("resources\\images\\others\\logo.png");
    final String PATH;
    Others(String path) {
        this.PATH = path;
    }
    public String getPath() {
        return this.PATH;
    }
}
