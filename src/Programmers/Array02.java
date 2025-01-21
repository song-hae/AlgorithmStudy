package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Array02 {
	//N이 최대 10000이므로 N^2은 안됨
	//1. 정답 배열과 수포자의 답안을 비교해서 같을 때마다 cnt를 1씩 늘리기
	//2. cnt가 가장 높은 사람을 배열에 놓고, 오름차순 정렬
	//answers는 10000까지 될 수 있으니, 답안에 대한 iterator는 answers를 각 수포자의 답안으로 나눈 나머지를 사용해야 할 듯?
	
	//실제 풀이
	private static int[] solution4(int[] answers) {
		//2차원 배열에 패턴 넣어줌  
		int[][] pattern = {
				{1,2,3,4,5}, 
				{2,1,2,3,2,4,2,5}, 
				{3,3,1,1,2,2,4,4,5,5}
				};
		
		//각 수포자의 점수를 넣어줄 배열 생성 
		int[] scores = new int[3];
		
		for(int i=0; i<answers.length; i++) { //정답을 순회
			for(int j=0; j<pattern.length; j++) { //수포자 답안을 담은 2차원 배열 순회  
				if(answers[i] == pattern[j][i%pattern[j].length]) { //이때 나머지 활용 
					scores[j]++;
				}
			}
		}
		
		int maxScore = Arrays.stream(scores).max().getAsInt(); //3명의 수포자 중 가장 높은 점수 구함
		
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i=0; i<scores.length; i++) {
			if(scores[i] == maxScore) {
				answer.add(i+1); //리스트에 가장 큰 점수에 해당하는 사람 넣음(중복 가능)
			} //오름차순은? 그렇기 때문에 일부러 1번 수포자부터 배열을 순회한 것(이러면 오름차순 반영됨) 
		}
		
		return answer.stream().mapToInt(Integer::intValue).toArray(); //배열화
	}
	
	//행렬 곱셈
	private static int[][] solution5(int[][] arr1, int[][] arr2){
		int r1 = arr1.length;	
		int c1 = arr1[0].length;	
		int c2 = arr2[0].length;
		
		int[][] result = new int[r1][c2];
		
//		for(int i=0 ; i<r1 ; i++) {
//			for(int j=0 ; j<c2 ; j++) {
//				for(int k=0 ; k<c1 ; k++) {
//					result[i][j] += arr1[i][k] * arr2[k][j];
//				}
//			}
//		}
		
		//cache miss rate를 고려한 방법(row-wise) -> 크기가 작아서 성능 상 차이는 없지만, 크기가 커질수록 기하급수적
		for(int i=0 ; i<r1 ; i++) {
			for(int k=0 ; k<c1 ; k++) {
		  		int r = arr1[i][k];
		  		for(int j=0 ; j<c2 ; j++){
		  			result[i][j] += r * arr2[k][j];
		  		}
			}
		}
		 
		return result;
	}
}
