import edu.princeton.cs.algs4.*;


public class Test{
public static void main(String[] args) {
        final int TESTS = 1;
        final int GRID_SIZE = 3;
         
        System.out.println("\n***Percolation: Monte Carlo Simulation ***\n");
         
        Percolation perc = new Percolation(GRID_SIZE);
        System.out.println("Successfully created Percolation object.");
       // System.out.println("N: " + perc.getN());
        System.out.println();
         
        System.out.println("Starting to open random sites...");
        int row, col, ct;
        double sum = 0.0;
        for (int i = 0; i < TESTS; i++) {
            ct = 0;
            perc = new Percolation(GRID_SIZE);
            while (!perc.percolates()) {
                row = StdRandom.uniform(GRID_SIZE)+1 ;
                col = StdRandom.uniform(GRID_SIZE)+1 ;
                if (perc.isFull(row, col)) {
                    perc.open(row, col);
                    ct++;
                }
                // System.out.println("Count: " + ct);
            }
            sum += ct;
        }
        System.out.println("After " + TESTS + " attempts, the average number of sites");
        System.out.printf("opened was %.2f", sum/TESTS);
        System.out.printf(" or %.2f", ((sum/TESTS)/(GRID_SIZE * GRID_SIZE)) * 100);
        System.out.println("%.");
        System.out.println("\nDone.\n");
    }
}