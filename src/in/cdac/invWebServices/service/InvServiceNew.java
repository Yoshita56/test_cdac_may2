package in.cdac.invWebServices.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/care-context")
public class InvServiceNew
{
        
        String error="Error Message:: ";
    
    @POST
    @Path("/link-unsynced")	
    @Consumes("application/json")
    @Produces({ "application/json" })
        public String link_unsynced(String strJson) throws Exception {
              //  JsonObject jsonResponse = new JsonObject();
                System.out.println("StrJson: "+strJson);
//                return jsonResponse.toString();
				return strJson;
        }
    }