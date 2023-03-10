package algorithms.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Physical {

    public static String rank(int[][] physical){
        StringBuilder sb = new StringBuilder();

        for (int i=0;i<physical.length;i++){
            int count = 1; //등수

            for (int j=0;j< physical.length;j++){
                if (i==j) continue;
                if (physical[i][0]<physical[j][0] && physical[i][1]<physical[j][1]){ //몸무게, 키 두 요소가 더 큰 수치가 있을 때
                    count++; //등수 하락
                }
            }

            sb.append(count);
            if (i<physical.length-1){
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine()); //입력값 1 : 입력할 수치 개수

        int[][] physical = new int[number][2]; //덩치 배열 => 2차원 배열 (몸무게, 키)
        for (int i=0;i<number;i++){
            String stats = br.readLine(); //입력값 2 : 몸무게 + 키
            StringTokenizer st = new StringTokenizer(stats);
            physical[i][0] = Integer.parseInt(st.nextToken()); //몸무게
            physical[i][1] = Integer.parseInt(st.nextToken()); //키
        }

        System.out.println(rank(physical));
    }

}
