package Handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class searchHandler extends myHandler
{

    public searchHandler(TextField userInput, String type, BufferedReader in, PrintWriter out, VBox result)
    {
        super(userInput, type, in, out, result);

    }

    @Override
    public void handle(ActionEvent arg0)
    {
        String toSearch = userInput.getText();
        out.println("search");
        out.println(toSearch);
        userInput.clear();
        try
        {
            System.out.println(in.readLine() + " ");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}