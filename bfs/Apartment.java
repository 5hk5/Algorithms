package algorithms.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Apartment {

    //정사각형 지도 내 상하좌우로 1이 연결된 것을 하나의 아파트 단지로 간주함
    //입력값 1 : N (정사각형 지도 크기)
    //입력값 2 : 지도 직접 입력 (0,1로 구성 / 공백 없음)
    //출력값 1 : 총 단지 수
    //출력값 2 : 각 단지내 아파트 수 (오름차순 / 한 줄에 하나씩)

    public static int[][] map;
    public static boolean[][] visited;

    public static List<Integer> apartmentCount; //아파트 수
    public static int complexCount; //단지 수

    public static int[] dirX = {-1,1,0,0};
    public static int[] dirY = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];
        apartmentCount = new ArrayList();

        //지도 배열에 입력값 대입
        for (int i=1;i<=N;i++){
            String[] numbers = br.readLine().split("");
            for (int j=1;j<=numbers.length;j++){
                map[i][j] = Integer.parseInt(numbers[j-1]);
            }
        }

        //bfs 탐색
        for (int i=1;i<=N;i++){
            for (int j=1;j<=N;j++){
                if (map[i][j]==1 && !visited[i][j]){
                    complexCount++; //아파트 단지 수 count
                    bfs(i,j);
                }
            }
        }

        System.out.println(complexCount); //단지 수

        //단지 내 아파트 수
        Collections.sort(apartmentCount);
        for (int apt : apartmentCount){
            System.out.println(apt);
        }
    }

    public static void bfs(int x, int y){ //단지 내 아파트들 탐색

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x,y));
        visited[x][y] = true;

        int count=0;
        while (!queue.isEmpty()){
            Point point = queue.poll();

            count++; //아파트 수 count

            for (int i=0;i<4;i++) {
                int newX = point.x + dirX[i];
                int newY = point.y + dirY[i];

                if (newX>0 && newY>0 && newX<map.length && newY<map.length) {
                    if (map[newX][newY] == 1 && !visited[newX][newY]) {
                        queue.offer(new Point(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
        }

        apartmentCount.add(count); //각 단지 내 아파트들 수 리스트에 추가

    }

}
