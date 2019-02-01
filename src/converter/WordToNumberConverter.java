package converter;


import constants.Constants;
import helper.WordToNumberHelper;
import model.DigitValue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordToNumberConverter {

    DigitValue digitValue;

    WordToNumberHelper wordToNumberHelper = new WordToNumberHelper();

    public DigitValue getDigitValue() {
        return digitValue;
    }

    public void splitDigitsMoney(String money) {

        //for all new money calculation create new object
        digitValue = new DigitValue();
        //using regex for split groups
        Pattern compile = Pattern.compile(Constants.MONEY_PATTERN);

        Matcher matcher = compile.matcher(money);

        if (matcher.find()) {

            //we know the group from regex pattern can use regex101 for if you want to see
            digitValue.setBillions(matcher.group(1));
            digitValue.setMillions(matcher.group(8));
            digitValue.setThousands(matcher.group(15));
            digitValue.setHundreds(matcher.group(22));

            //setted digitValue object according to group of the piece
            convertToNumber();
        }
    }

    private String convertToNumber() {

        //step by step send piece billions + millions + thousands + hundreds
        String result =wordToNumberHelper.calculatePiece(getDigitValue().getBillions()) +
                wordToNumberHelper.calculatePiece(getDigitValue().getMillions()) +
                wordToNumberHelper.calculatePiece(getDigitValue().getThousands()) +
                wordToNumberHelper.calculatePiece(getDigitValue().getHundreds())
                + " \\$";

        System.out.println(result.trim());
        return result;
    }
}
