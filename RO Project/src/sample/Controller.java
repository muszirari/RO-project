package sample;

import javafx.fxml.FXML;
import javafx.scene.Scene;

import java.awt.*;

public class Controller {

    @FXML private Checkbox orientee;
    @FXML private TextField nbSommet;
    @FXML private TextField nbArc;

    public void createGraphe(){
        boolean isoriented = orientee.getState();
        int nbS = Integer.getInteger(nbSommet.getText());
        int nbA = Integer.getInteger(nbArc.getText());
    }
}
