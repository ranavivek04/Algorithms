public class BinarySearch {
       
        public int biSearch(int[] a, int k) {
              int lo = 0;
              int hi = a.length-1;
              while( lo <= hi ) {
                    int mid = lo + (hi -lo)/2;
                    if ( k < a[mid] )  hi = mid -1;
                    else if ( k> a[mid] ) low = mid + 1;
                    else return mid; 
         }
         return -1;
      
}
