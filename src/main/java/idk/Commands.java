package idk;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS )
@JsonSubTypes({ 
      @Type(value = CreateSchemaCommand.class, name = "CreateSchema"), 
      @Type(value = DropSchemaCommand.class, name = "DropSchema") 
    })
interface Command {
    void execute();
}

class CreateSchemaCommand implements Command {
	private int mandant;
	private String schemaName;
	
    @Override
    public void execute() {
        System.out.println("Executing CommandImpl1" + getSchemaName() + mandant);
    }

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}
}
@JacksonXmlRootElement
class DropSchemaCommand implements Command {
	private String schemaName;
    @Override
    public void execute() {
        System.out.println("Executing CommandImpl2" + schemaName);
    }
}