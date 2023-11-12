package com.affankhamse.todolist;

import com.affankhamse.todolist.datamodule.TodoData;
import com.affankhamse.todolist.datamodule.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DialogController {

    @FXML
    private TextField shortDescriptionField;
    @FXML
    private TextArea detailField;
    @FXML
    private DatePicker deadlineField;

    public TodoItem processResult(){

        String shortDescription = shortDescriptionField.getText().trim();
        String detail = detailField.getText().trim();
        LocalDate deadline = deadlineField.getValue();
        TodoItem newItem = new TodoItem(shortDescription, detail,deadline);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;

    }
}
