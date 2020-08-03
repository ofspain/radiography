/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiography;

import com.jfoenix.controls.JFXTextField;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author femi
 */
public abstract class GeneralController {

    protected ScreensConfig config;

    public GeneralController(ScreensConfig config) {
        this.config = config;
    }

    public void showHomeHelp() {
    }

    public void exitApp() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("CONFIRMATION");
        alert.setHeaderText(null);
        alert.setContentText("DO YOU REALLY WANT TO EXIT APPLICATION?");
        alert.setResizable(false);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(0);
        } else {
            alert.hide();
        }

    }

    public void gotoSingleDosage() {
        config.loadSingleDose();
    }

    public void gotoHome() {
        config.loadHome();
    }

    public void gotoExtrapolated() {
        config.loadExtrapolated();
    }

    public void gotoIrradiation() {
        config.loadProtracted();
    }

    public void gotoNonPermanent() {
        config.loadNonPermanent();
    }

    public void gotoPermanent() {
        config.loadPermanent();
    }

    public void clearField(Label label, JFXTextField... doseField) {
        for (JFXTextField f : doseField) {
            f.setText("");
        }
        label.setText("");
    }

    public boolean fieldSettled(JFXTextField... doseField) {
        for (JFXTextField f : doseField) {
            if (null == f.getText() || f.getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    public double textValue(String text) {
        return Double.valueOf(text);
    }

    public void showFieldRequiredDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("WARNING");
        alert.setHeaderText(null);
        alert.setContentText("PLEASE ENSURED ALL FIELDS ARE ENTERED");
        alert.setResizable(false);
        alert.showAndWait();

    }

    private boolean someOtherCharater(Character c){
        return c.equals('.') || c.equals('-');
    }
    public void handleKeyTyped(KeyEvent evt) {
        String str = evt.getCharacter();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            Character c = str.charAt(i);
            if(!Character.isDigit(c) && !someOtherCharater(c)){
                evt.consume();
            }

        }
    }
}
