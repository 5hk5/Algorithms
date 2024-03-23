package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Average {

	public static void main(String[] args) throws IOException {

		//���� ���� = �� ��հ�/�ִ� * 100
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int count=Integer.parseInt(br.readLine()); //ù��° �Է°� (�Է��� �� ����)
		Double nums[]=new Double[count];
		StringTokenizer st= new StringTokenizer(br.readLine()); //�ι�° �Է°� (�� ����)
		br.close();
		
		//�� �迭�� �ֱ�
		for (int i=0;i<count;i++) {
			nums[i]=Double.parseDouble(st.nextToken());
		}
		
		//�ִ�, ��� ���ϱ�
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
