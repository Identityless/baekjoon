import java.io.*;

public class BJ4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            int tmp = Integer.parseInt(br.readLine());
            int cnt = 0;
            if (tmp == 0)
                break;
            for (int i = tmp+1 ; i <= tmp*2 ; i++) {
                if (isPrime(i))
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

