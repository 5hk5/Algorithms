package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AvgRatio {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//ù��° �Է°� : �׽�Ʈ���̽� ����
		//�� �׽�Ʈ���̽� : �л���, ����1, ����2, ..
		//������� �Ѵ� �л� ���� ��� (�Ҽ��� ��° �ڸ�����)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count=Integer.parseInt(br.readLine()); //�׽�Ʈ���̽� ����

		for (int i=0;i<count;i++) {
			
			StringTokenizer st=new StringTokenizer(br.readLine()," "); //�� �׽�Ʈ ���̽�
			int student=Integer.parseInt(st.nextToken()); //�л� ��
			int[] arrays=new int[student]; //���� �迭 
			double sum=0;
			
			for (int j=0;j<student;j++) {
				int score=Integer.parseInt(st.nextToken()); //����
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
