package task3;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ClicheForJson {
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public int id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String title;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String value;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<ClicheForJson> tests;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<ClicheForJson> values;

    public static ClicheForJson getClicheFromJson(File file, ObjectMapper mapper) throws IOException {
        return mapper.readValue(new File("B:\\dir\\tests.json"), ClicheForJson.class);
    }


    @Override
    public String toString() {
        return "id = " + id + "\n" +
                "title = " + title + "\n" +
                "value = " + value + "\n" +
                "tests = " + tests + "\n" +
                "values = " + values + "\n";

    }
}
