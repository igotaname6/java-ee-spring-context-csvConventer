package com.codecool.scc;

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
}
