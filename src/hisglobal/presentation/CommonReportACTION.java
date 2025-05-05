package hisglobal.presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class CommonReportACTION extends DispatchAction
{

	public ActionForward SERVICEUNITWISEREVISITPATREPORT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws Exception
	{
	
		String reportMode = request.getParameter("reportMode");
		
		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return mapping.findForward("SERVICEUNITWISEREVISITPATREPORTVIEW");
		}
		else
		{
			return mapping.findForward("SERVICEUNITWISEREVISITPATREPORT");
		}
	}
	
	public ActionForward PATIENTBELONGINGDTLREPORT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws Exception
	{
	
		String reportMode = request.getParameter("reportMode");
		
		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return mapping.findForward("PATIENTBELONGINGDTLREPORTVIEW");
		}
		else
		{
			return mapping.findForward("PATIENTBELONGINGDTLREPORT");
		}
	}
	
	public ActionForward SPECIALCLINICPATSTATREPORT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws Exception
	{
	
		String reportMode = request.getParameter("reportMode");
		
		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return mapping.findForward("SPECIALCLINICPATSTATREPORTVIEW");
		}
		else
		{
			return mapping.findForward("SPECIALCLINICPATSTATREPORT");
		}
	}
	
	public ActionForward MLCPOLICEINFOPROFORMAREPORT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{

		String reportMode = request.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return mapping.findForward("MLCPOLICEINFOPROFORMAREPORTVIEW");
		}
		else
		{
			return mapping.findForward("MLCPOLICEINFOPROFORMAREPORT");
		}
	}

	public ActionForward SERVICEUNITWISENEWREGREPORT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{

		String reportMode = request.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return mapping.findForward("SERVICEUNITWISENEWREGREPORTVIEW");
		}
		else
		{
			return mapping.findForward("SERVICEUNITWISENEWREGREPORT");
		}
	}

	public ActionForward POORFREEPATIENTSREPORT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{

		String reportMode = request.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return mapping.findForward("POORFREEPATIENTSREPORTVIEW");
		}
		else
		{
			return mapping.findForward("POORFREEPATIENTSREPORT");
		}
	}

	public ActionForward FOLLOWUPPATIENTSREPORT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{

		String reportMode = request.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return mapping.findForward("FOLLOWUPPATIENTSREPORTVIEW");
		}
		else
		{
			return mapping.findForward("FOLLOWUPPATIENTSREPORT");
		}
	}

	public ActionForward MLCPATIENTSLISTPGIREPORT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{

		String reportMode = request.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return mapping.findForward("MLCPATIENTSLISTPGIREPORTVIEW");
		}
		else
		{
			return mapping.findForward("MLCPATIENTSLISTPGIREPORT");
		}
	}

	public ActionForward ANONYMOUSPATANDDETWHOBROUGHTREPORT(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{

		String reportMode = request.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return mapping.findForward("ANONYMOUSPATANDDETWHOBROUGHTREPORTVIEW");
		}
		else
		{
			return mapping.findForward("ANONYMOUSPATANDDETWHOBROUGHTREPORT");
		}
	}

	public ActionForward ANONYMOUSPATIENTPGIREPORT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{

		String reportMode = request.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return mapping.findForward("ANONYMOUSPATIENTPGIREPORTVIEW");
		}
		else
		{
			return mapping.findForward("ANONYMOUSPATIENTPGIREPORT");
		}
	}

	public ActionForward DEPTWISENEWREGREPORT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{

		String reportMode = request.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return mapping.findForward("DEPTWISENEWREGREPORTVIEW");
		}
		else
		{
			return mapping.findForward("DEPTWISENEWREGREPORT");

		}
	}

	public ActionForward HOSPITALCASHCOLSUMMARYREPORT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{

		String reportMode = request.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return mapping.findForward("HOSPITALCASHCOLSUMMARYREPORTVIEW");
		}
		else
		{
			return mapping.findForward("HOSPITALCASHCOLSUMMARYREPORT");
		}
	}

	public ActionForward HOSPITALCASHCOLDETAILREPORT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{

		String reportMode = request.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return mapping.findForward("HOSPITALCASHCOLDETAILREPORTVIEW");
		}
		else
		{
			return mapping.findForward("HOSPITALCASHCOLDETAILREPORT");
		}
	}

	public ActionForward PATREGUSERWISEREPORT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{

		String reportMode = request.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return mapping.findForward("PATREGUSERWISEREPORTVIEW");
		}
		else
		{
			return mapping.findForward("PATREGUSERWISEREPORT");
		}
	}

	public ActionForward HOSPITALPATSTATREPORT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{

		String reportMode = request.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return mapping.findForward("HOSPITALPATSTATREPORTVIEW");
		}
		else
		{
			return mapping.findForward("HOSPITALPATSTATREPORT");
		}
	}

	public ActionForward NEWOLDTOTALPATOPDWISEREPORT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{

		String reportMode = request.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return mapping.findForward("NEWOLDTOTALPATOPDWISEREPORTVIEW");
		}
		else
		{
			return mapping.findForward("NEWOLDTOTALPATOPDWISEREPORT");
		}
	}

	public ActionForward NEWPATIENTSREGISTRATIONREPORT(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{

		String reportMode = request.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return mapping.findForward("NEWPATIENTSREGISTRATIONREPORTVIEW");
		}
		else
		{
			return mapping.findForward("NEWPATIENTSREGISTRATIONREPORT");
		}
	}

	public ActionForward PINCODEWISESTATISTICSREPORT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{

		String reportMode = request.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return mapping.findForward("PINCODEWISESTATISTICSREPORTVIEW");
		}
		else
		{
			return mapping.findForward("PINCODEWISESTATISTICSREPORT");
		}
	}

	public ActionForward DEPTUNITWISECASHCOLLECTIONREPORT(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{

		String reportMode = request.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return mapping.findForward("DEPTUNITWISECASHCOLLECTIONREPORTVIEW");
		}
		else
		{
			return mapping.findForward("DEPTUNITWISECASHCOLLECTIONREPORT");
		}
	}

	public ActionForward DEPTUNITWISETOTALPATIENTREPORT(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{

		String reportMode = request.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return mapping.findForward("DEPTUNITWISETOTALPATIENTREPORTVIEW");
		}
		else
		{
			return mapping.findForward("DEPTUNITWISETOTALPATIENTREPORT");
		}
	}

	public ActionForward DEPTWISEREGCATEGORYWISEREPORT(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{

		String reportMode = request.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return mapping.findForward("DEPTWISEREGCATEGORYWISEREPORTVIEW");
		}
		else
		{
			return mapping.findForward("DEPTWISEREGCATEGORYWISEREPORT");
		}
	}

	public ActionForward DEPTWISEPATCATWISEREPORT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{

		String reportMode = request.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return mapping.findForward("DEPTWISEPATCATWISEREPORTVIEW");
		}
		else
		{
			return mapping.findForward("DEPTWISEPATCATWISEREPORT");
		}

	}

	public ActionForward AGEWISEDEPTWISEREGPATREPORT(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3)
			throws Exception
	{
		String reportMode = arg2.getParameter("reportMode");
		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return arg0.findForward("AGEWISEDEPTWISEREGPATREPORTVIEW");
		}
		else
		{
			return arg0.findForward("AGEWISEDEPTWISEREGPATREPORT");
		}
	}

	public ActionForward EMERGENCYREPORT(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3) throws Exception
	{
		String reportMode = arg2.getParameter("reportMode");
		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return arg0.findForward("EMERGENCYREPORTVIEW");
		}
		else
		{
			return arg0.findForward("EMERGENCYREPORT");
		}
	}
	
	public ActionForward UNKNOWNPATIENTREPORT(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3) throws Exception
	{
		String reportMode = arg2.getParameter("reportMode");
		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return arg0.findForward("UNKNOWNPATIENTREPORTVIEW");
		}
		else
		{
			return arg0.findForward("UNKNOWNPATIENTREPORT");
		}
	}
	
	public ActionForward MLCPATIENTLISTINGBYALLCMOREPORT(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3) throws Exception
	{
		String reportMode = arg2.getParameter("reportMode");
		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return arg0.findForward("MLCPATIENTLISTINGBYALLCMOREPORTVIEW");
		}
		else
		{
			return arg0.findForward("MLCPATIENTLISTINGBYALLCMOREPORT");
		}
	}

	public ActionForward SHIFTWISECAESEBYCMOREPORT(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3) throws Exception
	{
		String reportMode = arg2.getParameter("reportMode");
		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return arg0.findForward("SHIFTWISECAESEBYCMOREPORTVIEW");
		}
		else
		{
			return arg0.findForward("SHIFTWISECAESEBYCMOREPORT");
		}
	}
	
	public ActionForward AGEWISEREPORT(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3) throws Exception
	{

		//System.out.println("DFFFFFFF" + arg0.findForward("AGEWISEREPORT"));
		String reportMode = arg2.getParameter("reportMode");
		//System.out.println("AGEWISEREPORT    Frommin  =" + arg2.getParameter("fromMin"));
		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return arg0.findForward("AGEWISEREPORTVIEW");
		}
		else
		{
			return arg0.findForward("AGEWISEREPORT");
		}
	}

	public ActionForward EMERGENCYREGISTEREDPATIENTREPORT(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3)
			throws Exception
	{

		//System.out.println("DFFFFFFF" + arg0.findForward("EMERGENCYREGISTEREDPATIENTREPORT"));
		String reportMode = arg2.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return arg0.findForward("EMERGENCYREGISTEREDPATIENTREPORTVIEW");
		}
		else
		{
			return arg0.findForward("EMERGENCYREGISTEREDPATIENTREPORT");
		}

	}

	public ActionForward GROUPWISECASHCOLLECTIONREPORT(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3)
			throws Exception
	{

		System.out.println("DFFFFFFF" + arg0.findForward("GROUPWISECASHCOLLECTIONREPORT"));
		String reportMode = arg2.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return arg0.findForward("GROUPWISECASHCOLLECTIONREPORTVIEW");
		}
		else
		{
			return arg0.findForward("GROUPWISECASHCOLLECTIONREPORT");
		}

	}

	public ActionForward MLCPATIENTLISTREPORT(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3)
			throws Exception
	{

		System.out.println("DFFFFFFF" + arg0.findForward("MLCPATIENTLISTREPORT"));
		String reportMode = arg2.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return arg0.findForward("MLCPATIENTLISTREPORTVIEW");
		}
		else
		{
			return arg0.findForward("MLCPATIENTLISTREPORT");
		}

	}

	public ActionForward BROUGHTDEADPATIENTREPORT(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3)
			throws Exception
	{

		System.out.println("DFFFFFFF" + arg0.findForward("BROUGHTDEADPATIENTREPORT"));
		String reportMode = arg2.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return arg0.findForward("BROUGHTDEADPATIENTREPORTVIEW");
		}
		else
		{
			return arg0.findForward("BROUGHTDEADPATIENTREPORT");
		}

	}

	public ActionForward PINCODEWISEREPORT(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3) throws Exception
	{

		System.out.println("DFFFFFFF" + arg0.findForward("PINCODEWISEREPORT"));
		String reportMode = arg2.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return arg0.findForward("PINCODEWISEREPORTVIEW");
		}
		else
		{
			return arg0.findForward("PINCODEWISEREPORT");
		}

	}

	public ActionForward DEPARTMENTWISEREGPATREPORT(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3)
			throws Exception
	{

		System.out.println("DFFFFFFF" + arg0.findForward("DEPARTMENTWISEREGPATREPORT"));
		String reportMode = arg2.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return arg0.findForward("DEPARTMENTWISEREGPATREPORTVIEW");
		}
		else
		{
			return arg0.findForward("DEPARTMENTWISEREGPATREPORT");
		}

	}

	public ActionForward DEPARTMENTWISETOTALPATREPORT(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3)
			throws Exception
	{

		System.out.println("DFFFFFFF" + arg0.findForward("DEPARTMENTWISETOTALPATREPORT"));
		String reportMode = arg2.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return arg0.findForward("DEPARTMENTWISETOTALPATREPORTVIEW");
		}
		else
		{
			return arg0.findForward("DEPARTMENTWISETOTALPATREPORT");
		}

	}

	public ActionForward ROOMWISETOTALPATREPORT(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3)
			throws Exception
	{

		System.out.println("DFFFFFFF" + arg0.findForward("ROOMWISETOTALPATREPORT"));
		String reportMode = arg2.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return arg0.findForward("ROOMWISETOTALPATREPORTVIEW");
		}
		else
		{
			return arg0.findForward("ROOMWISETOTALPATREPORT");
		}

	}

	public ActionForward USERWISECASHCOLLREPORT(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3)
			throws Exception
	{

		System.out.println("DFFFFFFF" + arg0.findForward("USERWISECASHCOLLREPORT"));
		String reportMode = arg2.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return arg0.findForward("USERWISECASHCOLLREPORTVIEW");
		}
		else
		{
			return arg0.findForward("USERWISECASHCOLLREPORT");
		}

	}

	public ActionForward TOTALPATSTATREPORT(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3) throws Exception
	{

		System.out.println("DFFFFFFF" + arg0.findForward("TOTALPATSTAT"));
		String reportMode = arg2.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return arg0.findForward("TOTALPATSTATREPORTVIEW");
		}
		else
		{
			return arg0.findForward("TOTALPATSTATREPORT");
		}

	}

	public ActionForward USERWISEPATLISTREPORT(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3)
			throws Exception
	{

		System.out.println("DFFFFFFF" + arg0.findForward("USERWISEPATLISTREPORT"));
		String reportMode = arg2.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return arg0.findForward("USERWISEPATLISTREPORTVIEW");
		}
		else
		{
			return arg0.findForward("USERWISEPATLISTREPORT");
		}

	}

	public ActionForward USERWISEREGREPORT(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3) throws Exception
	{

		System.out.println("DFFFFFFF" + arg0.findForward("USERWISEREGREPORT"));
		String reportMode = arg2.getParameter("reportMode");

		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return arg0.findForward("USERWISEREGREPORTVIEW");
		}
		else
		{
			return arg0.findForward("USERWISEREGREPORT");
		}
	}

	public ActionForward CATEGORYWISEREPORT(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3) throws Exception
	{
		System.out.println("DFFFFFFF" + arg0.findForward("CATEGORYWISEREPORT"));
		String reportMode = arg2.getParameter("reportMode");
		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return arg0.findForward("CATEGORYWISEREPORTVIEW");
		}
		else
		{
			return arg0.findForward("CATEGORYWISEREPORT");
		}
	}
	
	public ActionForward DIAGNOSISSTATLOCATIONWISEREPORT(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3) throws Exception
	{
		//System.out.println("DFFFFFFF" + arg0.findForward("CATEGORYWISEREPORT"));
		String reportMode = arg2.getParameter("reportMode");
		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return arg0.findForward("DIAGNOSISSTATLOCATIONWISEREPORTVIEW");
		}
		else
		{
			return arg0.findForward("DIAGNOSISSTATLOCATIONWISEREPORT");
		}
	}
	
	
	public ActionForward DEPTUNITROOMCONSULTANTTIMINGREPORT(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3) throws Exception
	{
		//System.out.println("DFFFFFFF" + arg0.findForward("CATEGORYWISEREPORT"));
		String reportMode = arg2.getParameter("reportMode");
		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return arg0.findForward("DEPTUNITROOMCONSULTANTTIMINGREPORTVIEW");
		}
		else
		{
			return arg0.findForward("DEPTUNITROOMCONSULTANTTIMINGREPORT");
		}
	}
	
	
	public ActionForward DISASTERDATERANGEWISEREPORT(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3) throws Exception
	{
		//System.out.println("DFFFFFFF" + arg0.findForward("CATEGORYWISEREPORT"));
		String reportMode = arg2.getParameter("reportMode");
		if (reportMode != null && (reportMode.equalsIgnoreCase("TEXT") || reportMode.equalsIgnoreCase("GRAPH")))
		{
			return arg0.findForward("DISASTERDATERANGEWISEREPORTVIEW");
		}
		else
		{
			return arg0.findForward("DISASTERDATERANGEWISEREPORT");
		}
	}
	
	
	public ActionForward CANCEL(ActionMapping arg0, ActionForm arg1, HttpServletRequest arg2, HttpServletResponse arg3) throws Exception
	{
		return arg0.findForward("CANCEL");
	}

}
