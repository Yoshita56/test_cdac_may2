package hisglobal.utility;

import java.io.*;

public class Printer
{
	private static final String TEMP_DIR_NAME = System.getProperties().getProperty("java.io.tmpdir");
	private static final String OS_NAME = System.getProperties().getProperty("os.name");

	public Printer()
	{
		System.out.println(OS_NAME + " OS Detected. ");
		System.out.println(TEMP_DIR_NAME + " IS Temp Dir. ");
	}

	//	Getting Host Name into Converted Form as 90.103.0.22 to 90_103_0_22
	private String getConvertedHostName(String dottedHostName)
	{
		byte[] hostNameArr = dottedHostName.getBytes();

		for (int i = 0; i < hostNameArr.length; i++)
		{
			if (hostNameArr[i] == (byte) 46) // Comapre with .
			hostNameArr[i] = (byte) 95;//replace with _
		}

		return new String(hostNameArr);

	}

	public synchronized boolean createTempFile(String contents, String hostName)
	{

		boolean retValue = false;

		String fileName = TEMP_DIR_NAME + "";
		//String dateTime	=	new registration.FuncLib().getSysdate("YYYYMonDDHH12_MIAM_");

		if (OS_NAME.startsWith("Linux")) fileName = "/root/nike/regCard_" + new Printer().getConvertedHostName(hostName) + ".txt";
		//fileName="/root/nike/regCard_"+new Printer().getConvertedHostName(hostName)+dateTime+".txt";
		else fileName += "regCard_" + new Printer().getConvertedHostName(hostName) + ".dat";

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

			Printer.printSlip(hostName);//Calling Self Function

			retValue = true;
		}
		catch (Exception e)
		{
			System.out.println("Exception in createTempFile() " + e);
			retValue = false;
		}

		return retValue;
	}

	public static boolean printSlip(String hostName)
	{

		boolean retValue = false;
		if (OS_NAME.startsWith("Linux"))
		{
			retValue = linuxPrinting(hostName);

		}
		else
		{
			if (OS_NAME.startsWith("Windows")) retValue = windowsPrinting("\\\\" + hostName + "\\printername", hostName);//For windows based printing
			else
			{
				System.out.println("Unable to detect the Operating System. Pritnting Aborted");
				retValue = false;
			}
		}
		return retValue;
	}

	public static boolean linuxPrinting(String hostName)
	{
		//String dateTime	=	new registration.FuncLib().getSysdate("YYYYMonDDHH12_MIAM_");
		boolean retValue = false;
		//String fileName		=	"/root/regCard_"+new BeanRegPrinterSupport().getConvertedHostName(hostName)+".dat";
		//String fileName		="/root/nike/regCard_"+new Printer().getConvertedHostName(hostName)+dateTime+".txt";
		String fileName = "/root/nike/regCard_" + new Printer().getConvertedHostName(hostName) + ".txt";
		String printCommand = "echo \"print\" " + fileName + "|smbclient //" + hostName + "/printername -U Administrator%";

		System.out.println("printer path Linux OS" + printCommand);

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

	public static boolean windowsPrinting(String printerPath, String hostName)
	{
		StringBuffer cnt = new StringBuffer();
		String fileName = TEMP_DIR_NAME + "regCard_" + new Printer().getConvertedHostName(hostName) + ".dat";
		boolean retValue = false;
		System.out.println("Inside Windows Printing Start");
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
			System.out.println("Inside Windows Printing ");
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
