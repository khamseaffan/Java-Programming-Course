package com.affankhamse.todolist;

import com.affankhamse.todolist.datamodule.TodoData;
import com.affankhamse.todolist.datamodule.TodoItem;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.io.IOException;
import java.security.Key;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Controller {
    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea detailTextArea;
    @FXML
    private Label deadlineLable;
    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private ContextMenu listContextMenu;
    @FXML
    private ToggleButton filterToggelbutton;

    private FilteredList<TodoItem> filteredList;
    private final Predicate<TodoItem> wantAllItem = new Predicate<TodoItem>() {
        @Override
        public boolean test(TodoItem todoItem) {
            return true;
        }
    };
    private final Predicate<TodoItem> todaysitem = new Predicate<TodoItem>() {
        @Override
        public boolean test(TodoItem todoItem) {
            return todoItem.getDeadline().equals(LocalDate.now());
        }
    };

    public void initialize() {

        listContextMenu = new ContextMenu();
        MenuItem deletMenuItem = new MenuItem("Delete");
        deletMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                deletItem(item);
            }
        });
        listContextMenu.getItems().addAll(deletMenuItem);

        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem todoItem, TodoItem t1) {

                if (t1!=null){
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    detailTextArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d,yyyy");
                    deadlineLable.setText(df.format(item.getDeadline()));
                }
            }
        });

        filteredList = new FilteredList<>(TodoData.getInstance().getTodoItems(), wantAllItem);


        SortedList<TodoItem> sortedList = new SortedList<>(filteredList,
                new Comparator<TodoItem>() {
                    @Override
                    public int compare(TodoItem o1, TodoItem o2) {
                        return o1.getDeadline().compareTo(o2.getDeadline());
                   }
                });

//        todoListView.setItems(TodoData.getInstance().getTodoItems()); -> it provide with unsorted list
        todoListView.setItems(sortedList);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();

        todoListView.setCellFactory(new Callback<ListView<TodoItem>, ListCell<TodoItem>>() {
            @Override
            public ListCell<TodoItem> call(ListView<TodoItem> todoItemListView) {
                ListCell<TodoItem> cell = new ListCell<>(){
                    @Override
                    protected void updateItem(TodoItem todoItem, boolean empty) {
                        super.updateItem(todoItem, empty);
                        if (empty){
                            setText(null);
                        }else {
                            setText(todoItem.getShortDescription());
                            if (todoItem.getDeadline().isBefore(LocalDate.now().plusDays(1)))
                                setTextFill(Color.RED);
                            else if (todoItem.getDeadline().equals(LocalDate.now().plusDays(1)))
                                setTextFill(Color.ORANGE);

                        }
                    }
                };

                cell.emptyProperty().addListener(
                        (obs, wasEmpty, isNowEmpty)->{
                            if (isNowEmpty){
                                cell.setContextMenu(null);
                            }
                            else
                                cell.setContextMenu(listContextMenu);
                        }
                );

                return cell;
            }
        });
    }

    @FXML
    public void showNewItemDialog(){
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("newItemDialog.fxml"));
        dialog.setTitle("Add New TodoItem");
        dialog.setHeaderText("Start Writing New todoItem ");

        try{
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }catch (IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK){
            DialogController dialogController = fxmlLoader.getController();
            TodoItem newItem = dialogController.processResult();
//            todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());
            todoListView.getSelectionModel().select(newItem);
//            todoListView.getSelectionModel().selectLast();
        }
    }
    
    public void handelExit() throws IOException{
        Platform.exit();
    }
    public void deletItem(TodoItem item){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Todo Item");
        alert.setHeaderText("Delet Item: " + item.getShortDescription());
        alert.setContentText("Press Ok to confirm or CANCLE to go back");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && (result.get()==ButtonType.OK)){
            TodoData.getInstance().deleteTodoItem(item);
        }
    }
    @FXML
    public void handelKeyPressed(KeyEvent keyEvent) {
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        if (item != null) {
            if (keyEvent.getCode().equals(KeyCode.DELETE))
                deletItem(item);
        }
    }

    @FXML
    public void handelFilterButton(){

        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();

        if (filterToggelbutton.isSelected()){
             filteredList.setPredicate(todaysitem);
             if (filteredList.isEmpty()) {
                 detailTextArea.clear();
                 deadlineLable.setText("");
             }else if (filteredList.contains(selectedItem)){
                 todoListView.getSelectionModel().select(selectedItem);
             }else {
                 todoListView.getSelectionModel().selectFirst();
             }
        }else {
            filteredList.setPredicate(wantAllItem);
            todoListView.getSelectionModel().select(selectedItem);
        }
    }
}
