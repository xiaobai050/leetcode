package pid71;

public class main {
	public static void main(String[] args) {
		String []pathTable = {
				"",
				"////",
				"//home",
				"/home//",
				"/a/./b/../c/",
				"/a/./b/../../c/",
				"a/'..'/a",
				"a/b/. ./c",
				"$",
				" / ",
				"/a /b/",
				"/..",
				"/../a",
				"/...",
		};
		for(String ito:pathTable){
			test(ito);			
		}
	}

	private static void test(String path) {
		Solution solution = new Solution();
		String rtn = solution.simplifyPath(path);
		System.out.println(rtn);
	}
}
