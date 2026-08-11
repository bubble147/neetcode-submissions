class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> e : edges) {
            adj.get(e.get(0)).add(new int[]{e.get(1), e.get(2)});
        }

        Map<Integer, Integer> dist = new HashMap<>();

        // {거리, 노드} 를 거리 오름차순으로 꺼낸다.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0];
            int node = cur[1];

            // 이미 더 짧은 경로로 확정된 노드는 건너뛴다
            if (dist.containsKey(node)) {
                continue;
            }
            dist.put(node, d);

            for (int[] next : adj.get(node)) {
                if (!dist.containsKey(next[0])) {
                    pq.offer(new int[]{d + next[1], next[0]});
                }
            }
        }

        // 큐에 한 번도 들어오지 못한 노드 = 도달 불가
        for (int i = 0; i < n; i++) {
            dist.putIfAbsent(i, -1);
        }
        return dist;
    }
}
