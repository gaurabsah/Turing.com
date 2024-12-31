package javaCoding;

public class ValidateIPAddress {
	public String validIPAddress(String queryIP) {
		if (queryIP == null || queryIP.isEmpty()) {
			return "Neither";
		}

		if (queryIP.contains(".")) {
			return isValidIPv4(queryIP) ? "IPv4" : "Neither";
		} else if (queryIP.contains(":")) {
			return isValidIPv6(queryIP) ? "IPv6" : "Neither";
		} else {
			return "Neither";
		}
	}

	private boolean isValidIPv4(String ip) {
		String[] parts = ip.split("\\.", -1); // Split and keep all parts
		if (parts.length != 4) {
			return false;
		}

		for (String part : parts) {
			if (part.isEmpty() || part.length() > 3) {
				return false;
			}

			// Check if part is numeric
			for (char c : part.toCharArray()) {
				if (!Character.isDigit(c)) {
					return false;
				}
			}

			int num = Integer.parseInt(part);

			// Check range and no leading zeros
			if (num < 0 || num > 255 || (part.charAt(0) == '0' && part.length() > 1)) {
				return false;
			}
		}
		return true;
	}

	private boolean isValidIPv6(String ip) {
		String[] parts = ip.split(":", -1); // Split and keep all parts
		if (parts.length != 8) {
			return false;
		}

		for (String part : parts) {
			if (part.isEmpty() || part.length() > 4) {
				return false;
			}

			// Check if part is hexadecimal
			for (char c : part.toCharArray()) {
				if (!Character.isDigit(c) && !(c >= 'a' && c <= 'f') && !(c >= 'A' && c <= 'F')) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ValidateIPAddress solution = new ValidateIPAddress();

		// Test cases
		System.out.println(solution.validIPAddress("172.16.254.1")); // Output: "IPv4"
		System.out.println(solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334")); // Output: "IPv6"
		System.out.println(solution.validIPAddress("256.256.256.256")); // Output: "Neither"
		System.out.println(solution.validIPAddress("2001:db8:85a3::8A2E:037j:7334")); // Output: "Neither"
	}
}
