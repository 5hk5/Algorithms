package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LongestPart {
	
	public static int[] seq; // �Է°� �迭
	public static int[] dp; // DP �迭 (dp[i]�� seq[i]������ ����κм��� ����)
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// �Է°� �迭
		seq = new int[N]; 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i=0;i<N;i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		// dp �迭
		dp = new int[N];
		dp(N);
		
	}
	
	private static void dp(int N) {
		dp[0] = 1; 

		for (int i=1;i<N;i++) { // 1~N-1 �ε��������� ����κм��� Ž�� ����
			dp[i] = 1;
			
			for (int j=0;j<i;j++) { // �� �ε��� �ձ��� Ž�� 
				if (seq[i]>seq[j] && dp[i]<dp[j]+1) { // �Է°��� �񱳰����� ũ��, ����κм��� ���̴� ������
					dp[i] = dp[j] + 1; // �� dp �迭 �ִ밪 ++
				}
			}
		}
		
		Arrays.sort(dp);
		System.out.println(dp[N-1]);
	}


}
