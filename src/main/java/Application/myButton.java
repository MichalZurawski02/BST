package Application;

import Handlers.myHandler;
import javafx.scene.control.Button;

public class myButton extends Button
{
    public myButton(myHandler event, String name)
    {
        super(name);
        this.setOnAction(event);
    }
}