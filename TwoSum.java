public class TwoSum{
       public static boolean count(int[] a , int s){
              
              int i=0;
              int j=a.length-1;
           
              while(i<j){
                   if (a[i] + a[j] < s)
                       i++;
                   else if (a[i] + a[j] > s)
                       j--;
                   else return true;
               }
           return false;
}

public static void main(String[] args){
       int[] arr={1,2,3,4,5};
       System.out.println(TwoSum.count(arr,20));
} 
}