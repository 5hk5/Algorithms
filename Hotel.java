package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hotel {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// ȣ�� �� ����
		// �մԵ��� ���� ȣ��(width) > ����(height) ��ȣ
		// 101ȣ, 201ȣ, 301ȣ, 102ȣ, 202ȣ, .. ������ ������
		// �Է°��� ( ���� �ʺ� �մԼ��� ) �� �� �� ȣ�� ���
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int total = Integer.parseInt(br.readLine()); //�׽�Ʈ ����
		
		for (int i=0;i<total;i++) {
			
			String input=br.readLine();
			StringTokenizer st = new StringTokenizer(input," ");
			
			int height = Integer.parseInt(st.nextToken()); //����, ��
			int width = Integer.parseInt(st.nextToken()); //�ʺ�, ��
			int queue = Integer.parseInt(st.nextToken()); //�մ� ����
			
			int[][] hotel = new int [height+1][width+1];
			
			int j = 0;
			int k = 0;
			int count=0;
			loop:
			for (k=1;k<=width;k++) {
				for (j=1;j<=height;j++) {
					count++;
					hotel[j][k]=count;
					if (count==queue) { //1���� �� �� �մ� ������ ��ġ�ϰ� �Ǹ� break
						break loop;
					}
				}
			}
								
			System.out.println(100*j+k);
			
		}
		
	}

}
