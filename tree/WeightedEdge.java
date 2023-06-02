package algorithms.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class WeightedEdge {
    /* 트리의 지름
    * = 리프노드 간 간선들의 최대 가중치 구하기
    * 입력값 1 : 노드 개수
    * 입력값 2 : n-1개 줄에 부모노드, 자식노드, 간선 가중치 입력 (공백 구분 / 부모노드 번호 작은 것부터 입력, 부모노드 번호가 같으면 자식노드 작은 것부터 입력)
    * ex. 1 2 3
    * 출력 값 : 노드 간 최대 경로 (리프노드)
    * 루트노드 번호는 1
    * 간선 가중치는 100 미만의 양의 정수
    */

    static boolean[] visited;
    static List<Node> tree[];

    static class Node {
        int num; //노드 번호
        int edge; //간선 가중치

        public Node (int num, int edge){
            this.num = num;
            this.edge = edge;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(br.readLine());

        tree = new ArrayList[nodes+1];
        visited = new boolean[nodes+1];

        for (int i=1;i<nodes+1;i++){
            tree[i] = new ArrayList<Node>();
        }

        StringTokenizer st;
        for (int i=0;i<nodes-1;i++){
            st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int edgeWeight = Integer.parseInt(st.nextToken());

            tree[parent].add(new Node(child, edgeWeight));
            tree[child].add(new Node(parent, edgeWeight));
        }

        for (int i=1;i<=nodes;i++){
            visited = new boolean[nodes+1]; //방문 배열 초기화
            visited[i] = true;
            dfs(i,0); //각 노드 dfs 탐색
        }

        System.out.println(maxEdge); //최대 간선 경로

    }

    static int maxEdge;

    static void dfs(int num, int edge){
        if (maxEdge < edge){
            maxEdge = edge; //간선 가중치 업데이트
        }

        for (Node node : tree[num]){
            if (!visited[node.num]){ //미방문 자식노드면
                visited[node.num] = true;
                dfs(node.num, edge + node.edge); //간선 가중치 누적시키면서 dfs 재귀 실행
            }
        }
    }

}
