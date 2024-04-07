package idk;

import java.io.IOException;
import java.util.Collection;

import javax.xml.namespace.QName;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

public class CommandSerializer extends JsonSerializer<Collection<Command>> {

	@Override
	public void serialize(Collection<Command> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		boolean toXml = gen instanceof ToXmlGenerator;
        if (!toXml) {
            // fallback to the default behavior for non-xml serialization
            gen.writeObject(value);
            return;
        }
        gen.writeStartArray();
        if (value != null) {
            for (Command item : value) {
                if (item == null) {
                    continue;
                }
                JsonTypeName jsonTypeName;
                if ((jsonTypeName = item.getClass().getAnnotation(JsonTypeName.class)) != null) {
                    // read JsonTypeName as the xml element name
                    // if JsonTypeName not present, use the default name
                    ((ToXmlGenerator) gen).setNextName(new QName("", jsonTypeName.value()));
                }
                gen.writeObject(item);
            }
        }
        gen.writeEndArray();
		
		
	}

}
