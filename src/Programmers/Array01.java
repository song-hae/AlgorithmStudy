package Programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Array01 {
    /*
    constraint
    1. 정수 배열의 길이는 2이상 10^5이하
    2. 정수 배열의 각 데이터 값은 -100,000 이상 100,000 이하

    ! 문제 분석
    데이터 개수는 최대 10^5, 제한 시간에 따라 O(N^2) 사용 불가 (3초 기준)
    why? 10^5개이면 10^5*10^5번 연산해야 하는데 10초 이상 걸림 (일반적으로 컴퓨터 1초 연산의 양은 10^8)
    원본 배열의 상태를 유지할지, 유지하지 않을지 고려 -> clone()
    */
    private static int[] solution(int[] arr){
        int[] a = arr.clone();
        Arrays.sort(a);
        return a;
    }

    private static int[] solution2(int[] arr){
        //중복값 제거
        Integer[] result = Arrays.stream(arr).boxed().distinct().
                toArray(Integer[]::new);
        //내림차순 정렬
        Arrays.sort(result, Collections.reverseOrder());
        //int형 배열로 변경
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }

    private static int[] solution3(int[] numbers) {
        //1. 배열에서 두 수를 선택하는 모든 경우의 수 구하기
        //2. 모든 경우의 수를 새로운 배열에 넣고, 중복값 제거
        //3. 배열을 오름차순으로 정렬하고 반환

        HashSet<Integer> set = new HashSet<>(); //셋을 통해서 중복값 허용 x

        int leng = numbers.length-1; //JAVA에서는 불필요 (C는 상황에 따라 필요할 수도)
        for(int i = 0 ; i< leng ; i++) {
            for(int j = i+1 ; j< leng + 1 ; i++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}