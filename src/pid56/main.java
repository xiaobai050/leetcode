package pid56;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author °×
 *
 */
public class main {
	public static void main(String[] args) {
		
		List<Interval> ii1=new ArrayList<Interval>();
		
//		ii1.add(new Interval(1,3));
//		ii1.add(new Interval(2,6));
//		ii1.add(new Interval(8,10));
//		ii1.add(new Interval(15,18));

//		ii1.add(new Interval(1,4));
//		ii1.add(new Interval(0,4));
//		ii1.add(new Interval(3,5));
		

		ii1.add(new Interval(1,4));
		ii1.add(new Interval(5,6));
		ii1.add(new Interval(5,7));
		

//		ii1.add(new Interval(2,3));
//		ii1.add(new Interval(4,5));
//		ii1.add(new Interval(6,7));
//		ii1.add(new Interval(8,9));
//		ii1.add(new Interval(1,10));
		
		test(ii1);
	}

	private static void test(List<Interval> ito) {
		
		System.out.println(ito);

		Solution solution = new Solution();
		long begin = System.currentTimeMillis();
		List<Interval> rtn = solution.merge(ito);
		long end = System.currentTimeMillis();

		System.out.println();
		System.out.println(rtn);
		System.out.println("ºÄÊ±£º" + (end - begin) + "ms");
		System.out.println("--------------");
	}
}
