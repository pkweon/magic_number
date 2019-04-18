import java.util.*;
import java.util.stream.Collectors;

public class Converter {
    Map<String, Integer> result = new HashMap<>();
    int min = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        List<String> wl = Arrays.asList(words);
        if (wl.contains(target)) {
            dfs(begin, target, wl, 0, "");
        } else {
            min = 0;
        }
        return min;
    }

    void dfs(String str, String target, List<String> list, int level, String history){
        history += " " + str;
        if (str.equals(target)) {
            System.out.println(history + "! : " + target);
            result.put(history, level);
            if (min > level) min = level;
            return;
        }
        if (list.size() == 0) {
            System.out.println(history + ">" + "X : " + target + " []");
        }
        for(String candidate : list) {
            int diffc = 0;
            for (int x = 0; x < str.length(); x++) {
                if (candidate.charAt(x) != str.charAt(x)) diffc ++;
                if (diffc > 1) break;
            }
            if (diffc == 1) {
                List<String> sublist = list.stream().filter(x -> !x.equals(candidate)).collect(Collectors.toList());
                dfs(candidate, target, sublist, level+1, history);
            }
        }
    }
}
