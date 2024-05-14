package utils;


import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();
    public static Map<String, Object> getJsonDataAsMap(String JsonFileName) throws IOException {
        String  completeJsonFilePath = System.getProperty("user.dir")+"/src/test/resources"+JsonFileName;
        Map<String, Object> data = objectMapper.readValue(new File(completeJsonFilePath), new TypeReference<>(){});
    return data;
    }
}
