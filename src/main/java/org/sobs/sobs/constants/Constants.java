package org.sobs.sobs.constants;

import javafx.scene.image.Image;
import javafx.stage.Screen;

import java.io.*;

public class Constants {
    public static final double SCREEN_WIDTH = Screen.getPrimary().getBounds().getWidth();
    public static final double SCREEN_HEIGHT = Screen.getPrimary().getBounds().getHeight();
    public static final double MENU_WIDTH = Screen.getPrimary().getBounds().getWidth() / 4;
    public static final double GAME_FIELD_WIDTH = Screen.getPrimary().getBounds().getWidth() - MENU_WIDTH;
    public static final String CURRENT_FILE_PATH = getCurrentFilePath();
    public static final double START_SCREEN_BUTTON_POSITION_X = SCREEN_WIDTH / 20;
    public static final double START_SCREEN_BUTTON_POSITION_Y = SCREEN_HEIGHT / 12;

    private static String getCurrentFilePath() {
        String currentFilePath = "";
        try {
            currentFilePath = String.valueOf(new File(Constants.class.getProtectionDomain().getCodeSource().getLocation().toURI()));
            currentFilePath = currentFilePath.replace("sobs.jar", "");
            currentFilePath = currentFilePath.replace("sobs.exe", "");
            if (currentFilePath.endsWith("classes")) {
                currentFilePath = currentFilePath +  "\\";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return currentFilePath;
    }
    public static ObjectOutputStream getObjectOutputStream(String path) {
        try {
            path = CURRENT_FILE_PATH + path;
            File file = new File(path);
            FileOutputStream fis = new FileOutputStream(file);
            ObjectOutputStream oin = new ObjectOutputStream(fis);
            return oin;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static ObjectInputStream getObjectInputStream(String path) {
        try {
            path = CURRENT_FILE_PATH + path;
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return ois;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Image getImage(String imageName) {
        try {
            return new Image(new FileInputStream(Constants.CURRENT_FILE_PATH + imageName));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
