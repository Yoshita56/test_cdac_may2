package hissso.controller.hlp;

import java.security.SecureRandom;

public class LoginHLP
{
	// Status Flags
	public static String LOGIN_STATUS_FAILED = "failed";
	public static String LOGIN_STATUS_SUCCESS = "success";
	
	public static String getRandomSalt(int nSaltSize)
	{
		SecureRandom objRandom = new SecureRandom();
		byte[] randomSalt = new byte[nSaltSize];
		objRandom.nextBytes(randomSalt);

		return randomSalt.toString();
	}
	
}
