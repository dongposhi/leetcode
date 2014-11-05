public class Solution {
    public int lengthOfLastWord(String s) {
        byte[] buf = s.getBytes();

        int count = 0;
        for(int i = buf.length-1;i>=0;i--) {
        	if(buf[i] != ' '){
        		count++;
        	}
        	else{
        		if( count != 0){
        			break;
        		}
        	}
        }
        return count;
    }

    public static void main(String[] args){
    	Solution s = new Solution();

    	System.out.println(s.lengthOfLastWord(args[0]));
    }
}
