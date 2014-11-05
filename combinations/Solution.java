import java.util.*;

public class Solution{
    public static void main(String[] args){
    
        int n = Integer.valueOf(args[0]);
        int k = Integer.valueOf(args[1]);

        List<List<Integer>> ret = combine(n,k);
        for (List<Integer> x : ret){
            System.out.print("[");
            for(Integer y : x){
                System.out.print(y + ",");
            }
            System.out.println("]");
        }
    }

    public static List<List<Integer>> combine(int n, int k){
        List<List<Integer>> ret = new ArrayList<List<Integer>> (0);

        if( k == 1){
           for ( int i = 1;i<=n;i++){
                List<Integer> ret1 = new ArrayList<Integer>();
                ret1.add(Integer.valueOf(i));
                ret.add(ret1);
            }
            return ret;
        }

        if( n == k){
            List<Integer> ret1 = new ArrayList<Integer>();
            for ( int i = 1;i<=k;i++){
                ret1.add(Integer.valueOf(i));
            }
            ret.add(ret1);
            return ret;
        }
    

        for ( int i = n; i>= k; i--){
            List<List<Integer>> tmp = combine (i-1,k-1);
            for (List<Integer> x : tmp){
                x.add(Integer.valueOf(i));
            }
            ret.addAll(tmp);
        }

        return ret;
    }
}

