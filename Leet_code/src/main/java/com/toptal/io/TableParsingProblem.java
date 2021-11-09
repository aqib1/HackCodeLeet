package com.toptal.io;

import java.util.*;
import java.util.stream.IntStream;

public class TableParsingProblem {

    private static final String NEWLINE_SPLITTER = "\n";
    private static final String COMMA_SPLITTER = ",";
    private static final int COLUMN_INDEX = 0;
    private static final int VALUES_INDEX_START = 1;
    private static final int INVALID_INPUT_RESPONSE = -1;
    private static final int ZERO = 0;

    // O(1) as map is constant time datastructure
    public static int solution(String S, String C) {
        if (Objects.isNull(S) || Objects.isNull(C) || S.isBlank() || C.isBlank())
            return INVALID_INPUT_RESPONSE;

        try {
            return parseRawDataByColumn(S)
                    .getOrDefault(C, Collections.emptyList())
                    .stream()
                    .map(Integer::parseInt)
                    .max(Integer::compareTo)
                    .orElseGet(() -> INVALID_INPUT_RESPONSE);
        } catch (NumberFormatException e) {
            return INVALID_INPUT_RESPONSE;
        }
    }

    // O(N) where N is the numbers of column
    private static Map<String, List<String>> parseRawDataByColumn(String S) {
        Map<String, List<String>> valuesByColumn = new HashMap<>();
        String[] rawData = S.split(NEWLINE_SPLITTER);
        if (notEmptyArray(rawData)) {
            String[] columns = rawData[COLUMN_INDEX].split(COMMA_SPLITTER);
            if (notEmptyArray(columns)) {
                Arrays.stream(columns).forEach(column ->
                        valuesByColumn.put(column, new ArrayList<>()));
                parseValuesInColumn(rawData, valuesByColumn, columns);

            }
        }
        return valuesByColumn;
    }

    // O(M*N) where M is the number of rows and N is the number for column
    private static void parseValuesInColumn(String[] rawData, Map<String, List<String>> valuesByColumn, String[] columns) {
        IntStream.range(VALUES_INDEX_START, rawData.length).forEach(rowIndex -> {
            int valueIndex = 0;
            String[] values = rawData[rowIndex].split(COMMA_SPLITTER);
            for (String column : columns) {
                valuesByColumn.get(column).add(values[valueIndex]);
                valueIndex++;
            }
        });
    }

    private static boolean notEmptyArray(String[] array) {
        return array.length != ZERO;
    }
}
