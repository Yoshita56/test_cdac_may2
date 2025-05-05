package hisglobal.backutil;

/*
Developed By          : Partha P Chattaraj
Creation Dated        : 17-06-2006
Modification Dated    : 07-05-2008
Version               : HIMS 2.0

*/


import hisglobal.backutil.dto.DataTransferObject;
import hisglobal.backutil.exception.EstateException;
import hisglobal.backutil.exception.GlobalException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
public class HelperMethods {

	//private final static String mstQuery = "accounts.paybill.global.pay_resource_mst";
	public final static int DD_MON_YYYY = 1;
	public final static int DD_MM_YYYY = 2;
	private static ResourceBundle mstRes = null;
	public static ResourceBundle trnRes = null;

	public static String getQuery(int index,String qryIndex,String mstQuery) throws GlobalException
	{

		String qry = null;
		try
		{
			switch(index) {
				case 1: //for Master prcoess only 
					if(mstRes == null) mstRes = ResourceBundle.getBundle(mstQuery);
					//System.out.println("mstRes=="+mstRes);
					qry = mstRes.getString(qryIndex);
					//System.out.println("Masters 1 "+qry);
					break;
				case 2: // for Transaction process only
					if(trnRes == null) trnRes = ResourceBundle.getBundle(mstQuery);
					//System.out.println("trnRes=="+trnRes);
					qry = trnRes.getString(qryIndex);
					//System.out.println("Transactions 2 "+qry);
					break;
				case 3:

				break;
			}
		}
		catch(Exception e)
		{
			throw new GlobalException("hisglobal.backutil.Helpermethods.getQuery()::"+e.getMessage());
		}
		if(qry==null)
			throw new GlobalException("hisglobal.backutil.Helpermethods.getQuery()::Query Not Uploaded");

		return qry;
	}


	public  static void populate(Object obj1, Object obj2) throws GlobalException
	{//data from object2 is populated into obj1
		//getter of object2 is called
		//setter of object1 is called

			Class cls2 = obj2.getClass();

			Method[] cls2Methods = cls2.getMethods();

			HashMap mpGettersInCls2 = new HashMap();
			for(int i=0; i<cls2Methods.length; i++)
			{
				if(cls2Methods[i].getName().indexOf("get")==0)
				{//if the method name starts with set
					mpGettersInCls2.put(cls2Methods[i].getName().substring(3), new Integer(i));
				}
			}

			Class cls1 = obj1.getClass();
			Method[] cls1Methods = cls1.getMethods();

			try
			{
				for(int i=0; i<cls1Methods.length; i++){
				if(cls1Methods[i].getName().indexOf("set")==0)
				{//if the method name starts with set
					if(mpGettersInCls2.containsKey(cls1Methods[i].getName().substring(3)))
					{
						int idx = ((Integer)mpGettersInCls2.get(cls1Methods[i].getName().substring(3))).intValue();
						Object str = cls2Methods[idx].invoke(obj2, null);
						cls1Methods[i].invoke(obj1, new Object[]{str});
					}
				}
			}
			}catch(Exception e){
				throw new GlobalException("hisglobal.backutil.Helpermethods.populate()::"+e.getMessage());
			}
			System.out.println("after populate ");
		}

	public  static void populateDTOfrmRS(DataTransferObject _dto, ResultSet _rs)throws GlobalException
	{
		System.out.println("rs");
		//data from object2 is populated into obj1
		//getString of RS is called for a col.
		//setter of VO is called for the corresponding data member...
		// Map keeps the mapping
		try{
			Class cls = _dto.getClass();
			Method[] clsMethods = cls.getMethods();
			System.out.println("INSIDE populateDTOfrmRS Common OUT ");
			ResultSetMetaData rsMetaData = _rs.getMetaData();
			int rsCols = rsMetaData.getColumnCount();

			while(_rs.next())
			{
				for(int i=1; i<=rsCols; i++){
				String strColLabel = rsMetaData.getColumnLabel(i);
				//System.out.println("strColLabel:  "+strColLabel);

				String strColVal = _rs.getString(rsMetaData.getColumnName(i));
				char[] arrCh = strColLabel.toCharArray();
				arrCh[0] = Character.toUpperCase(arrCh[0]);
				String strMethodName = new String(arrCh);
				strMethodName = "set"+strMethodName;
				int j;
				for(j=0; j<clsMethods.length; j++){
					if(clsMethods[j].getName().equalsIgnoreCase(strMethodName))
					{//if the method name starts with set
						clsMethods[j].invoke(_dto, new Object[]{strColVal});
						break;
					}

				}
				if(j>clsMethods.length)
					throw new GlobalException("HelperMethods.populateDTOfrmRS(): No setter for "+strMethodName);
			}



			}
		}
		catch(Exception e){
			throw new GlobalException("hisglobal.backutil.Helpermethods.populateDTOfrmRS()"+e.getMessage());
		}
	}


