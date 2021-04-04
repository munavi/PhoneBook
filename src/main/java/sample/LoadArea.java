package sample;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class LoadArea {
    final AnchorPane anchorPane = new AnchorPane();
    private final Button loadButton = new Button("Load");

    public LoadArea(TriggerLoad triggerLoad) {

        AnchorPane.setLeftAnchor(loadButton, 10.0);
        //AnchorPane.setRightAnchor(loadButton, 10.0);
        AnchorPane.setTopAnchor(loadButton, 10.0);
        AnchorPane.setBottomAnchor(loadButton, 10.0);
        loadButton.setMaxHeight(15);
        anchorPane.getChildren().addAll(loadButton);

        loadButton.onActionProperty().setValue(actionEvent -> triggerLoad.load());}



    public Node getPane() {
        return anchorPane;
    }

}