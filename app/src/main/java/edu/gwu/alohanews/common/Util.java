package edu.gwu.alohanews.common;

public class Util {

    private Util() {

    }

    public static boolean isStringEmpty(String string) {
        return string == null || string.length() == 0;
    }
}
