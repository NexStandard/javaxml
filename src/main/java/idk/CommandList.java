package idk;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

public class CommandList {
	    @JacksonXmlElementWrapper(useWrapping = false)
	    @JacksonXmlProperty(localName = "Command")
	    private List<Command> people = new ArrayList<>();

	    public List<Command> getPeople() {
	      return people;
	    }

	    public void setPeople(List<Command> people) {
	      this.people = people;
	    }
}
