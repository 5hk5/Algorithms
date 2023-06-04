package algorithms.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree { //이진 탐색 트리 후위 선회
    //입력값 : 트리 전위순회 결과 차례대로 입력하기
    //출력값 : 후위선회 결과

    static List<Integer> preOrder; //루트 / 왼 ... / 오...

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //전위순회(루 왼 오) 결과 리스트에 입력값 추가
        preOrder = new ArrayList<>();
        while (true){
            String input = br.readLine();
            if (input==null || input.equals("")) break;

            preOrder.add(Integer.parseInt(input));
        }

        //후위순회 실행 (왼 오 루)
        postOrder(0,preOrder.size()-1);
    }

    static void postOrder(int start, int end){
        if (start>end) return;

        int mid = start + 1; //서브트리 나누는 기준점 (왼쪽 서브트리 마지막 숫자)
        while (mid<=end && preOrder.get(mid)<preOrder.get(start)){ //부모노드보다 작으면 왼쪽 서브트리
            mid++; //왼쪽 서브트리 마지막 인덱스될 때까지 반복
        }

        postOrder(start+1,mid-1); //왼쪽 서브트리
        postOrder(mid, end); //오른쪽 서브트리

        System.out.println(preOrder.get(start));
    }

}
