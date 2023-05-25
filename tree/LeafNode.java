package algorithms.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LeafNode {
    /*
    * 리프 노드 개수 구하기
    * 입력값 1 : 노드 개수 (50 이하 자연수)
    * 입력값 2 : 0~N-1번 노드의 부모 나열 (부모 없으면 -1) ex. -1 0 0 1 1
    * 입력값 3 : 삭제할 노드 번호 (삭제 시 자식 노드들도 모두 삭제됨)
    * 출력값 : 최종 리프 노드 수
    * */

    static int N;

    static boolean visited[];
    static ArrayList<Integer>[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //노드 개수

        visited = new boolean[N];
        nodes = new ArrayList[N];

        //각 노드에 리스트 삽입
        for (int i=0;i<N;i++){
            nodes[i] = new ArrayList<>();
        }

        //노드 트리(그래프) 세팅
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            int parent = Integer.parseInt(st.nextToken());
            if (parent==-1) continue;
            nodes[parent].add(i);
        }

        //입력한 노드, 하위 노드 삭제 (방문 처리)
        deleteNodes(Integer.parseInt(br.readLine()));

        //리프노드 개수 세기
        countLeaves();
    }

    static void deleteNodes(int nodeToDelete){
        visited[nodeToDelete] = true; //방문 처리

        for (int i=0;i<nodes[nodeToDelete].size();i++){
            int node = nodes[nodeToDelete].get(i);

            if (!visited[node]){
                deleteNodes(node); //재귀
            }
        }
    }

    static void countLeaves(){
        int leaves=0;

        for (int i=0;i<N;i++){
            int count=0;

            if (visited[i]) continue; //삭제한 노드 count X

            for (int j=0;j<nodes[i].size();j++){
                if (!visited[nodes[i].get(j)]){
                    count++; //하위 노드 세기
                }
            }

            if (count==0) leaves++; //하위 노드 없는 리프노드일 때 count
        }

        System.out.println(leaves);
    }

}
