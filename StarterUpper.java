import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;

/*
 * In order to help learn course concepts, I worked on the homework with Allen Jiang,
 * discussed homework topics and issues with Allen Jiang,
 * and/or consulted related material that can be found at stackoverflow.com
 */

/**
 * @Override
 * @author Dean Hiromasa Miyata-Dawson
 * @version 12/3/2023
 * represents a start-up idea
 * extends application super-class
protected Object clone() throws CloneNotSupportedException {
    // TODO Auto-generated method stub
    return super.clone();
} */
public class StarterUpper extends Application {

    /**
     * start method
     * @param mainStage window of this JavaFX application
     */
    public void start(Stage mainStage) {
        File file = new File("ideas.txt");
        ArrayList<StartUpIdea> startUpIdeaList = new ArrayList<StartUpIdea>();

        Label name = new Label("Created By: Dean Hiromasa Miyata-Dawson");

        TextField problemInput = new TextField();
        Label problem = new Label("What is the problem? ");

        TextField targetCustomerInput = new TextField();
        Label targetCustomer = new Label("Who is the target customer? ");

        TextField customerNeedInput = new TextField();
        Label customerNeed = new Label("How badly does the customer NEED this problem fixed (1-10)? ");

        TextField knownPeopleWithProblemInput = new TextField();
        Label knownPeopleWithProblem = new Label("How many people do you know who might experience this problem? ");

        TextField targetMarketSizeInput = new TextField();
        Label targetMarketSize = new Label("How big is the target market? ");

        TextField competitorsInput = new TextField();
        Label competitors = new Label("Who are the competitors/existing solutions? ");

        Button submitButton = new Button();
        submitButton.setText("Add Idea to List");

        /*
         * Lambda Expression
         * Set each value of the answers to the form to the appropriate datatype
         * Submit a new start-up idea to the startUpIdeaList
         * If any of the datatypes do not align with the expected input, throw a NumberFormatException
         * catch a NumberFormatException
         */
        submitButton.setOnAction(event -> {
            try {
                StartUpIdea thisStartUpIdea = new StartUpIdea(problem.getText(), targetCustomer.getText(),
                    Integer.parseInt(customerNeed.getText()), Integer.parseInt(knownPeopleWithProblem.getText()),
                    Integer.parseInt(targetMarketSize.getText()), competitors.getText());

                startUpIdeaList.add(thisStartUpIdea);
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Input Type");
                alert.setContentText("This is not a valid input.");
                alert.showAndWait();
            }
        });

        Button sortButton = new Button();
        sortButton.setText("Sort Ideas by Potential");
        sortButton.setOnAction(event -> Collections.sort(startUpIdeaList));

        Button saveButton = new Button();
        saveButton.setText("Save Ideas to a File");

        /*
         * Anonymous Inner Class
         * EventHandler handles the event of when saveButton is clicked
         */
        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                FileUtil.saveIdeasToFile(startUpIdeaList, file);
            }
        };

        saveButton.setOnAction(handler);

        Button resetButton = new Button();
        resetButton.setText("Reset Form");

        /*
         * Lambda Expression
         * If the file does not exists, throw a FileNotFoundException
         * Show a confirmation type alert
         * Change the "ok" and "cancel" buttons to "yes" and "no"
         * If the user clicks "yes", delete the file and clear the idea list as well as all text fields
         * If the user clicks "no", close the alert window
         * catch FileNotFoundException
         */
        resetButton.setOnAction(event -> {
            try {
                if (!(file.exists())) {
                    throw new FileNotFoundException();
                }

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Are You Sure?");
                alert.setContentText("This will delete the entire list of start-up ideas and clear the form.");

                ButtonType yesButton = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.getButtonTypes().setAll(yesButton, noButton);

                alert.showAndWait().ifPresent(buttonType -> {
                    if (buttonType.getButtonData() == ButtonBar.ButtonData.YES) {
                        file.delete();
                        startUpIdeaList.clear();
                        problemInput.clear();
                        targetCustomerInput.clear();
                        customerNeedInput.clear();
                        knownPeopleWithProblemInput.clear();
                        targetMarketSizeInput.clear();
                        competitorsInput.clear();
                    } else {
                        alert.close();
                    }
                });
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        });

        HBox input1 = new HBox();
        input1.setAlignment(Pos.CENTER);
        input1.getChildren().addAll(problem, problemInput);

        HBox input2 = new HBox();
        input2.setAlignment(Pos.CENTER);
        input2.getChildren().addAll(targetCustomer, targetCustomerInput);

        HBox input3 = new HBox();
        input3.setAlignment(Pos.CENTER);
        input3.getChildren().addAll(customerNeed, customerNeedInput);

        HBox input4 = new HBox();
        input4.setAlignment(Pos.CENTER);
        input4.getChildren().addAll(knownPeopleWithProblem, knownPeopleWithProblemInput);

        HBox input5 = new HBox();
        input5.setAlignment(Pos.CENTER);
        input5.getChildren().addAll(targetMarketSize, targetMarketSizeInput);

        HBox input6 = new HBox();
        input6.setAlignment(Pos.CENTER);
        input6.getChildren().addAll(competitors, competitorsInput);

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(30);
        root.getChildren().addAll(name, input1, input2, input3, input4, input5,
            input6, submitButton, sortButton, saveButton, resetButton);

        Scene scene = new Scene(root, 600, 600);
        mainStage.setTitle("Problem Ideation Form");
        mainStage.setScene(scene);
        mainStage.show();
    }
}
