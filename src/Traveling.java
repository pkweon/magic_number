import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Traveling {
    List<String> path = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        List<String[]> remained = new ArrayList<>();
        for (String[] ticket : tickets) {
            remained.add(ticket);
        }
        dfs("ICN", remained, 0, "");
        if (path.size() > 0) {
            Collections.sort(path);
            return path.get(0).split("->");
        }
        String[] answer = {};
        return answer;
    }

    void dfs(String now, List<String[]> tickets, int level, String history) {
        System.out.println(history);
        if (history.length() > 0) history += "->";
        history += now;
        if (tickets.isEmpty()) {
            System.out.println(history);
            path.add(history);
        } else {
            List<String[]> available = tickets.stream()
                    .filter(t -> t[0].equals(now)).collect(Collectors.toList());
            for (String[] ticket : available) {
                dfs(ticket[1], tickets.stream().filter(x -> x != ticket).collect(Collectors.toList()), level+1, history);
            }
        }
    }

    void out(List<String[]> tickets) {
        String temp = tickets.get(0)[0];
        System.out.print(tickets.get(0)[0]);
        for(String[] ticket : tickets) {
            System.out.print("->" + ticket[1]);
            temp += "->" + ticket[1];
        }
        System.out.println();
        path.add(temp);
    }
}
