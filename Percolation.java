import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
   
   private final WeightedQuickUnionUF uf;
   private final WeightedQuickUnionUF ufNoTop;
   private final boolean[] openSite;
   private final int nN;
   private final int top;
   private final int bottom;
   private int openedSites=0;

   public Percolation(int n) {
          if (n < 1) throw new IllegalArgumentException("n should be greater than 0");
          this.nN = n;
          uf = new WeightedQuickUnionUF(nN*nN+2);
          ufNoTop = new WeightedQuickUnionUF(nN*nN+1);
          openSite = new boolean[nN*nN+2];
          top = 0;
          bottom = nN*nN+1;
          for (int i = 1 ; i <= nN*nN ; i++) {
          openSite[i] = false;     }       
   }

                
   public void open(int row , int col) { 
          validateRC(row , col);
          if (isOpen(row , col)) return;
          int index = xy2Dto1D(row , col);
          openSite[index] = true;
          openedSites++;
            if (row == 1) {
             uf.union(index , top);
             ufNoTop.union(index , top);
                    }
          if ( !percolates() ) {
              if (row == nN) uf.union(index , bottom);
                   
                           }
          if (row < nN && openSite[index + nN]) {
             uf.union(index , index + nN);   
             ufNoTop.union(index , index + nN);                           }
          if (row > 1 && openSite[index - nN]) {
             uf.union(index , index-nN);   
             ufNoTop.union(index , index - nN);                           }
          if (col<nN && openSite[index + 1]) {
             uf.union(index , index + 1);
             ufNoTop.union(index , index + 1);    
                                        }
          if (col > 1 && openSite[index - 1]) {
             uf.union(index , index-1);   
             ufNoTop.union(index , index-1);                           }  
   }    
   public boolean isOpen(int row , int col) {
          validateRC(row , col);
          return openSite[xy2Dto1D(row , col)];    
   }

   public boolean isFull(int row , int col) {
          validateRC(row , col);
          return ufNoTop.connected(top , xy2Dto1D(row , col));             
   }
   public boolean percolates() {
          return uf.connected(top , bottom);
   }
   private void validateRC(int row , int col) {
           if (row < 1 || row > nN || col < 1 || col > nN) throw new IllegalArgumentException("Index is not between 1 and nN.");
   }
    public int numberOfOpenSites() {
          return openedSites;   
   }
   private int xy2Dto1D(int row , int col) {
           validateRC(row , col);
           return (row - 1) * nN + col;          
   } 
   
}