package algorithms.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RGB {

    //RGB로 이뤄진 map에서 색상별로 구역 구분
    //적록색약인 사람은 R, G를 구분하지 못함
    //입력값 1 : N (정사각형 map 크기)
    //입력값 2 : map 직접 입력 (공백 X)
    //출력값 1 : A B (A: 적록색약 아닌 사람이 본 구역 수 / B: 적록색약이 본 구역 수)

    public static String[][] map;
    public static boolean[][] visited;

    public static int dx[] = {-1,0,0,1};
    public static int dy[] = {0,1,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //map 크기

        map = new String[N][N];
        visited = new boolean[N][N];

        //map 배열 입력
        for (int i=0;i<N;i++){
            String[] split = br.readLine().split("");
            for (int j=0;j<N;j++){
                map[i][j] = split[j];
            }
        }

        //적록색약X
        int count=0;
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                if (!visited[i][j]){
                    dfs(i,j);
                    count++;
                }
            }
        }

        visited = new boolean[N][N]; //방문 배열 초기화

        //적록색약O
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                if (map[i][j].equals("R")){ //R, G 동일한 문자로 변경
                    map[i][j] = "G";
                }
            }
        }

        int count2=0;
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                if (!visited[i][j]){
                    dfs(i,j);
                    count2++;
                }
            }
        }

        System.out.println(count+" "+count2);

    }

    public static void dfs(int x, int y){
        visited[x][y] = true;
        String color = map[x][y];

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<map.length && ny<map.length){
                if(!visited[nx][ny] && color.equals(map[nx][ny])) dfs(nx, ny); //재귀
            }
        }

    }

}
