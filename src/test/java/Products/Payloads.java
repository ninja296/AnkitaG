package Products;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Payloads {
    public static String getCreateProductPayloadFromString(String title, String price, String description, String categoryId,
                                                 String imagesLink){
        String payload = "{\n" +
                "  \"title\": \""+title+"\",\n" +
                "  \"price\": "+ price +",\n" +
                "  \"description\": \""+description+"\",\n" +
                "  \"categoryId\": "+categoryId+",\n" +
                "  \"images\": [\""+imagesLink+"\"]\n" +
                "}";
        return payload;
    }

    public static Map<String, Object> getCreateProductPayloadFromMap(String title, String price, String description, String categoryId,
                                                 String imagesLink){
        Map<String, Object> payload = new LinkedHashMap<String, Object>();
        payload.put("title", title);
        payload.put("price",price);
        payload.put("description",description);
        payload.put("categoryId",categoryId);
        payload.put("images", new String[]{imagesLink});
        return payload;
    }
}
