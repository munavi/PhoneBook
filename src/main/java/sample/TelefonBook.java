package sample;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TelefonBook {
    private final ObservableList<TelefonEntry> observableList= FXCollections.observableArrayList(new ArrayList<>());


    private final FilteredList<TelefonEntry> filteredList= new FilteredList<>(observableList);
    public TelefonBook(){
        observableList.add(new TelefonEntry("Anna", "Gerbert","1234"));
        observableList.add(new TelefonEntry("Jakob","Wieder","1456"));

    }


    public ObservableList <TelefonEntry> getNumbers(){ return observableList; }

    public List<TelefonEntry> search(Object value){
        filteredList.setPredicate(telefonEntry-> telefonEntry.contains((String) value));
        return filteredList;
    }

    public void delete(ObservableList<TelefonEntry> entries) {
        observableList.removeAll(entries);
    }

    public void add(TelefonEntry entry) {
        observableList.add(entry);
    }

    public void save() {
        JsonFactory factory;
        factory= new JsonFactory();
        Path path= Paths.get("/home/munavi/IdeaProjects/PhoneBook/src/main/java/sample/entries.json");

        try (OutputStream  os = Files.newOutputStream(path);
             JsonGenerator  generator = factory.createGenerator(os)) {

            generator.writeStartArray();
            //  Verwenden  Sie jg um fuer  jeden  Eintrag  im  Telefonbuch
            //  entsprechende  Objekte  im JSON zu  erzeugen
            for (TelefonEntry entry : observableList) {
                generator.writeStartObject();
                generator.writeStringField("firstName", entry.getFirstName());
                generator.writeStringField("lastName", entry.getLastName());
                generator.writeStringField("number", entry.getNumber());
                generator.writeEndObject();
            }

            generator.writeEndArray();


        } catch (IOException e) {
            e.printStackTrace ();}


    }


    public void load(){
        Path path= Paths.get("/home/munavi/IdeaProjects/PhoneBook/src/main/java/sample/entries.json");

        try (InputStream is = Files.newInputStream(path)) {
            ObjectMapper  mapper = new  ObjectMapper ();
            JsonNode  root = mapper.readTree(is);
            if (root.isArray()) {
                for (JsonNode e : root) {
                    String fn = e.get("firstname").asText();
                    String ln=e.get("lastname").asText();
                    String n=e.get("number").asText();


                    observableList.add(new TelefonEntry(fn,ln,n));
                }
            }

        } catch (IOException e){
            e.printStackTrace ();
        }

    }


}










