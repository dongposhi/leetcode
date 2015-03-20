public class Solution {
    public boolean isMatch(String s, String p) {
    	byte[] sb = s.getBytes();
    	byte[] pb = p.getBytes();

    	byte[] x = new byte[pb.length];

		{int j = 0;
	    	for(int i =0;i<pb.length;i++){
	    		if(!(pb[i] == '*' && i< pb.length -1 && pb[i+1] =='*')){
	    			x[j++] = pb[i];
	    		}
	    	}

	    	p = new String(x,0,j);
	    	pb = p.getBytes();
		}
    	if(p.equals("*")){
    		return true;
    	}

    	if(pb.length < 1){
    		if(sb.length < 1){
    			return true;
    		}
    		return false;
    	}

    	int j =0;
    	for(int i =0;i<sb.length;i++){
    		if(j == pb.length){
    			return false;
    		}
    		if(pb[j] == '?'){
    			j++;
    			continue;
    		}
    		else if(pb[j] == '*'){
    			if(j < pb.length -1 ){
    				int count = 0;
    				for(int m = j+1;m<pb.length;m++){
    					if(pb[m] !='*'){
    						if(pb[m] == '?'){
    							count++;
    						}
    						else{
    							for ( int n = i;n<sb.length - countNotWild(p.substring(m))+1;n++){
    								if(sb[n] == pb[m]){
    									if(n-i<count){
    										continue;
    									}
    									else{    										
    										boolean r = isMatch(s.substring(n),p.substring(m));
    										if(r){
    											return true;
    										}
    									}
    								}
    							}    						
    							return false;	    							
    						}
    					}
    				}
    				if(count > 0){
    					if ( i + count <= sb.length){
    						return true;
    					}
    					else{
    						return false;
    					}
    				}
    			}    			
	  			continue;
    		}
    		else if(sb[i] != pb[j]){
    			return false;
    		}
    		else{
    			j++;
    		}
    	}

    	if(j < pb.length){
	    	for(int i = j; i<pb.length;i++){
	    		if( pb[i] != '*'){
	    			return false;
	    		}
	    	}
	    	return true;
	    }
	    else if(j == pb.length){
	    	return true;
	    }

        return false;
    }

    public int countNotWild(String m){
    	byte[] buf = m.getBytes();
    	int count = 0;
    	for(byte b : buf){
    		if(b!='*'){
    			count++;
    		}
    	}
    	return count;
    }

    public static void main(String[] args){
    	Solution s = new Solution();

    	String[][] examples = new String[][]{
    		new String[]{"a","*?*?","F"},    		
    		new String[]{"aa","*a","T"},
    		new String[]{"ab","ab","T"},
    		new String[]{"aa","a","F"},
    		new String[]{"aa","aa","T"},
    		new String[]{"aaa","aa","F"},
    		new String[]{"aa","*","T"},
    		new String[]{"aa","a*","T"},
    		new String[]{"ab","?*","T"},
    		new String[]{"aab","c*a*b*","F"},
    		new String[]{"c","*?*","T"},
    		new String[]{"hi","*?","T"},
    		new String[]{"hhi","*?","T"},
    		new String[]{"ab","*ab","T"},
    		new String[]{"ab","*a*b","T"},
    		new String[]{"ab","*?*b","T"},
    		new String[]{"ab","*?*?","T"},
    		new String[]{"bacb","*?*b","T"},    		
    		new String[]{"bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaab", "b*b*ab**ba*b**b***bba","F"},
    		new String[]{"abbaabbbbababaababababbabbbaaaabbbbaaabbbabaabbbbbabbbbabbabbaaabaaaabbbbbbaaabbabbbbababbbaaabbabbabb", "***b**a*a*b***b*a*b*bbb**baa*bba**b**bb***b*a*aab*a**","T"},
    	};

    	for (String[] str : examples){
    		boolean ret = s.isMatch(str[0],str[1]);

    		System.out.println((str[2].equals((ret?"T":"F"))?"  ":"X ") + str[0] + (ret?" ":" doesn't ") + "match " + str[1]);
    	}
    }
}
