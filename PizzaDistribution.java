package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PizzaDistribution {

    //6조각 피자
    //n=사람의수
    //같은 개수의 조각을 n명이 먹으려면 최소 몇 판? (남김없이)
    //ex. n=8 일 때 8명이 6조각의 피자를 몇판 이상 먹을수 있는지 => 8 * 3 = 24 이므로 3판

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(distribute(Integer.parseInt(br.readLine())));
    }

    public static int distribute(int n) {
        if (n%6==0){
            return (int) n/6;
        } else {
            return (int) slice(n)/6;
        }
    }

    public static int slice(int n){
        for (int i=2;i<=600;i++){
            if ((i * n) % 6 == 0) {return n*i;}
        }

        return 0;
    }

}
