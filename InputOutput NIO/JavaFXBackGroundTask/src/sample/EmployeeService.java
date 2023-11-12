package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class EmployeeService extends Service<ObservableList<String>> {
    @Override
    protected Task<ObservableList<String>> createTask() {
        return new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                System.out.println("Thread is Running");
                String[] names = {
                        "Affan","Arkam","Moiz",
                        "Saad","Zaman","Abrar","Faiz","Waqas"
                };
                ObservableList<String> nameList = FXCollections.observableArrayList();
                for(int i =0 ;i<names.length;i++){
                    nameList.add(names[i]);
                    updateProgress(i+1,names.length);
                    Thread.sleep(200);
                }
                return nameList;
            }
        };

    }
}
