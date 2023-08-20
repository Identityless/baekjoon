import java.io.*;
import java.util.*;

public class BJ2839 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int kilos = Integer.parseInt(br.readLine());
        int lim3 = kilos / 3;
        int lim5 = kilos / 5;
        int min = 999999;

        for (int i = 0 ; i <= lim5 ; i++) {
            int kilosSub;
            for (int j = 0 ; j <= lim3 ; j++) {
                kilosSub = kilos - i * 5 - j * 3;
                if(kilosSub == 0 && i+j < min) {
                    min = i+j;
                }
            }
        }

        if(min == 999999)
            min = -1;

        bw.write(min+"");
        bw.flush();
        bw.close();
    }
}
