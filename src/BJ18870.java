import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BJ18870 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int i = 0;
        LinkedList<Integer> link = new LinkedList<>();
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] processedArr = Arrays.stream(inputs).distinct().sorted().toArray();
        HashMap<Integer, Integer> dict = new HashMap<>();
        inputs = Arrays.stream(inputs).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        LinkedList<Integer> list =(LinkedList<Integer>) Arrays.stream(inputs).boxed().toList();
        for(int a : processedArr) {
            dict.put(a, i++);
        }
        List<Map.Entry<Integer, Integer>> entries = dict.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).collect(Collectors.toList());
        Arrays.stream(inputs).forEach(it -> {
            try {
                bw.write(dict.get(it)+" ");
            } catch (IOException e) {

            }
        });



        bw.flush();
        bw.close();
    }
}
