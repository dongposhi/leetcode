public class Solution{
	public List<List<Integer>> combinationSum2(int[] num,
			int target) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		for (int i = num.length - 1; i >= 0; i--) {
			int cur = num[i];
			if (cur > target) {
				continue;
			} else if (cur == target) {
				List<Integer> tmp = new ArrayList<Integer>();
				tmp.add(Integer.valueOf(cur));
				ret.add(tmp);
			} else {
				int tmpT = target;
				int[] x = Arrays.copyOf(num, i );
				List<List<Integer>> y = combinationSum2(x, tmpT - cur);
				if (!y.isEmpty()) {
					for (List<Integer> z : y) {
						z.add(cur);
						Collections.sort(z);
					}
					ret.addAll(y);
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
