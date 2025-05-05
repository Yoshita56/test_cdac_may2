package hisglobal.utility.generictemplate.controller.action;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import hisglobal.presentation.Status;
import hisglobal.presentation.WebUTIL;
import hisglobal.utility.generictemplate.GenericTemplateConfig;
import hisglobal.utility.generictemplate.TemplateDesignerUtility;
import hisglobal.utility.generictemplate.controller.fb.TemplateImageViewUploadFB;
import hisglobal.utility.servlets.ServletsUtilityConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

public class TemplateImageViewUploadACTION extends DispatchAction
{
	public ActionForward unspecified(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
	{
		return this.NEW(mapping,form,request,response);		
	}	
	
	public ActionForward NEW(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
	{		
	    Status objStatus=new Status();
	    objStatus.add(Status.NEW);
		WebUTIL.setStatus(request,objStatus);	    
	 	return mapping.findForward("NEW");
	}
	
	public ActionForward SAVE(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
	{
		TemplateImageViewUploadFB fb=(TemplateImageViewUploadFB)form;
		Status objStatus=new Status();
		FormFile myfile=fb.getUploadImageName();
		byte[] fileDataAsByte=null;
		
		HttpSession session = request.getSession();
		
		try
		{
			fileDataAsByte = myfile.getFileData();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Map<String, byte[]> mpImageViewUploadedImageFilesData = null;
		
		if(session.getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_IMAGEVIEW_UPLOADED_IMAGE_FILE_DATA_MAP)==null)
		{
			mpImageViewUploadedImageFilesData = new HashMap<String, byte[]>();
		}
		else
		{
			mpImageViewUploadedImageFilesData = (Map<String, byte[]>)session.getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_IMAGEVIEW_UPLOADED_IMAGE_FILE_DATA_MAP);
		}
		String key = fb.getRow() + TemplateDesignerUtility.SEP_IMAGEVIEW_KEY_ROW_COL + fb.getCol();
		
		mpImageViewUploadedImageFilesData.put(key, fileDataAsByte);
			
		WebUTIL.setAttributeInSession(request,GenericTemplateConfig.GENERIC_TEMPLATE_IMAGEVIEW_UPLOADED_IMAGE_FILE_DATA_MAP, mpImageViewUploadedImageFilesData);
		
		objStatus.add(Status.DONE);
		WebUTIL.setStatus(request,objStatus);
		return mapping.findForward("NEW");
	}

	public ActionForward VIEW(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
	{
		TemplateImageViewUploadFB fb=(TemplateImageViewUploadFB)form;
		Status objStatus=new Status();
		HttpSession session = request.getSession();
		
		if(session.getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_IMAGEVIEW_UPLOADED_IMAGE_FILE_DATA_MAP)==null)
		{			
			objStatus.add(Status.UNSUCESSFULL,"No Image Found","");
		}
		else
		{
			Map<String, byte[]> mpImageViewUploadedImageFilesData = null;
			mpImageViewUploadedImageFilesData = (Map<String, byte[]>)session.getAttribute(GenericTemplateConfig.GENERIC_TEMPLATE_IMAGEVIEW_UPLOADED_IMAGE_FILE_DATA_MAP);
			
			String key = fb.getRow() + TemplateDesignerUtility.SEP_IMAGEVIEW_KEY_ROW_COL + fb.getCol();
			
			WebUTIL.setAttributeInSession(request,ServletsUtilityConfig.SERVLET_DISPLAY_BYTE_ARRAY, mpImageViewUploadedImageFilesData.get(key));
			WebUTIL.setAttributeInSession(request,ServletsUtilityConfig.SERVLET_DISPLAY_BYTE_ARRAY_CONTENT_TYPE, "image/jpg");

			objStatus.add(Status.DONE);
		}
		WebUTIL.setStatus(request, objStatus);
		return mapping.findForward("SHOW");
	}
}
