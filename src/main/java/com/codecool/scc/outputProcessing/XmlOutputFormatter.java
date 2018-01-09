package com.codecool.scc.outputProcessing;

import java.util.List;
import java.util.Map;

public class XmlOutputFormatter implements OutputFormatter {
    
    
    @Override
    public void printToConsole(List<Map<String, String>> file) {
    
        int id = 1;
        for(Map<String, String> lines : file){
                System.out.format("<%d>\n", id);
            for (String record : lines .keySet()){
                System.out.format("\t<%1$s>%2$s></%1$s>\n", record, lines .get(record));
            }
            System.out.format("</%d>\n", id);
            id++;
        }
    }
}
