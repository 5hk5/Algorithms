package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mode {

    //배열 내 최빈값 구하기
    //입력 예 : 1,2,2,3,4
    //출력 예 : 2
    //최빈값 2개 이상일 시 -1 출력

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ",");

        int[] array = new int[st.countTokens()];
        for (int i=0;i<array.length;i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(mode(array));
    }

    static int mode(int[] array) {
        int[] count = new int[1001];

        int max = 0; //빈도 최대값
        int maxNum = 0; //최빈값
        for (int i=0;i<array.length;i++){
            count[array[i]]++;

            if (max < count[array[i]]){
                max = count[array[i]];
                maxNum = array[i];
            }
        }

        //최빈값 중복 시 -1 반환
        int repeat=0;
        for (int i=0;i<count.length;i++){
            if (max == count[i]){
                repeat++;
            }
            if (repeat>1){
                return -1;
            }
        }

        return maxNum;
    }

}
