class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        int len = numbers.length;
        
        dfs(numbers, target, len, 0, 0);
        
        return answer;
    }
    
    static void dfs(int[] numbers, int target, int len, int depth, int sum){
        if(depth == len){
            if(sum == target) answer++;
            return;
        }
        
        
        dfs(numbers, target, len, depth+1, sum+numbers[depth]);
        dfs(numbers, target, len, depth+1, sum-numbers[depth]);
    }
}