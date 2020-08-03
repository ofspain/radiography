/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiography;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author femi
 */
public class ExtrapolatedController extends GeneralController {

    @FXML
    private JFXTextField r_Text, dosage;
    @FXML
    private Label resultLabel;

    public ExtrapolatedController(ScreensConfig config) {
        super(config);
    }

    @FXML
    public void showHomeHelp(MouseEvent evt) {
    }

    @FXML
    public void exitApp(MouseEvent evt) {
        exitApp();
    }

    @FXML
    public void gotoSingleDose(ActionEvent evt) {
        gotoSingleDosage();
    }

    @FXML
    public void gotoIrradiation(ActionEvent evt) {
        gotoIrradiation();
    }

    @FXML
    public void gotoNonPermanent(ActionEvent evt) {
        gotoNonPermanent();
    }

    @FXML
    public void gotoPermanent(ActionEvent evt) {
        gotoPermanent();
    }

    @FXML
    public void gotoHome(MouseEvent evt) {
        gotoHome();
    }

    @FXML
    public void calculateResult(ActionEvent evt) {

        if (fieldSettled(r_Text, dosage)) {

            double r = this.textValue(this.r_Text.getText());
            double d = this.textValue(this.dosage.getText());
            double result = r * d;

            String resultText = String.format("%.3f", result);
            resultLabel.setText(resultText);
        } else {
            showFieldRequiredDialog();
        }
    }

    @FXML
    public void clearField(ActionEvent evt) {
        clearField(resultLabel, r_Text, dosage);
    }
    
    @FXML
    public void consumeNonNumber(KeyEvent evt){
        handleKeyTyped(evt);
    }

}
