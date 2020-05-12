import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int numRouters1 = 7;
        int numLinks1 = 7;
        int[][] links1 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};
        System.out.println(getCriticalNodes(links1, numLinks1, numRouters1));
    }

    private static List<Integer> getCriticalNodes(int[][] links, int numLinks, int numRouters) {
        int[] lowTimes = new int[numRouters];
        int[] discTimes = new int[numRouters];
        boolean[] visited = new boolean[numRouters];

        List<Integer> result = new ArrayList<>();

        // create graph and adjacency matrix
        List[] graph = new ArrayList[numRouters];
        for (int i = 0; i < numRouters; i++) graph[i] = new ArrayList<Integer>();
        for (int[] link : links) {
            int node = link[0];
            int edge = link[1];
            graph[node].add(edge);
            graph[edge].add(node);
        }
        System.out.println(Arrays.toString(graph));

        // run dfs
        int currNode = 0;
        int parent = -1;
        int time = 0;

        DFS(graph, currNode, parent, result, visited, lowTimes, discTimes, time);

        return result;
    }

    private static void DFS(List[] graph, int currNode, int parent, List<Integer> result, boolean[] visited, int[] lowTimes, int[] discTimes, int time) {
        time += 1;

        discTimes[currNode] = time;
        lowTimes[currNode] = time;
        visited[currNode] = true;

        List<Integer> neighbors = graph[currNode];
        for (int neighbor : neighbors) {
            if (neighbor == parent) continue;
            if (!visited[neighbor]) {
                DFS(graph, neighbor, currNode, result, visited, lowTimes, discTimes, time);
                lowTimes[currNode] = Math.min(lowTimes[currNode], lowTimes[neighbor]);
                if (discTimes[currNode] < lowTimes[neighbor]) result.add(currNode);
            } else {
                lowTimes[currNode] = Math.min(lowTimes[currNode], discTimes[neighbor]);
            }
        }
    }

}
