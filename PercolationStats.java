import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;


public class PercolationStats {
   
   private double[] openSites;
   private int t;
   private static final double CONFIDENCE_95 = 1.96;
   
public PercolationStats(int n , int trials) {
          if (n <= 0 || trials <= 0 ) throw new IllegalArgumentException("n <= 0 or trials <=0 ");
          this.t = trials;
          openSites = new double[trials];
          
          for (int i = 0; i < trials ; i++ ) { 
                 Percolation perc = new Percolation(n); 
                 int openedSites = 0;   
                 while (!perc.percolates()) {
                       int j = StdRandom.uniform(1 , n + 1);
                       int k = StdRandom.uniform(1 , n + 1);
                       if (!perc.isOpen(j , k)){
                       perc.open(j , k);
                       openedSites++;
                         } 
                  } 
                 openSites[i]=(double) openedSites / (n * n);  
        }            
   }    
   

   public double mean() {
          return StdStats.mean(openSites);
          
   }                         
   public double stddev() {
          return StdStats.stddev(openSites);
             }                           
   public double confidenceLo() {
          return mean() - CONFIDENCE_95 * stddev() / Math.sqrt(t); 
   }                 
   public double confidenceHi() {
          return mean() + CONFIDENCE_95 * stddev() / Math.sqrt(t);
   }                 

   public static void main(String[] args) {
          int n = Integer.parseInt( args[0] );
          int t = Integer.parseInt( args[1] );
          PercolationStats ps = null;
           try {
               ps = new PercolationStats(n , t);
          } catch (IllegalArgumentException e) {
               StdOut.println( e.getMessage() );
            }
          StdOut.println( "mean		          = " + ps.mean() );
          StdOut.println( "stddev		          = " +ps.stddev() );
          StdOut.println( "95% confidence interval   = [" + ps.confidenceLo() +","+ ps.confidenceHi() + "]" );

   }        
}