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
    private OutputFormatterFactory outputFormatterFactory;
    
    public SimpleCsvConventer(DataProvider dataProvider, OutputFormatterFactory outputFormatterFactory) {
        this.outputType = OutputType.TABLE;
        this.dataProvider = dataProvider;
        this.outputFormatterFactory = outputFormatterFactory;
    }
    
    public void convert(String fileUrl, OutputType outputType) throws IOException {
        setOutputType(outputType);
        this.convert(fileUrl);

    }

    public void convert(String fileUrl) throws IOException {
        
        OutputFormatter outputFormatter = outputFormatterFactory.createByFormat(this.outputType);
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
