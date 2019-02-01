package helper;

public class NumberToWordHelper {

    /*
    all numbers occurs tens and single numbers and trick number is 19, after 19 all numbers repeat same process
     */
    private static final String[] tensNames = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
    };

    private static final String[] numNames = {
            "zero",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };

    public String calculateDigitPiece(String substring, String moneyType) {
        /*
        calculate digits of money pieces null or X or XX or XX or XXX
         */
        if (substring == null) {
            return "";
        }
        if (substring.length() < 3) {
            //for usage X or XX
            return calculateResult(Integer.parseInt(substring), moneyType);
        }
        //XXX
        return numNames[Integer.parseInt(substring.substring(0, 1))] + " hundred" + (moneyType.equals("") ? " and" : "") + calculateResult(Integer.parseInt(substring.substring(1)), moneyType);
    }

    public String calculateResult(int money, String moneyType) {
        if (money < 20) {
            /*
            is money smaller than 20 use numNames
             */
            return (numNames[money] + (" " + (moneyType)));
        } else {

            //if bigger than 20 find tens and collect it with tensNames and numNames
            int result = money % 10;

            return (tensNames[money / 10] + numNames[result] + (" " + (moneyType)));
        }
    }


}
