package sample;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


public class SaveArea {
    final AnchorPane anchorPane = new AnchorPane();
    private final Button saveButton = new Button("Save");

    public SaveArea(TriggerSave triggerSave) {

        AnchorPane.setLeftAnchor(saveButton, 10.0);
        AnchorPane.setRightAnchor(saveButton, 10.0);
        AnchorPane.setTopAnchor(saveButton, 10.0);
        AnchorPane.setBottomAnchor(saveButton, 10.0);

        anchorPane.getChildren().addAll(saveButton);

        saveButton.onActionProperty().setValue(actionEvent -> triggerSave.save());}



    public Node getPane() { return anchorPane;
    }

}

