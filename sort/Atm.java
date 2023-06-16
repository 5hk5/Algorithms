package algorithms.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Atm {
    /*
    * ATM 앞에 N명의 사람들이 줄 설 때, 각 사람들의 대기시간 총합의 최소값
    * 인당 대기시간 = (앞 사람들의 대기시간 + 본인 대기시간)이므로 오름차순 정렬로 누적합 최소화시키기
    *
    * 입력값 1 : N(사람 수)
    * 입력값 2 : 인당 인출시간(대기시간) ex. 1 4 6 3 4
    * 출력값 : 인당 대기시간 총합의 최소값
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //사람 수

        int[] timePerOne = new int[N]; //각 인출시간

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            timePerOne[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(timePerOne); //오름차순 정렬

        //인당 대기시간 총합
        int waitingTime=0; //인당 누적 대기시간
        int totalTime=0; //총합
        for (int i=0;i<N;i++){
            waitingTime += timePerOne[i];
            totalTime += waitingTime;
        }

        System.out.println(totalTime);
    }

    static void sort(){

    }

}
