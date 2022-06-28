package Handlers;

import java.io.BufferedReader;
import java.io.PrintWriter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public abstract class myHandler implements EventHandler<ActionEvent>
{
    TextField userInput;
    String type;
    PrintWriter out;
    BufferedReader in;
    VBox result;

    public myHandler(TextField userInput, String type, BufferedReader in, PrintWriter out, VBox result)
    {
        this.userInput = userInput;
        this.type = type;
        this.in = in;
        this.out = out;
        this.result = result;
    }
}