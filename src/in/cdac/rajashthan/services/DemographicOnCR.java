package in.cdac.rajashthan.services;

import in.cdac.rajashthan.bo.PatientDemoGraphicDataSet;
import in.cdac.rajashthan.dao.PatientDemoGraphicDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path(value="/PatientDemographic/{CR}")
public class DemographicOnCR {
    @GET
    @Produces(value={"text/xml", "application/xml"})
    public PatientDemoGraphicDataSet getPatientDemoGraphicData(@PathParam(value="CR") String CR) {
        return PatientDemoGraphicDAO.getPatientDemoGraphicData((String)CR);
    }
}
