package algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cantor {

    //칸토어 => 각 구간 3등분해 가운데 구간을 반복적으로 제외
    //입력값 : N
    //문자열("-" * 3^N) 3등분해가며 가운데 구간은 공백으로 바꿈 (모든 선의 길이가 1 될 때까지)
    //출력값 : -와 공백으로 구성된 문자열

    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while((input = br.readLine())!=null){
            sb = new StringBuilder();

            int number = (int)Math.pow(3,Integer.parseInt(input)); //3^N

            for (int i=0;i<number;i++){
                sb.append("-"); //초기 문자열 세팅
            }

            cantor(0,number);

            System.out.println(sb.toString());

        }
    }

   public static void cantor(int start, int size){
        if (size==1){ //base condition
            return;
        }

        int newSize = size/3;

        for (int i=start+newSize;i<start+(newSize*2);i++){
            sb.setCharAt(i,' '); //가운데 구간 공백으로
        }

        cantor(start,newSize); //왼쪽 구간
        cantor(start+(newSize*2),newSize); //오른쪽 구간
   }

}
