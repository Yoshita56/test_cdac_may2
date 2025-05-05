package hisglobal.utility;

/**
 * @copyright CDAC
 * @developer Pragya Sharma
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.FileNameMap;
import java.net.URLConnection;

public class HisFileControlUtil
{
	private static final String OS_NAME = System.getProperties().getProperty("os.name");

	public static boolean isWindowsOS()
	{
		if (OS_NAME.startsWith("Linux")) return false;
		else return true;
	}

	private String fileName;
	private String windowsFilePath;
	private String linuxFilePath;
	private byte[] fileContent;
	private String fileContentInString;

	public HisFileControlUtil()
	{
		this.fileName = "";
		this.windowsFilePath = "";
		this.linuxFilePath = "";
		this.fileContent = null;
	}

	public HisFileControlUtil(String name)
	{
		this.fileName = name;
		this.windowsFilePath = "";
		this.linuxFilePath = "";
		this.fileContent = null;
	}
	
	

	public HisFileControlUtil(String name, String winPath, String linuxPath)
	{
		this.fileName = name;
		// Converting / to \\
		this.setWindowsFilePath(winPath);
		this.linuxFilePath = linuxPath;
		this.fileContent = null;
	}

	public HisFileControlUtil(String name, String winPath, String linuxPath, byte[] contents)
	{
		this.fileName = name;
		// Converting / to \\
		this.setWindowsFilePath(winPath);
		this.linuxFilePath = linuxPath;
		this.fileContent = contents;
	}

	public void reset()
	{
		this.fileName = "";
		this.windowsFilePath = "";
		this.linuxFilePath = "";
		this.fileContent = null;
	}

	private boolean createDir(File _dir)
	{
		boolean flag = true;
		try
		{			
			String path = _dir.getPath();
			String splitter = null;
			if (path.contains("/")) splitter = "/";
			else if (path.contains("\\")) splitter = "\\\\";
			String[] paths = path.split(splitter);
			String createPath = paths[0];
			for(int i=1; i<paths.length; i++)
			{
				createPath+=splitter+paths[i];
				File dir = new File(createPath);
				if(!dir.exists()) dir.mkdir();				
			}
		}
		catch (Exception e)
		{
			System.out.println("Error in Creating Directories :" + e);
			flag = false;
		}
		return flag;
	}

	public boolean saveFile()
	{
		try
		{
			// Setting Path
			String path;
			if (this.windowsFilePath.trim().equals("") || this.linuxFilePath.trim().equals("")) return false;
			if (this.fileName.trim().equals("")) return false;
			if (this.fileContent == null || this.fileContent.length == 0) return false;

			if (OS_NAME.startsWith("Linux")) path = "/root" + this.linuxFilePath;
			else path = this.windowsFilePath;

			// Creating Directory
			File dir = new File(path);
			if (!dir.exists()) createDir(dir); // dir.mkdir();

			// Creating File even if it exists already
			File file = new File(dir, this.fileName);
			if (!file.exists()) file.createNewFile();
			else
			{
				file.delete();
				file.createNewFile();
			}
			System.out.println("File Path " + file.getPath());

			// Adding data to Created File
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(this.fileContent);
			fos.flush();
			fos.close();
		}
		catch (Exception e)
		{
			System.out.println("Error in Uploading File :" + e);
		}
		return true;
	}

	public boolean deleteFile()
	{
		try
		{
			// Setting Path
			String path;
			if (this.windowsFilePath.trim().equals("") || this.linuxFilePath.trim().equals("")) return false;
			if (this.fileName.trim().equals("")) return false;

			if (OS_NAME.startsWith("Linux")) path = "/root" + this.linuxFilePath;
			else path = this.windowsFilePath;

			// Checking Directory if Exixts
			File dir = new File(path);
			if (!dir.exists()) return false;
			if (!dir.isDirectory()) return false;

			// Deleting File if exists
			File file = new File(dir, this.fileName);
			if (file.exists()) file.delete();
		}
		catch (Exception e)
		{
			System.out.println("Error in Deleting File :" + e);
		}
		return true;
	}

	public boolean readFile()
	{
		try
		{
			// Setting Path
			String path;
			if (this.windowsFilePath.trim().equals("") || this.linuxFilePath.trim().equals("")) return false;
			if (this.fileName.trim().equals("")) return false;

			if (OS_NAME.startsWith("Linux")) path = "/root" + this.linuxFilePath;
			else path = this.windowsFilePath;

			// Checking Directory if Exixts
			File dir = new File(path);
			if (!dir.exists()) return false;
			if (!dir.isDirectory()) return false;

			// If Directory not exist return false
			File file = new File(dir, this.fileName);
			if (!file.exists()) return false;
			if (!file.isFile()) return false;

			// Reading data from File
			FileInputStream fis = new FileInputStream(file);
			byte[] bytes = new byte[fis.available()];
			fis.read(bytes);

			char[] chars = new char[bytes.length];
			for (int i = 0; i < bytes.length; i++)
				chars[i] = (char) bytes[i];

			// File Content
			this.fileContentInString = String.valueOf(chars);
			this.fileContent = bytes;
			fis.close();
		}
		catch (Exception e)
		{
			System.out.println("Error in Reading File :" + e);
		}
		return true;
	}

	public String getFileContentType()
	{
		String contentType = "";
		FileNameMap fileNameMap = URLConnection.getFileNameMap();
		contentType = fileNameMap.getContentTypeFor(fileName);
		return contentType;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public String getWindowsFilePath()
	{
		return windowsFilePath;
	}

	public void setWindowsFilePath(String windowsFilePath)
	{
		if (windowsFilePath.contains("/")) windowsFilePath = windowsFilePath.replace("/", "\\");
		this.windowsFilePath = windowsFilePath;
	}

	public String getLinuxFilePath()
	{
		return linuxFilePath;
	}

	public void setLinuxFilePath(String linuxFilePath)
	{
		this.linuxFilePath = linuxFilePath;
	}

	public String getPath()
	{
		String path="";
		if (this.windowsFilePath.trim().equals("") || this.linuxFilePath.trim().equals("")) return path;
		if (OS_NAME.startsWith("Linux")) path = "/root" + this.linuxFilePath;
		else path = this.windowsFilePath;
		return path.replace("\\", "/");
	}

	public byte[] getFileContent()
	{
		return fileContent;
	}

	public void setFileContent(byte[] fileContent)
	{
		this.fileContent = fileContent;
	}

	public String getFileContentInString()
	{
		return this.fileContentInString;
	}
}
