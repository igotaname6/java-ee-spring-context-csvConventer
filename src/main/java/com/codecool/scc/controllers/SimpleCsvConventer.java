package com.codecool.scc.controllers;

import com.codecool.scc.fileProcessing.DataProvider;
import com.codecool.scc.outputProcessing.OutputType;
import com.codecool.scc.outputProcessing.OutputFormatter;
import com.codecool.scc.outputProcessing.OutputFormatterFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SimpleCsvConventer {

    private OutputType outputType;
    private DataProvider dataProvider;

    public SimpleCsvConventer(DataProvider dataProvider){
        //Default value of outputType use if no type is given in convert method.
        this.outputType = OutputType.TABLE;
        this.dataProvider = dataProvider;
    }
    
    public void convert(String fileUrl, OutputType outputType) throws IOException {
        setOutputType(outputType);
        this.convert(fileUrl);

    }

    public void convert(String fileUrl) throws IOException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        OutputFormatterFactory factory = (OutputFormatterFactory) ctx.getBean("outputFormatterFactory");
        
        OutputFormatter outputFormatter = factory.createByFormat(this.outputType);
        List<Map<String, String>> dataToConvert = dataProvider.readData(fileUrl);
        outputFormatter.printToConsole(dataToConvert);
    }

    public OutputType getOutputType() {
        return outputType;
    }

    public void setOutputType(OutputType outputType) {
        this.outputType = outputType;
    }
}
