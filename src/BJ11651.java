import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class BJ11651 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int numOfLoc = Integer.parseInt(br.readLine());
        int[][] cordinates = new int[numOfLoc][2];

        for(int i = 0 ; i < numOfLoc ; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            cordinates[i][0] = input[0];
            cordinates[i][1] = input[1];
        }

        Arrays.sort(cordinates, (e1, e2) -> {
            if (e1[1] == e2[1])
                return e1[0] - e2[0];
            else
                return e1[1] - e2[1];
        });

        for (int[] e : cordinates) {
            bw.write(e[0]+" "+e[1]+"\n");
        }
        bw.flush();
        bw.close();
    }
}

