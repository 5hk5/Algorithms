package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OnX {

	   public static void main(String[] args) throws IOException {
	      //�Է°� 1: �ϴܿ� ���� �Է°� ����
	      //�Է°� 2~n: OXXOOOXXO ó�� O X�� ������ �Է°��� => �迭�� �ޱ� 
	      //�迭[0]~[n] ���ڿ� �ȿ��� O ���� �ÿ��� 1�� ���� 
	      
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      int num=Integer.parseInt(br.readLine());
	      String[] array=new String[num];
	      
	      for (int i=0;i<num;i++) {
	         array[i]=br.readLine(); //���ڿ� �Է°��� �迭�� ����
	         int count=0;
	         int sum=0;
	         for (int j=0;j<array[i].length();j++) { //�迭[0]���� ����
	            if (array[i].charAt(j)=='O') { //�迭[0]�� �ε���0���� ����
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