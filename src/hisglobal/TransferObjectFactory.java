package hisglobal;

import hisglobal.ClassData;

import java.lang.reflect.Method;
import java.util.HashMap;
//import java.lang.reflect.*;

/**
* The factory class that populates the data and returns the object in which data has been
* transfered.
*/
public class TransferObjectFactory {

	/**
	* Use a HashMap to cache class information for
	* Transfer Object classes
	*/
	private static HashMap <String,ClassData>classDataInfo = new HashMap<String,ClassData>();

	/**
	* 
	*/
	public static Object populateData(String clsName, Object objName) {
		
		ClassData voCData = null;
		
		//java.lang.reflect.Field[] voFields = null;
		java.lang.reflect.Method[] voFields = null;
		
		java.lang.Object voObj = null;
		//java.lang.reflect.Field beanField = null;
		java.lang.reflect.Method beanField = null;
		java.lang.Class clsFormBean = null;
		
		String voFieldName = "";
		boolean retVal = true;
		
		//
		Class[] cls = null;
		try {
			// Get the class data for the complete Transfer Object type 
	  		voCData = getClassData (clsName); 
			voFields = voCData.arrFields;		//field name
				
			//get class for form bean
			clsFormBean = objName.getClass();
				
			//create an instance of VO to be returened after populating the data
			voObj = Class.forName(clsName).newInstance();
						
	  		// copy the common fields from the complete TO to the fields of the requested TO
	  		for (int i = 0; i < voFields.length; i++) {
				
				retVal = true;				
				voFieldName = voFields[i].getName();
				//System.out.println("voFieldName = " + voFieldName);
				
				if(voFieldName.startsWith("set")) {
				
					voFieldName = "get" + voFieldName.substring(3);
					//System.out.println("voFieldName = " + voFieldName);
					
					try {
						//beanField = clsFormBean.getDeclaredField(voFieldName);
						//cls = voFields[i].getParameterTypes();
						beanField = clsFormBean.getDeclaredMethod(voFieldName,cls);
						//System.out.println("beanField = " + beanField.getName());
					}
					catch(Exception e) {
						retVal = false;
					}
		
					if(retVal) {
						//voFields[i].set(voObj,beanField.get(objName));
						Object[] arg = null;
						Object ret = beanField.invoke(objName,arg);
						
						voFields[i].invoke(voObj,ret);
					}
				}
	  		}
		}
		catch (Exception e) { 
			System.out.println("e :: " + e);
			voObj = null;
		}
		finally {
			voCData = null;
			voFields = null;
			beanField = null;
			clsFormBean = null;
		}
		
		return voObj;
	}

	
	/**
	 * This function will not create an object. It just copies the contents of objName into beanObj
	 * @param beanObj
	 * @param objName
	 */	
	public static void populateData(Object beanObj, Object objName) {
		
		java.lang.reflect.Method[] voFields = null;
		
		java.lang.reflect.Method beanField = null;
		java.lang.Class clsFormBean = null;
		
		String voFieldName = "";
		boolean retVal = true;
		
		//
		Class[] cls = null;
		try {
			// Get the list of methods
			voFields = (beanObj.getClass()).getDeclaredMethods();
				
			//get class for form bean
			clsFormBean = objName.getClass();
		
	  		// copy the common fields from the complete TO to the fields of the requested TO
	  		for (int i = 0; i < voFields.length; i++) {
				
				retVal = true;				
				voFieldName = voFields[i].getName();
				//System.out.println("voFieldName = " + voFieldName);
				
				if(voFieldName.startsWith("set")) {
				
					voFieldName = "get" + voFieldName.substring(3);
					//System.out.println("voFieldName = " + voFieldName);
					
					try {
						//beanField = clsFormBean.getDeclaredField(voFieldName);
						//cls = voFields[i].getParameterTypes();
						beanField = clsFormBean.getDeclaredMethod(voFieldName,cls);
						//System.out.println("beanField = " + beanField.getName());
					}
					catch(Exception e) {
						retVal = false;
					}
		
					if(retVal) {
						//voFields[i].set(voObj,beanField.get(objName));
						Object[] arg = null;
						Object ret = beanField.invoke(objName,arg);
						
						voFields[i].invoke(beanObj,ret);
					}
				}
	  		}
		}
		catch (Exception e) { 
			//System.out.println("e :: " + e);
		}
		finally {
			voFields = null;
			beanField = null;
			clsFormBean = null;
		}
		
		//return voObj;
	}

	/**
	* Return a ClassData object that contains the 
	* information needed to create
	* a Transfer Object for the given class. This information
	* is only obtained from the
	* class using reflection once, after that it will be 
	* obtained from the classDataInfo HashMap.
	*/
	private static ClassData getClassData(String className) {

		ClassData cData = (ClassData)classDataInfo.get(className);

		try {

			if (cData == null) {
				// Get the class of the given object and the Transfer Object to be created
			  	java.lang.Class voClass = Class.forName(className);
				
			  	Method[] arrMethods = voClass.getDeclaredMethods();
				
			  	// Determine the fields that must be copied  
				//java.lang.reflect.Field[] arrFields = voClass.getDeclaredFields();
		  	
				//cData = new ClassData(voClass, arrFields);
				cData = new ClassData(voClass, arrMethods);
			  
			  	//put into hash map
			  	classDataInfo.put(className, cData);
			}
		}
		catch (Exception e) {
			System.out.println("Exception : " + e);
			// handle exceptions here...
		}
	
		return cData;
	}

}

/**
* Inner Class that contains class data for the
* Transfer Object classes
*/
class ClassData {
	
	// Transfer Object Class
  	public Class    clsTransferObject;

  	// Transfer Object fields
  	//public java.lang.reflect.Field[] arrFields;
  	public java.lang.reflect.Method[] arrFields;

  	// Constructor
  	/*
  	public ClassData(Class cls,java.lang.reflect.Field[] fields) {
    	clsTransferObject = cls;
    	arrFields = fields;
  	}
  	*/
  	public ClassData(Class cls,java.lang.reflect.Method[] methods) {
    	clsTransferObject = cls;
    	arrFields = methods;
  	}
}