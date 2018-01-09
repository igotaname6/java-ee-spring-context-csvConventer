package com.codecool.scc.outputProcessing;

import com.codecool.scc.OutputFormat;

public class OutputFormatterFactory {
    
    public OutputFormatter createByFormat(OutputFormat outputFormat){
        OutputFormatter  outputFormatter = null;
        
        if(outputFormat  == OutputFormat.JSON){
            outputFormatter = new JsonOutputFormatter();
        } else if(outputFormat == OutputFormat.XML){
            outputFormatter = new XmlOutputFormatter();
        } else if(outputFormat == OutputFormat.TABLE){
            outputFormatter = new TableOutputFormatter();
        }
        return outputFormatter;
    }
}
