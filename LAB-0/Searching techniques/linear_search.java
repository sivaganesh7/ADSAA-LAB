import java.util.Scanner;
public class lsearch {
	public static void main(String args[]){
		Scanner read = new Scanner(System.in);
		
		System.out.print("Enter the no. of elements: ");
		int n = read.nextInt();
		int[] arr = new int[n];
		
		System.out.println("Enter the elements: ");
		for(int i = 0; i < n; i++){
			arr[i] = read.nextInt();
		}
		
		System.out.print("Enter the key: ");
		int key = read.nextInt();
		boolean pos = linearSearch(arr, key);		
		if (pos != false){
			System.out.println("Key is found");
		}
		else {
			System.out.println("Key is not found");
		}
	}
	static boolean linearSearch(int a[], int k){
		boolean f=false;
		for(int i = 0; i < a.length; i++){
			if(k == a[i]){
				f=true;
				break;
			}
		}
		return f;
	}
}
