import java.util.*;
/**
 * Definition for an interval.
 */
class Interval {
    int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new ArrayList<Interval>();
        
        for(Interval tmp : intervals){
            ret = insert(ret,tmp);
        }
        
        return ret;
    }
            public  List<Interval> insert(List<Interval> intervals,
                        Interval newInterval) {
                List<Interval> ret = new ArrayList<Interval>();

                int m = -1;
                int n = -1;

                boolean sdone = false;
                boolean edone = false;

                for (int i = 0; i < intervals.size(); i++) {
                        Interval cur = intervals.get(i);
                        if (newInterval.start > cur.end) {
                                continue;
                        } else {
                                m = (m == -1) ? i : m;
                                sdone = true;
                                // start care about end
                                if (newInterval.end <= cur.end) {
                                        edone = true;
                                        n = i;
                                }
                        }
                        if (sdone && edone) {
                                break;
                        }
                }

                if (!sdone) {
                        Iterator<Interval> it = intervals.iterator();

                        while (it.hasNext()) {
                                ret.add(it.next());
                        }
                        ret.add(newInterval);
                        return ret;
                } else if (!edone) {
                        Iterator<Interval> it = intervals.iterator();
                        int i = 0;
                        while (it.hasNext()) {
                                if (i == m) {
                                        break;
                                }
                                ret.add(it.next());
                                i++;
                        }

                        Interval x = intervals.get(m);
                        x.end = newInterval.end;

                        newInterval.start = Math.min(newInterval.start, x.start);
                        ret.add(newInterval);

                        return ret;
                } else {
                        if (m == n) {
                                Interval x = intervals.get(m);
                                if (x.start <= newInterval.start && x.end >= newInterval.end) {
                                        return intervals;
                                } else if (x.start > newInterval.end) {
                                        Iterator<Interval> it = intervals.iterator();
                                        int i = 0;
                                        while (it.hasNext()) {
                                                if (i == m) {
                                                        ret.add(newInterval);
                                                }
                                                ret.add(it.next());
                                                i++;
                                        }
                                }
                                else{
                                        Iterator<Interval> it = intervals.iterator();
                                        int i = 0;
                                        while (it.hasNext()) {
                                                Interval cur =it.next();
                                                if (i != m) {
                                                        ret.add(cur);
                                                }
                                                else{
                                                        newInterval.start = Math.min(newInterval.start, cur.start);
                                                        newInterval.end = Math.max(newInterval.end,cur.end);
                                                        ret.add(newInterval);
                                                }

                                                i++;
                                        }
                                }
                        } else {
                                Iterator<Interval> it = intervals.iterator();
                                int i = 0;
                                while (it.hasNext()) {
                                        Interval cur = it.next();
                                        if (i < m || i > n) {
                                                ret.add(cur);
                                        } else if (i == m) {
                                                newInterval.start = Math.min(newInterval.start,
                                                                cur.start);
                                        } else if (i == n) {
                                                if (newInterval.end < cur.start) {
                                                        ret.add(newInterval);
                                                        ret.add(cur);
                                                } else {
                                                        newInterval.end = Math
                                                                        .max(newInterval.end, cur.end);
                                                        ret.add(newInterval);
                                                }
                                        }
                                        i++;
                                }
                        }
                }
                return ret;
        }

}
