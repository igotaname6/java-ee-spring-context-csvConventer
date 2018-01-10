package com.codecool.scc.outputProcessing;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OutputFormatterFactory {
    
    public OutputFormatter createByFormat(OutputType outputType) {
    
        OutputFormatter outputFormatter;
    
        if (outputType == OutputType.JSON) {
            outputFormatter = new JsonOutputFormatter();
        } else if (outputType == OutputType.XML) {
            outputFormatter = new XmlOutputFormatter();
        } else if (outputType == OutputType.TABLE) {
            outputFormatter = new TableOutputFormatter();
        } else {
            throw new InvalidOutputTypeException(outputType);
        }
        return outputFormatter;
    }
}
