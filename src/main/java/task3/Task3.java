package task3;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;

public class Task3 {

    static ObjectMapper mapper = new ObjectMapper();

    public static ClicheForJson getResultForWritingJson(ClicheForJson clicheForJson, ValuesFromJson valuesFromJson) {
        for (ResultOfTest element : valuesFromJson.values) {
            for (ClicheForJson el : clicheForJson.tests) {
                useRecursionWriteValuesToCliche(el, element);
            }

        }
        return clicheForJson;
    }

    private static ClicheForJson useRecursionWriteValuesToCliche(ClicheForJson clicheForJson, ResultOfTest resultOfTest) {
        if (clicheForJson.id == resultOfTest.id) {
            clicheForJson.value = resultOfTest.value;
            return clicheForJson;
        }
        if (clicheForJson.values != null) {
            for (ClicheForJson element : clicheForJson.values) {
                useRecursionWriteValuesToCliche(element, resultOfTest);
            }
        }
        return clicheForJson;
    }


    public static void main(String[] args) throws IOException {
        File fileTests = new File(args[0]);
        ClicheForJson clicheForJson = ClicheForJson.getClicheFromJson(fileTests, mapper);
        File fileValues = new File(args[1]);
        ValuesFromJson valuesFromJson = ValuesFromJson.getValueForJson(fileValues, mapper);

        ClicheForJson resultObject = Task3.getResultForWritingJson(clicheForJson, valuesFromJson);

        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        mapper.writeValue(new File("B:\\dir\\report.json"), resultObject);//????????????????????


    }
}
