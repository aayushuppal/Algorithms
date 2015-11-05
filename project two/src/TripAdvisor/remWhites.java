package TripAdvisor;

/**
 * Created by hellsapphire on 11/2/2015.
 */
public class remWhites {

    public static void main(String[] args) {
        String s = "The  big   thing";

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == ' ' && s.charAt(i) == ' ') {
                s = s.substring(0, i) + s.substring(i + 1);
                i--;
            }
        }

        System.out.println(s);
    }
}
