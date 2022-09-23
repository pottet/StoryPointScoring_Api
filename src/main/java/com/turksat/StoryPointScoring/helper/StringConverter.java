package com.turksat.StoryPointScoring.helper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringConverter {
    public static String convertToDatabaseColumn(List<String> attribute) {
        return attribute == null ? null : String.join(",",attribute);
    }

    public static List<String> convertToEntityAttribute(String dbData) {
        return dbData == null ? Collections.emptyList() : Arrays.asList(dbData.split(","));
    }
}
