import java.io.*;
import java.util.Arrays;

public class BJ19532 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x, y;
        for(x = -999 ; x <= 999 ; x++) {
            for (y = -999; y <= 999 ; y++) {
                if(inputs[0]*x + inputs[1]*y == inputs[2] && inputs[3]*x + inputs[4]*y == inputs[5]) {
                    bw.write(x+" "+y);
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }
    }
}
