public class Test{
    public static void main(String[] args){
    
        int n = 1;
        System.out.println(n + " is read as " + countAndSay(n));
    }

    public static String countAndSay(int n){
        String ret = "";

        byte[] btmp = Integer.valueOf(n).toString().getBytes();

        int count = 1;
        for (int i = 1;i<btmp.length;i++){
        	if(btmp[i] != btmp[i-1]){
        		ret = ret  + count + (btmp[i-1] - '0');
        		count = 0;
         	}
        	count++;
        }
        ret = ret  + count + (btmp[btmp.length - 1] - '0');

        return ret;
    }
}
