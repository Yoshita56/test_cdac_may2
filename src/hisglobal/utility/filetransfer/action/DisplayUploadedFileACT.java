package hisglobal.utility.filetransfer.action;

import hisglobal.exceptions.HisApplicationExecutionException;
import hisglobal.utility.filetransfer.FTPFileTransfer;
import hisglobal.utility.filetransfer.actionsupport.DisplayUploadedFileSUP;
import hisglobal.utility.filetransfer.config.FileTransferConfig;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DisplayUploadedFileACT extends DisplayUploadedFileSUP
{
	static final long serialVersionUID = 0L;

	public String execute()
	{
		OutputStream os = null;
		BufferedOutputStream bos = null;
		try
		{
			os = response.getOutputStream();
			bos = new BufferedOutputStream(os);

			if(strProcessId==null || strProcessId.trim().equals("") || strCRNoHospCode==null || strCRNoHospCode.trim().equals("") || strFileName==null || strFileName.trim().equals(""))
			{
				//throw new HisApplicationExecutionException("Servlet Parameters are not sufficient:: Please Contact Administrator");
				FileInputStream fileInStream = (FileInputStream)this.getSession().get(FileTransferConfig.KEY_UPLOADED_FILE_CONTENT);
				String uploadedFile  = (String) this.getSession().get(FileTransferConfig.KEY_UPLOADED_FILE_NAME);
				response.setContentType(FTPFileTransfer.getFileContentType(uploadedFile));

				int c;
				while ((c = fileInStream.read()) != -1)
				{
					os.write(c);
				}    
			}
			else
			{
				
				// Setting File Content Type into Response
				response.setContentType(FTPFileTransfer.getFileContentType(strFileName));
				
				if(!FTPFileTransfer.retrieveWriteFile(strProcessId, strFileName, strCRNoHospCode, response))
				{
					String msg="<B>This file does not exist:: Please Contact Administrator</B>";
					byte[] bytes=msg.getBytes();
					response.setHeader("Pragma", "no-cache");
					bos.write(bytes, 0, bytes.length);
				}
			}
		}
		catch(HisApplicationExecutionException e)
		{
			String msg="<B>"+ e.getMessage()+"</B>";
			byte[] bytes=msg.getBytes();
			response.setHeader("Pragma", "no-cache");
			try
			{
				bos.write(bytes, 0, bytes.length);
			}
			catch(IOException ee)
			{
			}
		}
		catch(IOException e)
		{
			String msg="<B>This file does not exist:: Please Contact Administrator</B>";
			byte[] bytes=msg.getBytes();
			response.setHeader("Pragma", "no-cache");
			try
			{
				bos.write(bytes, 0, bytes.length);
			}
			catch(IOException ee)
			{
			}
		}
		catch(Exception e)
		{
			String msg="<B>This file does not exist:: Please Contact Administrator</B>";
			byte[] bytes=msg.getBytes();
			response.setHeader("Pragma", "no-cache");
			try
			{
				bos.write(bytes, 0, bytes.length);
			}
			catch(IOException ee)
			{
			}
		}
		finally
		{
			try
			{
				response.getOutputStream().flush();
				if(bos!=null)	bos.close();
			}
			catch(Exception e)
			{
			}
		}
		return null;
	}
}
