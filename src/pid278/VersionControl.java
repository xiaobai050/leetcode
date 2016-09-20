package pid278;

public class VersionControl {
	static int bad;
	public boolean isBadVersion(int middle) {
		return middle>=this.bad;
	}
}
