package in.cdac.rajashthan.services;

import in.cdac.rajashthan.bo.NewCountDataSet;
import in.cdac.rajashthan.dao.DailyTransactionsCountDAO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path(value="/hisTransactionCount/{serviceId}")
public class DailyTransactionsCount {
    @GET
    @Produces(value={"text/xml", "application/xml"})
    public NewCountDataSet getCount(@PathParam(value="serviceId") String strServiceID) {
        return DailyTransactionsCountDAO.getCount((String)strServiceID);
    }
}