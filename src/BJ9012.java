import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BJ9012 {
    private static List<Deque<String>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            list = new ArrayList<>();
            String ps = br.readLine();
            if (isVPS(ps))
                bw.write("YES\n");
            else
                bw.write("NO\n");
        }
        bw.flush();
        bw.close();
    }

    private static boolean isVPS(String ps) {
        if (ps.length() % 2 != 0)
            return false;
        int sp = 0;
        int ep = 0;
        Deque<String> deque = new LinkedList<>();
        for (int i = 0 ; i < ps.length() ; i++) {
            String tmp = ps.substring(i, i+1);
            if (tmp.equals("("))
                sp++;
            else
                ep++;
            deque.add(tmp);
            if (ep > sp)
                return false;

            if (sp == ep) {
                list.add(deque);
                deque = new LinkedList<>();
                sp = 0;
                ep = 0;
            }
        }

        if(sp != 0 || ep != 0) {
            return false;
        }

        for (Deque<String> tmp : list) {
            String e1, e2;
            e1 = tmp.pollFirst();
            e2 = tmp.pollLast();
            if (e1.equals(e2))
                return false;
        }
        return true;
    }
}
