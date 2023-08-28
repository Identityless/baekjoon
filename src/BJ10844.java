import java.io.*;

public class BJ10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int mod = 1000000000;

        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N+1][10];

        for (int i = 1 ; i < 10 ; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2 ; i <= N ; i++) {
            for (int j = 0 ; j < 10 ; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][1]%mod;
                }
                if (j > 0 && j < 9) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]%mod;
                }
                if (j == 9) {
                    dp[i][j] = dp[i-1][8]%mod;
                }
            }
        }

        long answer = 0;
        for (int i = 0 ; i < 10 ; i++) {
            answer += dp[N][i];
        }

        bw.write(answer%mod+"");
        bw.flush();
        bw.close();
    }


//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int N = Integer.parseInt(br.readLine());
//
//        Queue<String> queue = new LinkedList<>(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9"));
//        Queue<String> zeroQueue = new LinkedList<>(List.of("0"));
//
//        for (int i = 1 ; i < N ; i++) {
//            int queueSize = queue.size();
//            int zQueueSize = zeroQueue.size();
//            for (int j = 0 ; j < zQueueSize ; j++) {
//                String tmp = zeroQueue.poll();
//                queue.add(1+tmp);
//            }
//            for (int j = 0 ; j < queueSize ; j++) {
//                String tmp = queue.poll();
//                int first = Integer.parseInt(tmp.charAt(0)+"");
//                if (first == 1) {
//                    zeroQueue.add(0+tmp);
//                    queue.add(2+tmp);
//                } else if (first > 1 && first < 9) {
//                    queue.add((first+1)+tmp);
//                    queue.add((first-1)+tmp);
//                }
//                else {
//                    queue.add(8+tmp);
//                }
//            }
//        }
//
//        bw.write(queue.size()%1000000000+"");
//        bw.flush();
//        bw.close();
//    }
}
