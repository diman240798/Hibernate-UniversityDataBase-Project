package executeProgram;


import hibernateUtil.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;

import java.util.Locale;
import java.util.ResourceBundle;


public class ExecuteProgram extends Application {


            public static final SessionFactory session = HibernateUtil.getSessionFactory();
            @Override
            public void start(Stage primaryStage) throws Exception{
                FXMLLoader fxmlLoader = new FXMLLoader();


                fxmlLoader.setResources(ResourceBundle.getBundle("bundles.Locale", new Locale("en")));

                primaryStage.setTitle(fxmlLoader.getResources().getString("Table_Scientist"));
                Pane root = (Pane) fxmlLoader.load(getClass().getClassLoader().getResource("fxml_Files/program.fxml"));
                primaryStage.setScene(new Scene(root));


               // choiceOfLanguage();
                primaryStage.show();
            }

    public static void main(String[] args) {
            launch(args);
        }


   /* private void choiceOfLanguage() {
        ChoiceBox chooseLanguage = new Program_Controller().chooseLanguage;
        chooseLanguage.setValue("Select Lang");
        chooseLanguage.setOnAction(
                value ->
                {
                 switch (chooseLanguage.getValue().toString()){
                     case "en":
                 }
                });
    }*/
}

