public class Solution {
    public int searchInsert(int[] A, int target) {
        if(A == null || A.length ==0){
			 return 0;
		 }

		 int len = A.length;
		 int start = 0;
		 int end = len -1;
		 
		 if (len == 1){
			 return ( target <= A[0])?0:1;
		 }
		 
		 boolean desc = A[start] < A[end];
		 
		 if (desc){
			 if(target <= A[start])
				 return 0;
			 if(target > A[end])
				 return end + 1;
			 if(target == A[end]){
				 return end;
			 }
		 }
		 else{
			 if(target >= A[start])
				 return 0;
			 if(target < A[end])
				 return end + 1;
			 if(target == A[end]){
				 return end;
			 }
		 }
		 while(end - start > 1){
			 int index = start + (end - start + 1 )/2;
			 if(A[index] == target){
				 return index;
			 }
			 else if(A[index] > target){
				 if(desc){
					 end = index;
				 }
				 else{
					 start = index;
				 }
			 }
			 else{
				 if(desc){
					 start = index;
				 }
				 else{
					 end = index;
				 }
			 }
		 }
		 
		 if(A[start] == target){
			 return start;
		 }
		 
		 if(A[end] == target){
			 return end;
		 }
		 
		 if(desc){
			 if(target < A[start]){
				 return start;
			 }
			 else if (target > A[end]){
				 return end + 1;
			 }
			 else{
				 return end;
			 }
		 }
		 else{
			 if(target > A[start]){
				 return start;
			 }
			 else if (target < A[end]){
				 return end + 1;
			 }
			 else{
				 return end;
			 }
		 }	        	
    }
}
