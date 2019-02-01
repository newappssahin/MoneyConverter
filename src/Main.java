import converter.MoneyConverter;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) {

        MoneyConverter.convert("101 \\$");
        MoneyConverter.convert("111745 \\$");
        MoneyConverter.convert("223745 \\$");
        MoneyConverter.convert("7344445 \\$");
        MoneyConverter.convert("one dollars");
        MoneyConverter.convert("five dollars");
        MoneyConverter.convert("one hundred and one dollars");
        MoneyConverter.convert("one hundred and fifty six dollars");
        MoneyConverter.convert("one thousands and one hundred and fifty six dollars");
        MoneyConverter.convert("twelve thousands and seven hundred and forty five dollars");
        MoneyConverter.convert("one hundred twenty three thousands and seven hundred and forty five dollars");
        MoneyConverter.convert("one millions and two hundred thirty four thousands and seven hundred and forty five dollars");
        MoneyConverter.convert("twelve millions and three hundred forty seven thousands and four hundred and fifty six dollars");
        MoneyConverter.convert("eight hundred twenty three millions and four hundred seventy four thousands and five hundred and sixty seven dollars");

    }

    @Test
    public void regexTest() {
        String billions;
        String millions;
        String thousands;
        String hundreds;
        String input = "one hundred twenty three billions and four hundred fifty six millions and seven hundred eighty nine thousands and one hundred and twenty three dollars\n";
        String regex = "^(((\\s+\\w+)?(\\w+\\s+)?)+(billions))?+((\\s+)?and)?(((\\s+\\w+)?(\\w+\\s+)?)+(millions))?+((\\s+)?and)?(((\\s+\\w+)?(\\w+\\s+)?)+(thousands))?+((\\s+)?and)?(((\\s+\\w+)?(\\w+\\s+)?)+(dollars))";

        Pattern compile = Pattern.compile(regex);

        Matcher matcher = compile.matcher(input);

        if (matcher.find()) {
            hundreds = matcher.group(22);
            thousands = matcher.group(15);
            millions = matcher.group(8);
            billions = matcher.group(1);

            System.out.println("HUNDREDS :" + hundreds);
            System.out.println("THOUSANDS :" + thousands);
            System.out.println("MILLIONS :" + millions);
            System.out.println("BILLIONS :" + billions);

        }

    }
}