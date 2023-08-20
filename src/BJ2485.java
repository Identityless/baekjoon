import java.io.*;

public class BJ2485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N-1];
        int tmp = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < N-1 ; i++) {
            int tmp2 = Integer.parseInt(br.readLine());
            arr[i] = tmp2 - tmp;
            tmp = tmp2;
        }

        int intersection = getIntersection(arr[0], arr[1]);
        for (int i = 2 ; i < arr.length ; i++) {
            intersection = getIntersection(intersection, arr[i]);
        }

        int answer = 0;

        for (int section : arr) {
            answer += section / intersection - 1;
        }

        bw.write(answer+"");
        bw.flush();
        bw.close();

    }

    private static int getIntersection(int a, int b) {
        int top = Math.max(a, b);
        int bottom = Math.min(a, b);

        while (true) {
            if (top % bottom == 0) {
                return bottom;
            }
            else {
                int tmp = top;
                top = bottom;
                bottom = tmp % bottom;
            }
        }
    }
}
