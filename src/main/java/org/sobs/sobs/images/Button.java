package org.sobs.sobs.images;

public enum Button {
    BACK("resources\\images\\button\\back.png"),
    BACK_ENTERED("resources\\images\\button\\back_entered.png"),
    BACK_CLICK("resources\\images\\button\\back_click.png"),
    EXIT("resources\\images\\button\\exit.png"),
    EXIT_ENTERED("resources\\images\\button\\exit_entered.png"),
    EXIT_CLICK("resources\\images\\button\\exit_click.png"),
    LOAD("resources\\images\\button\\load.png"),
    LOAD_ENTERED("resources\\images\\button\\load_entered.png"),
    LOAD_CLICK("resources\\images\\button\\load_click.png"),
    MENU("resources\\images\\button\\menu.png"),
    MENU_ENTERED("resources\\images\\button\\menu_entered.png"),
    NEW_GAME("resources\\images\\button\\new_game.png"),
    NEW_GAME_ENTERED("resources\\images\\button\\new_game_entered.png"),
    NEW_GAME_CLICK("resources\\images\\button\\new_game_click.png"),
    NEXT("resources\\images\\button\\next.png"),
    NEXT_ENTERED("resources\\images\\button\\next_entered.png"),
    NEXT_CLICK("resources\\images\\button\\next_click.png"),
    NO("resources\\images\\button\\no.png"),
    PREVIOUS("resources\\images\\button\\previous.png"),
    PREVIOUS_ENTERED("resources\\images\\button\\previous_entered.png"),
    PREVIOUS_CLICK("resources\\images\\button\\previous_click.png"),
    SELECT_ARMOR("resources\\images\\button\\select_armor.png"),
    SELECT_ARMOR_ENTERED("resources\\images\\button\\select_armor_entered.png"),
    SELECT_ARMOR_CLICK("resources\\images\\button\\select_armor_click.png"),
    SETTINGS("resources\\images\\button\\settings.png"),
    SETTINGS_ENTERED("resources\\images\\button\\settings_entered.png"),
    SETTINGS_CLICK("resources\\images\\button\\settings_click.png"),
    YES("resources\\images\\button\\yes.png"),
    START("resources\\images\\button\\start.png"),
    START_ENTERED("resources\\images\\button\\start_entered.png");
    final String path;

    Button(String path) {
        this.path = path;
    }
    public String getPath() {
        return this.path;
    }
}
