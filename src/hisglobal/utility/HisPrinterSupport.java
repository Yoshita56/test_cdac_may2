package hisglobal.utility;

import java.io.*;

public class HisPrinterSupport
{
	private static final String TEMP_DIR_NAME = System.getProperties().getProperty("java.io.tmpdir");
	private static final String OS_NAME = System.getProperties().getProperty("os.name");

	public HisPrinterSupport()
	{
		System.out.println(OS_NAME + " OS Detected. ");
		System.out.println(TEMP_DIR_NAME + " IS Temp Dir. ");
	}

	public synchronized static boolean createTempFile(String contents, String tmpFileName)
	{

		boolean retValue = false;

		String fileName = TEMP_DIR_NAME + "";

		if (OS_NAME.startsWith("Linux")) fileName = "/root/" + tmpFileName + ".dat";
		else fileName += tmpFileName + ".dat";

		try
		{
			System.out.println("In createtempFile (File Name) " + fileName);
			FileWriter FR = new FileWriter(fileName, false);
			BufferedWriter OS = new BufferedWriter(FR);

			for (int i = 0; i < contents.length(); i++)
			{

				OS.write(contents.charAt(i));
				OS.flush();
			}

			OS.close();
			retValue = true;
		}
		catch (Exception e)
		{
			System.out.println("Exception in createTempFile() " + e);
			retValue = false;
		}

		return retValue;
	}

	public synchronized static boolean createTempFileVisit(String contents)
	{

		boolean retValue = false;

		String fileName = TEMP_DIR_NAME + "";

		if (OS_NAME.startsWith("Linux")) fileName = "/root/regCardVisit.dat";
		else fileName += "regCardVisit.dat";

		try
		{
			System.out.println("In createtempFile (File Name) " + fileName);
			FileWriter FR = new FileWriter(fileName, false);
			BufferedWriter OS = new BufferedWriter(FR);

			for (int i = 0; i < contents.length(); i++)
			{

				OS.write(contents.charAt(i));
				OS.flush();
			}

			OS.close();
			retValue = true;
		}
		catch (Exception e)
		{
			System.out.println("Exception in createTempFile() " + e);
			retValue = false;
		}

		return retValue;
	}

	public synchronized static boolean createTempFileEmr(String contents)
	{

		boolean retValue = false;

		String fileName = TEMP_DIR_NAME + "";

		if (OS_NAME.startsWith("Linux")) fileName = "/root/regCardEmr.dat";
		else fileName += "regCardEmr.dat";

		try
		{
			System.out.println("In createtempFile (File Name) " + fileName);
			FileWriter FR = new FileWriter(fileName, false);
			BufferedWriter OS = new BufferedWriter(FR);

			for (int i = 0; i < contents.length(); i++)
			{

				OS.write(contents.charAt(i));
				OS.flush();
			}

			OS.close();
			retValue = true;
		}
		catch (Exception e)
		{
			System.out.println("Exception in createTempFile() " + e);
			retValue = false;
		}

		return retValue;
	}

	public synchronized static boolean printSlip(String hostName, String _tmpFile,String _clientOS)
	{

		boolean retValue = false;
		String printCommand="";
		if (OS_NAME.startsWith("Linux"))
		{
			
			retValue = linuxPrinting(hostName,_tmpFile,_clientOS);

		}
		else
		{
			if (OS_NAME.startsWith("Windows"))
				{
				retValue = windowsPrinting("\\\\" + hostName + "\\HISPRINTER", _tmpFile);//For windows based printing
				}
			else
			{
				System.out.println("Unable to detect the Operating System. Pritnting Aborted");
				retValue = false;
			}
		}
		return retValue;
	}
	
	//new method for getting the printer name from the calling process
	public synchronized static boolean printSlip(String hostName, String _tmpFile,String _clientOS,String printerName)
	{
		
		boolean retValue = false;
		String printCommand="";
		if (OS_NAME.startsWith("Linux"))
		{
			
			retValue = linuxPrinting(hostName,_tmpFile,_clientOS,printerName);
			
		}
		else
		{
			if (OS_NAME.startsWith("Windows"))
			{
				retValue = windowsPrinting("\\\\" + hostName + "\\"+printerName , _tmpFile);//For windows based printing
			}
			else
			{
				System.out.println("Unable to detect the Operating System. Pritnting Aborted");
				retValue = false;
			}
		}
		return retValue;
	}

