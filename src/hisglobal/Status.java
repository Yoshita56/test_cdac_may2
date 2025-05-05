package hisglobal;

import hisglobal.utility.Entry;

import java.util.HashSet;
import java.util.Iterator;

public class Status
{
	public final static String CODE_LOGIN_UID_INVALID = "100";
	public final static String CODE_LOGIN_PWD_INVALID = "101";
	public final static String CODE_LOGIN_CONFLICT = "102";
	public final static String CODE_LOGIN_FAILED = "103";
	public final static String CODE_LOGIN_INSERT_FAILED = "104";
	public final static String CODE_LOGOUT_UPDATE_FAILED = "105";

	public final static String CODE_NEW = "001";
	public final static String CODE_DONE = "002";
	public final static String CODE_CUSTOM = "003";
	public final static String CODE_ERROR = "004";
	public final static String CODE_ERROR_DATAACCESS = "005";
	public final static String CODE_ERROR_APP_EXECUTION = "006";
	public final static String CODE_UNSUCESSFULL = "007";
	public final static String CODE_INPROCESS = "008";
	public final static String CODE_FAILURE = "009";

	public final static Entry LOGININVALIDUID = new Entry("", Status.CODE_LOGIN_UID_INVALID);
	public final static Entry LOGININVALIDPWD = new Entry("", Status.CODE_LOGIN_PWD_INVALID);
	public final static Entry LOGINCONFLICT = new Entry("", Status.CODE_LOGIN_CONFLICT);
	public final static Entry LOGINFAILED = new Entry("", Status.CODE_LOGIN_FAILED);
	public final static Entry LOGININSERTFAILED = new Entry("", Status.CODE_LOGIN_INSERT_FAILED);
	public final static Entry LOGOUTUPDATEFAILED = new Entry("", Status.CODE_LOGOUT_UPDATE_FAILED);

	public final static Entry NEW = new Entry("", Status.CODE_NEW);
	public final static Entry DONE = new Entry("", Status.CODE_DONE);
	public final static Entry CUSTOM = new Entry("", Status.CODE_CUSTOM);
	public final static Entry ERROR = new Entry("", Status.CODE_ERROR);
	public final static Entry ERROR_DA = new Entry("", Status.CODE_ERROR);
	public final static Entry ERROR_AE = new Entry("", Status.CODE_ERROR);
	public final static Entry UNSUCESSFULL = new Entry("", Status.CODE_UNSUCESSFULL);
	public final static Entry INPROCESS = new Entry("", Status.CODE_INPROCESS);
	public final static Entry FAILURE = new Entry("", Status.CODE_FAILURE);

	private HashSet statusList = new HashSet();

	public HashSet getStatusList()
	{
		return statusList;
	}

	public void clear()
	{
		statusList.clear();
	}

	//status corresponds to label whereas _code corresponds to value
	public void add(Entry _objEntry, String _MSG, String _msgType)
	{
		_objEntry = (Entry) _objEntry.clone();
		_objEntry.setLabel(_msgType + _MSG);
		this.add(_objEntry);
	}

	public void add(String _code, String _status)
	{
		statusList.add(new Entry(_status, _code));
	}

	public void add(Entry _objEntry)
	{
		statusList.add(_objEntry);
	}

	public void remove(Entry _objEntry)
	{
		statusList.remove(_objEntry);
	}

	public boolean contains(Entry _objEntry)
	{
		return this.statusList.contains(_objEntry);
	}

	public String getMessage(String _code)
	{
		//System.out.println(_code);
		Iterator it = statusList.iterator();
		while (it.hasNext())
		{
			Entry objEntry = (Entry) it.next();
			if (objEntry.getValue().trim().equalsIgnoreCase(_code)) return objEntry.getLabel();
		}
		return "";
	}
}
