import java.io.*;
import java.util.*;

public class BJ22233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Boolean> dict = new HashMap<>();
        for (int i = 0 ; i < N ; i++) {
            dict.put(br.readLine(), true);
        }
        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine(), ",");
            while (st.hasMoreTokens()) {
                dict.remove(st.nextToken());
            }
            bw.write(dict.size()+"\n");
        }

        bw.flush();
        bw.close();
    }
}
