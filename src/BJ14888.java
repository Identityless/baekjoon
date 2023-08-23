import java.io.*;
import java.util.Arrays;

public class BJ14888 {
    private static int[] numbers;
    private static int[] operators; // 순서대로 + - * /
    private static int N;
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        operators = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        find(1, numbers[0]);

        bw.write(max + "\n" + min);
        bw.flush();
        bw.close();
    }

    private static void find(int sp, int sub) {
        if (sp == N) {
            min = Math.min(min, sub);
            max = Math.max(max, sub);
            return;
        }

        for (int i = 0 ; i < 4 ; i++) {
            if (operators[i] > 0) {
                int tmp = 0;
                operators[i] -= 1;
                switch (i) {
                    case 0 : {
                        tmp = sub + numbers[sp];
                        break;
                    }
                    case 1 : {
                        tmp = sub - numbers[sp];
                        break;
                    }
                    case 2 : {
                        tmp = sub * numbers[sp];
                        break;
                    }
                    case 3 : {
                        tmp = sub / numbers[sp];
                        break;
                    }
                }
                find(sp+1, tmp);
                operators[i] += 1;
            }
        }
    }
}
