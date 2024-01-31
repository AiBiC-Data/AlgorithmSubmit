class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int N = 0;
        for(int[] a: land){
            N++;
        }
        int[][] dp = new int[N][4];
        
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];
        
        for(int i=1; i<N; i++){
            for(int j=0; j<4; j++){
                int max = 0;
                for(int k=0; k<4; k++){
                    if(j==k) continue;
                    max = Math.max(dp[i-1][k], max);
                }
                dp[i][j] = max+land[i][j];
            }
        }
        for(int i=0; i<4; i++){
            answer = Math.max(answer, dp[N-1][i]);
        }
        return answer;
    }
}