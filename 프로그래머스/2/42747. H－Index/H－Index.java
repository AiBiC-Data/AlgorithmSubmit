class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        int[] nums = new int[10001];
        for(int i=0; i<n; i++){
            int t = citations[i];
            nums[t]+=1;
        }
        int cnt=0;
        for(int i=0; i<10001; i++){
            if(cnt<=i && n-cnt>=i){
                answer=i;
            }
            cnt += nums[i];
        }
        return answer;
    }
}