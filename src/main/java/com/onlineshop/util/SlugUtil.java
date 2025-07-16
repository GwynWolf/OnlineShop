package com.onlineshop.util;

import java.util.HashMap;
import java.util.Map;

public class SlugUtil {
    private static final Map<Character, String> translitMap = new HashMap<>();

    static {
        translitMap.put('А', "A");
        translitMap.put('а', "a");
        translitMap.put('Б', "B");
        translitMap.put('б', "b");
        translitMap.put('В', "V");
        translitMap.put('в', "v");
        translitMap.put('Г', "H");
        translitMap.put('г', "h");
        translitMap.put('Ґ', "G");
        translitMap.put('ґ', "g");
        translitMap.put('Д', "D");
        translitMap.put('д', "d");
        translitMap.put('Е', "E");
        translitMap.put('е', "e");
        translitMap.put('Є', "Ye");
        translitMap.put('є', "ie");
        translitMap.put('Ж', "Zh");
        translitMap.put('ж', "zh");
        translitMap.put('З', "Z");
        translitMap.put('з', "z");
        translitMap.put('И', "Y");
        translitMap.put('и', "y");
        translitMap.put('І', "I");
        translitMap.put('і', "i");
        translitMap.put('Ї', "Yi");
        translitMap.put('ї', "i");
        translitMap.put('Й', "Y");
        translitMap.put('й', "i");
        translitMap.put('К', "K");
        translitMap.put('к', "k");
        translitMap.put('Л', "L");
        translitMap.put('л', "l");
        translitMap.put('М', "M");
        translitMap.put('м', "m");
        translitMap.put('Н', "N");
        translitMap.put('н', "n");
        translitMap.put('О', "O");
        translitMap.put('о', "o");
        translitMap.put('П', "P");
        translitMap.put('п', "p");
        translitMap.put('Р', "R");
        translitMap.put('р', "r");
        translitMap.put('С', "S");
        translitMap.put('с', "s");
        translitMap.put('Т', "T");
        translitMap.put('т', "t");
        translitMap.put('У', "U");
        translitMap.put('у', "u");
        translitMap.put('Ф', "F");
        translitMap.put('ф', "f");
        translitMap.put('Х', "Kh");
        translitMap.put('х', "kh");
        translitMap.put('Ц', "Ts");
        translitMap.put('ц', "ts");
        translitMap.put('Ч', "Ch");
        translitMap.put('ч', "ch");
        translitMap.put('Ш', "Sh");
        translitMap.put('ш', "sh");
        translitMap.put('Щ', "Shch");
        translitMap.put('щ', "shch");
        translitMap.put('Ю', "Yu");
        translitMap.put('ю', "iu");
        translitMap.put('Я', "Ya");
        translitMap.put('я', "ia");
        translitMap.put('Ь', "");
        translitMap.put('ь', "");
        translitMap.put('\'', "");
        translitMap.put('’', "");
    }

    public static String toSlug(String input) {
        if (input == null || input.isBlank()) return "";

        StringBuilder sb = new StringBuilder();

        for (char c : input.trim().toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(translitMap.getOrDefault(c, String.valueOf(c)));
            } else {
                sb.append('-');
            }
        }

        String slug = sb.toString().toLowerCase()
                .replaceAll("-{2,}", "-")
                .replaceAll("^-|-$", "");

        return slug;
    }
}