	public synchronized static boolean printSlipVisit(String hostName)
	{

		boolean retValue = false;
		if (OS_NAME.startsWith("Linux"))
		{
			retValue = linuxPrintingVisit(hostName);

		}
		else
		{
			if (OS_NAME.startsWith("Windows")) retValue = windowsPrintingVisit("\\\\" + hostName + "\\printer");//For windows based printing
			else
			{
				System.out.println("Unable to detect the Operating System. Pritnting Aborted");
				retValue = false;
			}
		}
		return retValue;
	}

	public static boolean printSlipEmr(String hostName)
	{

		boolean retValue = false;
		if (OS_NAME.startsWith("Linux"))
		{
			retValue = linuxPrintingEmr(hostName);

		}
		else
		{
			if (OS_NAME.startsWith("Windows")) retValue = windowsPrintingEmr("\\\\" + hostName + "\\printer");//For windows based printing
			else
			{
				System.out.println("Unable to detect the Operating System. Pritnting Aborted");
				retValue = false;
			}
		}
		return retValue;
	}

	public synchronized static boolean linuxPrinting(String hostName,String _tmpFile,String _clientOS)
	{

		boolean retValue = false;
		String fileName = "/root/"+_tmpFile;
		String printCommand = "";
		
		////print command based on client OS
		if(_clientOS.equals("Linux"))
			printCommand = "lpr -P "+hostName+" -l "+fileName;
		else	
			printCommand = "echo \"print\" " + fileName + "|smbclient //" + hostName + "/HISPRINTER -U hisprinter%hisprinter";
		
		
		//String printCommand = "echo \"print\" " + fileName + "|smbclient //" + hostName + "/HISPRINTER -U Administrator%";
		try
		{
			FileOutputStream os = new FileOutputStream("/root/printSlip.sh");
			PrintStream ps = new PrintStream(os, false);
			System.out.println("Before Executing print for linux");
			ps.print(printCommand + "\n");
			System.out.println("afetr Executing print for linux");
			ps.close();
			Runtime rt = Runtime.getRuntime();
			Process prs = rt.exec("sh /root/changeMode.sh");
			prs.waitFor();
			retValue = true;
		}
		catch (Exception e)
		{
			System.out.println("Exception occurred in linuxPrinting() " + e);
			e.printStackTrace();
			retValue = false;
		}
		return retValue;
	}
	
	
	//new method for getting the printer name from the calling process
	
	public synchronized static boolean linuxPrinting(String hostName,String _tmpFile,String _clientOS,String printerName)
	{
		
		boolean retValue = false;
		String fileName = "/root/"+_tmpFile;
		String printCommand = "";
		
		////print command based on client OS
		if(_clientOS.equals("Linux"))
			printCommand = "lpr -P "+hostName+" -l "+fileName;
		else	
			printCommand = "echo \"print\" " + fileName + "|smbclient //" + hostName + "/"+printerName+ " -U hisprinter%hisprinter";
		
		
		//String printCommand = "echo \"print\" " + fileName + "|smbclient //" + hostName + "/HISPRINTER -U Administrator%";
		try
		{
			FileOutputStream os = new FileOutputStream("/root/printSlip.sh");
			PrintStream ps = new PrintStream(os, false);
			System.out.println("Before Executing print for linux");
			ps.print(printCommand + "\n");
			System.out.println("afetr Executing print for linux");
			ps.close();
			Runtime rt = Runtime.getRuntime();
			Process prs = rt.exec("sh /root/changeMode.sh");
			prs.waitFor();
			retValue = true;
		}
		catch (Exception e)
		{
			System.out.println("Exception occurred in linuxPrinting() " + e);
			e.printStackTrace();
			retValue = false;
		}
		return retValue;
	}

	public synchronized static boolean linuxPrintingVisit(String hostName)
	{

		boolean retValue = false;
		String fileName = "/root/regCardVisit.dat";
		String printCommand = "echo \"print\" " + fileName + "|smbclient //" + hostName + "/printer -U Administrator%";
		try
		{
			FileOutputStream os = new FileOutputStream("/root/printSlip.sh");
			PrintStream ps = new PrintStream(os, false);
			ps.print(printCommand + "\n");
			//ps.flush();
			ps.close();
			Runtime rt = Runtime.getRuntime();
			Process prs = rt.exec("/root/changeMode.sh");
			prs.waitFor();
			retValue = true;
		}
		catch (Exception e)
		{
			System.out.println("Exception occurred in linuxPrinting() " + e);
			retValue = false;
		}
		return retValue;
	}

