
import java.util.Scanner;

public class linear_search{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("enter the size of array: ");
        int n=s.nextInt();
        int[] a=new int[n];
        System.out.println("enter the elements of array: ");
        for(int i=0;i<a.length;i++){
            a[i]=s.nextInt();
        }
        System.out.println("enter the element to search");
        int key=s.nextInt();
        boolean f=false;
        for (int i =0; i < n; i++) {
            if(a[i]==key){
                System.out.println("element found at index "+i);
                f=true;
                
            }
        }
        if(f==false){
            System.out.println("element not found");
        }
    }
}