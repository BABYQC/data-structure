import java.util.*;

/**
 * 无向图
 *
 * @Author: chang qi
 * @Date: 2023/10/23
 */
public class GraphUndirected {

    private Map<Integer, List<Integer>> graph;
    private int nodeCount;

    public void init(int[][] edges, int nodeCount) {
        this.nodeCount = nodeCount;
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1]);
        }
    }

    public void addEdge(int src, int dest) {
        List<Integer> srcEdges = graph.getOrDefault(src, new ArrayList<>());
        srcEdges.add(dest);
        graph.put(src, srcEdges);

        List<Integer> destEdges = graph.getOrDefault(dest, new ArrayList<>());
        destEdges.add(src);
        graph.put(dest, destEdges);
    }

    public List<Integer> bfs(int start, int target) {
        int[] remember = new int[]{nodeCount};
        // 记录搜索路径
        Map<Integer, Integer> searchMap = new HashMap<>();
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);

        while (!deque.isEmpty()) {
            int node = deque.remove();

            // 搜寻到结果
            if (node == target) {
                break;
            }

            if (remember[node] == 1) {
                continue;
            }
            remember[node] = 1;
            List<Integer> edges = graph.get(node);
            for (int dst : edges) {
                if (remember[dst] == 1) {
                    continue;
                }
                remember[dst] = 0;
                deque.add(dst);
                searchMap.put(dst, node);
            }

        }

        //
    }

}
