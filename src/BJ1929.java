import java.io.*;
import java.util.Arrays;

public class BJ1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = NM[0] ; i <= NM[1] ; i++) {
            if (isPrime(i))
                bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
    }

    private static boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2 ; i*i <= num ; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