	public  static DataTransferObject[] populateDTOfrmRS(Class _dtoClass, ResultSet _rs) throws Exception
	{
		//System.out.println("inside populateVOfrmRS======");

		//data from object2 is populated into obj1
		//getString of RS is called for a col.
		//setter of VO is called for the corresponding data member...
		// Map keeps the mapping
		//System.out.println("Class _voClass :: "+_voClass);
		if(_dtoClass.getSuperclass() != DataTransferObject.class)
			throw new GlobalException("hisglobal.backutil.HelperMethods.populateDTOfrmRS():  illegal argument Exception");

		ArrayList alVO = new ArrayList();
		try{
			Class cls = _dtoClass;
			Method[] clsMethods = cls.getMethods();
			ResultSetMetaData rsMetaData = _rs.getMetaData();
			int rsCols = rsMetaData.getColumnCount();


			for(int rsCounter = 0; _rs.next(); rsCounter++)
			{
				DataTransferObject _dto = (DataTransferObject) cls.newInstance();
				for(int i=1; i<=rsCols; i++){

					String strColLabel = rsMetaData.getColumnLabel(i);

					String strColVal = _rs.getString(rsMetaData.getColumnName(i));

					char[] arrCh = strColLabel.toCharArray();
					arrCh[0] = Character.toUpperCase(arrCh[0]);

					String strMethodName = new String(arrCh);
					strMethodName = "set"+strMethodName;

					int j;
					for(j=0; j<clsMethods.length; j++){


						if(clsMethods[j].getName().equalsIgnoreCase(strMethodName)){//if the method name starts with set
							clsMethods[j].invoke(_dto, new Object[]{strColVal});

							break;
						}
					}
					if(j>clsMethods.length)
						throw new GlobalException("hisglobal.backutil.HelperMethods.populateDTOfrmRS(): No setter for "+strMethodName);

					}

				alVO.add(_dto);

			}
		}catch(Exception e){
			throw new GlobalException("hisglobal.backutil.Helpermethods.populateDTOfrmRS::"+e);
		}


		if(alVO.size()<=0)
			return null;

		DataTransferObject[] arr = new DataTransferObject[alVO.size()];
		for(int i=0; i<alVO.size(); i++)
			arr[i]=(DataTransferObject)alVO.get(i);


		return arr;
	}



	public static synchronized String getSysDate(int format) throws GlobalException
	{
		try
		{
			String dateStr = null;
			HisMethods his = new HisMethods();
			String query="";
			switch(format)
			{
			case 1:
				query = "SELECT TO_CHAR(SYSDATE,'DD-MON-YYYY') FROM DUAL";
				break;
			case 2:
				query = "SELECT TO_CHAR(SYSDATE,'DD-MM-YYYY') FROM DUAL";
				break;
			case 3:
			    query = "SELECT TO_CHAR(SYSDATE,'YYMMDD') FROM DUAL";
			    break;
			case 4:
				query = "SELECT TO_CHAR(SYSDATE,'DDMMYY') FROM DUAL";
			    break; 
			case 5:
			    query = "SELECT TO_CHAR(SYSDATE,'HH:MM:SS') FROM DUAL";
			    break; 
			case 6:
			    query = "SELECT TO_CHAR(SYSDATE,'DD') FROM DUAL";
				break;
			case 7:
			    query = "SELECT TO_CHAR(SYSDATE,'MMYY') FROM DUAL";
				break;
			case 8:
			     query = "SELECT TO_CHAR(SYSDATE,'MM') FROM DUAL";
				 break;
			default:
				query = "SELECT TO_CHAR(SYSDATE,'DD-MON-YYYY') FROM DUAL";
				break;

			}
			HisResultSet result = his.getRecord(query);
		 	if(result.next())
		 	{
				dateStr = result.getString(1);
		 	}
			return dateStr;
		}
		catch(Exception e)
		{
			throw new GlobalException("hisglobal.backutil.HisMethods.getSysDate():"+e.getMessage());
		}

	}

