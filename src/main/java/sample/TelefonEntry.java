package sample;

import javafx.beans.property.SimpleStringProperty;

public class TelefonEntry {

    private final SimpleStringProperty lastName = new SimpleStringProperty();
    private final SimpleStringProperty  firstName = new SimpleStringProperty();
    private final SimpleStringProperty  number = new SimpleStringProperty();
    private boolean isNew = true;

    public TelefonEntry() {
        this.lastName.set("Last Name");
        this.firstName.set("Fist Name");
        this.number.set("Number");
        isNew = true;
    }



    public TelefonEntry(String lastName, String firstName, String number) {
        this.lastName.set(lastName);
        this.firstName.set(firstName);
        this.number.set(number);
        isNew = false;
    }

    public String getLastName() {

        return lastName.get();
    }

    public void setLastName(String value) {
        lastName.set(value);
        isNew = false;
    }

    public String getFirstName() {

        return firstName.get();
    }

    public void setFirstName(String value) {
        firstName.set(value);
        isNew = false;
    }

    public String getNumber() {

        return number.get();
    }

    public void setNumber(String value) {
        number.set(value);
        isNew = false;
    }

    public boolean isNew() {
        return isNew;
    }
    public boolean contains(String searchTerm){
        return  isNew() || firstName.get().contains(searchTerm)
                || lastName.get().contains(searchTerm)
                || number.get().contains(searchTerm);

    }
}