package algorithms.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TreeCount {

    /* 주어진 그래프 내 트리 개수 세기
    * 트리 = 사이클 없는 연결 요소
    * 트리 => 두 정점 경로 1개뿐 & 정점 n개 -> 간선 n-1개
    * 입력값 1 : N M (N: 정점 수 , M: 간선 수)
    * 입력값 2 : M개의 테스트케이스 (연결할 정점 a,b 입력) ex. 1 2
    * 출력값 :
    * 트리 없으면 "Case n: No trees."
    * 1개면 "Case n: There is one tree."
    * 그 외 "Case n: A forest of T trees."
    */

    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); //노드 개수
            int M = Integer.parseInt(st.nextToken()); //간선 개수

            if (N==0 && M==0) break;

            graph = new ArrayList[N+1];
            visited = new boolean[N+1];
            for (int i=1;i<=N;i++){
                graph[i] = new ArrayList<>();
            }

            for (int i=1;i<=M;i++){
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());

                graph[node1].add(node2);
                graph[node2].add(node1);
            }

            int treeCount = 0; //트리 개수
            for (int i=1;i<=N;i++){ //각 노드 탐색
                if (!visited[i]){
                    visited[i] = true;
                    if (dfs(0,i))  treeCount++;
                }
            }

            print(treeCount);
        }

    }

    static boolean dfs(int root, int node){ //트리 여부 확인
        for (int i : graph[node]){
            if (i == root) continue;
            if (visited[i]) return false; //방문 여부 확인
            visited[i] = true;
            if (!dfs(node, i)) return false; //역방향 확인
        }

        return true;
    }

    static int caseCount = 0;
    static void print(int treeCount){
        caseCount++;

        switch (treeCount){
            case 0 :
                System.out.println("Case " + caseCount + ": No trees.");
                break;
            case 1 :
                System.out.println("Case " + caseCount + ": There is one tree.");
                break;
            default :
                System.out.println("Case " + caseCount + ": A forest of " + treeCount + " trees.");
                break;
        }
    }

}
