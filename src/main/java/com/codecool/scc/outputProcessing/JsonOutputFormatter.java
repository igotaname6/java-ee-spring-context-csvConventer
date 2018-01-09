package com.codecool.scc.outputProcessing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonOutputFormatter implements OutputFormatter {

    @Override
    public void printToConsole(List<Map<String, String>> fileData) {
    
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    
        try {
            mapper.writeValue(System.out, fileData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