	public static String storeImageInFileSystem(byte[] _imageArr,String _fileName,String _newFileName,String _storagePath) throws FileNotFoundException,IOException{
		System.out.println("inside storeImageInFileSystem");
		FileOutputStream fos=null;
		  System.out.println("_fileName:::::::::"+_fileName);
			File file=new File(_storagePath);
			String filePath=_storagePath+"\\"+_newFileName;
			 if(!file.exists()){
				 if(file.mkdir())
				 {
					 File file1=new File(_storagePath+"\\"+_newFileName);
					 fos=new FileOutputStream(file1);
					 fos.write(_imageArr);
					 System.out.println("after writing to file first time");
				 }
			 }
			 else
			 {
				 File file1=new File(_storagePath+"\\"+_newFileName);
				 fos=new FileOutputStream(file1);
				 fos.write(_imageArr);
				 System.out.println("after writing to file");
			 }
		try
		{
			fos.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception while closing");
		}
		return filePath;
	}//end of method processimage

	public static  byte[] getByteArrayOfImage(String _fileNameWithPath)throws IOException,FileNotFoundException{
		byte[] readBytes = null;
		FileInputStream  fos=new FileInputStream(_fileNameWithPath);
	    readBytes=new byte[fos.available()];
		fos.read(readBytes);
		return readBytes;
}


	public  static void populateDTOfrmRSEachRow(DataTransferObject _dto, ResultSet _rs)throws EstateException
	{
		System.out.println("rs");
		//data from object2 is populated into obj1
		//getString of RS is called for a col.
		//setter of VO is called for the corresponding data member...
		// Map keeps the mapping
		try{
			Class cls = _dto.getClass();
			Method[] clsMethods = cls.getMethods();
			//List alMethods = Arrays.asList(clsMethods);

			ResultSetMetaData rsMetaData = _rs.getMetaData();
			int rsCols = rsMetaData.getColumnCount();
			//System.out.println("rsCols"+rsCols);


				//System.out.println("inside rs.next()=====");
				for(int i=1; i<=rsCols; i++){

				String strColLabel = rsMetaData.getColumnLabel(i);
				//System.out.println("strColLabel:  "+strColLabel);

				String strColVal = _rs.getString(rsMetaData.getColumnName(i));
				//System.out.println("strColVal:  "+strColVal);
				char[] arrCh = strColLabel.toCharArray();
				arrCh[0] = Character.toUpperCase(arrCh[0]);
				//System.out.println("strColLabel:  "+strColLabel);

				String strMethodName = new String(arrCh);
				strMethodName = "set"+strMethodName;
				//System.out.println("strMethodName:  "+strMethodName);

				int j;
				for(j=0; j<clsMethods.length; j++){
					//System.out.println("clsMethods[i].getName():  "+clsMethods[j].getName()+"   strMethodName:   "+strMethodName);

					if(clsMethods[j].getName().equalsIgnoreCase(strMethodName)){//if the method name starts with set
						clsMethods[j].invoke(_dto, new Object[]{strColVal});
						break;
					}

				}
				if(j>clsMethods.length)
					throw new EstateException("HelperMethods.populateDTOfrmRS(): No setter for "+strMethodName);
			}




		}catch(Exception e){
			throw new EstateException("estate.global.Helpermethods.populateDTOfrmRS()"+e.getMessage());
		}
	}



}
