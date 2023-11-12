package contactApplication;

import contactApplication.dataModules.Contact;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Controller {

    @FXML
    private TableView<Contact> tableView;
    @FXML
    private TableColumn<Contact , SimpleStringProperty> firstName;
    @FXML
    private TableColumn<Contact ,SimpleStringProperty> lastName;
    @FXML
    private TableColumn<Contact ,SimpleStringProperty> note;
    @FXML
    private TableColumn<Contact ,SimpleStringProperty> phoneNo;


    public void initialize(){

        for (Contact person : getContactList()){
            System.out.print(person);
        }

//        tableView.getColumns().addAll(firstName,lastName,phoneNo,note);
        tableView.setItems(getContactList());

        if (tableView.hasProperties())
            System.out.print("Work Done");
        else
            System.out.print("Faiiliure");


    }

    public ObservableList<Contact> getContactList() {

        ObservableList<Contact> contactList = FXCollections.observableArrayList();
        contactList.add(new Contact("Affan" , "Khamse", "9992546779",""));
        contactList.add(new Contact("Tahaa" , "Dawe", "7745166442","hashCode"));
        contactList.add(new Contact("Sanjay" , "Nadar", "2314121421","Hurry up!"));
        contactList.add(new Contact("Sahil" , "dangat", "3345642255",""));

        return contactList;
    }
}
