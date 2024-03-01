package algorithms.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class connectedComponents {
    // 방향 없는 그래프 => 연결 요소 개수 구하기
    // 입력 1 : N M => N: 정점 개수, M: 간선 개수
    // 입력 2~ : u v => u, v: 간선 양 끝 점
    // 출력 : 연결 요소 개수
    public static boolean[][] graph;
    public static boolean[] visited;
    public static int connectionCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int node = Integer.parseInt(st.nextToken());
        int link = Integer.parseInt(st.nextToken());

        graph = new boolean[node+1][node+1];
        visited = new boolean[node+1];

        for (int i=0;i<link;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph[node1][node2] = graph[node2][node1] = true;
        }

        countConnection();

        System.out.println(connectionCnt);
    }

    // 연결요소 count
    private static void countConnection() {
        for (int i=1;i<graph.length;i++){
            if (!visited[i]){ // 노드(i) 미방문 시 dfs 탐색
                dfs(i);
                connectionCnt++;
            }
        }
    }

    // dfs 탐색
    private static void dfs(int node) { // 방문 => true 대입
        visited[node] = true;

        for (int i=1;i<graph[node].length;i++){
            if (!visited[i] && graph[node][i]){ // 미방문 & 현 node와 연결된 노드일 때
                dfs(i); // 다시 dfs 탐색
            }
        }
}

}
