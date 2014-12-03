public class Solution {
    public String reverseWords(String s) {
         
         s = s.trim();
		 byte[] buf = s.getBytes();
		 
		StringBuilder sb = new StringBuilder();
		 
		 int pos = buf.length -1;
		 for(int i = buf.length -1 ;i >= 0;i--){
			 if(buf[i] == ' '){
			     if(buf[i+1] == ' '){
			         pos = i -1;
					continue;
				}
				 sb.append(s.substring(i+1, pos+1)).append(' ');
				 pos = i -1;
			 }
		 }
		 sb.append(s.substring(0, pos+1));
		 return sb.toString();
    }
}
