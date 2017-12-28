package com.codecool.scc;

public class ConventerApplication {

    public static void main(String[] args) {

        if(args.length > 2){
            System.out.println("To many arguments");
            System.exit(1);
        } else if(args.length == 0){
            System.out.println("Csv file path to convert required");
            System.exit(1);
        } else if(args.lenght == 1){

        }
    }
}
