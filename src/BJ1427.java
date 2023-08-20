import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BJ1427 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        List<String> prelist = Arrays.asList(br.readLine().split(""));
        List<Integer> list = prelist.stream().map(it -> Integer.parseInt(it)).collect(Collectors.toList());
        list.sort(Comparator.reverseOrder());

        for(int k : list) {
            bw.write(k+"");
        }
        bw.flush();
        bw.close();
    }
}
