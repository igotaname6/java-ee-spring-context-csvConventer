package com.codecool.scc.outputProcessing;

public class InvalidOutputTypeException extends RuntimeException{
    
    private String wrongType;
    
    public InvalidOutputTypeException(String wrongType){
        this.wrongType = wrongType;
    }
    
    public InvalidOutputTypeException() {
    }
    
    public InvalidOutputTypeException(OutputType outputType) {
    }
    
    public void setWrongType(String wrongType) {
        this.wrongType = wrongType;
    }
    
    public String getWrongType() {
        return wrongType;
    }
}
