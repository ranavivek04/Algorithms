public class SuccessorWithDelete{

private WeightedQULargest uf;

public SuccessorWithDelete(int n){
uf=new WeightedQULargest(n);
}

public void remove(int x){
uf.union(x,x+1);
}

public int successor(int x){
  return uf.find(x);
}

}

  