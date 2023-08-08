package Data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader {

    public List<HashMap<Object, Object>> getDataToMap(String filePath) throws IOException {
        //Read json to String
        String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

        //String to Hasmap-Jackson DataBind
        ObjectMapper mapper = new ObjectMapper();
        /*List<HashMap<Object, Object>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<Object, Object>>>() {
        });

        return data;*/

        return mapper.readValue(jsonContent, new TypeReference<List<HashMap<Object, Object>>>() {
        });
    }
}
