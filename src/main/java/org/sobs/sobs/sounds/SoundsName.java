package org.sobs.sobs.sounds;

public enum SoundsName {
    START_SCREEN("resources\\sounds\\StartScreenSound.mp3"),
    BUTTON_ENTERED("resources\\sounds\\button-entered.mp3"),
    BUTTON_CLICK("resources\\sounds\\button-click.mp3"),
    BUTTON_EXITED("resources\\sounds\\button-exited.mp3"),
    BUTTON_PRESSED(""),
    BUTTON_RELEASED("");
    String name;
    SoundsName(String name) {
        this.name = name;
    }
    public String getSoundName() {
        return this.name;
    }
}
