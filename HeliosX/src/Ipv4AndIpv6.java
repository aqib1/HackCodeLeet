import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

enum IP {
	IPv4, IPv6, Neither
}

public class Ipv4AndIpv6 {

	private static final String IPV6_REGEX = "^([0-9A-Fa-f]{0,4}:){2,7}([0-9A-Fa-f]{1,4}$|((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.|$)){4})$";
	private static final String IPV4_REGEX = "\\b((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.|$)){4}\\b";
	private static final String EXCEPTIONAL_INVALIDITY_IPV6 = "^([0-9A-Fa-f]{0,4}:){2,3}[0-9A-Fa-f]{0,4}::[0-9]{2}:[0-9]{4}$";

	public static boolean validateIp(String ip, String ipType) {
		return Pattern.compile(ipType, Pattern.CASE_INSENSITIVE).matcher(ip).find();
	}

	public static String checkIp(String ip) {
		if (validateIp(ip, EXCEPTIONAL_INVALIDITY_IPV6)) {
			return IP.Neither.name();
		} else if (validateIp(ip, IPV4_REGEX)) {
			return IP.IPv4.name();
		} else if (validateIp(ip, IPV6_REGEX)) {
			return IP.IPv6.name();
		} else {
			return IP.Neither.name();
		}
	}

	public static List<String> checkIps(List<String> ips) {
		System.out.println(ips);
		if (Objects.isNull(ips) || ips.isEmpty()) {
			return Arrays.asList();
		}

		List<String> result = new ArrayList<>();

		for (String ip : ips) {
			result.add(checkIp(ip));
		}
		return result;
	}

	public static void main(String[] args) {

	}
}
