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
public class NonPermanentController extends GeneralController {

    @FXML
    private JFXTextField r_nutText, lamdaText, miuText, timeText, beta_alpha_ratio;
    @FXML
    private Label resultLabel;

    public NonPermanentController(ScreensConfig config) {
        super(config);
    }

    @FXML
    public void gotoHome(MouseEvent evt) {
        gotoHome();
    }

    @FXML
    public void showHomeHelp(MouseEvent evt) {
    }

    @FXML
    public void exitApp(MouseEvent evt) {
        exitApp();
    }

    @FXML
    public void gotoSingleDosage(ActionEvent evt) {
        gotoSingleDosage();
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
        if (fieldSettled(r_nutText, lamdaText, miuText, timeText, beta_alpha_ratio)) {
            double result1 = firstTerm();
            double result2 = thirdTerm() - fourthTerm();
            double result3 = result2 * secondTerm();

            double result = 1 + result1 * result3;

            String resultText = String.format("%.3f", result);
            resultLabel.setText(resultText);
        } else {
            showFieldRequiredDialog();
        }

    }

    @FXML
    public void clearField(ActionEvent evt) {
        this.clearField(resultLabel, r_nutText, lamdaText, miuText, timeText, beta_alpha_ratio);
    }

    private double firstTerm() {
        double rNut = textValue(r_nutText.getText());
        double lamdaVal = textValue(lamdaText.getText());
        double miuVal = textValue(miuText.getText());
        double beta_alpharatio = textValue(beta_alpha_ratio.getText());

        double first = (2 * rNut * lamdaVal) / (miuVal - lamdaVal);
        return (first * beta_alpharatio);

    }

    private double secondTerm() {

        double time = textValue(timeText.getText());
        double lamdaVal = textValue(lamdaText.getText());
        double power = -1 * time * lamdaVal;
        double first = 1 - Math.exp(power);
        return 1 / first;
    }

    private double thirdTerm() {
        double time = textValue(timeText.getText());
        double lamdaVal = textValue(lamdaText.getText());
        double power = -2 * time * lamdaVal;

        double first = 1 - Math.exp(power);
        double second = 1 / (2 * lamdaVal);

        return first * second;

    }

    private double fourthTerm() {

        double lamdaVal = textValue(lamdaText.getText());
        double miuVal = textValue(miuText.getText());
        double time = textValue(timeText.getText());

        double first = 1 / (miuVal + lamdaVal);
        double power = time * (miuVal + lamdaVal);
        double second = 1 - Math.exp(power);
        return first * second;
    }
    
    @FXML
    public void consumeNonNumber(KeyEvent evt){
        handleKeyTyped(evt);
    }
}
