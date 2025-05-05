package hissso.security;

import java.security.*;

import javax.crypto.*;
import javax.crypto.spec.*;

import java.util.*;
import java.io.*;

public abstract class SecureCryptAlgorithm
{
	private static String KEY_GENERATION_ALGORITHM = "DES";
	private static String CRYPT_ALGORITHM = "DES/ECB/PKCS5Padding";
	
	// Generates a DES Secret Key
	public static String generateKey()
	{
		try
		{
			KeyGenerator keygen = KeyGenerator.getInstance(KEY_GENERATION_ALGORITHM);
			SecretKey desKey = keygen.generateKey();
			byte[] bytes = desKey.getEncoded();
			return getString(bytes);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	// Getting Key Object for Encryption from the passed Secret Key String
	private static Key getKey(String secretKey)
	{
		try
		{
			byte[] bytes = getBytes(secretKey);
			DESKeySpec pass = new DESKeySpec(bytes);
			SecretKeyFactory skf = SecretKeyFactory.getInstance(KEY_GENERATION_ALGORITHM);
			SecretKey s = skf.generateSecret(pass);
			return s;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	// Encrypting Source with the help of Passed secretKey
	public static String encrypt(String source, String secretKey)
	{
		try
		{
			Key key = getKey(secretKey);
			Cipher desCipher = Cipher.getInstance(CRYPT_ALGORITHM);
			desCipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] cleartext = source.getBytes();
			byte[] ciphertext = desCipher.doFinal(cleartext);
			return getString(ciphertext);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	// Decrypting Source with the help of Passed secretKey
	public static String decrypt(String source, String secretKey)
	{
		try
		{
			Key key = getKey(secretKey);
			Cipher desCipher = Cipher.getInstance(CRYPT_ALGORITHM);
			byte[] ciphertext = getBytes(source);
			desCipher.init(Cipher.DECRYPT_MODE, key);
			byte[] cleartext = desCipher.doFinal(ciphertext);
			return new String(cleartext);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	private static String getString(byte[] bytes)
	{
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bytes.length; i++)
		{
			byte b = bytes[i];
			sb.append((int) (0x00FF & b));
			if (i + 1 < bytes.length)
			{
				sb.append(".");
			}
		}
		return sb.toString();
	}

	private static byte[] getBytes(String str)
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		StringTokenizer st = new StringTokenizer(str, ".", false);
		while (st.hasMoreTokens())
		{
			int i = Integer.parseInt(st.nextToken());
			bos.write((byte) i);
		}
		return bos.toByteArray();
	}
	
	/* New Methods and variables added by Garima on 1st July 2016 for User Agent Additional INformation in Cache*/
	/*Start*/
	
	/**
	 * Encrypt.
	 * 
	 * @param source
	 *            the source
	 * @return the string
	 */
	public static synchronized String encrypt(String source) {
		
		if(source == null || source.trim().length() == 0)
			return "";
		
		try {
			Key key = getKey();
			Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			desCipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] cleartext = source.getBytes();
			byte[] ciphertext = desCipher.doFinal(cleartext);
			return getString(ciphertext);
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return null;
	}
	
	/** The Constant KEY_STRING. */
	private static final String KEY_STRING = "197.255.248.97.234.56.100.241";
	/**
	 * Decrypt.
	 * 
	 * @param source
	 *            the source
	 * @return the string
	 */
	public static synchronized String decrypt(String source) {
		
		if(source == null || source.trim().length() == 0)
			return "";
		
		try {
			Key key = getKey();
			Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			byte[] ciphertext = getBytes(source);
			desCipher.init(Cipher.DECRYPT_MODE, key);
			byte[] cleartext = desCipher.doFinal(ciphertext);
			return new String(cleartext);
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Gets the key.
	 * 
	 * @return the key
	 */
	private static synchronized Key getKey() {
		try {
			byte[] bytes = getBytes(KEY_STRING);
			DESKeySpec pass = new DESKeySpec(bytes);
			SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
			SecretKey s = skf.generateSecret(pass);
			return s;
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return null;
	}
	
	/*End*/

	/*
	 * public static void main( String[] args ) {
	 * 
	 * String str= SecurityUtil.encrypt( "U.S." ); String str2= SecurityUtil.decrypt( str); System.out.println("enc  "+str
	 * +"   length "+str.length()); System.out.println("desc  "+str2); }
	 */
}
