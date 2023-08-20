import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class BJ17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Integer> primeSet = new HashSet<>();

        for (int i = 2 ; i <= 100000 ; i++) {
            if (isPrime(i))
                primeSet.add(i);
        }
        int N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            int tmp = Integer.parseInt(br.readLine());
            int cnt = 0;
            for (int j = 2 ; j*2 <= tmp ; j++) {
                if (primeSet.contains(j) && primeSet.contains(tmp-j))
                    cnt++;
            }
            bw.write(cnt+"\n");
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
