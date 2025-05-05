package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import javax.servlet.http.HttpServletRequest;


import mms.MmsConfigUtil;
import mms.transactions.bo.LotsDetailTransBO;
import mms.transactions.controller.fb.LotsDetailTransFB;

import mms.transactions.vo.LotsDetailTransVO;


public class LotsDetailTransDATA {

	public static void initialAdd(LotsDetailTransFB formBean,
			HttpServletRequest request) {

		LotsDetailTransVO vo = null;
		LotsDetailTransBO bo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		String temp="";
		String strTemp1[]=null;
		String strCondemnTypeVals="";
		try {
				bo = new LotsDetailTransBO();
				vo = new LotsDetailTransVO();
	
				hisutil = new HisUtil("Lots Details Transaction",
				"LotsDetailTransDATA");
		
				String ctDate = hisutil.getASDate("dd-MMM-yyyy");
				
				formBean.setStrCtDate(ctDate);
				
				strTemp1=request.getParameter("comboName").replace('^', '#').split("#");
				String path = "/mms"+request.getParameter("cnt_page")+".cnt";
				
				formBean.setStrPath(path);
				formBean.setCnt_page(request.getParameter("cnt_page"));
				formBean.setStrStoreId(request.getParameterValues("combo")[0]);
				formBean.setStrItemCategoryNo(request.getParameterValues("combo")[1]);
				formBean.setComboName(request.getParameter("comboName"));
				formBean.setStrStoreName(strTemp1[0]);
				formBean.setStrItemCategoryName(strTemp1[1]);
				formBean.setCombo(request.getParameterValues("combo"));
				vo.setStrStoreId(formBean.getStrStoreId());
				vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
				vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				
				bo.initAdd(vo);
				if(vo.getStrMsgType().equals("1")){
					throw new Exception(vo.getStrMsgString());
				}
				temp = hisutil.getOptionValue(vo.getGroupWS(), "0",
						"0^Select Value", false);
				formBean.setStrGroupValues(temp);
				strCondemnTypeVals= hisutil.getOptionValue(vo.getWsCondemnType(), "0",
						"0^Select Value", false);
				formBean.setStrCondemnTypeVals(strCondemnTypeVals);
				
				
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "LotsDetailTransDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"LotsDetailTransDATA->initialAdd()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}
	
	
	public static void cancelLots(LotsDetailTransFB formBean,
			HttpServletRequest request) {

		LotsDetailTransVO vo = null;
		LotsDetailTransBO bo = null;
		String strmsgText = "";
		String strTemp1[]=null;
		String strChk="";
		try {
				bo = new LotsDetailTransBO();
				vo = new LotsDetailTransVO();
				strChk=request.getParameter("chk");
				strTemp1=strChk.replace('@', '#').split("#");
				vo.setStrStoreId(request.getParameterValues("combo")[0]);
				vo.setStrItemCategoryNo(request.getParameterValues("combo")[1]);
				vo.setStrAgendaNo(strTemp1[1]);
				//vo.setStrItemId(strTemp1[2]);
				//vo.setStrItemBrandId(strTemp1[3]);
				vo.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrRemarks(request.getParameter("cancelRemarks"));
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				bo.cancelLots(vo);
				if(vo.getStrMsgType().equals("1")){
					throw new Exception(vo.getStrMsgString());
				}
					
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "LotsDetailTransDATA.cancelLots(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"LotsDetailTransDATA->cancelLots()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			
		}

	}


	public static void insert(LotsDetailTransFB formBean,
			HttpServletRequest request) {

		LotsDetailTransVO vo = null;
		LotsDetailTransBO bo = null;
		String strmsgText = "";
		MmsConfigUtil mcu = null;
		
		try {
			bo = new LotsDetailTransBO();
			formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			mcu = new MmsConfigUtil(formBean.getStrHospCode());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo = (LotsDetailTransVO) TransferObjectFactory.populateData("mms.transactions.vo.LotsDetailTransVO", formBean);
			
			vo.setStrFinStartDate(mcu.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospCode()));
			vo.setStrFinEndDate(mcu.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospCode()));
			
			bo.insert(vo);
			if(vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			else
			{
				formBean.setStrMsg("Record is successfully Saved");
			}
					
		} catch (Exception e) {
			strmsgText = "LotsDetailTransDATA.insert(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"LotsDetailTransDATA->initialAdd()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
			+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			
		}

	}
	
}
