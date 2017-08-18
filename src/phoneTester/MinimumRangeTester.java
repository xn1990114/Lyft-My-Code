package phoneTester;

import static org.junit.Assert.*;
import phone.MinimumRange;
import java.util.*;

import org.junit.Test;

public class MinimumRangeTester {

	@Test
	public void test() {
		MinimumRange mr=new MinimumRange();
		List<int[]> lists=new ArrayList<int[]>();
		int[] a1={};
		int[] a2={Integer.MIN_VALUE,Integer.MAX_VALUE};
		int[] a3={-10224,-344,-32,-31,-30-100,124,1232};
		int[] a4={-50,-30,30};
		int[] a5={912,1232,2343,12321};
		lists.add(a1);
		lists.add(a3);
		int[] r1=mr.calRange(lists);
		assertTrue(r1.length==0);
		lists.clear();
		lists.add(a2);
		int[] r2=mr.calRange(lists);
		assertTrue(r2[0]==Integer.MIN_VALUE&&r2[1]==Integer.MIN_VALUE);
		lists.add(a3);
		lists.add(a4);
		int[] r3=mr.calRange(lists);
		assertTrue(r3[0]==Integer.MIN_VALUE&&r3[1]==-50);
		lists.clear();
		lists.add(a5);
		lists.add(a4);
		int[] r4=mr.calRange(lists);
		assertTrue(r4[0]==30&&r4[1]==912);
		lists.clear();
		lists.add(a3);
		lists.add(a4);
		lists.add(a5);
		int[] r5=mr.calRange(lists);
		assertTrue(r5[0]==30&&r5[1]==912);
	}

}
