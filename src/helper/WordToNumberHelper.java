package helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordToNumberHelper {


    private static int digitToWordNumNames(String digit) {
        switch (digit) {
            case "zero":
                return 0;
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            case "ten":
                return 10;
            case "eleven":
                return 11;
            case "twelve":
                return 12;
            case "thirteen":
                return 13;
            case "fourteen":
                return 14;
            case "fifteen":
                return 15;
            case "sixteen":
                return 16;
            case "seventeen":
                return 17;
            case "eighteen":
                return 18;
            case "nineteen":
                return 19;
        }
        return 0;
    }

    private static int digitToWordTenNames(String digit) {
        switch (digit) {
            case "twenty":
                return 20;
            case "thirty":
                return 30;
            case "forty":
                return 40;
            case "fifty":
                return 50;
            case "sixty":
                return 60;
            case "seventy":
                return 70;
            case "eighty":
                return 80;
            case "ninety":
                return 90;
        }
        return 0;
    }

    public String calculatePiece(String moneyPiece) {
        if (moneyPiece == null) {
            return "";
        }
        int result = 0;

        //if word has hundred means piece of that has 2 length else has 1 length
        String[] hundreds = moneyPiece.split("hundred");
        if (hundreds.length == 1) {
            String reg2 = "\\b(?!dollars)\\b\\S+";
            Pattern compile = Pattern.compile(reg2);
            Matcher matcher = compile.matcher(moneyPiece);

            result = calculateResult(matcher);

        } else if (hundreds.length == 2) {
            String hundred = hundreds[0];

            // hundred occurs a digit and hundred word that's why find digit and multiply by 100 then use calculateResult for X and XX
            result = digitToWordNumNames(hundred.trim()) * 100;

            String reg3 = "\\b(?!dollars|and)\\b\\S+";
            Pattern compile = Pattern.compile(reg3);
            Matcher matcher = compile.matcher(hundreds[1]);

            result = result + calculateResult(matcher);
        }

        return String.valueOf(result);
    }

    private int calculateResult(Matcher matcher) {

        /*
        use for collect XX and X
        find from switch case value of that and collect that's values
         */
        int result = 0;
        while (matcher.find()) {
            if (digitToWordNumNames(matcher.group(0)) != 0) {
                result = result + digitToWordNumNames(matcher.group(0));
            } else {
                result = result + digitToWordTenNames(matcher.group(0));

            }

        }
        return result;
    }
}
