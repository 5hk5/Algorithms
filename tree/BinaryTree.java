package algorithms.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinaryTree {
    //이진 트리 전위,중위,후위 순회
    //1<=노드 개수<=26
    //입력값 1 : 노드 개수
    //입력값 2 : A B C (A: 부모 노드, B: 왼쪽 자식 노드, C: 오른쪽 자식 노드)
    //=> 자식 노드 없으면 .으로 표시
    //출력값 : 전위, 중위, 후위 순회 결과 (각 줄, 공백 없이)
    //항상 A가 루트 노드

    static class Node { //노드
        char value;
        Node left;
        Node right;

        public Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static Node first = new Node('A', null, null); //루트 노드 설정

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodes = Integer.parseInt(br.readLine()); //노드 수

        StringTokenizer st;
        for (int i=0;i<nodes;i++){ //노드 세팅
            st = new StringTokenizer(br.readLine());

            char value = st.nextToken().charAt(0); //부모 노드 값
            char left = st.nextToken().charAt(0); //왼쪽 자식 노드
            char right = st.nextToken().charAt(0); //오른쪽 자식 노드

            insertNode(first, value, left, right);
        }

        preOrder(first);
        System.out.println();
        inOrder(first);
        System.out.println();
        postOrder(first);
    }

    public static void insertNode(Node node, char root, char left, char right) {
        if (node.value == root) { //루트 노드일 때
            node.left = (left == '.' ? null : new Node(left,null,null));
            node.right = (right == '.' ? null : new Node(right,null,null));
        } else {
            if (node.left != null) insertNode(node.left, root, left, right); //왼쪽 노드
            if (node.right != null) insertNode(node.right, root, left, right); //오른쪽 노드
        }
    }

    public static void preOrder(Node node) { //전위
        if(node == null) return;

        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) { //중위
        if(node == null) return;

        inOrder(node.left);
        System.out.print(node.value);
        inOrder(node.right);
    }

    public static void postOrder(Node node) { //후위
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value);
    }

}
