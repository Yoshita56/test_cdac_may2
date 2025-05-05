package hisglobal.transactionutil;

import hisglobal.presentation.CSRFGardTokenAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * @author dell
 * 
 */
public class GenericController extends CSRFGardTokenAction {

	TransInterface masterObj = null;

	String cnt_page = "";

	// String combo[] = null;

	// Logger logger = Logger.getLogger(getClass());
	StringBuffer br = new StringBuffer(1000);

	public GenericController() {
	}

	public GenericController(TransInterface masterObj, String cnt_page) {
		this.masterObj = masterObj;
		this.cnt_page = cnt_page;

	}

	/*
	 * THIS FUNCTION OPENS THE TRANSACTION TEMPLATE AS PER USER CHOICE i.e. in
	 * Tiles in Frames in Normal Mode
	 */
	public final ActionForward unspecified(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		// combo = null;
		// String combo[] = null;
		String strPath = "";
		ActionForward actFrw = new ActionForward();
		GenericFormBean formBean = (GenericFormBean)form;
		formBean.setSession(request.getSession());
		GenericDATA.setUserName(request,formBean,masterObj);
		if (request.getParameter("userValue") != null) {
			request.getSession().setAttribute("USERVALUE",request.getParameter("userValue").toString());
		}
		LISTDATA(request);
		strPath = GenericDATA.checkMode(masterObj, 0);
		actFrw.setPath(strPath);
		actFrw.setContextRelative(true);
		return actFrw;

	}
	
	public ActionForward GOTOMAINPAGE(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse _response)
			throws Exception {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}

	public final ActionForward LIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String strPath = "";
		LISTDATA(request);
		ActionForward actFrw = new ActionForward();
		strPath = GenericDATA.checkMode(masterObj, 0);
		actFrw.setPath(strPath);
		actFrw.setContextRelative(true);
		return actFrw;

	}

	private final void LISTDATA(HttpServletRequest request) {

		GenericDATA.LISTDATA(request, masterObj, cnt_page);

	}

	public final ActionForward BUTTON(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		GenericDATA.BUTTON(request, response, masterObj);

		return null;
	}

	public final ActionForward LISTPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		GenericDATA.LISTPAGE(request, response, masterObj);

		return null;
	}

	public final ActionForward SEARCH(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		GenericDATA.SEARCH(request, response, masterObj);

		return null;

	}

	public final ActionForward DEFAULT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		GenericDATA.DEFAULT(request, response, masterObj);

		return null;
	}

	public final ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		// String combo[] = null;
		// combo = request.getParameterValues("combo");
		return this.LIST(mapping, form, request, response);
	}

	public final ActionForward DELETE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		
		GenericDATA.DELETE(request, response, masterObj);
		return null;
	}

	public final ActionForward REPORT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		request.setAttribute("combo", request.getParameterValues("combo"));
		ActionForward actFrw = new ActionForward();
		actFrw.setPath("/hisglobal/transactionutil/master/rpt_transTemp_gbl.jsp");
		actFrw.setContextRelative(true);
    	return actFrw;
	}

	public final ActionForward VIEWDATA(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) 
	{
		GenericDATA.VIEWDATA(request, response, masterObj);
		return null;
	}

	public final ActionForward REPORTDATA(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) 
	{
		GenericDATA.REPORTDATA(request, response, masterObj);
		return null;
	}
}
