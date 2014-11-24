public class Solution{
    public int firstMissingPositive(int[] A) {

		int n = A.length;
	
		for(int i = 0;i<n;i++){
			int cur = A[i];
			while(true){
				if(cur >n){
					A[i] = 0;
					break;
				}
				else if(cur == i+1){
					break;
				}
				else if (cur < i + 1){
					if(cur > 0){
						A[cur-1] = cur;
					}
					break;
				}
				else if( cur > i+1){
					int tmp = A[cur-1];
					if(tmp == cur){
						A[i] = 0;
						break;
					}
					A[cur -1] = cur;
					A[i] = tmp;
					cur = A[i];
				}
			}
		}
		
		for(int i =0;i<n;i++){
			if(A[i] != i+1){
				return i+1;
			}
		}
		return n+1;
	}
}
