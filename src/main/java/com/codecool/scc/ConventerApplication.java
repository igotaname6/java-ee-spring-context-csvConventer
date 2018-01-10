package com.codecool.scc;

import com.codecool.scc.fileProcessing.DataProvider;
import com.codecool.scc.controllers.SimpleCsvConventer;
import com.codecool.scc.outputProcessing.InvalidOutputTypeException;
import com.codecool.scc.outputProcessing.OutputType;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ConventerApplication {

    public static void main(String[] args) throws IOException {
    
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    
        if (args.length > 2) {
            System.out.println("To many arguments");
            System.exit(1);
        } else if (args.length == 0) {
            System.out.println("Csv file path to convert required");
            System.exit(1);
        } else {
            SimpleCsvConventer conventer = (SimpleCsvConventer) ctx.getBean("simpleCsvConventer");
            
            if (args.length == 2) {
                try {
                OutputType outputType = OutputType.getOutputFormatFromString(args[0]);
                conventer.convert(args[1], outputType);
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
