package in.cdac.rajashthan.services;

import in.cdac.rajashthan.bo.PatientDataSet;
import in.cdac.rajashthan.dao.DailyPatientListDAO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path(value="/hisDailyPatientList/{serviceId}")
 //@Path(value="/hisDailyPatientList/{serviceId}/{fromTime}/{toTime}")
public class DailyPatientList {
    @GET
    @Produces(value={"application/json", "application/json"})
    public String getList(@PathParam(value="serviceId") String strServiceID) {
    return DailyPatientListDAO.getPatientVisitData((String)strServiceID); 
  //Rajshthan 
   // public PatientDataSet getList(@PathParam(value="serviceId") String strServiceID,@PathParam(value="fromTime") String fromTime,@PathParam(value="toTime") String toTime) {
   // return DailyPatientListDAO.getPatientVisitData((String)strServiceID,(String)fromTime,(String)toTime);
    }
}