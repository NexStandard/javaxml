package idk;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


public class Main {
    public static void main(String[] args) throws Exception {
        // Erstellen einer Liste von Command-Objekten
    	CommandList s = new CommandList();
    	
        List<Command> commands = s.getPeople();
        commands.add(new CreateSchemaCommand());
        commands.add(new DropSchemaCommand());

        // Erstellen eines XML-Mappers
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.disable(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);

        // Die Liste in eine XML-Datei serialisieren
        var s2 = xmlMapper.writeValueAsString(s);
        System.out.println(s2);
    }
}