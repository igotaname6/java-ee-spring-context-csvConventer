package com.codecool.scc.outputProcessing;

public enum OutputType {
    TABLE("table"),
    JSON("json"),
    XML("xml");

    private final String outputName;

    OutputType(String outputName){
        this.outputName = outputName;
    }

    public String getOutputName() {
        return outputName;
    }
    
    public static OutputType getOutputFormatFromString(String string){
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
