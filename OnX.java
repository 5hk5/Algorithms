package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OnX {

	   public static void main(String[] args) throws IOException {
	      //입력값 1: 하단에 받을 입력값 갯수
	      //입력값 2~n: OXXOOOXXO 처럼 O X로 구성된 입력값들 => 배열로 받기 
	      //배열[0]~[n] 문자열 안에서 O 연속 시에만 1씩 누적 
	      
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      int num=Integer.parseInt(br.readLine());
	      String[] array=new String[num];
	      
	      for (int i=0;i<num;i++) {
	         array[i]=br.readLine(); //문자열 입력값들 배열에 넣음
	         int count=0;
	         int sum=0;
	         for (int j=0;j<array[i].length();j++) { //배열[0]부터 조사
	            if (array[i].charAt(j)=='O') { //배열[0]의 인덱스0부터 조사
	               count++;   
	               sum+=count; 
	            }else {
	               count=0;
	            }
	         }
	         System.out.println(sum);
	      }
	      
	   }

	}