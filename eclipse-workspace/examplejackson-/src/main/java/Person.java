import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
	
	
	@JsonIgnore 
	// Purpose: Exclude fields from serialization or deserialization
	private String privateEmail;
	
	@JsonProperty("fullName") 
	// Purpose: rename a field for serialization or deserialization
    private String name;
	
	private int age;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	// Purpose: Customize date formatting or other property-level configurations
    private Date dob;
	
	
	private Map<String, Object> additionalProperties = new HashMap<>();
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }
    @JsonAnySetter
    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
    // Purpose: Handle dynamic or unknown properties.
	
	public Person(String string, int i, Date dob2, String email) {
		name = string;
		age = i;
		dob = dob2;
		privateEmail = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
	    return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDOB() {
		return dob;
	}
	public void setDOB(Date date) {
		this.dob = date;
	}
	public String getPrivateEmail() {
		return privateEmail;
	}
	public void setPrivateEmail(String name) {
		this.privateEmail = name;
	}
}
