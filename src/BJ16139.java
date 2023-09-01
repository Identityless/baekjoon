import java.io.*;
import java.util.*;

public class BJ16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        int q = Integer.parseInt(br.readLine());
        int[][] arr = new int[S.length()+1][26];
        for (int i = 1 ; i <= S.length() ; i++) {
            for (int j = 0 ; j < 26 ; j++) {
                if (S.charAt(i-1)-97 == j) {
                    arr[i][j] = arr[i-1][j] + 1;
                }
                else {
                    arr[i][j] = arr[i-1][j];
                }
            }
        }
        for (int i = 0 ; i < q ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String target = st.nextToken();
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int answer = arr[to+1][target.charAt(0)-97] - arr[from][target.charAt(0)-97];
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
    }
}
