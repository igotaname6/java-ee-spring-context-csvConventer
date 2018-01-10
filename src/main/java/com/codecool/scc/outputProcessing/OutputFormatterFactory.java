package com.codecool.scc.outputProcessing;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OutputFormatterFactory {
    
    public OutputFormatter createByFormat(OutputType outputType){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        OutputFormatter  outputFormatter = null;
        
        if(outputType == OutputType.JSON){
            outputFormatter = (OutputFormatter) ctx.getBean("jsonOutputFormatter");
        } else if(outputType == OutputType.XML){
            outputFormatter = (OutputFormatter) ctx.getBean("xmlOutputFormatter");
        } else if(outputType == OutputType.TABLE){
            outputFormatter = (OutputFormatter) ctx.getBean("tableOutputFormatter");
        } else {
            throw new InvalidOutputTypeException(outputType);
        }

}
