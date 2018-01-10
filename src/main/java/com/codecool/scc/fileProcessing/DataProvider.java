package com.codecool.scc.fileProcessing;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface DataProvider {
    
    List<Map<String, String>> readData(String fileUrl) throws IOException;
}
