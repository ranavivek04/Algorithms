class WeightedQU{
private int[] id;
private int[] sz;
private int count;

public WeightedQU(int n){
id=new int[n];
sz=new int[n];
count=n;
for(int i=0;i<n;i++){
id[i]=i;
sz[i]=1;
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

public void union(int p, int q){

int i=root(p);
int j=root(q);

if(sz[i]<sz[j]){
id[i]=j;
sz[j]=sz[j]+sz[i];
}
else{
id[j]=i;
sz[i]=sz[i]+sz[j];
}
count--;
}
}


