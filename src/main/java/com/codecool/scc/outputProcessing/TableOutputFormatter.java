package com.codecool.scc.outputProcessing;

import dnl.utils.text.table.TextTable;

import java.util.List;
import java.util.Map;

public class TableOutputFormatter implements OutputFormatter {
    
    @Override
    public void printToConsole(List<Map<String, String>> file) {
        //Crete array with table header
        String[] headers = file.get(0).keySet().toArray(new String[0]);
        file.remove(0);
        
        //sets table sizes
        int columnsCount = headers.length;
        int rowsCount = file.size();
    
        String[][] tableData = convertDataMapToStringDimentionalArray(file, columnsCount, rowsCount);
        
        TextTable textTable = new TextTable(headers, tableData);
        textTable.printTable();
    }
    
    private String[][] convertDataMapToStringDimentionalArray(List<Map<String, String>> file, int columnsCount, int rowsCount) {
        String[][] tableData = new String[rowsCount][columnsCount];
        int index = 0;
        for(Map<String, String> mapRow:  file){
            String[] dataRow = mapRow.values().toArray(new String[0]);
            tableData[index++] = dataRow;
        }
        return tableData;
    }
}
