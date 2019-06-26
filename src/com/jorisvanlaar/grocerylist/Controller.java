package com.jorisvanlaar.grocerylist;

import com.jorisvanlaar.grocerylist.datamodel.BonusCard;
import com.jorisvanlaar.grocerylist.datamodel.Customer;
import com.jorisvanlaar.grocerylist.datamodel.Product;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.util.Optional;
import static javafx.scene.paint.Color.GREEN;

public class Controller {

    @FXML
    private BorderPane mainPanel;

    @FXML
    private TableView<Product> productsTable;

    @FXML
    private Label totalPriceLabel;

    @FXML
    private Label bonusCardLabel;

    @FXML
    private Label discountLabel;

    private Customer customer;

    public void initialize(){
        TextInputDialog nameDialog = new TextInputDialog();
        nameDialog.setTitle("Grocery List app");
        nameDialog.setHeaderText("Welcome to the Grocery List app!");
        nameDialog.setContentText("Please enter your name:");

        Optional<String> result = nameDialog.showAndWait();
        if (result.isPresent()){
            String name = result.get();
            customer = new Customer(name);
        } else{
            customer = new Customer("No name");
        }
        productsTable.setItems(customer.getGroceryList().getProducts());
        totalPriceLabel.setText(String.valueOf(customer.getGroceryList().getTotalPrice()));

        if(customer.hasBonusCard()){
            bonusCardLabel.setText(customer.getBonusCard().getBonusCardSerial());
        }
    }

    @FXML
    public void showAddProductDialog(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainPanel.getScene().getWindow());
        dialog.setTitle("Add New Product");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("productDialog.fxml"));

        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e){
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            ProductController productController = fxmlLoader.getController();
            Product newProduct = productController.getNewProduct();
            customer.getGroceryList().addProduct(newProduct);
            updateTotalPriceLabel();
        }
    }

    @FXML
    public  void deleteProduct(){

        Product selectedProduct = productsTable.getSelectionModel().getSelectedItem();
        if (selectedProduct == null){
            Alert unselectedAlert = new Alert(Alert.AlertType.INFORMATION);
            unselectedAlert.setTitle("No Product Selected");
            unselectedAlert.setHeaderText(null);
            unselectedAlert.setContentText("Please select the product you want to delete");
            unselectedAlert.showAndWait();
            return;
        }

        Alert deleteAlert = new Alert(Alert.AlertType.CONFIRMATION);
        deleteAlert.setTitle("Delete Product");
        deleteAlert.setHeaderText(null);
        deleteAlert.setContentText("Are you sure you want to delete the selected product: " + selectedProduct.getProductName() + "?");

        Optional<ButtonType> result = deleteAlert.showAndWait();
        if(customer.hasBonusCard()==false && result.isPresent() && result.get() ==  ButtonType.OK){
            customer.getGroceryList().deleteProduct(selectedProduct);
            updateTotalPriceLabel();
            return;
        }
        if(customer.hasBonusCard()==true && result.isPresent() && result.get() ==  ButtonType.OK){
            customer.getGroceryList().getDiscountedTotalPrice();
            customer.getGroceryList().deleteProduct(selectedProduct);
            updateTotalPriceLabel();
        }
    }

    @FXML
    public void showBonusDialog(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainPanel.getScene().getWindow());
        dialog.setTitle("Activate Bonus Card");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("bonusDialog.fxml"));

        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e){
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        BonusController bonusController = fxmlLoader.getController();

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        dialog.getDialogPane().lookupButton(ButtonType.OK).disableProperty()
                .bind(Bindings.createBooleanBinding(
                        () -> !bonusController.getBonusField().getText().matches("[0-9]+"),
                        bonusController.getBonusField().textProperty()
                ));

        Optional<ButtonType> result = dialog.showAndWait();
        if (customer.hasBonusCard()== false && result.isPresent() && result.get() == ButtonType.OK){

            BonusCard bonusCard = new BonusCard(bonusController.getNewSerial());
            customer.setBonusCard(bonusCard);
            bonusCardLabel.setTextFill(GREEN);
            bonusCardLabel.setText(bonusCard.getBonusCardSerial());
            discountLabel.setText(" - 10% discount applied");
            updateTotalPriceLabel();
            return;
        }

        if(customer.hasBonusCard()==true && result.get() != ButtonType.CANCEL){
            Alert serialAlert = new Alert(Alert.AlertType.INFORMATION);
            serialAlert.setTitle("Jammer de bammer");
            serialAlert.setHeaderText(null);
            serialAlert.setContentText("You've already entered a Bonus Card serial");
            serialAlert.showAndWait();
        }
    }

    public void updateTotalPriceLabel(){
        if (customer.hasBonusCard()==false){
            totalPriceLabel.setText(String.valueOf(customer.getGroceryList().getTotalPrice()));
        } else if (customer.hasBonusCard()==true){
            totalPriceLabel.setText(String.valueOf(customer.getGroceryList().getDiscountedTotalPrice()));
        } else{
            totalPriceLabel.setText("Bonus Card status unknown");
        }
    }
}
