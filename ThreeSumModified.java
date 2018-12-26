import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import java.util.*;

public class ThreeSumModified{

public static int count(int[] a){
       int n=a.length;
       int cnt=0;
       Arrays.sort(a);
       
       for (int i=0;i<n-2;i++){
           int j=i+1;
           int k=n-1;

            while(j<k){
                  int sum = a[i] + a[j] + a[k];
                   if ( sum < 0)
                       j++;
                   if ( sum >= 0)
                       k--;
                   if (sum==0) cnt++; 
               }
                    
       }  
      
      return cnt;
}

public static void main(String[] args){
int a[] = In.readInts(args[0]);
Stopwatch stopwatch = new Stopwatch();
StdOut.println(ThreeSum.count(a));
double time = stopwatch.elapsedTime();
StdOut.println("elapsed time is: "+time);
}


}
