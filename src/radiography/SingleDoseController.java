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
public class SingleDoseController extends GeneralController {

    @FXML
    private JFXTextField doseField, beta_to_alphaRatio;
    @FXML
    private Label resultLabel;

    public SingleDoseController(ScreensConfig config) {
        super(config);
    }

    @FXML
    public void showHomeHelp(MouseEvent evt) {
    }

    @FXML
    public void gotoHome(MouseEvent evt) {
        gotoHome();
    }

    @FXML
    public void exitApp(MouseEvent evt) {
        exitApp();
    }

    @FXML
    public void gotoExtrapolated(ActionEvent evt) {
        gotoExtrapolated();
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
    public void calculateResult(ActionEvent evt) {
        if (fieldSettled(doseField, beta_to_alphaRatio)) {

            double dosage = Double.valueOf(doseField.getText());
            double beta_to_alpha = Double.valueOf(beta_to_alphaRatio.getText());
            double result = 1 + (dosage * beta_to_alpha);
            String resultText = String.format("%.3f", result);
            resultLabel.setText(resultText);
        } else {
            this.showFieldRequiredDialog();
        }
    }

    @FXML
    public void clearField(ActionEvent evt) {
        clearField(resultLabel, doseField, beta_to_alphaRatio);

    }
    
    @FXML
    public void consumeNonNumber(KeyEvent evt){
        handleKeyTyped(evt);
    }
}
