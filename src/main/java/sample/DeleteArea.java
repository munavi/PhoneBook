package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class DeleteArea {
    private final AnchorPane anchorPane = new AnchorPane();
    private final Button deleteButton = new Button("Delete");


    public DeleteArea(TriggerDelete triggerDelete) {
        AnchorPane.setTopAnchor(deleteButton, 10.0);
        AnchorPane.setRightAnchor(deleteButton, 10.0);
        AnchorPane.setBottomAnchor(deleteButton, 10.0);
        deleteButton.setPrefWidth(70.0);

        anchorPane.getChildren().add(deleteButton);
        deleteButton.onActionProperty().setValue(actionEvent -> triggerDelete.delete());
    }

    public Node getPane() {
        return anchorPane;
    }
}
