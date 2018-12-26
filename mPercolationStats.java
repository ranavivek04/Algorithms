import edu.princeton.cs.algs4.StdOut;    
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;    
/*
 *How do I generate a site uniformly at random among all blocked sites for use in PercolationStats? 
 * Pick a site at random (by using StdRandom to generate two integers between 1 and N) 
 * and use this site if it is blocked; if not, repeat. 
 */
public class mPercolationStats {
   private int T; //T independent experiments
   private double[] fraction;
       
   public mPercolationStats(int N, int T) {  // perform T independent experiments on an N-by-N grid
       if (N <= 0 || T <= 0) {
           throw new IllegalArgumentException("N and T must be bigger than 0");
       }
       this.T = T;
       fraction = new double[T];
      
       for (int count = 0; count < T; count++) {
           Percolation pr =  new Percolation(N);
           int openedSites = 0;
           while (!pr.percolates()) {
               int i = StdRandom.uniform(1, N+1);
               int j = StdRandom.uniform(1, N+1);
               if (!pr.isOpen(i, j)) {
                   pr.open(i, j);
                   openedSites++;
               }
           }
           fraction[count] = (double) openedSites / (N * N);
       }
   }
  
   public double mean() {                     // sample mean of percolation threshold
       return StdStats.mean(fraction);
   }
   
   public double stddev() {                 // sample standard deviation of percolation threshold
       return StdStats.stddev(fraction);
   }
   
   public double confidenceLo() {           // low  endpoint of 95% confidence interval
       return mean() - 1.96 * stddev() / Math.sqrt(T); 
   }
   
   public double confidenceHi() {      // high endpoint of 95% confidence interval
       return mean() + 1.96 * stddev() / Math.sqrt(T); 
   } 
  
   public static void main(String[] args)    // test client (described below)
   {
       int N = Integer.parseInt(args[0]);
       int T = Integer.parseInt(args[1]);
       mPercolationStats ps = new mPercolationStats(N, T);
       StdOut.println("mean                    = " + ps.mean());
       StdOut.println("stddev                  = " + ps.stddev());
       StdOut.println("95% confidence interval = "+ps.confidenceLo()+", "+ ps.confidenceHi());
   }
}