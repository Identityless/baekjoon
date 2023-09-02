import java.io.*;
import java.util.*;
class Main {
    static long Comb(long n){
        if (n < 2)
            return 0;
        else
            return n * (n - 1) / 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] S = new long[n];
        int[] M = new int[n];
        int[] C = new int[m];
        for (int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            if (i == 0)
                S[i] = num;
            else
                S[i] = S[i - 1] + num;
            M[i] = (int)(S[i] % m);
            C[M[i]]++;
        }
        long sum = C[0];
        for (int i = 0; i < m; i++)
            sum += Comb(C[i]);
        System.out.println(sum);
    }
}

public class BJ10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        int[] cnt = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= N ; i++) {
            arr[i] = (int) (arr[i-1] + Long.parseLong(st.nextToken())) % M;
            cnt[arr[i]] += 1;
        }

        long result = cnt[0];

        for (int i = 0 ; i < M ; i++) {
            if (cnt[i] > 1) {
                result += getCombination(cnt[i]);
            }
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }

    private static long getCombination(long n){
        return n*(n-1)/2;
    }
}
