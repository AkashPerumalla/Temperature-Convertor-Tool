package com.internshala.javafxapp;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Optional;
public class MyMain extends Application {
    public static void main(String[] args) {
        System.out.println("main");
        launch(args);
    }
    @Override
    public void init() throws Exception {
        System.out.println("Init");
        super.init();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("start");
        FXMLLoader loader = new FXMLLoader(MyMain.class.getResource("app_layout.fxml"));
        VBox rootNode = loader.load();
        MenuBar menuBar= createMenu();
        rootNode.getChildren().addFirst(menuBar);
        Scene scene = new Scene(rootNode);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool");
        primaryStage.show();
    }
    private MenuBar createMenu() {
        //File Menu
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        newMenuItem.setOnAction(actionEvent -> System.out.println("New Menu Item Clicked..."));
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem quitMenuItem = new MenuItem("Quit");
        quitMenuItem.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });
        fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);
        //Help Menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutApp = new MenuItem("About App");
        aboutApp.setOnAction(actionEvent -> aboutApp());
        helpMenu.getItems().addAll(aboutApp);
        //Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }
    public void aboutApp() {
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My First Desktop App");
        alertDialog.setHeaderText("Learning JavaFX");
        alertDialog.setContentText("I am just a beginner but soon I will become pro and start developing awesome Java Games.");
        ButtonType yesBtn = new ButtonType("Yes");
        ButtonType noBtn = new ButtonType("No");
        alertDialog.getButtonTypes().setAll(yesBtn,noBtn);
        Optional<ButtonType> clickedBtn= alertDialog.showAndWait();
        if (clickedBtn.isPresent() && clickedBtn.get() == yesBtn){
            System.out.println("Yes btn clicked");
        } else {
            System.out.println("No btn clicked");
        }
    }
    @Override
    public void stop() throws Exception {
        System.out.println("Stop");
        super.stop();
    }
}