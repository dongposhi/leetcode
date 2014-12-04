public class Solution {
    public int evalRPN(String[] tokens) {
       	     int n = tokens.length;
	     
	     ArrayList<Integer> stack = new ArrayList<Integer>();
	     
	     String s = null;
	     int depth = 0;
	     for(int i = 0;i<n;i++){
	    	 s = tokens[i];
	    	 if(!(s.equals("+") ||s.equals("-") ||s.equals("*") ||s.equals("/") )){	    		 
				stack.add(Integer.parseInt(s));
				depth++;
	    	 }
	    	 else{
	    		 int a = stack.remove(--depth);
	    		 int b = stack.remove(--depth);
	    		 if(s.equals("+")){
	    			 stack.add(a+b);
	    		 }
	    		 else if(s.equals("-")){
	    			 stack.add(b-a);
	    		 }
	    		 else if(s.equals("*")){
	    			 stack.add(b*a);
	    		 }
	    		 else if(s.equals("/")){
	    			 stack.add(b/a);
	    		 }
    			 depth++;	    				 
	    	 }
	     }
	     
	     return stack.get(0);
        
        
    }
}
