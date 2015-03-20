import java.util.*;

public class Solution {
     public static List<List<Integer>> combine(int[] num, int k, int sum){
        /*
        System.out.print("num = [");
        for(int  i: num){
            System.out.print(i + ",");
        }
      	System.out.println("] k= " + k + "  sum = " + sum );
        */
        List<List<Integer>> ret = new ArrayList<List<Integer>> (0);

        int n = num.length;
        if( k == 1){
           for ( int i = 0;i<n;i++){
                List<Integer> ret1 = new ArrayList<Integer>();
                if(num[i] == sum){
                	ret1.add(Integer.valueOf(num[i]));
                	ret.add(ret1);
                }
            }
            return ret;
        }

        if( n == k){
            List<Integer> ret1 = new ArrayList<Integer>();
            int total = 0;
            for ( int i = 0;i<k;i++){
            	total += num[i];
            }
            if(total == sum){
                for(int i =0;i<k;i++){
                	ret1.add(Integer.valueOf(num[i]));                   
                }
            	ret.add(ret1);
            }
            return ret;
        }
    

        for ( int i = n - 1 ; i>= k-1; i--){
            List<List<Integer>> tmp = combine (Arrays.copyOf(num, i),k-1, sum - num[i]);
            for (List<Integer> x : tmp){
                x.add(Integer.valueOf(num[i]));
            }
            ret.addAll(tmp);
        }

        return ret;
    }


    public static List<List<Integer>> threeSum(int[] num){
        Arrays.sort(num);
    	List<List<Integer>> ret = combine(num,3,0);
/*
        for (List<Integer> x : ret){
            Collections.sort(x);
        }
        */
        return ret;

    }


    public static void main(String[] args){
    
    //	int[] num = new int[]{8,5,3,9,12,-9,8,-9,13,-10,-14,-13,5,-15,-4,2,8,-11,-6,12,9,-15,13,11,13,13,6,-12,-15,-4,-6,0,-14,5,-14,5,3,2,4,2,7,5,4,-10,-3,7,7,-9,4,-14,10,-2,-13,8,-6,7,-1,7,11,-9,-12,-10,6,12,10,7,2,-9,-6,13,8,9,3,-11,14,-14,11,-2,14,0,-1,1,6,-7,-5,7,-14,9,0,4,7,-5,1,-2,14,-3,12,-6,-5,14,-8,-12,0,3,-8,-1};
        int[] num = new int[]{-1 ,0 ,1,2,-1,-4 };

        List<List<Integer>> ret = threeSum2(num);
        for (List<Integer> x : ret){
            System.out.print("[");
            for(Integer y : x){
                System.out.print(y + ",");
            }
            System.out.println("]");
        }
    }




    /**
       todo: still has duplicated result and time limit exceed.
    */
    public static List<List<Integer>> threeSum2(int[] num){
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int n = num.length;
        for (int i = 0;i<n - 2;i++){
            for (int j = i+1;j<n-1;j++){
                for(int k = j+1;k<n-1;k++){
                    if(num[i] + num[j] + num[k] == 0){
                        List<Integer> a = new ArrayList<Integer>();
                        int min = num[i];
                        if(min >= num[j] && min >= num[k]){
                            a.add(Math.min(num[j],num[k]));
                            a.add(Math.max(num[j],num[k]));
                            a.add(min);
                        }
                        else if (min >= num[j] && min <= num[k]){
                            a.add(num[j]);
                            a.add(min);
                            a.add(num[k]);
                        }
                        else if (min >= num[k] && min <= num[j]){
                            a.add(num[k]);
                            a.add(min);
                            a.add(num[j]);
                        }
                        else{
                            a.add(min);
                            a.add(Math.min(num[j],num[k]));
                            a.add(Math.max(num[j],num[k]));
                        }
                        ret.add(a);
                    }
                }
            }
        }
        return ret;
    }
}
