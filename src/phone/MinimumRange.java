package phone;

import java.util.*;

/*
You have k lists ofsorted integers.
Find the smallest rangethat includes at least one number from each of the k lists.
For example,
List 1: [4, 10, 15, 24,26]
List 2: [0, 9, 12, 20] num = 9 index[1] = 1
List 3: [5, 18, 22, 30]index[2] = 0 num = 5
output = [20,24]
 */
public class MinimumRange {
	public int[] calRange(List<int[]> lists) {
		Comparator<int[]> com=new Comparator<int[]>() {
			public int compare(int[] i1, int[] i2) {
				if(i1[2]>i2[2]){
					return 1;
				}
				else if(i1[2]<i2[2]){
					return -1;
				}
				return 0;
			}
		};
		// int[3]- index0= list #, index1= element position, index2 element value
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(com);
		for (int i = 0; i < lists.size(); i++) {
			int[] curr = lists.get(i);
			if (curr.length == 0) {
				return new int[0];
			}
			int[] toadd = { i, 0, curr[0] };
			pq.offer(toadd);
			min=Math.min(min, curr[0]);
			max=Math.max(max, curr[0]);
		}
		int[] result = { min, max };
		while(!pq.isEmpty()){
			int[] top=pq.poll();
			if(top[1]==lists.get(top[0]).length-1){
				break;
			}
			top[1]++;
			top[2]=lists.get(top[0])[top[1]];
			pq.offer(top);
			max=Math.max(max, top[2]);
			min=pq.peek()[2];
			if((long)max-(long)min<(long)result[1]-(long)result[0]){
				result[0]=min;
				result[1]=max;
			}
		}
		return result;
	}
}
