package hust.soict.hedspi.javafx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    private Color currentColor = Color.BLACK; // Default to black (Pen)

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, currentColor);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void usePen(ActionEvent event) {
        currentColor = Color.BLACK; // Set color to black for Pen
    }

    @FXML
    void useEraser(ActionEvent event) {
        currentColor = Color.WHITE; // Set color to white for Eraser
    }

}
