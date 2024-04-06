package idk;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "DbCommands")
public class CommandList {
	  @JacksonXmlProperty(localName = "Command")
	    @JacksonXmlElementWrapper(useWrapping = false)
	    private List<Command> people = new ArrayList<>();

	    public List<Command> getPeople() {
	      return people;
	    }

	    public void setPeople(List<Command> people) {
	      this.people = people;
	    }
}
