class WeightedQULargest{
private int[] id;
private int[] sz;
private int[] lar;
private int count;

public WeightedQULargest(int n){
id=new int[n];
sz=new int[n];
count=n;
for(int i=0;i<n;i++){
id[i]=i;
sz[i]=1;
lar[i]=i;
}
}

private int root(int i){
while(id[i]!=i){
i=id[i];
}
return i;
}

public int count() {
        return count;
    }

public boolean find(int p,int q){
return root(p)==root(q);
}

public int find(int p){
  return lar[root(p)] ;   
}
public void union(int p, int q){

int i=root(p);
int j=root(q);

int lp=lar[i];
int lq=lar[j];

if(sz[i]<sz[j]){
id[i]=j;
sz[j]=sz[j]+sz[i];
if(lp>lq)
lar[j]=lp;
}
else{
id[j]=i;
sz[i]=sz[i]+sz[j];
if(lq>lp)
lar[i]=lq;

}
count--;
}
}


