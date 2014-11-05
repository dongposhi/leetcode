import java.util.*;

public class Solution{
    public static void main(String[] args){
    
        int n = 4;
        int k = 2;

        List<List<Integer>> ret = comine(n,k);
        for (List<Integer> x : ret){
            System.out.print("[");
            for(Integer y : x){
                System.out.print(y + ",");
            }
            System.out.println("]");
        }
    }

    public static List<List<Integer>> combine(int n, int k){
        List<List<Integer>> ret = new List<List<Integer>> (0);
        if( n == k){
            List<Integer> ret1 = new List<Integer>();
            for ( int i = 1;i<=k;i++){
                ret1.add(Integer.valueOf(i));
            }
            ret.add(ret1);
            return ret;
        }
    

        for ( int i = n; i>= k-1; i--){
            List<List<Integer>> tmp = combine (n-1,k-1);
            for (List<Integer> x : tmp){
                x.add(Integer.value(n));
            }
        }

        return ret;
    }
}

