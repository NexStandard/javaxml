package idk;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


public class Main {
    public static void main(String[] args) throws Exception {
        // Erstellen einer Liste von Command-Objekten
        ArrayList<CreateSchemaCommand> commands = new ArrayList<>();
        commands.add(new CreateSchemaCommand());
        // commands.add(new DropSchemaCommand());

        // Erstellen eines XML-Mappers
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // Die Liste in eine XML-Datei serialisieren
        var s = xmlMapper.writeValueAsString(commands);
        System.out.println(s);
    }
}