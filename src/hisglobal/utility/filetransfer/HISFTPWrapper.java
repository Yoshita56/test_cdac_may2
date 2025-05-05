package hisglobal.utility.filetransfer;

import java.util.Vector;
import java.io.*;
import java.net.UnknownHostException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

/**
 * A Simple Wrapper around the Apache Commons Net FTP library
 * 
 * @author C-DAC, Noida
 * @version 1.0
 */

public class HISFTPWrapper extends FTPClient
{

	// Connecting and Logging into FTP Server
	public boolean connectAndLogin(String strHost_p, String strUserName_p, String strPassword_p) throws IOException, UnknownHostException,
			FTPConnectionClosedException
	{
		boolean success = false;
		try
		{
			connect(strHost_p);

			int reply = getReplyCode();
			if (FTPReply.isPositiveCompletion(reply))
			{
				success = login(strUserName_p, strPassword_p);
			}

			if (!success) disconnect();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return success;
	}

	/**
	 * Turn passive transfer mode on or off. If Passive mode is active, a PASV command to be issued and interpreted before
	 * data transfers; otherwise, a PORT command will be used for data transfers. If you're unsure which one to use, you
	 * probably want Passive mode to be on.
	 */
	public void setPassiveMode(boolean setPassive)
	{
		if (setPassive) enterLocalPassiveMode();
		else enterLocalActiveMode();
	}

	/** Use ASCII mode for file transfers */
	public boolean ascii() throws IOException
	{
		return setFileType(FTP.ASCII_FILE_TYPE);
	}

	/** Use Binary mode for file transfers */
	public boolean binary() throws IOException
	{
		return setFileType(FTP.BINARY_FILE_TYPE);
	}

	/** Download a file from the server, and save it to the specified local file */
	public boolean downloadFile(String serverFile, String localFile) throws IOException, FTPConnectionClosedException
	{
		FileOutputStream out = new FileOutputStream(localFile);
		boolean result = retrieveFile(serverFile, out);
		out.close();
		return result;
	}

	/** Upload a file to the server */
	public boolean uploadFile(String localFile, String serverFile) throws IOException, FTPConnectionClosedException
	{
		FileInputStream in = new FileInputStream(localFile);
		boolean result = storeFile(serverFile, in);
		in.close();
		return result;
	}

	/**
	 * Get the list of files in the current directory as a Vector of Strings (excludes subdirectories)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector listFileNames() throws IOException, FTPConnectionClosedException
	{
		FTPFile[] files = listFiles();
		Vector v = new Vector();
		for (int i = 0; i < files.length; i++)
		{
			if (!files[i].isDirectory()) v.addElement(files[i].getName());
		}
		return v;
	}

	/**
	 * Get the list of files in the current directory as a single Strings, delimited by \n (char '10') (excludes
	 * sub directories)
	 */
	public String listFileNamesString() throws IOException, FTPConnectionClosedException
	{
		return vectorToString(listFileNames(), "\n");
	}

	/**
	 * Get the list of sub directories in the current directory as a Vector of Strings (excludes files)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector listSubdirNames() throws IOException, FTPConnectionClosedException
	{
		FTPFile[] files = listFiles();
		Vector v = new Vector();
		if (files != null)
		{
			for (int i = 0; i < files.length; i++)
			{
				if (files[i].isDirectory()) v.addElement(files[i].getName());
			}
		}

		return v;
	}

	/**
	 * Get the list of sub directories in the current directory as a single Strings, delimited by \n (char '10') (excludes
	 * files)
	 */
	public String listSubdirNamesString() throws IOException, FTPConnectionClosedException
	{
		return vectorToString(listSubdirNames(), "\n");
	}

	/** Convert a Vector to a delimited String */
	@SuppressWarnings({ "rawtypes"})
	private String vectorToString(Vector v, String delim)
	{
		StringBuffer sb = new StringBuffer();
		String s = "";
		for (int i = 0; i < v.size(); i++)
		{
			sb.append(s).append((String) v.elementAt(i));
			s = delim;
		}
		return sb.toString();
	}

}
