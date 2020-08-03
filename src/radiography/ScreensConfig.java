/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiography;

import java.net.URL;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author femi
 */
@Configuration
@Lazy

public class ScreensConfig {

    public static final int WIDTH = 480;
    public static final int HEIGHT = 320;

    private Stage stage;
    private Scene scene;
    private StackPane root;

    public void setPrimaryStage(Stage primaryStage) {
        this.stage = primaryStage;
    }

    public void showMainScreen() {
        root = new StackPane();
        stage.setTitle("SpringFX");
        scene = new Scene(root, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.setResizable(false);

        stage.setOnHiding(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) {
                System.exit(0);
                // TODO you could add code to open an "are you sure you want to exit?" dialog
            }
        });

        stage.show();
    }

    private void setNode(Node node) {
        root.getChildren().setAll(node);
    }

    private void setNodeOnTop(Node node) {
        root.getChildren().add(node);
    }

    public void removeNode(Node node) {
        root.getChildren().remove(node);
    }

    private Node getNode(final GeneralController control, URL location) {
        FXMLLoader loader = new FXMLLoader(location);
        loader.setControllerFactory(new Callback<Class<?>, Object>() {
            public Object call(Class<?> aClass) {
                return control;
            }
        });

        try {
            return (Node) loader.load();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Stage getStage() {
        return stage;
    }

    @Bean
    @Scope("prototype")
    HomeController loadHomeController() {
        return new HomeController(this);
    }
    
    @Bean
    @Scope("prototype")
    ExtrapolatedController loadExtrapolatedController() {
        return new ExtrapolatedController(this);
    }
    @Bean
    @Scope("prototype")
    PermanentController loadPermanentController() {
        return new PermanentController(this);
    }
    @Bean
    @Scope("prototype")
    NonPermanentController loadnonPermenentController() {
        return new NonPermanentController(this);
    }
    @Bean
    @Scope("prototype")
    SingleDoseController loadSingleDoseController() {
        return new SingleDoseController(this);
    }
    @Bean
    @Scope("prototype")
    ProtractedController loadProtractedController() {
        return new ProtractedController(this);
    }

    void loadHome() {
        setNode(getNode(loadHomeController(), getClass().getResource("home.fxml")));
    }

    public void loadSingleDose() {
        setNode(getNode(loadSingleDoseController(), getClass().getResource("single_dose.fxml")));
    }

    public void loadExtrapolated() {
        setNode(getNode(loadExtrapolatedController(), getClass().getResource("erd.fxml")));
    }

    public void loadProtracted() {
        setNode(getNode(loadProtractedController(), getClass().getResource("protracted.fxml")));
    }

    public void loadNonPermanent() {
        setNode(getNode(loadnonPermenentController(), getClass().getResource("non_permanent.fxml")));
    }

    public void loadPermanent() {
        setNode(getNode(loadPermanentController(), getClass().getResource("permanent.fxml")));

    }
    
    
}
