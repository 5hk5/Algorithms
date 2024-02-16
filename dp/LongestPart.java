package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LongestPart {
	
	public static int[] seq; // 입력값 배열
	public static int[] dp; // DP 배열 (dp[i]는 seq[i]까지의 최장부분수열 길이)
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 입력값 배열
		seq = new int[N]; 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i=0;i<N;i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		// dp 배열
		dp = new int[N];
		dp(N);
		
	}
	
	private static void dp(int N) {
		dp[0] = 1; 

		for (int i=1;i<N;i++) { // 1~N-1 인덱스까지의 최장부분수열 탐색 시작
			dp[i] = 1;
			
			for (int j=0;j<i;j++) { // 각 인덱스 앞까지 탐색 
				if (seq[i]>seq[j] && dp[i]<dp[j]+1) { // 입력값이 비교값보다 크고, 최장부분수열 길이는 작으면
					dp[i] = dp[j] + 1; // 현 dp 배열 최대값 ++
				}
			}
		}
		
		Arrays.sort(dp);
		System.out.println(dp[N-1]);
	}


}
