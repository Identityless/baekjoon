import java.util.*;
public class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "SFO"}, {"ATL", "SFO"}, {"SFO", "ALT"}, {"SFO", "ICN"}};
        String[] ans = sol.solution(tickets);
//        for(int[] a : ans) {
//            for(int b : a) {
//                System.out.print(b + " ");
//            }
//            System.out.println();
//        }

    }
}

class Solution {
    String[][] tickets;

    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        boolean[] used = new boolean[tickets.length];
        List<String> list = dfs(used, "ICN", new ArrayList<String>());
        System.out.println(list);
        String[] answer = list.toArray(String[]::new);
        return answer;
    }

    private List<String> dfs(boolean[] used, String startPoint, List<String> list) {
        Map<String, Integer> dict = new HashMap<>();
        List<String> canGo = new ArrayList<>();
        list.add(startPoint);

        for (int i = 0 ; i < tickets.length ; i++) {
            if (tickets[i][0].equals(startPoint) && !used[i]) {
                canGo.add(tickets[i][1]);
                dict.put(tickets[i][1], i);
            }
        }
        if (!canGo.isEmpty()) {
            canGo.sort(Comparator.naturalOrder());
            for (int i = 0 ; i < canGo.size() ; i++) {
                String dest = canGo.get(i);
                int ticket = dict.get(dest);
                used[ticket] = true;
                List<String> nList = dfs(used.clone(), dest, new ArrayList<String>(list));
                used[ticket] = false;
                if (nList.size() == tickets.length + 1) {
                    return nList;
                }
            }
        }
        return list;
    }
}
