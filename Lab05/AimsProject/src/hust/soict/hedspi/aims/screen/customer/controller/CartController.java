package hust.soict.hedspi.aims.screen.customer.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import hust.soict.hedspi.aims.cart.Cart;
 import hust.soict.hedspi.aims.media.Media;
import java.net.URL;
import java.util.ResourceBundle;

public class CartController implements Initializable {
    private Cart cart;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    // Optionally, other fields such as costLabel, filter TextField, etc.

    // Constructor to inject Cart
    public CartController(Cart cart) {
        this.cart = cart;
    }

    // Default no-arg constructor (FXMLoader needs it)
    public CartController() {}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set up columns
        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        // Bind cart data to TableView
        if (cart != null && cart.getItemsOrdered() != null) {
            tblMedia.setItems(cart.getItemsOrdered());
        }

        // Hide buttons by default
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Add listener to TableView selection
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });
    }

    // Optional: If cart is set after construction
    public void setCart(Cart cart) {
        this.cart = cart;
        if (tblMedia != null && cart.getItemsOrdered() != null) {
            tblMedia.setItems(cart.getItemsOrdered());
        }
    }


    private void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {

            btnRemove.setVisible(true);


            btnPlay.setVisible(canPlayMedia(media));
        }
    }


    private boolean canPlayMedia(Media media) {

        return false;
    }

    @FXML
    private void btnRemovePressed() {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia != null && cart != null) {
            cart.removeMedia(selectedMedia);
        }
    }

}
