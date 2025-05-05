package in.cdac.rajashthan.services;

import in.cdac.rajashthan.bo.NewDataSet;
import in.cdac.rajashthan.dao.CreateDrugStockDao;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path(value="/drugStockDetails/{locationCode}")
public class DrugStockService {
    @GET
    @Produces(value={"text/xml", "application/xml"})
    public NewDataSet getStockDtls(@PathParam(value="locationCode") String strStoreId) {
        return CreateDrugStockDao.getStockDtls((String)strStoreId);
    }
}