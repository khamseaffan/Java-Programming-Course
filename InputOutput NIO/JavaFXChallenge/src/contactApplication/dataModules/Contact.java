package contactApplication.dataModules;

import javafx.beans.property.SimpleStringProperty;

public class Contact {
    private SimpleStringProperty firstName = new SimpleStringProperty("");
    private SimpleStringProperty lastName = new SimpleStringProperty("");
    private SimpleStringProperty phoneNo = new SimpleStringProperty("");
    private SimpleStringProperty notes = new SimpleStringProperty("");

    public Contact(String firstName, String lastName, String phoneNo, String notes) {
        this.firstName.set(firstName);
        this.lastName.set(lastName) ;
        this.phoneNo.set(phoneNo) ;
        this.notes.set(notes);
    }

    public Contact() {
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getPhoneNo() {
        return phoneNo.get();
    }

    public SimpleStringProperty phoneNoProperty() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo.set(phoneNo);
    }

    public String getNotes() {
        return notes.get();
    }

    public SimpleStringProperty notesProperty() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }

    @Override
    public String toString() {
        return firstName.get() + "\t" + lastName.get() + "\t" + phoneNo.get() + "\t" + notes.get() + "\n" ;
    }
}
