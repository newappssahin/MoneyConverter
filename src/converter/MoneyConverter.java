package converter;

import constants.Constants;
import converter.NumberToWordConverter;
import converter.WordToNumberConverter;
import helper.PatternHelper;
import org.junit.Test;

public class MoneyConverter {

    public static void convert(String money) {

        //first control money value is number or word then apply different methods
        if (PatternHelper.isWord(money)) {
            //is process here that's mean money value is word and use WordToNumberConverter
            WordToNumberConverter wordToNumberConverter = new WordToNumberConverter();
            wordToNumberConverter.splitDigitsMoney(money);

        } else {
            //is process here that's mean money value is number and use NumberToWordConverter
            NumberToWordConverter numberToWordConverter = new NumberToWordConverter();

            //for first running send money with NEW_PAYMENT argument and split without $ sign (for this purpose used regex pattern
            System.out.println(numberToWordConverter.convertToWord(money.split("\\b(?!\\d+)")[0], Constants.NEW_PAYMENT).trim());

        }
    }

}
