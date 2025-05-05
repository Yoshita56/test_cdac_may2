package in.cdac.rajashthan.services;

import in.cdac.rajashthan.dao.IssuetoPatListDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path(value="/hisIssuetoPatientList/")
//@Path(value="/hisDailyPatientList/{serviceId}/{fromTime}/{toTime}")

public class IssuetoPatList {

	    @GET
	    @Produces(value={"application/json", "application/json"})
	    public String getList(@QueryParam(value="serviceId") String strServiceID,@QueryParam(value="crNo") String strCRNo) {
	    return IssuetoPatListDAO.getPatientIssueData((String)strServiceID,(String)strCRNo); 
	  //Rajshthan 
	   // public PatientDataSet getList(@PathParam(value="serviceId") String strServiceID,@PathParam(value="fromTime") String fromTime,@PathParam(value="toTime") String toTime) {
	   // return DailyPatientListDAO.getPatientVisitData((String)strServiceID,(String)fromTime,(String)toTime);
	    }

}
