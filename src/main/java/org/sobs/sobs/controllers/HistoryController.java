package org.sobs.sobs.controllers;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.sobs.sobs.constants.Constants;
import org.sobs.sobs.images.BackGround;
import org.sobs.sobs.images.Button;
import org.sobs.sobs.images.Others;
import org.sobs.sobs.sounds.Sounds;
import org.sobs.sobs.sounds.SoundsName;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HistoryController {
    private final Stage STAGE = new Stage();
    private final Pane PANE = new Pane();
    private final Scene SCENE = new Scene(PANE, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
    private Sounds buttonEntered;
    private Sounds buttonExited;
    private Sounds buttonClick;
    private ImageView buttonBack;
    private ImageView buttonNext;
    private ImageView buttonPrevious;
    private ImageView buttonSelectArmor;
    private ImageView historySlide;
    private List<Image> historySlides = getSlides();
    private int slidesCount;
    private int currentSlide = 0;

    public void launch(Scene prevoiusScene) {
        STAGE.setX(0);
        STAGE.setY(0);
        setPane();
        setButton();
        STAGE.setScene(SCENE);
        STAGE.getIcons().add(Constants.getImage(Others.LOGO.getPath()));
        STAGE.setAlwaysOnTop(true);
        STAGE.initStyle(StageStyle.TRANSPARENT);
        STAGE.setResizable(false);
        STAGE.show();
        ((Stage) (prevoiusScene).getWindow()).close();
    }
    private void setPane() {
        ImageView backGround = new ImageView(Constants.getImage(BackGround.HISTORY_BACKGROUND.getPath()));
        backGround.setFitWidth(Constants.SCREEN_WIDTH);
        backGround.setFitHeight(Constants.SCREEN_HEIGHT);
        buttonBack = new ImageView(Constants.getImage(Button.BACK.getPath()));
        buttonBack.setLayoutX(Constants.START_SCREEN_BUTTON_POSITION_X);
        buttonBack.setLayoutY(Constants.SCREEN_HEIGHT - Constants.START_SCREEN_BUTTON_POSITION_Y);
        buttonNext = new ImageView(Constants.getImage(Button.NEXT.getPath()));
        buttonNext.setLayoutX(Constants.START_SCREEN_BUTTON_POSITION_X * 4);
        buttonNext.setLayoutY(Constants.SCREEN_HEIGHT - Constants.START_SCREEN_BUTTON_POSITION_Y * 2);
        buttonPrevious = new ImageView(Constants.getImage(Button.PREVIOUS.getPath()));
        buttonPrevious.setLayoutX(Constants.START_SCREEN_BUTTON_POSITION_X);
        buttonPrevious.setLayoutY(Constants.SCREEN_HEIGHT - Constants.START_SCREEN_BUTTON_POSITION_Y * 2);
        buttonSelectArmor = new ImageView(Constants.getImage(Button.SELECT_ARMOR.getPath()));
        buttonSelectArmor.setLayoutX(Constants.SCREEN_WIDTH - Constants.START_SCREEN_BUTTON_POSITION_X * 4);
        buttonSelectArmor.setLayoutY(Constants.SCREEN_HEIGHT - Constants.START_SCREEN_BUTTON_POSITION_Y);
        historySlide = new ImageView(historySlides.get(currentSlide));
        historySlide.setLayoutX(Constants.START_SCREEN_BUTTON_POSITION_X);
        historySlide.setLayoutY(Constants.START_SCREEN_BUTTON_POSITION_Y);
        historySlide.setFitWidth(historySlide.getImage().getWidth() / 3);
        historySlide.setFitHeight(historySlide.getImage().getHeight() / 3);
        buttonPrevious.setVisible(currentSlide != 0);
        buttonSelectArmor.setVisible(currentSlide == historySlides.size() - 1);
        PANE.getChildren().add(backGround);
        PANE.getChildren().add(buttonBack);
        PANE.getChildren().add(buttonNext);
        PANE.getChildren().add(buttonPrevious);
        PANE.getChildren().add(buttonSelectArmor);
        PANE.getChildren().add(historySlide);
    }
    private void setButton() {
        buttonBack.setOnMouseEntered(e -> {
            buttonBack.setImage(Constants.getImage(Button.BACK_ENTERED.getPath()));
            buttonEntered = new Sounds(SoundsName.BUTTON_ENTERED.getSoundName());
            buttonEntered.start();
        });
        buttonBack.setOnMouseExited(e -> {
            buttonBack.setImage(Constants.getImage(Button.BACK.getPath()));
            buttonExited = new Sounds(SoundsName.BUTTON_EXITED.getSoundName());
            buttonExited.start();
        });
        buttonBack.setOnMouseClicked(e -> {
            buttonBack.setImage(Constants.getImage(Button.BACK_CLICK.getPath()));
            buttonClick = new Sounds(SoundsName.BUTTON_CLICK.getSoundName());
            buttonClick.start();
            new StartController().launch();
            STAGE.close();
        });
        buttonNext.setOnMouseEntered(e -> {
            buttonNext.setImage(Constants.getImage(Button.NEXT_ENTERED.getPath()));
            buttonEntered = new Sounds(SoundsName.BUTTON_ENTERED.getSoundName());
            buttonEntered.start();
        });
        buttonNext.setOnMouseExited(e -> {
            buttonNext.setImage(Constants.getImage(Button.NEXT.getPath()));
            buttonExited = new Sounds(SoundsName.BUTTON_EXITED.getSoundName());
            buttonExited.start();
        });
        buttonNext.setOnMouseClicked(e -> {
            buttonNext.setImage(Constants.getImage(Button.NEXT_CLICK.getPath()));
            buttonClick = new Sounds(SoundsName.BUTTON_CLICK.getSoundName());
            buttonClick.start();
            changeSlide(1);
            if (currentSlide == historySlides.size() - 1){
                buttonSelectArmor.setVisible(true);
            }
        });
        buttonPrevious.setOnMouseEntered(e -> {
            buttonPrevious.setImage(Constants.getImage(Button.PREVIOUS_ENTERED.getPath()));
            buttonEntered = new Sounds(SoundsName.BUTTON_ENTERED.getSoundName());
            buttonEntered.start();
        });
        buttonPrevious.setOnMouseExited(e -> {
            buttonPrevious.setImage(Constants.getImage(Button.PREVIOUS.getPath()));
            buttonExited = new Sounds(SoundsName.BUTTON_EXITED.getSoundName());
            buttonExited.start();
        });
        buttonPrevious.setOnMouseClicked(e -> {
            buttonPrevious.setImage(Constants.getImage(Button.PREVIOUS_CLICK.getPath()));
            buttonClick = new Sounds(SoundsName.BUTTON_CLICK.getSoundName());
            buttonClick.start();
            changeSlide(-1);
        });
        buttonSelectArmor.setOnMouseEntered(e -> {
            buttonSelectArmor.setImage(Constants.getImage(Button.SELECT_ARMOR_ENTERED.getPath()));
            buttonEntered = new Sounds(SoundsName.BUTTON_ENTERED.getSoundName());
            buttonEntered.start();
        });
        buttonSelectArmor.setOnMouseExited(e -> {
            buttonSelectArmor.setImage(Constants.getImage(Button.SELECT_ARMOR.getPath()));
            buttonExited = new Sounds(SoundsName.BUTTON_EXITED.getSoundName());
            buttonExited.start();
        });
        buttonSelectArmor.setOnMouseClicked(e -> {
            buttonSelectArmor.setImage(Constants.getImage(Button.SELECT_ARMOR_CLICK.getPath()));
            buttonClick = new Sounds(SoundsName.BUTTON_CLICK.getSoundName());
            buttonClick.start();
        });
    }
    private List<Image> getSlides() {
        File dir = new File(Constants.CURRENT_FILE_PATH + "resources\\images\\characters\\");
        File[] arrFiles = dir.listFiles();
        slidesCount = arrFiles.length - 1;
        List<Image> list = new ArrayList<>();
        for (int i = 0; i < arrFiles.length; i++) {
            list.add(Constants.getImage(arrFiles[i].toString().replace(Constants.CURRENT_FILE_PATH, "")));
        }
        return list;
    }
    private void changeSlide(int i) {
        if (i > 0 && currentSlide < historySlides.size()) {
            currentSlide += i;
        }
        if (i < 0 && currentSlide > 0) {
            currentSlide += i;
        }
        historySlide.setImage(historySlides.get(currentSlide));
        buttonPrevious.setVisible(currentSlide != 0);
        buttonNext.setVisible(currentSlide != historySlides.size() - 1);
    }
}
