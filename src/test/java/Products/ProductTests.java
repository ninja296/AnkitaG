package Products;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JsonUtils;
import utils.RestUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProductTests {

    @Test
    public void createProduct() throws IOException {

        String env = System.getProperty("env") == null? "qa": System.getProperty("env");
        Map<String, Object> data = JsonUtils.getJsonDataAsMap("/"+env+"/productsApiData.json");
        String endPoint = (String) data.get("createProductEndPoint");
        Map<String, Object> payload = Payloads.getCreateProductPayloadFromMap("New Product","10","A description",
                "1","https://placeimg.com/640/480/any");
/*        Response response = RestAssured.given()
                .baseUri("https://api.escuelajs.co/api/v1/products/")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"title\": \"New Product\",\n" +
                        "  \"price\": 10,\n" +
                        "  \"description\": \"A description\",\n" +
                        "  \"categoryId\": 1,\n" +
                        "  \"images\": [\"https://placeimg.com/640/480/any\"]\n" +
                        "}")
                .post()
                .then().log().all().extract().response();*/
        Response response = RestUtils.performPost(endPoint, payload, new HashMap<>());
        Assert.assertEquals(response.statusCode(),201);
    }
}
