import java.util.*;
public class knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter bag weight");
        int m = sc.nextInt();
        System.out.println("enter total number weights ");
        int n = sc.nextInt();
        int p[] = new int[n];
        int w[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("enter" + i + "object weight");
            w[i] = sc.nextInt();
            System.out.println("enter" + i + "object profit");
            p[i] = sc.nextInt();
        }
        double rato[] = new double[n];
        double fw[] = new double[n];
        for (int i = 0; i < n; i++) {  
            rato[i] = (double) p[i] / w[i];
        }
        Arrays.fill(fw, 0);
        double temp;
        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rato[i] < rato[j]) {
                    temp = rato[i];
                    rato[i] = rato[j];
                    rato[j] = temp;
                    temp = p[i];
                    p[i] = p[j];
                    p[j] = (int)temp;
                    temp = w[i];
                    w[i] = w[j];
                    w[j] = (int)temp;

                }
            }
        } 
        double maxpro=0; 
        for(int i=0;i<n;i++){  
            if(m==0){ 
            break;
            }
            else if(m>w[i]){ 
                maxpro +=p[i]; 
                m -=w[i]; 
                fw[i]=1;  
                System.out.println("Item Weight "+w[i]+" with profit "+p[i]+" placed fully in the bag");
            } 
            else{  
                fw[i]=(double)m/w[i];  
                m=0;
                maxpro+=p[i]*fw[i];  
                System.out.println("weighgt of the object is"+w[i]+"profit is"+p[i]+"we placed weight of the object is"+fw[i]);  
            }
        } 
        System.out.println("maximum profit is "+maxpro);  
        for(int i=0;i<n;i++){ 
            System.out.println(fw[i]);
        }
        sc.close();
    }

}
