class Solution{
    static int answer;
    public int solution(int n, int a, int b){
        answer = 0;
        find(n, a, b, 1);

        return answer;
    }
    public int find(int n, int a, int b, int c){
        if((a+1)/2==(b+1)/2){
            answer=c;
            return 0;
        }
        return find(n>>1, (a+1)>>1, (b+1)>>1, c+1);
    }
}