package algorithms.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ParentNode {
    /*
    * 루트 노드가 1인 트리
    * 입력값 1 : 노드 개수
    * 입력값 2 : 연결된 정점 ex.1 6 (노드 개수-1 개 만큼)
    * 출력값 : 2번 노드부터 각 노드 부모노드 번호 출력
    * */

    static boolean[] visited;
    static ArrayList<Integer> nodes[];
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //노드 수

        parent = new int[N+1]; //출력할 부모노드 리스트
        nodes = new ArrayList[N+1]; //노드 리스트
        visited = new boolean[N+1]; //노드 방문 여부

        //각 노드에 리스트 대입
        for (int i=0;i<N+1;i++){
            nodes[i] = new ArrayList<>();
        }

        //입력값 노드들 연결
        StringTokenizer st;
        for (int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            nodes[node1].add(node2);
            nodes[node2].add(node1);
        }

        //1번 루트노드부터 dfs
        dfs(1);

        //2번 노드부터 부모노드 출력
        for (int i=2;i<N+1;i++){
            System.out.println(parent[i]);
        }
    }

    static void dfs(int root){
        visited[root] = true; //위에서부터 방문처리

        for (int node : nodes[root]){ //root번 노드와 연결된 노드들(node) 탐색
            if (!visited[node]){ //연결노드(node)가 방문 처리 안 됐다면
                parent[node] = root; //root는 node번 노드의 부모
                dfs(node);
            }
        }
    }

}
