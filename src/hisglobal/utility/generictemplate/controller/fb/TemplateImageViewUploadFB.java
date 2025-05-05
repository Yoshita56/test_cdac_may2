package hisglobal.utility.generictemplate.controller.fb;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class TemplateImageViewUploadFB extends ActionForm
{
	private FormFile uploadImageName;
	private String transactionMode;
	private String row;
	private String col;
	private String extension;

	public String getTransactionMode()
	{
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode)
	{
		this.transactionMode = transactionMode;
	}

	public FormFile getUploadImageName()
	{
		return uploadImageName;
	}

	public void setUploadImageName(FormFile uploadImageName)
	{
		this.uploadImageName = uploadImageName;
	}

	public String getRow()
	{
		return row;
	}

	public void setRow(String row)
	{
		this.row = row;
	}

	public String getCol()
	{
		return col;
	}

	public void setCol(String col)
	{
		this.col = col;
	}

	public String getExtension()
	{
		return extension;
	}

	public void setExtension(String extension)
	{
		this.extension = extension;
	}
}
