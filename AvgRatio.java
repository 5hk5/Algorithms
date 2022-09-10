package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AvgRatio {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//첫번째 입력값 : 테스트케이스 개수
		//각 테스트케이스 : 학생수, 성적1, 성적2, ..
		//평균점수 넘는 학생 비율 출력 (소수점 셋째 자리까지)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count=Integer.parseInt(br.readLine()); //테스트케이스 개수

		for (int i=0;i<count;i++) {
			
			StringTokenizer st=new StringTokenizer(br.readLine()," "); //각 테스트 케이스
			int student=Integer.parseInt(st.nextToken()); //학생 수
			int[] arrays=new int[student]; //성적 배열 
			double sum=0;
			
			for (int j=0;j<student;j++) {
				int score=Integer.parseInt(st.nextToken()); //성적
				arrays[j]=score;
				sum+=score;
			}
			
			double avg=sum/student;
			double avgCount=0;
			
			for (int j=0;j<student;j++) {
				if(avg<arrays[j]) {
					avgCount++;
				}
			}
			
			System.out.printf("%.3f%%\n",avgCount/student*100);
			
		}
		
	}

}
