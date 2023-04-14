package algorithms.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Parenthesis {

    //괄호 짝 맞는지 안 맞는지 확인
    //입력값 : 괄호 입력할 횟수
    //출력값 : YES / NO  => 괄호 짝 맞음 / 아님
    //ex.
    //2
    //(()) => Yes
    //((() => No

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i=0;i<N;i++){
            sb.append(parenthesis(br.readLine())).append("\n");
        }

        System.out.println(sb);
    }

    public static String parenthesis(String input){
        Stack<Character> stack = new Stack<>();

        for (int i=0;i<input.length();i++){
            char p = input.charAt(i);

            //괄호 짝 맞으면 스택 empty 하도록
            if (p=='('){ //왼쪽 괄호 => 스택에 푸쉬
                stack.push(p);
            } else if (stack.empty()){ //왼쪽 괄호 없이 오른쪽 괄호부터 시작할 때
                return "NO";
            } else if (p==')'){ //오른쪽 괄호 => 스택에서 팝
                stack.pop();
            }
        }

        if (stack.isEmpty()){ //스택에 푸쉬, 팝 반복 후 남은 괄호가 없으면
            return "YES";
        } else{
            return "NO";
        }

    }

}
