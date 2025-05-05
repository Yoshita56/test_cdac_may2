package mms.transactions.controller.data;


import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.upload.FormFile;

import mms.AttachFileGlobal;
import mms.MmsConfigUtil;
import mms.transactions.bo.CondemnationRegisterTransBO;
import mms.transactions.controller.fb.CondemnationRegisterTransFB;
import mms.transactions.controller.hlp.CondemnRegisterTransHLP;
import mms.transactions.vo.CondemnationRegisterTransVO;


public class CondemnationRegisterTransDATA {

	public static void initialAdd(CondemnationRegisterTransFB formBean,
			HttpServletRequest request) {

		CondemnationRegisterTransVO vo = null;
		CondemnationRegisterTransBO bo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		String temp="";
		String strTemp1[]=null;
		try {
				bo = new CondemnationRegisterTransBO();
				vo = new CondemnationRegisterTransVO();
	
				hisutil = new HisUtil("mms", "CondemnationRegisterTransDATA");
				String ctDate = hisutil.getASDate("dd-MMM-yyyy");
				hisutil = new HisUtil("Condemnation Register Transaction",
				"CondemnationRegisterTransDATA");
		
				formBean.setStrCtDate(ctDate);
				String chk=request.getParameter("chk");
				String strTemp[]=chk.replace('@', '#').split("#");
				strTemp1=request.getParameter("comboName").replace('^', '#').split("#");
				String path = "/mms"+request.getParameter("cnt_page")+".cnt";
				
				formBean.setStrPath(path);
				formBean.setCnt_page(request.getParameter("cnt_page"));
				formBean.setStrStoreId(request.getParameterValues("combo")[0]);
				formBean.setStrItemCategoryNo(request.getParameterValues("combo")[1]);
				formBean.setChk(chk);
				formBean.setStrAgendaNo(strTemp[0]);
				formBean.setStrAgendaDate(strTemp[2]);
				formBean.setStrCondemnationType(strTemp[1]);
				formBean.setComboName(request.getParameter("comboName"));
				formBean.setStrStoreName(strTemp1[0]);
				formBean.setStrItemCategoryName(strTemp1[1]);
				formBean.setCombo(request.getParameterValues("combo"));
				vo.setStrAgendaNo(formBean.getStrAgendaNo());
				vo.setStrStoreId(formBean.getStrStoreId());
				vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
				vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrCondemnationType(formBean.getStrCondemnationType());
				
				bo.initAdd(vo);
				if(vo.getStrMsgType().equals("1")){
					throw new Exception(vo.getStrMsgString());
				}
				
				temp = hisutil.getOptionValue(vo.getCommitteTypeWS(), "0",
						"0^Select Value", false);
				formBean.setStrCommitteTypeValue(temp);
				temp = hisutil.getOptionValue(vo.getBuyerDtlWS(), "0",
						"0^Select Value", false);
				formBean.setStrBuyerListValues(temp);
				formBean.setStrItemDetailsValue(CondemnRegisterTransHLP.getItemDetails(vo.getItemDtlWS()));
				formBean.setStrCondemnationTypeName(vo.getStrCondemnTypeName());
			} catch (Exception e) {
			strmsgText = "CondemnationRegisterTransDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"CondemnationRegisterTransDATA->initialAdd()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}

	public static void insert(CondemnationRegisterTransFB formBean,
			HttpServletRequest request) {

		CondemnationRegisterTransVO vo = null;
		CondemnationRegisterTransBO bo = null;
		String strmsgText = "";
		MmsConfigUtil mcu = null;
		HisUtil hisutil=null;
		String strFileExt="";
		String []temp=null;
		AttachFileGlobal fs=null;
	//	String filePath="";
		try {
				mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				
				hisutil = new HisUtil("mms", "CondemnationRegisterTransDATA");
				String strCtDate = hisutil.getASDate("dd-MMM-yyyy");
				fs=new AttachFileGlobal();
				
				bo = new CondemnationRegisterTransBO();
				formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				vo = (CondemnationRegisterTransVO) TransferObjectFactory.populateData("mms.transactions.vo.CondemnationRegisterTransVO", formBean);
				vo.setStrCtDate(strCtDate);
				vo.setStrFileNo(formBean.getStrFileNo());
				vo.setStrPageNo(formBean.getStrPageNo());
				FormFile myFile = formBean.getStrLocation();
				strFileExt=myFile.getFileName();
				temp=strFileExt.replace('.', '#').split("#");
				
				strFileExt=temp[temp.length-1];
				vo.setStrFileExt(strFileExt);
				vo.setStrFinStartDate(mcu.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospCode()));
				vo.setStrFinStartEndDate(mcu.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospCode()));
				bo.insert(vo);
				if(vo.getStrMsgType().equals("1"))
				{
					throw new Exception(vo.getStrMsgString());
				}
				else
				{
		//			filePath=mcu.getStrCommitteeFilePath();
					formBean.setStrResult("1");
					formBean.setStrMsg("Record is successfully Saved");
					fs.saveFile(myFile.getFileData(), vo.getStrFileName()); 
				}
					
		} catch (Exception e) {
			
			formBean.setStrResult("0");
			strmsgText = "CondemnationRegisterTransDATA.insert(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"CondemnationRegisterTransDATA->insert()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
			+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			
		}

	}
	public static void getMemberDtl(CondemnationRegisterTransFB _CondemnationRegisterTransFB,HttpServletRequest request,HttpServletResponse response)
	{
		 String strmsgText = "";
		 CondemnationRegisterTransBO bo = null;
		CondemnationRegisterTransVO vo = null;
		String result="";
		try
		{
			
			vo=new CondemnationRegisterTransVO();
			bo=new CondemnationRegisterTransBO();
			vo.setStrCommitteType(request.getParameter("committeType"));
			vo.setStrItemCategoryNo(request.getParameter("itemCategNo"));
			vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			bo.getMemberDetails(vo);
			_CondemnationRegisterTransFB.setCommitteMemberWS(vo.getCommitteMemberWS());
			result=CondemnRegisterTransHLP.createMemberDetails(_CondemnationRegisterTransFB);
			if(vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			response.getWriter().print(result);
			
		}
		catch(Exception e)
		{
			strmsgText = "SampleRegisterTransDATA.getMemberDtl() --> "
				+ e.getMessage();
			HisException eObj = new HisException("MMS", "CondemnationRegisterTransDATA->getMemberDtl()", strmsgText);
		    String response1 = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator!";
		    try
		    {
		    	response.getWriter().print(response1);
		    	eObj=null;
		    }
		    catch(Exception e1)
		    {
		    	
		    }

		}
	}

}
