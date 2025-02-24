import java.util.*;
public class Quicksort {
    public static void quicksort(int[] a,int low, int high) {
        if (low < high) {
            int j=partition(a,low,high);
            quicksort(a,low,j-1);
            quicksort(a,j+1,high);
}
}
public static int partition(int[] a,int low,int high) {
    int pivot=a[low];
    int i=low+1;
    int j=high;
    while(i<j){
        while(a[i]<=pivot && i<j){
            i++;
        }
        while(a[j]>=pivot && i<=j){
            j--;
        }
        if(i<j){
            swap(a,i,j);
        }
    }
    swap(a,j,low);
    return j;
}
public static void swap(int[] a,int i,int j) {
    int temp=a[i];
    a[i]=a[j];
    a[j]=temp;
}
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter Array size :");
    int n=s.nextInt();
    int[] a=new int[n];
    System.out.println("Enter "+n+" elements :");
    for(int i=0;i<n;i++){
        a[i]=s.nextInt();
    }
    System.out.println("Given Array ::");
    for(int i:a){
        System.out.print(i+" ");
    }
    System.out.println();
    quicksort(a,0,n-1);
    System.out.println("Array After Sorting ::");
    for(int i:a){
    System.out.print(i+" ");
}
System.out.println();
}
}
