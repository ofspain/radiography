/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiography;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author femi
 */
public class RadioGraphy extends Application {

    private  ScreensConfig screen;
    private final static int WIDTH = 450;
    private final static int HEIGHT = 647;
    @Override
    public void start(Stage primaryStage) {
        Platform.setImplicitExit(true);

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        screen = context.getBean(ScreensConfig.class);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        screen.setPrimaryStage(primaryStage);
        screen.showMainScreen();
        screen.loadHome();
        
        
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    

}
