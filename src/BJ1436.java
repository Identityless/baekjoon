import java.io.*;
import java.util.*;

public class BJ1436 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int seq = Integer.parseInt(br.readLine());
        int ans = 665;

        for(int i = 0 ; i < seq ; i++ ) {
            ans = getNext666(ans);
        }

        bw.write(ans+"");
        bw.flush();
        bw.close();
    }

    private static int getNext666(int start) {
        while(true) {
            start++;
            if (String.valueOf(start).contains("666")) {
                return start;
            }
        }
    }
}
