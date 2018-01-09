package com.codecool.scc;

import com.codecool.scc.conventers.DataProvider;
import com.codecool.scc.conventers.FileReader;
import com.codecool.scc.conventers.SimpleCsvConventer;
import com.codecool.scc.outputProcessing.InvalidOutputTypeException;

import java.io.IOException;

public class ConventerApplication {

    public static void main(String[] args) throws IOException {
    
        if (args.length > 2) {
            System.out.println("To many arguments");
            System.exit(1);
        } else if (args.length == 0) {
            System.out.println("Csv file path to convert required");
            System.exit(1);
        } else {
            DataProvider reader = new FileReader();
            SimpleCsvConventer conventer = new SimpleCsvConventer(reader);
            
            if (args.length == 2) {
                try {
                OutputFormat outputFormat = OutputFormat.getOutputFormatFromString(args[0]);
                conventer.convert(args[1], outputFormat);
                } catch (InvalidOutputTypeException e){
                    System.out.format("Invalid output type: %s", e.getWrongType());
                }
            } else {
                //Default table type;
                conventer.convert(args[0]);
            }
        }
    }
}
