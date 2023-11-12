package contactApplication.dataModules;

import javafx.collections.ObservableList;

public final class ContactData {

    private ContactData contactData ;

    ObservableList<Contact> contacts ;

    private ContactData() {
        this.contactData = new ContactData();
    }
    public ContactData getInstance(){
        return contactData;
    }


}
