package in.cdac.rajashthan.services;

import in.cdac.rajashthan.bo.ImageRetrievalDataSet;
import in.cdac.rajashthan.dao.ImageRetrievalDAO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

 //@Path(value="/hisImageRetrievalUtil/{CRNo}/{EID}/{SLNo}/{HospC}")
 @Path(value="/hisImageRetrievalUtil/{EID}/{SLNo}/{HospC}")

public class ImageRetrievalUtil {
    @GET
    @Produces(value={"application/json", "application/json"})
  
    public ImageRetrievalDataSet getList(@PathParam(value="EID") String eid,@PathParam(value="SLNo") String sln,@PathParam(value="HospC") String hospCode) {
    return ImageRetrievalDAO.getImageData((String) eid,(String) sln,(String)hospCode);
    }
}