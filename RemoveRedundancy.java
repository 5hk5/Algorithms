package algorithms;

import java.util.ArrayList;
import java.util.Set;

public class RemoveRedundancy {

    public static void main(String[] args) {

        //오름차순 정렬
        int array[] = {3,5,2,6,9,5,73,4,6,21,2}; //주어진 배열

        int temp; //임시 변수
        for (int i=0;i<array.length-1;i++){

            for (int j=i+1;j<array.length;j++){
                if (array[i]>array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

        }

        //중복 횟수 세기
        int count=0;
        for (int i=0;i<array.length-1;i++){
            if (array[i]==array[i+1]) {
                count++;
            }
        }

        int[] newArray = new int[array.length-count]; //중북 제거된 길이의 배열 선언

        int indexCount=-1;
        for (int i=0;i<array.length-1;i++){

            if (array[i]==array[i+1]) continue; //중복 시 count X

            indexCount++; //중복 아닐 시 새 배열 인덱스로 count
            newArray[indexCount] = array[i];
            if (i+1==array.length-1){ //마지막 두 수 비교해 중복 아니면 마지막 숫자 수동 삽입
                newArray[newArray.length-1] = array[i+1];
            }
        }

        //정렬 결과 출력
        for (int i=0;i<array.length;i++){
            System.out.print(array[i] + " ");
        }

        System.out.println();

        //중복 제거된 결과 출력
        for (int i=0;i<newArray.length;i++){
            System.out.print(newArray[i] + " ");
        }

    }



}
