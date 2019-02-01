package helper;

import constants.Constants;

import java.util.regex.Pattern;

public class PatternHelper {

    public static boolean isWord(String money) {

        //used pattern if text has dollar word we know that this is word else number
        return Pattern.compile(Constants.DOLLAR).matcher(money).find();
    }

}
