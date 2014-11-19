public class Solution{
	public boolean isPalindrome(String s){
		if(s == null){
			return false;
		}
		
		byte[] buf = s.getBytes();
		byte[] buf2 = new byte[buf.length];
		
		int j = 0;
		for (int i = 0;i<buf.length;i++){
			if((buf[i]>='a' && buf[i] <='z') || (buf[i]>='A' && buf[i] <='Z') || (buf[i] >='0' && buf[i] <='9')){
				buf2[j++] = (byte) ((buf[i] >= 'a')? (buf[i] - 32) : buf[i]);
			}
		}
		for(int m = 0;m<(j+1)/2;m++){
			if(buf2[m] != buf2[j-m-1]){
				return false;
			}
		}
		
		return true;
	}
}
