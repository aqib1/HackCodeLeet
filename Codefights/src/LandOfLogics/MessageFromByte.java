package LandOfLogics;

import java.math.BigInteger;

public class MessageFromByte {
	static String messageFromBinaryCode(String code) {
		 return new String(new BigInteger(code, 2).toByteArray());
	}

	public static void main(String[] args) {
		System.out.println(messageFromBinaryCode("010010000110010101101100011011000110111100100001"));

	}

}
