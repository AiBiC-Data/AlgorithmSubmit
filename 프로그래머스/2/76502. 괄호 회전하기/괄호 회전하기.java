import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int size = s.length();
        s = s+s;
        for(int i=0; i<size; i++){
            Stack<Character> stack = new Stack();
            for(int j=0; j<size; j++){
                if(stack.isEmpty()){
                    stack.add(s.charAt(i+j));
                }
                else{
                    char c = stack.peek();
                    if(c=='(' && s.charAt(i+j)==')')
                        stack.pop();
                    else if(c=='[' && s.charAt(i+j)==']')
                        stack.pop();
                    else if(c=='{' && s.charAt(i+j)=='}')
                        stack.pop();
                    else
                        stack.add(s.charAt(i+j));
                }
            }
            if(stack.isEmpty())answer++;
        }
        return answer;
    }
}