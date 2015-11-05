package TripAdvisor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hellsapphire on 10/31/2015.
 */
public class regexMatcher {

    public static void main(String[] args) {
        String s = "this is john doe 90 (785)673-3456 (785)673-3456 (785)673-3456 (778)673-3476";
        s = s.replaceFirst("\\d{2}", "XY");
        System.out.println(s);

        Pattern pat = Pattern.compile("(\\(\\d{3}\\)\\d{3}\\-\\d{3})");
        Matcher mat = pat.matcher(s);

        while (mat.find()) {
            System.out.println(mat.group(1));
        }
    }

    public static void tester() {

    }

}
