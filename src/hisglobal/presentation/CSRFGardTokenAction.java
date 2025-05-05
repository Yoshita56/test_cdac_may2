package hisglobal.presentation;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.actions.DispatchAction;

public class CSRFGardTokenAction extends DispatchAction
{
	public String generateToken(HttpServletRequest request)
	{
		freeToken(request);
		saveToken(request);
		return "1";
	}

	
	public String validateToken(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//String retVal = "0";
		String retVal = "1";
		try
		{
			//if (isTokenValid(request)) retVal = "1";
			//else retVal = "0";
			retVal = "1";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			retVal = "0";
		}

		freeToken(request);

		if (retVal.equals("0"))
		{
			response.sendRedirect("/INVMGM/hisglobal/errorPage/token_error_page.jsp");
			//response.flushBuffer();
			//request.getRequestDispatcher("/AHIMS/hisglobal/errorPage/token_error_page.jsp").forward(request, response);
			//throw new Exception("Token not validated !!");
		}
		return retVal;
	}

	public String freeToken(HttpServletRequest request)
	{
		resetToken(request);
		return "1";
	}

	public static String GenerateSecureRandomNumber(HttpServletRequest request)
	{
		String tokenNo = "";
		try
		{
			// Initialize SecureRandom
			// This is a lengthy operation, to be done only upon
			// initialization of the application
			SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
			// generate a random number
			String randomNum = new Integer(prng.nextInt()).toString();
			// get its digest
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] result = sha.digest(randomNum.getBytes());

			tokenNo = hexEncode(result);
			request.getSession().setAttribute("UNIQUE_ID", tokenNo);
		}
		catch (NoSuchAlgorithmException ex)
		{
			System.err.println(ex);
		}
		return tokenNo;
	}

	private static String hexEncode(byte[] aInput)
	{
		StringBuilder result = new StringBuilder();
		char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		for (int idx = 0; idx < aInput.length; ++idx)
		{
			byte b = aInput[idx];
			result.append(digits[(b & 0xf0) >> 4]);
			result.append(digits[b & 0x0f]);
		}
		return result.toString();
	}

}
