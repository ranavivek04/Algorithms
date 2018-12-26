import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
   
   private  WeightedQuickUnionUF uf;
   private boolean[] openSite;
   private int N;
   private int top;
   private int bottom;

   public Percolation(int n){
          if(n<0) throw new IllegalArgumentException("n should be greater than 0");
          this.N=n;
          uf=new WeightedQuickUnionUF(N*N+2);
          openSite=new boolean[N*N+2];
          top=0;
          bottom=N*N+1;
          for(int i=1;i<=N*N;i++){
          openSite[i]=false;     }       
   }

                
   public void open(int row, int col){ 
          validateRC(row,col);
         // if(isOpen(row,col)) return;
          int index=xy2Dto1D(row,col);
          openSite[index]=true;
          if(row==1){
             uf.union(index,top);
             
                    }
          if(!percolates()){
              if(row==N) uf.union(index,bottom);
                   
                           }
          if(row<N && openSite[index+N]){
             uf.union(index,index+N);   
                                        }
          if(row>1 && openSite[index-N]){
             uf.union(index,index-N);   
                                        }
          if(col<N && openSite[index+1]){
             uf.union(index,index+1);   
                                        }
          if(col>1 && openSite[index-1]){
             uf.union(index,index-1);   
                                        }  
   }    
   public boolean isOpen(int row, int col){
          validateRC(row,col);
          return openSite[xy2Dto1D(row,col)];    
   }

   public boolean isFull(int row, int col){
          validateRC(row,col);
          return uf.connected(top,xy2Dto1D(row,col));             
   }
   public int numberOfOpenSites(){
          return N*N-uf.count();   
   }
   public boolean percolates(){
          return uf.connected(top,bottom);
   }
   private void validateRC(int row,int col){
           if(row<1 || row>N || col<1 || col>N) throw new IndexOutOfBoundsException("Index is not between 1 and N.");
   }
   private int xy2Dto1D(int row,int col){
           validateRC(row,col);
           return (row-1)*N+col;          
   } 
   public static void main(String[] args) {}  // test client (optional)
}