package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Cutline {
    //입력값 1: 응시자수 수상자수
    //입력값 2: 성적 (공백 기준)
    //내림차순 커트라인 구하기 (수상자수-1 에 해당하는 인덱스의 성적 찾기 ex. 수상자수:2 -> 성적[1])
    //Arrays.sort 사용

    public static void main(String[] args) throws IOException {
        new Cutline().print();
    }

    public void print() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());
        int winner = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        Integer[] scoreArray = new Integer[total];
        int i=0;
        while (st2.hasMoreTokens()){
            scoreArray[i] = Integer.parseInt(st2.nextToken());
            i++;
        }

        Arrays.sort(scoreArray, Collections.reverseOrder());

        System.out.println(scoreArray[winner-1]);
    }

}
