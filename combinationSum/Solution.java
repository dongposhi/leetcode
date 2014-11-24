public class Solution{
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		for(int i = candidates.length - 1;i>=0;i--){
			int cur = candidates[i];
			if(cur > target){
				continue;
			}
			else if(cur == target){
				List<Integer> tmp = new ArrayList<Integer>();
				tmp.add(Integer.valueOf(cur));
				ret.add(tmp);
			}
			else{
				List<Integer> tmp = new ArrayList<Integer>();
				int tmpT = target;
				int[] x = Arrays.copyOf(candidates, i+1);
				while(tmpT - cur > 0){
					tmp.add(cur);
					 
					List<List<Integer>> y = combinationSum(x,tmpT - cur);
					if(!y.isEmpty()){
						for(List<Integer> z: y){
							z.addAll(tmp);
							Collections.sort(z);
						}
						ret.addAll(y);
					}
					 
					tmpT = tmpT - cur;
				}
			}
		}
		Set<List<Integer>> s = new HashSet<List<Integer>>();
		s.addAll(ret);
		ret.clear();
		ret.addAll(s);
		return ret;
    }    
}
