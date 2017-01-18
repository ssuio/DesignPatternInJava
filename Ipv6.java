
public class Ipv6 {
	public static void main(String[] args) {
		String ipv6 = "2001:0:0:25de:0:0:0:cade";
		ipv6 = ipv6.replaceAll("((?::0\\b){2,}):?(?!\\S*\\b\\1:0\\b)(\\S*)", "::$2");
		System.out.println(ipv6);
		System.out.println(ipv6);
		System.out.println(ipv6);
		System.out.println(ipv6);
		System.out.println(ipv6);
		System.out.println(ipv6);
		System.out.println(ipv6);
		System.out.println(ipv6);
	}
}
