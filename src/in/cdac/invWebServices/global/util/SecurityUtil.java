package in.cdac.invWebServices.global.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SecurityUtil {

	public static final int SALT_SIZE = 24;
	
	public static String getRandomSalt (int saltSize) {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[saltSize];
		random.nextBytes(salt);
		return salt.toString();
	}
	
	private static String convertToHex (byte[] data) {
		StringBuffer buf = new StringBuffer();
		for (int i=0;i<data.length;++i) {
			int halfByte = (data[i] >>> 4) & 0x0F;
			int twoHalves = 0;
			do {
				if ((0 <= halfByte) && (halfByte <= 9))
					buf.append((char) ('0' + halfByte));
				else
					buf.append((char) ('a' + (halfByte - 10)));
				halfByte = data[i] & 0x0F;
			} while (twoHalves++ < 1);
		}
		return buf.toString();
	}
	
	public static String SHA1 (String text) 
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		byte[] sha1Hash = new byte[40];
		md.update(text.getBytes("iso-8859-1"), 0, text.length());
		sha1Hash = md.digest();
		return convertToHex(sha1Hash);
	}
}
