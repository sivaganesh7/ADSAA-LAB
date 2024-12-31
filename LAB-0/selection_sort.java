import java.util.Scanner;

public class selection_sort {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("enter the size of array: ");
        int n=s.nextInt();
        int[] a=new int[n];
        System.out.println("enter the elements of array: ");
        for(int i=0;i<a.length;i++){
            a[i]=s.nextInt();
        }
        System.out.println("Before sorting: ");
        for(int i:a){
            System.out.print(i+" ");
        }
        int i,j,temp;
        for (i = 0; i <n-1; i++) {
            int min = i;
            for(j=i+1;j<n;j++){
                if(a[j]<a[min]){
                    min=j;
                    }
                }
              temp=a[min];
             a[min]=a[i];
             a[i]=temp;
             }
        System.out.println("\nAfter sorting: ");
        for(int k:a){
            System.out.print(k+" ");
            }
            }
        }
