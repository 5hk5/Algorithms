package algorithms.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Virus {

    //1번 컴퓨터(노드)와 직간접적으로 연결되는 노드 개수 세기

    public static int[][] array;
    public static boolean[] visited;

    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //컴퓨터 수 (노드 수)
        int V = Integer.parseInt(br.readLine()); //연결된 컴퓨터 쌍 (간선 수)

        array = new int[N+1][N+1]; //노드, 간선 배열
        visited = new boolean[N+1]; //방문 여부 배열

        //배열에 컴퓨터 연결관계 설정
        StringTokenizer st;
        for (int i=0;i<V;i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            array[num1][num2] = array[num2][num1] = 1; //양방향 연결관계 설정
        }

        bfs(1);

        System.out.println(count);
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while(!queue.isEmpty()){
            Integer qNum = queue.poll();

            for (int i=0;i<array.length;i++){
                if (array[qNum][i]==1 && visited[i]==false){
                    queue.offer(i);
                    visited[i]=true;
                    count++; //1번 노드와 직간접 연결되는 노드들 모두 count
                }
            }
        }

    }

}
