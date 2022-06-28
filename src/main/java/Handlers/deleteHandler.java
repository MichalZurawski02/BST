package Handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class deleteHandler extends myHandler
{



    public deleteHandler(TextField userInput, String type, BufferedReader in, PrintWriter out, VBox result)
    {
        super(userInput, type, in, out, result);

    }

    @Override
    public void handle(ActionEvent arg0)
    {
        String toDelete = userInput.getText();
        userInput.clear();
        out.println("delete");
        out.println(toDelete);
        try
        {
            System.out.println(in.readLine() + " ");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static class drawHandler extends myHandler
    {
        public drawHandler(TextField userInput, String type, BufferedReader in, PrintWriter out, VBox result)
        {
            super(userInput, type, in, out, result);
        }

        @Override
        public void handle(ActionEvent arg0)
        {
            try
            {
                out.println("draw");
                result.getChildren().clear();
                Label toDraw = new Label(in.readLine());
                result.getChildren().add(toDraw);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
}