package com.se;

public class Question {

    public String text;
    public Format format;

    public Question(String text, Format format) {
        this.text = text;
        this.format = format;
    }

    public boolean isValidAnswer(String ans) {

        if (ans == null) {
            return false;
        }

        if (ans.isEmpty()) {
            return format == Format.NULL;
        }

        switch (format) {
            case NUM -> {
                try {
                    Integer.parseInt(ans);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            case YN -> {
                return ans.equalsIgnoreCase("Y") ||
                        ans.equalsIgnoreCase("N") ||
                        ans.equalsIgnoreCase("yes") ||
                        ans.equalsIgnoreCase("no");
            }
            default -> { // if format is txt
                return true;
            }
        }

    }

    public enum Format {
        NULL, YN, NUM, TXT
    }

}
