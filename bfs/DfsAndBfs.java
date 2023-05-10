package algorithms.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class DfsAndBfs {

    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static StringBuilder sb = new StringBuilder();

    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);

        N = Integer.parseInt(st.nextToken()); //정점 개수
        int M = Integer.parseInt(st.nextToken()); //간선 개수
        int V = Integer.parseInt(st.nextToken()); //탐색 시작되는 정점 번호

        //그래프 초기화 (ArrayList<ArrayList<Integer>> 구조)
        for (int i=0;i<=N;i++){
            graph.add(i,new ArrayList<Integer>());
        }

        //간선 추가 (쌍방)
        for (int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int vertex1 = Integer.parseInt(st.nextToken());
            int vertex2 = Integer.parseInt(st.nextToken());

            graph.get(vertex1).add(vertex2);
            graph.get(vertex2).add(vertex1);
        }

        //ArrayList 정렬
        for (int i=0;i<=N;i++){
            Collections.sort(graph.get(i));
        }

        //dfs
        boolean[] visited = new boolean[N+1]; //정점 방문 여부 표시 배열
        dfs(V, visited);

        sb.append("\n");

        //bfs
        bfs(V);

        System.out.println(sb);

    }

    private static void dfs(int vertex, boolean[] visited){ //시작 정점, 방문 여부 배열

        visited[vertex] = true;
        sb.append(vertex).append(" ");

        for (int i=0;i<graph.get(vertex).size();i++){
            if (!visited[graph.get(vertex).get(i)]){ //하위 노드들 visited 여부 확인
                dfs(graph.get(vertex).get(i), visited);  //하위 노드들 재귀적으로 접근
            }
        }

    }

    private static void bfs(int vertex){ //시작 정점

        boolean visited[] = new boolean[N+1]; //방문 여부 배열

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(vertex);
        visited[vertex] = true; //시작 정점 방문 처리

        while (!queue.isEmpty()){
            int nearVertex = queue.poll(); //큐에 저장된 인근 노드(처음엔 시작 노드) poll
            sb.append(nearVertex).append(" ");

            for (int i=0;i<graph.get(nearVertex).size();i++){
                if (!visited[graph.get(nearVertex).get(i)]){ //하위 노드들 방문 여부 확인
                    queue.add(graph.get(nearVertex).get(i)); //큐에 추가
                    visited[graph.get(nearVertex).get(i)] = true;
                }
            }
        }

    }


}
