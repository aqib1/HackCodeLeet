package EruptionOfLight;

public class FindDomainName {
	static String findEmailDomain(String address) {
		return address.substring(address.lastIndexOf('@')+1, address.length());
	}

	public static void main(String[] args) {
		System.out.println(findEmailDomain("John.Smith@example.com"));
	}
}
