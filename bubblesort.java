import java.util.Scanner;

public class bubblesort {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter the number of elements: ");
	int n = sc.nextInt();
	int[] A = new int[n];
	System.out.println("Enter the elements:");
	for (int i = 0; i < n; i++)
		A[i] = sc.nextInt();
	bubbleSort(A);
	System.out.println("Sorted array:");
	for (int i = 0; i < A.length; i++)
	System.out.print(A[i] + " ");
}
static void bubbleSort(int[] A) {
int n = A.length;
for (int i = 0;i <(n-1);i++){
	for (int j = 0; j <(n-1-i); j++){
		if (A[j] > A[j + 1]) {
			int temp = A[j];
			A[j] = A[j + 1];
			A[j + 1] = temp;
			}
			}
}
}

} 

