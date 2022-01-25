package task3;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ValuesFromJson {
    public ResultOfTest resultOfTest;
    //            public int id;
//            public String value;
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    public List<ResultOfTest> values;

    public void setResultOfTest(ResultOfTest resultOfTest) {
        this.resultOfTest = resultOfTest;
    }

    public void setValues(List<ResultOfTest> values) {
        this.values = values;
    }

    public ResultOfTest getResultOfTest() {
        return resultOfTest;
    }

    public List<ResultOfTest> getValues() {
        return values;
    }

    public static ValuesFromJson getValueForJson(File file, ObjectMapper mapper) throws IOException {
        return mapper.readValue(new File("B:\\dir\\values.json"), ValuesFromJson.class);
    }

    @Override
    public String toString() {
        return //"id = " +id + "\n" +
                // "value = " +value + "\n" +
                "values = " +values + "\n";

    }
}
