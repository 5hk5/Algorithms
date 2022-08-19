package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Average {

	public static void main(String[] args) throws IOException {

		//조작 점수 = 실 평균값/최댓값 * 100
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int count=Integer.parseInt(br.readLine()); //첫번째 입력값 (입력할 값 갯수)
		Double nums[]=new Double[count];
		StringTokenizer st= new StringTokenizer(br.readLine()); //두번째 입력값 (값 나열)
		br.close();
		
		//값 배열에 넣기
		for (int i=0;i<count;i++) {
			nums[i]=Double.parseDouble(st.nextToken());
		}
		
		//최댓값, 평균 구하기
		Double max=0.0;
		Double sum=0.0;
		for (int i=0;i<count;i++) {
			if(max<nums[i]) {
				max=nums[i];
			}
			sum+=nums[i];
		}
		
		Double avg=sum/count;
		Double result=avg/max*100;
		
		System.out.println(result);
		
	}

}
