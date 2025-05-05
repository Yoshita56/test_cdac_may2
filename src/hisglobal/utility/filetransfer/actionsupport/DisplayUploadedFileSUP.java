package hisglobal.utility.filetransfer.actionsupport;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class DisplayUploadedFileSUP extends ActionSupport implements ServletRequestAware, ServletResponseAware, SessionAware
{
	private static final long serialVersionUID = 1L;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	@SuppressWarnings("rawtypes") private Map sessionMap = null;

	protected String strProcessId;
	protected String strCRNoHospCode;
	protected String strFileName;

	protected String varStatus;

	public static String FILE_UPLOAD_STATUS_INITIAL = "INITIAL";
	public static String FILE_UPLOAD_STATUS_DONE = "DONE";

	public DisplayUploadedFileSUP()
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
