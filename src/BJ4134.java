import java.io.*;

public class BJ4134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long N = Long.parseLong(br.readLine());

        for (long i = 0 ; i < N ; i++) {
            bw.write(getPrime(Long.parseLong(br.readLine()))+"\n");
        }
        bw.flush();
        bw.close();
    }

    private static long getPrime(long num) {
        while (true) {
            if (isPrime(num)) {
                return num;
            }
            num++;
        }
    }

    private static boolean isPrime(long num) {
        if (num < 2)
            return false;
        for (long i = 2 ; i*i <= num ; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
