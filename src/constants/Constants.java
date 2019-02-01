package constants;

public class Constants {
    public static final String DOLLAR = "dollar";

    //NEW_PAYMENT added for calculation start with new object, added as parameter just for new calculation
    public static boolean NEW_PAYMENT = true;
    public static boolean OLD_PAYMENT = false;

    /*
     word to number regex pattern, use regex101 and see groups, split according to billions, millions, thousands, dollars
     use this link for see group of piece:
     https://regex101.com/r/HcaHxv/1
     */
    //
    public static final String MONEY_PATTERN = "^(((\\s+\\w+)?(\\w+\\s+)?)+(billions))?+((\\s+)?and)?(((\\s+\\w+)?(\\w+\\s+)?)+(millions))?+((\\s+)?and)?(((\\s+\\w+)?(\\w+\\s+)?)+(thousands))?+((\\s+)?and)?(((\\s+\\w+)?(\\w+\\s+)?)+(dollars))";

}
