package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

import java.util.concurrent.ExecutionException;

public class Controller {

    private Task<ObservableList<String>> task;

    private Service<ObservableList<String>> service;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private ListView nameListView;

    public void initialize(){
//        task = new Task<ObservableList<String>>() {
//            @Override
//            protected ObservableList<String> call() throws Exception {
//                System.out.println("Thread is Running");
//                String[] names = {
//                        "Affan","Arkam","Moiz",
//                        "Saad","Zaman","Abrar","Faiz","Waqas"
//                };
//                ObservableList<String> nameList = FXCollections.observableArrayList();
//                for(int i =0 ;i<names.length;i++){
//                    nameList.add(names[i]);
//                    updateProgress(i+1,names.length);
//                    Thread.sleep(200);
//                }
//
////                Platform.runLater(new Runnable() {
////                    @Override
////                    public void run() {
////                        nameListView.setItems(nameList);
////                    }
////                });
//                return nameList;
//            }
//        };
        service = new EmployeeService();
                //Item Binding
        nameListView.itemsProperty().bind(service.valueProperty());
        progressBar.progressProperty().bind(service.progressProperty());

        service.setOnRunning(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
                progressBar.setVisible(true);
            }
        });
        service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
                progressBar.setVisible(false);
            }
        });

//        // Using DataBinding Instead of Paltform.runLater()

    }

    @FXML
    public void buttonPressed(){
//        new Thread(task).start();
//        System.out.println("Button Pressed");

        if(service.getState() == Service.State.SUCCEEDED){
            service.reset();
            service.start();
        }else if(service.getState() == Service.State.READY)
            service.start();

    }
}
