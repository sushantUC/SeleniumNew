package util;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import java.util.Map;

/**
 * Created by sushant on 05/02/19.
 */
public class JsonUtil {

    public static <T> T stringToJson(String json, Class<T> typeOfT) {
        return new Gson().fromJson(json, typeOfT);
    }

    public static Map<String, String> jsonToMap(String json) {
        return stringToJson(json, Map.class);
    }

    public static Object stringToJson(String json) {
        return new JsonParser().parse(json);
    }

}

   /* public static void main(String[] args)  throws NoSuchElementException {
        String strJson = "{'successful':'true','message':null,'errors':null,'warnings':null,'picklistCode': '1000431','pickSetName': 'DEFAULT',picker\":null,\"pickSetType\":\"STOCKING\",\"destination\":\"INVOICING\",\"statusCode\":\"CREATED\",\"pickBucketScannedQuantity\":{},\"skuToScanIdentifier\":{\"skun580\":\"skun580\"},\"pickInstructions\":{\"code1\":{\"skun580\":{\"quantity\":1,\"productName\":\"skun580\",\"validItemCodes\":[\"1810171014839\",\"1810171014877\",\"1810171014834\",\"1810171014798\",\"1810171014831\",\"1810171014875\",\"1810171014832\",\"1810171014876\",\"1810171014837\",\"1810171014838\",\"1810171014835\",\"1810171014836\",\"1810171014830\",\"1810171014828\",\"1810171014829\",\"1810171014822\",\"1810171014866\",\"1810171014823\",\"1810171014867\",\"1810171014820\",\"1810171014864\",\"1810171014821\",\"1810171014865\",\"1810171014826\",\"1810171014827\",\"1810171014824\",\"1810171014868\",\"1810171014825\",\"1810171014869\",\"1810171014862\",\"1810171014863\",\"1810171014860\",\"1810171014861\",\"1810171014819\",\"1810171014817\",\"1810171014818\",\"1810171014855\",\"1810171014856\",\"1810171014853\",\"1810171014854\",\"1810171014815\",\"1810171014859\",\"1810171014816\",\"1810171014813\",\"1810171014857\",\"1810171014814\",\"1810171014858\",\"1810171014851\",\"1810171014852\",\"1810171014850\",\"1810171014807\",\"1810171014844\",\"1810171014845\",\"1810171014842\",\"1810171014843\",\"1810171014848\",\"1810171014849\",\"1810171014846\",\"1810171014847\",\"1810171014840\",\"1810171014841\"],\"imageUrl\":null}}}}";

        JsonObject picklistDetailsJson = (JsonObject) JsonUtil.stringToJson(strJson);

        System.out.println(picklistDetailsJson);

        System.out.println(picklistDetailsJson.get("pickInstructions").getAsJsonObject().get("code1").getAsJsonObject().get("skun580").getAsJsonObject().get("validItemCodes"));

        JsonArray validItemCode = (JsonArray)picklistDetailsJson.get("pickInstructions").getAsJsonObject().get("code1").getAsJsonObject().get("skun580").getAsJsonObject().get("validItemCodes");

        System.out.println(validItemCode);
        Iterator<JsonElement> iterator= validItemCode.iterator();
       *//* while (iterator.hasNext()){
            System.out.println("sout: " +iterator.next());
        }*//*

        for(int i=1; i<=3; i++)
        {
           // validItemCode.toString().trim().
            for (int j=1; j<=2; j++){
            System.out.println(validItemCode.get(i).getAsBigInteger());
            }

            //validItemCode.get(i).getAsNumber();
        }*/



