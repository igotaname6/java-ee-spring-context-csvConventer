package com.codecool.scc.conventers;

import java.io.IOException;
import java.util.List;

public interface DataProvider {

    List<String> readData(String fileUrl) throws IOException;
}
