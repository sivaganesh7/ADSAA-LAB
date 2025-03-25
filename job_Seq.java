import java.util.*;
public class job_scheduling{  
   public static void main(String[] args) { 
       Scanner sc = new Scanner(System.in); 
       System.out.println("enter the number of jobs"); 
       int n = sc.nextInt(); 
       int profits[] = new int[n]; 
       int id[] = new int[n]; 
       int temp,deadlines[] = new int[n]; 
       for (int i=0;i<n;i++){ 
          System.out.println("enter job "+i+"id"); 
          id[i] = sc.nextInt();  
           System.out.println("enter job "+i+"profit"); 
          profits[i] = sc.nextInt();  
           System.out.println("enter job "+i+"deadline"); 
          deadlines[i] = sc.nextInt(); 
       } 
       // arrage profits with the descending order  
       for(int i=0;i<n;i++){ 
           for(int j=i+1;j<n;j++){ 
               if(profits[i]<profits[j]){ 
                  temp = profits[j]; 
                  profits[j] = profits[i];  
                  profits[i] = temp; 
                  temp = id[j]; 
                  id[j] = id[i];  
                  id[i] = temp; 
                  temp = deadlines[j]; 
                  deadlines[j] = deadlines[i];  
                  deadlines[i] = temp;  
               }
           }
       }    
       int maxdeadline=deadlines[0];
       for (int i = 1; i < n; i++) {
        if (deadlines[i] > maxdeadline) {
            maxdeadline = deadlines[i];
        }  
    } 
      int fp =0;
      int [] max =new int[maxdeadline+1]; 
      Arrays.fill(max,0); 
      for(int i=0;i<n;i++){ 
       for(int j=deadlines[i];j>0;j--){ 
        if(max[j]==0){ 
            max[j]=1; 
            fp=fp+profits[i]; 
            break;
        }
       }
      } 
System.out.println(fp);
       sc.close();   
   } 
}
