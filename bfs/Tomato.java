package algorithms.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {
    /*
    * 격자 모양 상자 안에 토마토 있음 => 배열
    * 0: 익지 않은 토마토, 1: 익은 토마토, -1: 토마토 없는 빈 칸
    * 익은 토마토의 상하좌우 칸에 익지 않은 토마토가 있으면 1일 후 익음 (+1)
    *
    * 입력값 1 : M N (M: 상자 가로 길이, N: 상자 세로 길이)
    * 입력값 2 : 상자 배열 (0,1,-1로 구성)
    * 출력값 : 상자 내부 토마토 모두 익을 때까지의 최소 날짜 => BFS
    * (이미 모든 토마토 익었으면 0 출력, 모든 토마토 익을 수 없는 상황이면 -1 출력)
    * */

    static int M, N;

    static int[][] box;

    static int[] nx = {-1,1,0,0};
    static int[] ny = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); //상자 가로
        N = Integer.parseInt(st.nextToken()); //상자 세로

        box = new int[N][M];

        //box 배열 초기화
        for (int i=0;i<N;i++){
            String[] s = br.readLine().split(" ");
            for (int j=0;j<M;j++){
                box[i][j] = Integer.parseInt(s[j]);
            }
        }

        //bfs 탐색
        bfs();

        //출력
        print();

    }

    static void bfs(){

        Queue<Point> queue = new LinkedList<>();

        //익은 토마토 큐에 넣기
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (box[i][j]==1){
                    queue.offer(new Point(i,j));
                }
            }
        }

        //익지 않은 토마토 큐에 새로 추가하며 일수 계산
        while (!queue.isEmpty()){
            Point point = queue.poll();

            for (int i=0;i<4;i++){
                int xx = nx[i] + point.x;
                int yy = ny[i] + point.y;


                if (xx>=0 && yy>=0 && xx<N && yy<M){
                    if (box[xx][yy]==0) {
                        box[xx][yy] = box[point.x][point.y] + 1; //일수 계산

                        queue.offer(new Point(xx,yy));
                    }
                }
            }
        }

    }

    static void print(){

        int max=0;
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (box[i][j]==0) { //익지 않은 토마토 남아있을 때
                    System.out.println(-1);
                    return;
                }

                max = Math.max(max, box[i][j]);
            }
        }

        if (max==1){ //처음부터 모든 토마토 익었을 때
            System.out.println(0);
        } else {
            System.out.println(max-1);
        }

    }

}
