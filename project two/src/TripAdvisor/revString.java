package TripAdvisor;

/**
 * Created by hellsapphire on 11/4/2015.
 */
public class revString {

    public static void main(String[] args) {
        String s = "asdsd sdsad sdad asdsd sds";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; --i) {
            if (!arr[i].equals("")) {
                sb.append(arr[i]).append(" ");
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
}