	public synchronized static boolean linuxPrintingEmr(String hostName)
	{

		boolean retValue = false;
		String fileName = "/root/regCardEmr.dat";
		String printCommand = "echo \"print\" " + fileName + "|smbclient //" + hostName + "/printer -U Administrator%";
		try
		{
			FileOutputStream os = new FileOutputStream("/root/printSlip.sh");
			PrintStream ps = new PrintStream(os, false);
			ps.print(printCommand + "\n");
			//ps.flush();
			ps.close();
			Runtime rt = Runtime.getRuntime();
			Process prs = rt.exec("/root/changeMode.sh");
			prs.waitFor();
			retValue = true;
		}
		catch (Exception e)
		{
			System.out.println("Exception occurred in linuxPrinting() " + e);
			retValue = false;
		}
		return retValue;
	}

	public synchronized static boolean windowsPrinting(String printerPath, String _tmpFile)
	{
		StringBuffer cnt = new StringBuffer();
		String fileName = TEMP_DIR_NAME + _tmpFile;
		boolean retValue = false;

		try
		{
			boolean eof = false;
			int j = 0;

			FileOutputStream os = new FileOutputStream(printerPath);
			PrintStream ps = new PrintStream(os, false);
			FileInputStream fs = new FileInputStream(fileName);
			BufferedInputStream br = new BufferedInputStream(fs);
			File f = new File(fileName);

			char msg[] = new char[(int) f.length() + 1];

			while (!eof)
			{

				int i = br.read();

				if (i == -1) eof = true;
				else
				{
					msg[j] += (char) (i);
					cnt.append(msg[j]);
					j++;
				}

			}

			cnt.append("\n");
			ps.print(cnt);
			//System.out.println("Contents are "+cnt);
			//ps.print("\f");	//form feed char to go to next page

			ps.close();
			retValue = true;
			System.out.println(cnt);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception occurred in windowsPrinting() " + e);
			retValue = false;
		}

		return retValue;
	}

	public synchronized static boolean windowsPrintingVisit(String printerPath)
	{
		StringBuffer cnt = new StringBuffer();
		String fileName = TEMP_DIR_NAME + "regCardVisit.dat";
		boolean retValue = false;

		try
		{
			boolean eof = false;
			int j = 0;

			FileOutputStream os = new FileOutputStream(printerPath);
			PrintStream ps = new PrintStream(os, false);
			FileInputStream fs = new FileInputStream(fileName);
			BufferedInputStream br = new BufferedInputStream(fs);
			File f = new File(fileName);

			char msg[] = new char[(int) f.length() + 1];

			while (!eof)
			{

				int i = br.read();

				if (i == -1) eof = true;
				else
				{
					msg[j] += (char) (i);
					cnt.append(msg[j]);
					j++;
				}

			}

			cnt.append("\n");
			ps.print(cnt);
			//System.out.println("Contents are "+cnt);
			//ps.print("\f");	//form feed char to go to next page

			ps.close();
			retValue = true;
			System.out.println(cnt);
		}
		catch (Exception e)
		{
			System.out.println("Exception occurred in windowsPrinting() " + e);
			retValue = false;
		}

		return retValue;
	}

	public synchronized static boolean windowsPrintingEmr(String printerPath)
	{
		StringBuffer cnt = new StringBuffer();
		String fileName = TEMP_DIR_NAME + "regCardEmr.dat";
		boolean retValue = false;

		try
		{
			boolean eof = false;
			int j = 0;

			FileOutputStream os = new FileOutputStream(printerPath);
			PrintStream ps = new PrintStream(os, false);
			FileInputStream fs = new FileInputStream(fileName);
			BufferedInputStream br = new BufferedInputStream(fs);
			File f = new File(fileName);

			char msg[] = new char[(int) f.length() + 1];

			while (!eof)
			{

				int i = br.read();

				if (i == -1) eof = true;
				else
				{
					msg[j] += (char) (i);
					cnt.append(msg[j]);
					j++;
				}

			}

			cnt.append("\n");
			ps.print(cnt);
			//System.out.println("Contents are "+cnt);
			//ps.print("\f");	//form feed char to go to next page

			ps.close();
			retValue = true;
			System.out.println(cnt);
		}
		catch (Exception e)
		{
			System.out.println("Exception occurred in windowsPrinting() " + e);
			retValue = false;
		}

		return retValue;
	}

}
