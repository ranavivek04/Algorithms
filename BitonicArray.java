public class BitonicArray{


private static int findBitonicPoint(int a[]){
           int n = a.length;
           int lo = 0;
           int hi = n-1;
           while (lo <= hi){
                 int mid = lo + ( hi - lo ) / 2;
                 if ( a[mid] > a[mid-1] && a[mid]<a[mid+1])
                      lo=mid+1;
                 if( a[mid]<a[mid-1] && a[mid]>a[mid+1] )
                      hi=mid-1;
                 if( a[mid]> a[mid-1] && a[mid]>a[mid+1])
                      return mid;
                  }
            return -1;
         }

private static int findLeft(int a[],int n){
        int lo = 0;
        int hi = findBitonicPoint(a);
        while ( lo <= hi ) {
             int mid = lo + (hi - lo)/2;
             if (n < a[mid])
               hi = mid - 1;
             else if ( n > a[mid] )
                  lo = mid + 1;
             else return mid;
               }   
          return -1;
}

private static int findRight(int a[],int n){
        int l = a.length;
        int lo = findBitonicPoint(a)+1;
        int hi = l-1;
        while ( lo <= hi ) {
             int mid = lo + (hi - lo)/2;
             if (n < a[mid])
              lo = mid + 1;
             else if ( n > a[mid] )
                   hi = mid - 1;
             else return mid;
               }   
          return -1;
}

public static int find(int[] a,int n){
      return BitonicArray.findLeft(a,n)==-1 ? BitonicArray.findRight(a,n) :BitonicArray.findLeft(a,n); 
           
         
}
public static void main(String[] args){
int arr[]={2,3,5,7,9,11,13,4,1,0};
System.out.println(BitonicArray.findBitonicPoint(arr));
System.out.println(BitonicArray.findLeft(arr,3));
System.out.println(BitonicArray.findRight(arr,0));
System.out.println(BitonicArray.find(arr,3));
System.out.println(BitonicArray.find(arr,0));

   }
}

      