package algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Recursion {
    //펠린드롬 여부 확인 (앞뒤 대칭인 문자) ex. ABBA, A, AABAA
    //입력값1 : 비교할 문자열 수
    //입력값2 : 문자열들
    //출력값 : 펠린드롬이면 1, 아니면 0 + 비교한 횟수

    public static int count=0;

    public static int recur(String S, int first, int second){ //문자열 내에서 비교 반복
        count++;
        if (first>=second) return 1; //모든 수 비교 완료 시
        else if (S.charAt(first)!=S.charAt(second)) return 0; //비교 시 다른 문자일 때
        else return recur(S,first+1,second-1); //문자열 바깥쪽에서부터 두 수 비교
    }

    public static int isPalindrome(String S){
        int length = S.length();
        return recur(S, 0, length-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=0;i<T;i++){
            count=0;
            int palindrome = isPalindrome(br.readLine());
            System.out.println(palindrome+ " "+ count);
        }

    }

}
