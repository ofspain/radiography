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
public class ProtractedController extends GeneralController {

    @FXML
    private JFXTextField r_Text, miuText, timeText, beta_alpha_ratio;
    @FXML
    private Label resultLabel;

    public ProtractedController(ScreensConfig config) {
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
    public void gotoSingleDosage(ActionEvent evt) {
        gotoSingleDosage();
    }

    @FXML
    public void gotoExtrapolated(ActionEvent evt) {
        gotoExtrapolated();
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
        if (fieldSettled(r_Text, miuText, timeText, beta_alpha_ratio)) {

            double result;
            double time = this.textValue(timeText.getText());
            if (time < 10) {
                result = this.smallTime();
            } else if (time < 100) {
                result = this.mediumTime();
            } else {
                result = this.largeTime();
            }

            String resultText = String.format("%.3f", result);
            resultLabel.setText(resultText);
        } else {
            this.showFieldRequiredDialog();
        }

    }

    @FXML
    public void clearField(ActionEvent evt) {
        clearField(resultLabel, r_Text, miuText, timeText, beta_alpha_ratio);
    }

    private double largeTime() {
        double r = this.textValue(r_Text.getText());
        double miu = this.textValue(miuText.getText());
        double b_a = this.textValue(beta_alpha_ratio.getText());

        double first = (2 * r) / miu;
        double second = first * b_a;
        return 1 + second;
    }

    private double mediumTime() {
        double r = this.textValue(r_Text.getText());
        double miu = this.textValue(miuText.getText());
        double b_a = this.textValue(beta_alpha_ratio.getText());
        double time = this.textValue(this.timeText.getText());

        double first = (2 * r) / miu;
        double second = first * b_a;
        double third = 1 - (1 / (miu * time));
        return 1 + second * third;
    }

    private double smallTime() {
        double r = this.textValue(r_Text.getText());
        double miu = this.textValue(miuText.getText());
        double b_a = this.textValue(beta_alpha_ratio.getText());
        double time = this.textValue(this.timeText.getText());

        double miu_time = miu * time;
        double first = Math.exp(-1 * miu_time);
        double second = (1 - first) * (1 / miu_time);
        double third = 1 - second;
        double fourth = (2 * r) / miu;
        double fifth = third * fourth * b_a;
        return 1 + fifth;
    }
    
    @FXML
    public void consumeNonNumber(KeyEvent evt){
        handleKeyTyped(evt);
    }
}
