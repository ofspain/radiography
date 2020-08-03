/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiography;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author femi
 */
public class HomeController extends GeneralController {

    public HomeController(ScreensConfig config) {
        super(config);
    }

    @FXML
    public void showHomeHelp(MouseEvent evt) {
        showHomeHelp();
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

}
