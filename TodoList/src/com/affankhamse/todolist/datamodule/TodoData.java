package com.affankhamse.todolist.datamodule;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

public class TodoData {
    private static TodoData instance = new TodoData();
    private String fileName = "TodoData.txt";

    private ObservableList<TodoItem> todoItems ;
    private DateTimeFormatter formatter ;

    public void addTodoItem(TodoItem item){
        todoItems.add(item);
    }

    public static TodoData getInstance(){
        return instance;
    }

    private TodoData(){
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public ObservableList<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(ObservableList<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    public void loadTodoData() throws IOException {
        todoItems = FXCollections.observableArrayList();
        Path path = Paths.get(fileName);
        BufferedReader br = Files.newBufferedReader(path);

        String input;
        try{
            while((input=br.readLine()) != null){
                String[] strings = input.split("\t");
                String shortDescription = strings[0];
                String detaail = strings[1];
                String date = strings[2];

                TodoItem todoItem = new TodoItem(shortDescription,detaail, LocalDate.parse(date,formatter));
                todoItems.add(todoItem);
            }
        }finally {
            if (br != null)
                br.close();
        }
    }

    public void storeTodoData() throws IOException{
        Path path = Paths.get(fileName);
        BufferedWriter bw = Files.newBufferedWriter(path);

        try{
            Iterator<TodoItem> iterator =  todoItems.iterator();
            while (iterator.hasNext()){
                TodoItem item = iterator.next();
                bw.write(String.format("%s\t%s\t%s",
                        item.getShortDescription(),
                        item.getDetails(),
                        item.getDeadline().format(formatter)));
                bw.newLine();
            }


        }finally {
            if (bw != null)
                bw.close();
        }
    }


    public void deleteTodoItem(TodoItem item) {
        if (todoItems.remove(item)){
            System.out.println("item Removed");
        }
    }
}
