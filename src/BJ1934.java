import java.io.*;
import java.util.Arrays;

public class BJ1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            bw.write(getMinCoMul(tmp[0], tmp[1])+"\n");
        }
        bw.flush();
        bw.close();
    }
    private static int getMinCoMul(int a, int b) {
        int i = 1;
        while (true) {
            if ((b*i) % a == 0) {
                return b*i;
            }
            i++;
        }
    }
}
