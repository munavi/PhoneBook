package sample;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class AddArea {


    final AnchorPane anchorPane = new AnchorPane();
    final Button addButton = new Button("Add");


    public AddArea(TriggerAdd triggerAdd) {
        AnchorPane.setTopAnchor(addButton, 10.0);
        AnchorPane.setRightAnchor(addButton, 10.0);
        AnchorPane.setBottomAnchor(addButton,10.0);
        addButton.setPrefWidth(70.0);


        anchorPane.getChildren().addAll(addButton);

        addButton.onActionProperty().setValue(actionEvent -> triggerAdd.add());}



    public Node getPane() {
        return anchorPane;
    }


}
