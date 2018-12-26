import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.Stopwatch;

public class SocialNetworkConnectivity { 
       
        public static void main(String[] args) {
        String filenames[] = {"input_1000_450000_250000.txt", 
                              "input_2000_1800000_750000.txt", 
                              "input_4000_7200000_2250000.txt"
                             };
        
        
        for (String filename: filenames) {
            Stopwatch timer = new Stopwatch();
            
            In in = new In(filename);

            int n = in.readInt();
       
            WeightedQU uf = new WeightedQU(n);
        
            int line = 0;
            while (!in.isEmpty()) {            
                int timestamp = in.readInt();
                int i = in.readInt();
                int j = in.readInt();        
                line++;
            
                uf.union(i, j);
                if (uf.count()==1) {
                    StdOut.println("file: " + filename 
                                 + "\ttimestamp: " + timestamp 
                                 + "  line: " + line 
                                 + "  (elapsed time: " + timer.elapsedTime() + ")");
                    break;
                }
            }
        
            in.close();
        }            
    }
}
