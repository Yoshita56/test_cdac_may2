package hisglobal.utility.filetransfer.action;

import hisglobal.utility.filetransfer.FTPFileTransfer;
import hisglobal.utility.filetransfer.actionsupport.UploadFileSUP;
import hisglobal.utility.filetransfer.config.FileTransferConfig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UploadFileACT extends UploadFileSUP
{
	private static final long serialVersionUID = 0L;
	public static String PAGE_UPLOAD_FILE = "file";
	public static String PAGE_UPLOAD_AUDIO_VIDEO = "audiovideo";
	public static String PAGE_UPLOAD_IMAGE = "image";

	public UploadFileACT()
	{
	}

	// Initialize Upload File (Default)
	public String execute() throws Exception
	{
		System.out.println("UploadFileACT.execute().......");
		return file();
	}

	// Initialize Upload File
	public String file() throws Exception
	{
		System.out.println("UploadFileACT.file().......");
		varStatus = FILE_UPLOAD_STATUS_INITIAL;
		if(strProcessId==null || strProcessId.trim().equals(""))
			strProcessId = FileTransferConfig.PROCESS_ID_PATIENT_IMAGE_UPLOAD;
		return PAGE_UPLOAD_FILE;
	}

	// Initialize Upload Audio Video
	public String audiovideo() throws Exception
	{
		System.out.println("UploadFileACT.audiovideo().......");
		varStatus = FILE_UPLOAD_STATUS_INITIAL;
		return PAGE_UPLOAD_AUDIO_VIDEO;
	}

	// Initialize Upload Image
	public String image()
	{
		System.out.println("UploadFileACT.image().......");
		varStatus = FILE_UPLOAD_STATUS_INITIAL;
		return PAGE_UPLOAD_IMAGE;
	}

	// Attach/Upload Image
	@SuppressWarnings("unchecked")
	public String attach()
	{
		System.out.println("UploadFileACT.attach().......");
		varStatus = FILE_UPLOAD_STATUS_INITIAL;
		try
		{
			if(this.uploadedFile!=null && this.uploadedFile.isFile())
			{
				long fileSize = this.uploadedFile.length();
				
				if (fileSize > 4194304) // 4MB   10240 10KB
				{
					addActionError("Can't Upload. File is larger than 4 MB.");
				}
				else
				{
					FileInputStream fileInStream = new FileInputStream(this.uploadedFile);
					this.getSession().put(FileTransferConfig.KEY_UPLOADED_FILE_CONTENT, fileInStream);
					this.getSession().put(FileTransferConfig.KEY_UPLOADED_FILE_NAME, this.uploadedFile.getName());

					/*
					FileInputStream fileReadStream = new FileInputStream(this.uploadedFile);
					DataInputStream dataInputStream = new DataInputStream(fileReadStream);
					BufferedReader buffRead = new BufferedReader(new InputStreamReader(dataInputStream));
					String strLine;
					try
					{
						// Read File Line By Line
						while ((strLine = buffRead.readLine()) != null)
						{
							// Print the content on the console
							System.out.println(strLine);
							//sb.append(strLine);
						}
					}
					catch (IOException e)
					{
						e.printStackTrace();
					};*/
//					File destFile = new File(destPath, myFileFileName);
//					FileUtils.copyFile(myFile, destFile);

					// Uploading File to FTP Server if required
					if(strProcessId!=null && FileTransferConfig.MAP_PROCESS_DETIAL.containsKey(strProcessId))
					{
						if(strCRNoHospCode!=null && !strCRNoHospCode.trim().equals("") && strFileName!=null && !strFileName.trim().equals("") )
						{
							System.out.println("Inside FTP");
							FileInputStream fileInFTPStream = new FileInputStream(this.uploadedFile);
							FTPFileTransfer.uploadFile(strProcessId, strFileName, fileInFTPStream, strCRNoHospCode);
							System.out.println("FTP Saved");
						}
					}
					varStatus = FILE_UPLOAD_STATUS_DONE;
					addActionError("File Uploaded Successfully");
				}
			}
			else
			{
				addActionError("File is not uploaded. Please try again.");
			}
		}
		catch (FileNotFoundException e)
		{
			addActionError("File is not uploaded. Please try again.");
			e.printStackTrace();
		}
		catch (IOException e)
		{
			addActionError("File is not uploaded. Please try again.");
			e.printStackTrace();
		}
		catch (Exception e)
		{
			addActionError("File is not uploaded. Please try again.");
			e.printStackTrace();
		}
		finally
		{
		}
		return PAGE_UPLOAD_FILE;
	}
	
	public String done()
	{
		System.out.println("UploadFileACT.done().......");
		return SUCCESS;
	}
}
