import java.io.*;
import java.util.Arrays;

public class BJ1735 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int mom = a[1] * b[1];
        int son = a[0]*b[1] + b[0]*a[1];
        int top, bottom;
        int intersection;

        if (mom > son) {
            top = mom;
            bottom = son;
        } else {
            top = son;
            bottom = mom;
        }

        while (true) {
            if (top % bottom == 0) {
                intersection = bottom;
                break;
            }
            else {
                int tmp = top;
                top = bottom;
                bottom = tmp % bottom;
            }
        }
        mom /= intersection;
        son /= intersection;

        bw.write(son + " " + mom);
        bw.flush();
        bw.close();
    }
}
