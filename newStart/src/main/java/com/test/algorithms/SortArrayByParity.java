package com.test.algorithms;

public class SortArrayByParity {

	public int[] sortArrByParity_1 (int[] A) {
		int i = 0;
		int j = A.length -1;
		while (i < j) {
			if (A[i] % 2 == 0) i++;
			if (A[j] % 2 == 1) j--;
			if (A[i]%2 > A[j]%2) {
				int temp = A[i];
				A[i]=A[j];
				A[j]=temp;
			}				
		}
		return A;
	}
	
	public int[] sortArrayByParity_2 (int[] A) {
		int[] B = new int[A.length];
		int t=0;
		for (int i=0;i<A.length;i++) {
			if (A[i] %2 == 0) {
				B[t]=A[i];
				t++;
			}
		}
		for (int i=0;i<A.length;i++) {
			if(A[i]%2 == 1) {
				B[t]=A[i];
				t++;
			}
		}	
		return B;
	}
	
	public static void main (String[] args) {
		SortArrayByParity sortArrayByParity = new SortArrayByParity();
		int[] A = new int[] {1,2,3,4,12,324,34,33,32,655,675,7,78,356,90,96,92};
		int[] A1 =sortArrayByParity.sortArrByParity_1(A);
		for (int a: A1) {
			System.out.print(a + "  ");
		}
		System.out.println("\n -------------------------------------------------------------------------------------");
		int[] A2 =sortArrayByParity.sortArrByParity_1(A);
		for (int a: A2) {
			System.out.print(a + "  ");
		}
		
	}
	
}
