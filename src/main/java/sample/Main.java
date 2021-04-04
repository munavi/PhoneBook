package sample;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.List;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        TelefonBook telefonBook=new TelefonBook();
        EntryArea entryArea = new EntryArea(telefonBook.getNumbers());
//        SearchArea searchArea= new SearchArea(value -> entryArea.setItems(telefonBook.search(value)));
//        DeleteArea deleteArea=new DeleteArea(() -> {
//            ObservableList <TelefonEntry> selectedEntries= entryArea.getSelectedEntries();
//            telefonBook.delete(selectedEntries);
//        });

 //       AddArea addArea = new AddArea(() -> telefonBook.add(new TelefonEntry()));

        //SpeicherArea speicherArea= new SpeicherArea(new TriggerSave() {
        //   @Override
        // public void save() {
        // telefonBook.save();
        // }
        //});// здесь нужно переписать для лямбды аусдрука
        SaveArea saveArea= new SaveArea(() -> telefonBook.save());// здесь нужно переписать для лямбды аусдрука

//        LoadArea loadArea=new LoadArea(() -> telefonBook.load());

        HBox topHBox = new HBox();
//        topHBox.getChildren().add(loadArea.getPane());
        topHBox.getChildren().add(saveArea.getPane());
//        topHBox.getChildren().add(searchArea.getPane());
        topHBox.setAlignment(Pos.CENTER_LEFT);


        HBox bottomHBox = new HBox();
//        bottomHBox.getChildren().add(deleteArea.getPane());
//        bottomHBox.getChildren().add(addArea.getPane());
        bottomHBox.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setTop(topHBox);
        root.setBottom(bottomHBox);




        // root.setTop(searchArea.getPane());
        root.setCenter(entryArea.getPane());
        // root.setBottom(deleteArea.getPane());
        //root.setRight(addArea.getPane());
        //root.setLeft(saveArea.getPane());
        // root.setLeft(loadArea.getPane());

        // root.setLeft(); сделать один класс для одной кнопки как загрузка сохранение класс


        primaryStage.setTitle("Telefonbuch");
        primaryStage.setScene(new Scene(root, 370, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}