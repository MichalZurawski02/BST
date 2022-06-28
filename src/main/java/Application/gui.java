package Application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import Handlers.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class gui extends Application
{

    @Override
    public void start(Stage mainStage) throws Exception
    {
        BorderPane mainLayout = new BorderPane();
        Scene scene = new Scene(mainLayout);
        //gora okna
        HBox top = new HBox();
        TextField userInput = new TextField();
        VBox result = new VBox();

        Socket socket = new Socket("localhost", 4444);

        OutputStream output = socket.getOutputStream();
        PrintWriter out = new PrintWriter(output, true);

        InputStream input = socket.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(input));

        treeType dialog = new treeType();
        dialog.showAndWait();
        String type = dialog.getType();
        out.println(type);

        myButton insertButton = new myButton(new insertHandler(userInput, type, in, out, result), "Insert");
        myButton searchButton = new myButton(new searchHandler(userInput, type, in, out, result), "Search");
        myButton deleteButton = new myButton(new deleteHandler(userInput, type, in, out, result), "Delete");
        myButton drawButton = new myButton(new drawHandler(userInput, type, in, out, result), "Draw");

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event ->
        {
            try
            {
                socket.close();
                Platform.exit();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }});

        top.getChildren().addAll(userInput, insertButton, searchButton, deleteButton, drawButton, exitButton);
        mainLayout.setTop(top);

        mainLayout.setCenter(result);



        result.setFillWidth(true);



        mainStage.setTitle("BST");
        mainStage.setHeight(1080);
        mainStage.setWidth(1920);
        mainStage.setScene(scene);
        mainStage.show();
    }

}