package task3;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FilterWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class Task3 {

    static ObjectMapper mapper = new ObjectMapper();

    class ClicheForJson {
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

        public ClicheForJson getClicheFromJson() throws IOException {
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

    class ValueForJson{
            public Dop dop;
//            public int id;
//            public String value;
            //@JsonInclude(JsonInclude.Include.NON_NULL)
            public List<Dop> values;

        public void setDop(Dop dop) {
            this.dop = dop;
        }

        public void setValues(List<Dop> values) {
            this.values = values;
        }

        public Dop getDop() {
            return dop;
        }

        public List<Dop> getValues() {
            return values;
        }

        @Override
        public String toString() {
            return //"id = " +id + "\n" +
                   // "value = " +value + "\n" +
                    "values = " +values + "\n";

        }
    }

    class Dop {
        public int id;
        public String value;

        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public String getValue() {
            return value;
        }

        public String toString() {
            return "id = " + id + "\n" +
                    "value = " + value + "\n";
        }
    }


    public static void main(String[] args) throws IOException {

        ValueForJson valueForJson =
                mapper.readValue("B:\\dir\\values.json",ValueForJson.class);
        System.out.println(valueForJson.toString());
      //  mapper.writeValue(new File("B:\\dir\\tests1.json"), result);
    }

}
