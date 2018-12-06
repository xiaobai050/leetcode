package me.bai.study.leetcode;

class ValidIPAddress {
	public static void main(String[] args) {
		String ok = new ValidIPAddress().validIPAddress("192.0.0.1");
		System.out.println(ok);
	}

	public String validIPAddress(String IP) {
		if (IP.startsWith(".") || IP.endsWith(".") || IP.startsWith(":") || IP.endsWith(":")) return "Neither";
		String[] strs = IP.split("\\.");
		if (strs.length == 4 && isIPv4(strs)) return "IPv4";

		strs = IP.split(":");
		if (strs.length == 8 && isIPv6(strs)) return "IPv6";

		return "Neither";
	}

	private boolean isIPv4(String[] strs) {
		for (String s : strs) {
			if (s.length() < 1 || s.length() > 3) {
				return false;
			}
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c > '9' || c < '0') {
					return false;
				}
			}
			int v = Integer.valueOf(s);
			if (v == 0 && s.length() > 1) {
				return false;
			}
			if (v > 0 && s.charAt(0) == '0') {
				return false;
			}

			if (v < 0 || v > 255) {
				return false;
			}
		}
		return true;
	}

	private boolean isIPv6(String[] strs) {
		for (String s : strs) {
			if (s.length() < 1 || s.length() > 4) {
				return false;
			}
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')) {
					continue;
				} else {
					return false;
				}
			}
		}
		return true;
	}

}