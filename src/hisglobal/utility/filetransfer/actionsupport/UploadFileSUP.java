package hisglobal.utility.filetransfer.actionsupport;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UploadFileSUP extends ActionSupport implements ServletRequestAware, ServletResponseAware, SessionAware
{
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	private HttpServletResponse response;
	@SuppressWarnings("rawtypes") private Map sessionMap = null;

	protected String strProcessId;
	protected String strCRNoHospCode;
	protected String strFileName;
	protected String varStatus;
	protected File uploadedFile;
 
	public static String FILE_UPLOAD_STATUS_INITIAL = "INITIAL";
	public static String FILE_UPLOAD_STATUS_DONE = "DONE";

	public UploadFileSUP()
	{
		varStatus =  FILE_UPLOAD_STATUS_INITIAL;
	}

	public void clear()
	{
	}

	@Override
	public void setServletRequest(HttpServletRequest request)
	{
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response)
	{
		this.response = response;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public void setSession(Map sessionMap)
	{
		this.sessionMap = sessionMap;
	}

	@SuppressWarnings("rawtypes")
	public Map getSession()
	{
		return this.sessionMap;
	}

	public HttpServletRequest getRequest()
	{
		return this.request;
	}

	public HttpServletResponse getResponse()
	{
		return this.response;
	}

	public String getVarStatus()
	{
		return varStatus;
	}

	public void setVarStatus(String varStatus)
	{
		this.varStatus = varStatus;
	}

	public String getStrProcessId()
	{
		return strProcessId;
	}

	public void setStrProcessId(String strProcessId)
	{
		this.strProcessId = strProcessId;
	}

	public File getUploadedFile()
	{
		return uploadedFile;
	}

	public void setUploadedFile(File uploadedFile)
	{
		this.uploadedFile = uploadedFile;
	}

	public String getStrCRNoHospCode()
	{
		return strCRNoHospCode;
	}

	public void setStrCRNoHospCode(String strCRNoHospCode)
	{
		this.strCRNoHospCode = strCRNoHospCode;
	}

	public String getStrFileName()
	{
		return strFileName;
	}

	public void setStrFileName(String strFileName)
	{
		this.strFileName = strFileName;
	}
}
