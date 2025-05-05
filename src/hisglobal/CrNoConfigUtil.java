package hisglobal;

import org.apache.jcs.JCS;
import org.apache.jcs.access.exception.CacheException;

public class CrNoConfigUtil {

	private static JCS cacheCrNoVOJCS ;	 	
	@SuppressWarnings("unused")
	private String strHospitalCode = "";	
	private CrNoVO vObj = null;
	
	private String directorateCode="";  
	
	private String strValue=""; 
	
	public CrNoConfigUtil(String hospitalCode)  
	{
		this.strHospitalCode = hospitalCode;		
		try
		{			
			if(cacheCrNoVOJCS == null)
			{				
				cacheCrNoVOJCS = JCS.getInstance( "cacheCrNoVO" );
				System.out.println("cache inside");
			}
							
			if(cacheCrNoVOJCS.get(hospitalCode) == null )
			{				
				cacheCrNoVOJCS.put( hospitalCode, new CrNoVO(hospitalCode) );
				System.out.println("cache not exists");
			}
			
			vObj = (CrNoVO) cacheCrNoVOJCS.get(hospitalCode);
			System.out.println("getStrdirectorateCode:: "+vObj.getStrdirectorateCode());
			System.out.println("getHospitalCode:: "+vObj.getHospitalCode());
		} 
		catch (CacheException e1)
		{
			e1.printStackTrace();
		}
	}
	
	public String getDirectorateCode() {
		return vObj.getStrdirectorateCode();
	}

	public String getStrValue() {
		return vObj.getHospitalCode();
	}

}
