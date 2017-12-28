package com.codecool.scc.conventers;

import com.codecool.scc.OutputFormat;

import java.io.File;

public class SimpleCsvConventer {
    private OutputFormat outputFormat;

    void convert(File file, OutputFormat outputFormat){
        setOutputFormat(outputFormat);
        System.out.println("I convert CSV to " + outputFormat.getOutputName());

    }

    void convert(File file){
        setOutputFormat(OutputFormat.TABLE);
        System.out.println("I convert CSV to " + outputFormat.getOutputName());
    }

    public OutputFormat getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(OutputFormat outputFormat) {
        this.outputFormat = outputFormat;
    }
}
