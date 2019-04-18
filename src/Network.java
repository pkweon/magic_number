import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Network {
    /*
    public int solution(int n, int[][] computers) {
        boolean[] checked = new boolean[computers.length];
        int answer = n;
        for (int x = 0; x < n-1; x++) {
            if (!checked[x]) {
                checked[x] = true;
                for (int y = x+1; y < n; y++) {
                    if (computers[x][y] == 1) {
                        if (!checked[y]) {
                            checked[y] = true;
                            System.out.println(x + "," + y);
                            answer--;
                            if (answer == 1) return answer;
                        }
                    }
                }
            }
        }
        return answer;
    }
    */

    void dfs(int start, int[][] computers, int n) {
        checked[start]= true;
        for(int i=0; i<n; i++)
        {
            if(!checked[i] && computers[start][i] == 1) {
                dfs(i, computers, n);
            }
        }
    }

    boolean[] checked;

    public int solution(int n, int[][] computers) {
        checked = new boolean[computers.length];
        int answer = 0;
        for(int i=0; i<n; i++)
        {
            if(!checked[i]) {
                answer++;
                dfs(i, computers, n);
            }
        }
        return answer;
    }
}
