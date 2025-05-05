package global.utility;

/*
 * @author:
 */

import global.utility.FTPStaticConfigurator;


import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.FileNameMap;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletResponse;

public class FTPFileTransfer
{
	
	public static InputStream retrieveFile(String strFilePath_p, String strFileName_p) throws FileNotFoundException
	{
		InputStream inputStream = null;
		try
		{
			String ftpServerURL = FTPStaticConfigurator.HIS_FTP_SERVER_ADDRESS_COMPLETE; 
			String strFileFtpURL = "ftp://" + ftpServerURL;
			URL urlftp = new URL(strFileFtpURL  + "/" + strFileName_p);
			
			System.out.println("urlftp "+urlftp);

			URLConnection urlc = urlftp.openConnection();
			
			System.out.println("opening...");

			inputStream = urlc.getInputStream();
			
			System.out.println("got input stream...");

		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new FileNotFoundException("File Not Found");
		}
		return inputStream;
	}

	
	
}
