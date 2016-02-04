package cn.openjpa.demos.utils;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.ext.ContextResolver;

import org.glassfish.jersey.moxy.json.MoxyJsonConfig;

public class JsonMoxyConfigurationContextResolver implements ContextResolver<MoxyJsonConfig>{

	private final MoxyJsonConfig config;
	 
    public JsonMoxyConfigurationContextResolver() {
        final Map<String, String> namespacePrefixMapper = new HashMap<String, String>();
        namespacePrefixMapper.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
        
        config = new MoxyJsonConfig()
            .setNamespacePrefixMapper(namespacePrefixMapper)
            .setNamespaceSeparator(':')
//            .setAttributePrefix("")
//            .setValueWrapper("value")
//            .property(JAXBContextProperties.JSON_WRAPPER_AS_ARRAY_NAME, true)
            .setFormattedOutput(false)
            .setIncludeRoot(false)
            .setMarshalEmptyCollections(false);
    }
 
    @Override
    public MoxyJsonConfig getContext(Class<?> objectType) {
        return config;
    }

}
