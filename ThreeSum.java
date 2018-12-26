import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;;

public class ThreeSum{

public static int count(int[] a){
       int n=a.length;
       int cnt=0;
       
      for(int i=0;i<n;i++){
         for(int j=1;j<n;j++){
             for(int k=2;k<n;k++){
                 if(a[i] + a[j] + a[k] == 0) cnt++;
              }
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
