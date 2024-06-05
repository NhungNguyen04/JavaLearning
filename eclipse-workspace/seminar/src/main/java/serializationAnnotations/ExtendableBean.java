package serializationAnnotations;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExtendableBean {
	public String name;
	private Map<String, String> properties;
	

	@JsonAnyGetter
	public Map<String, String> getProperties() {
		return properties;
	}
	
	@Test
	public void whenSerializingUsingJsonAnyGetter_thenCorrect()
	throws JsonProcessingException {
		ExtendableBean bean = new ExtendableBean();
		bean.properties.add(“attr1”, “val1”);
		bean.add(“attr2”, “val2”);
		String result = new ObjectMapper().writeValueAsString(bean);
		assertThat(result, containsString(“attr1”));
		assertThat(result, containsString(“val1”));
	}
}
