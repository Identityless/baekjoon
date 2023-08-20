import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BJ4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String s = br.readLine();
            if (s.equals("."))
                break;
            String ps = getPS(s);
            String sps = getSPS(s);
            if (isValid(ps) && isValid(sps))
                bw.write("YES\n");
            else
                bw.write("NO\n");
        }

        bw.flush();
        bw.close();
    }

    private static boolean isValid(String ps) {
        if (ps.length() % 2 != 0)
            return false;

        int sp = 0, ep = 0;

        for (int i = 0 ; i < ps.length() ; i++) {
            String tmp = ps.substring(i, i+1);
            if (tmp.equals("(") || tmp.equals("["))
                sp++;
            else
                ep++;
            if (ep > sp)
                return false;
        }
        return true;
    }

    private static String getPS(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < s.length() ; i++) {
            String tmp = s.substring(i, i+1);
            if (tmp.equals("(") || tmp.equals(")"))
                list.add(tmp);
        }
        StringBuilder sb = new StringBuilder();
        for (String p : list) {
            sb.append(p);
        }

        return sb.toString();
    }

    private static String getSPS(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < s.length() ; i++) {
            String tmp = s.substring(i, i+1);
            if (tmp.equals("[") || tmp.equals("]"))
                list.add(tmp);
        }
        StringBuilder sb = new StringBuilder();
        for (String p : list) {
            sb.append(p);
        }

        return sb.toString();
    }
}
