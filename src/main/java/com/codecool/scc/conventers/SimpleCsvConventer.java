package com.codecool.scc.conventers;

import com.codecool.scc.OutputFormat;
import com.codecool.scc.outputProcessing.OutputFormatter;
import com.codecool.scc.outputProcessing.OutputFormatterFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SimpleCsvConventer {

    private OutputFormat outputFormat;
    private DataProvider dataProvider;

    public SimpleCsvConventer(DataProvider dataProvider){
        //Default value of outputFormat use if no type is given in convert method.
        this.outputFormat = OutputFormat.TABLE;
        this.dataProvider = dataProvider;
    }

    public void convert(String fileUrl, OutputFormat outputFormat) throws IOException {
        setOutputFormat(outputFormat);
        this.convert(fileUrl);

    }

    public void convert(String fileUrl) throws IOException {
        OutputFormatter outputFormatter = new OutputFormatterFactory().createByFormat(this.outputFormat);
        List<Map<String, String>> dataToConvert = dataProvider.readData(fileUrl);
        outputFormatter.printToConsole(dataToConvert);
    }

    public OutputFormat getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(OutputFormat outputFormat) {
        this.outputFormat = outputFormat;
    }
}
