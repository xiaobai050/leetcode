package pid56;

public class Interval {
	int start;
	int end;
	Interval() {start = 0;end = 0;}
	Interval(int s, int e) {start = s;end = e;}
	
	@Override
	public String toString() {
		return "["+start+","+end+"]";
	}
}
