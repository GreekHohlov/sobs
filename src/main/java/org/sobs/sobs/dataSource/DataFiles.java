package org.sobs.sobs.dataSource;

public enum DataFiles {
    PLAYER("resources\\settings\\player");
    String path;
    DataFiles(String path) {
        this.path = path;
    }
    public String getFilePath() {
        return this.path;
    }
}
