import java.io.*;
import java.util.*;

public class BJ10814 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[][] inputs = new String[N][2];

        for (int i = 0 ; i < N ; i++) {
            String[] input = br.readLine().split(" ");
            inputs[i][0] = input[0];
            inputs[i][1] = input[1];
        }

        Arrays.sort(inputs, (e1, e2) -> {
//           if (Integer.parseInt(e1[0]) == Integer.parseInt(e2[0])) {
//              return e2[1].compareTo(e1[1]);
//           }
           return Integer.parseInt(e1[0]) - Integer.parseInt(e2[0]);
        });

        Arrays.stream(inputs).forEach(it -> {
            try {
                bw.write(it[0]+" "+it[1]+"\n");
            } catch(IOException e) {

            }
        });

        bw.flush();
        bw.close();
    }
}
