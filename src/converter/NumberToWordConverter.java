package converter;


import constants.Constants;
import helper.NumberToWordHelper;
import model.DigitValue;

public class NumberToWordConverter {

    DigitValue digitValue;

    NumberToWordHelper numberToWordHelper = new NumberToWordHelper();

    public DigitValue getDigitValue() {
        return digitValue;
    }

    public void createDigitObject() {
        digitValue = new DigitValue();
    }

    public String convertToWord(String money, boolean isNewPayment) {
        if (isNewPayment) {
            //if new calculation create new Digit object
            createDigitObject();
        }
        if (money.length() >= 3) {
            //if money length bigger than 3 split by as 3 block (read number of money step by step as XXX.XXX.XXX.XXX => XXX)
            return splitMoneyPiece(money);
        }
        //set digit value if money length < 3 that mean now here money piece => XX or X
        setDigitValueByDigit(money);

        return convertDigitToWord();
    }

    private String convertDigitToWord() {

        //use calculateDigitPiece for all piece of money billions, millions etc..
        String result = numberToWordHelper.calculateDigitPiece(getDigitValue().getBillions(), "billions and") +
                numberToWordHelper.calculateDigitPiece(getDigitValue().getMillions(), "millions and") +
                numberToWordHelper.calculateDigitPiece(getDigitValue().getThousands(), "thousands and") +
                numberToWordHelper.calculateDigitPiece(getDigitValue().getHundreds(), "");
        if (result.trim().equals("zero") || result.trim().equals("one")) {
            result = result + "dollar";
        } else {
            result = result + "dollars";
        }

        return result;
    }

    private void setDigitValueByDigit(String text) {

        /*
        set digit object as piece of money remember money occurs XXX.XXX.XXX.XXX
        split money from reverse that's mean set first hundreds and if it is not null then set thousand
                    XXX
                XXX.XXX
            XXX.XXX.XXX
        XXX.XXX.XXX.XXX

        we split from reverse because if you do not have hundred money you already do not have millions :)
         */
        if (digitValue.getHundreds() == null) {
            digitValue.setHundreds(text);
        } else if (digitValue.getThousands() == null) {
            digitValue.setThousands(text);
        } else if (digitValue.getMillions() == null) {
            digitValue.setMillions(text);
        } else {
            digitValue.setBillions(text);

        }

    }

    private String splitMoneyPiece(String moneyPiece) {

        //split money
        StringBuilder sb = new StringBuilder(moneyPiece);

        //reverse it and take first piece than reverse it again and convertToWord as paramater OLD_PAYMENT
        StringBuilder reverse = sb.reverse();
        String substring = reverse.reverse().substring(sb.length() - 3);

        moneyPiece = moneyPiece.substring(0, moneyPiece.length() - 3);

        //call digit value for all piece
        setDigitValueByDigit(substring);

        if (moneyPiece.length() == 0) {
            //if money piece zero return the last step and collect the money piece
            return convertDigitToWord();
        }

        //if has money piece continue convert it
        return convertToWord(moneyPiece, Constants.OLD_PAYMENT);
    }


}
