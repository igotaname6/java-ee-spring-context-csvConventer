package com.codecool.scc;

import com.codecool.scc.outputProcessing.InvalidOutputTypeException;

public enum OutputFormat {
    TABLE("table"),
    JSON("json"),
    XML("xml");

    private final String outputName;

    OutputFormat(String outputName){
        this.outputName = outputName;
    }

    public String getOutputName() {
        return outputName;
    }
    
    public static OutputFormat getOutputFormatFromString(String string){
        if(string.toLowerCase().equals("table")){
            return TABLE;
        } else if(string.toLowerCase().equals("json")){
            return JSON;
        }else if(string.toLowerCase().equals("xml")){
            return XML;
        } else {
            throw new InvalidOutputTypeException(string);
        }
    }
}
