package Application;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.layout.HBox;

/**
 * A class that customizes the dialog to provide informations on author and purpose of app
 */
public class treeType extends Dialog<Boolean>
{
    private String type = "";
    public treeType()
    {

        HBox hbox = new HBox(3);
        hbox.setPadding(new Insets(10,20,10,20));
        setTitle("Enter tree type");

        Button stringButton = new Button("String");
        Button intButton = new Button("Integer");
        Button doubleButton = new Button("Double");
        Button exitButton = new Button("Exit");

        exitButton.setOnAction(event ->
        {
            this.setResult(Boolean.TRUE);
            this.close();
            Platform.exit();
        });
        stringButton.setOnAction(event ->
        {
            type = "s";
            this.setResult(Boolean.TRUE);
            this.close();
        });
        intButton.setOnAction(event ->
        {
            type = "i";
            this.setResult(Boolean.TRUE);
            this.close();
        });
        doubleButton.setOnAction(event ->
        {
            type = "d";
            this.setResult(Boolean.TRUE);
            this.close();
        });
        hbox.getChildren().addAll(stringButton, intButton, doubleButton, exitButton);
        getDialogPane().setContent(hbox);
    }
    public String getType()
    {
        return type;
    }
}