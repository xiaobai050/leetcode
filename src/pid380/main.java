package pid380;

import java.util.Arrays;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method; 
/**
 * 
 * @author °×
 *
 */
public class main {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		String[] testTableMethod = { 
				"RandomizedSet","insert","insert","remove","insert","insert","insert","remove","remove","insert","remove","insert","insert","insert","insert","insert","getRandom","insert","remove","insert","insert"
						
		};
		int[][] testTableNum = { 
				{},{3},{-2},{2},{1},{-3},{-2},{-2},{3},{-1},{-3},{1},{-2},{-2},{-2},{1},{},{-2},{0},{-3},{1}
			};

		RandomizedSet randomizedSet = new RandomizedSet();
		for(int i=1;i<testTableMethod.length;i++) {
			randomizedSet=test(randomizedSet,testTableMethod[i],testTableNum[i]);
		}
	}

	private static RandomizedSet test( RandomizedSet randomizedSet,String string,int[] num) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.print(">> ");
		System.out.print(string);
		System.out.println(Arrays.toString(num));
		System.out.println();
		
		Method m1 = num.length == 0 ? RandomizedSet.class.getMethod(string)
				: RandomizedSet.class.getMethod(string, int.class);
		Object rtn;
		long begin = System.currentTimeMillis();

		if (num.length == 0)
			rtn = m1.invoke(randomizedSet);
		else
			rtn = m1.invoke(randomizedSet, num[0]);

		long end = System.currentTimeMillis();

		System.out.println();
		System.out.println("                               << "+rtn);
		System.out.println("--------------------------------------ºÄÊ±£º" + (end - begin) + "ms");
		return randomizedSet;
	}
	
	
}
