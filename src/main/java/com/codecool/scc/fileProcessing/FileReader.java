package com.codecool.scc.fileProcessing;


import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class FileReader implements DataProvider {
    
    public List<Map<String, String>> readData(String fileUrl) throws IOException {
    
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(fileUrl))) {
            List<Map<String, String>> dataMap = new ArrayList<>();
            String[] headerLine = bufferedReader.readLine().split(",");
            
            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] splitedLine = line.split(",");
                Map<String, String> lineMap = IntStream.range(0, splitedLine.length)
                                                .boxed()
                                                .collect(Collectors.toMap(i -> headerLine[i], i -> splitedLine[i]));
                dataMap.add(lineMap);
            }
            return dataMap;
        }
    }
}

