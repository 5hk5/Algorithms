package algorithms.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Island { //BFS

    //행렬로 이뤄진 지도 (섬은 1, 바다는 0)
    //섬 개수 세기 (대각선으로 연결될 시 하나의 섬으로 인식)
    //입력값 1 : w h (각각 너비, 높이)
    //입력값 2 : 지도 그리기 (h개의 줄)
    //출력값 : 섬 개수
    //0 0 입력할 때까지 테스트케이스 반복

    public static int w,h; //지도 열, 행

    //상하좌우대각선 위치 좌표들
    public static int[] dirX = {0,0,1,1,1,-1,-1,-1};
    public static int[] dirY = {1,-1,0,-1,1,0,-1,1};

    public static int[][] map; //지도 배열
    public static boolean[][] visited; //방문 여부 확인 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w==0 && h==0) {
                break;
            }

            map = new int[h][w];
            visited = new boolean [h][w];

            //지도 배열 삽입
            for (int i=0;i<h;i++){
                st = new StringTokenizer(br.readLine());
                for (int j=0;j<w;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //방문 여부 확인, 섬 개수 세기
            int count=0;
            for (int i=0;i<h;i++){
                for (int j=0;j<w;j++){
                    if (!visited[i][j] && map[i][j]==1) { //방문 X, 데이터 1일 때
                        bfs(i,j);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");

        }

        System.out.println(sb);

    }

    public static void bfs(int x, int y){
        Queue<Direction> queue = new LinkedList<>();

        queue.offer(new Direction(x,y));
        visited[x][y] = true;

        while (!queue.isEmpty()){

            Direction d = queue.poll();

            //입력한 좌표 근처 좌표 확인
            for (int i=0;i<8;i++){
                int nearX = d.x + dirX[i];
                int nearY = d.y + dirY[i];

                if (nearX>=0 && nearY>=0 && nearX<h && nearY<w //지도 내 좌표인지 확인
                && !visited[nearX][nearY] && map[nearX][nearY]==1){
                    visited[nearX][nearY] = true;
                    queue.offer(new Direction(nearX, nearY));
                }
            }

        }

    }

    static class Direction {
        int x,y;

        public Direction(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

}
