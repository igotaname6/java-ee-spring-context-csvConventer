package com.codecool.scc.conventers;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader implements DataProvider{

    public List<String> readData(String fileUrl) throws IOException {

        java.io.FileReader ioFileReader = new java.io.FileReader(fileUrl);
        BufferedReader bufferedReader = new BufferedReader(ioFileReader);

        return bufferedReader.lines().collect(Collectors.toList());

    }
}
