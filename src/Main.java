public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        //System.out.println(new Solution().solution(new int[] {1, 1, 1, 1, 1}, 3));
        //System.out.println(new Network().solution(3, new int[][] { {1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        //System.out.println(new Network().solution(3, new int[][] { {1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
        //System.out.println(new Network().solution(3, new int[][] { {1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
        //System.out.println(new Converter().solution("hit" , "cog", new String[] { "hot", "dot", "dog", "lot", "log", "cog"}));
        //System.out.println(new Traveling().solution(new String[][] { {"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"} }));
        System.out.println(new Traveling().solution(new String[][] {
                {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}
        }));
    }
}

class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0);
    }

    public void out(int[] numbers) {
        for (int x : numbers) System.out.print(" " + x);
        System.out.println();
    }

    public int dfs(int[] numbers, int target, int level) {
        if (level < numbers.length) {
            numbers[level] *= 1;
            int plus = dfs(numbers, target, level+1);
            numbers[level] *= -1;
            int minus = dfs(numbers, target, level+1);
            return plus + minus;
        } else {
            int sum = 0;
            for (int x : numbers) sum += x;
            if (sum == target) {
                out(numbers);
                return 1;
            } else {
                return 0;
            }
        }
    }
}
