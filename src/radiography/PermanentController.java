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
public class PermanentController extends GeneralController {

    @FXML
    private JFXTextField r_nutText, lamdaText, miuText, beta_alpha_ratio;
    @FXML
    private Label resultLabel;

    public PermanentController(ScreensConfig config) {
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
    public void gotoPermanent(ActionEvent evt) {
        gotoPermanent();
    }

    @FXML
    public void calculateResult(ActionEvent evt) {
        if (fieldSettled(r_nutText, lamdaText, miuText, beta_alpha_ratio)) {
        double r_nut = this.textValue(this.r_nutText.getText());
        double miu = this.textValue(this.miuText.getText());
        double lamda = this.textValue(this.lamdaText.getText());
        double b_a = this.textValue(this.beta_alpha_ratio.getText());

        double first = r_nut / (miu + lamda);
        double second = first * b_a;

        double result = 1 + second;

        String resultText = String.format("%.3f", result);
        resultLabel.setText(resultText);}else{
            showFieldRequiredDialog();
        }
    }

    @FXML
    public void clearField(ActionEvent evt) {
    }
    
    @FXML
    public void consumeNonNumber(KeyEvent evt){
        handleKeyTyped(evt);
    }
}
