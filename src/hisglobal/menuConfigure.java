package hisglobal;

public class menuConfigure
{

	private String plusImage = "../hisglobal/images/pl_small.gif"; // //For Plus Image in Menu Frame
	private String minusImage = "../hisglobal/images/mi_small.gif"; // For Minus Image in Menu Frame
	private String topMenuColor = "#005B88"; // Font color of Top Level Menu
	private String topMenuFontSize = "1"; // Font Size of Top Level Menu
	private String topMenuFont = "Arial";// Font face of Leaf Menu
	private String leafMenuColor = "#005B88";// Font color of Leaf Menu
	private String leafMenuFontSize = "1";// Font Size of Leaf Menu
	private String leafMenuFont = "Arial"; // Font face of Leaf Menu
	private String menuPageBackColor = "#FFEBD5"; // Menu Page Back Color EBEBEB
	private String highLightColor = "#800080"; // 009B00"; // Color which is to be highlighted
	//private String headerImage = "../hisglobal/images/Final20.jpg"; // Header Image		//old image
	//private String headerNewImage = "../hisglobal/images/Final21.jpg"; // Header Image	//old image
	private String headerImage = "../hisglobal/images/GeneralHeader.png";
	private String headerNewImage = "../hisglobal/images/GeneralHeader.png";
	private String initPageImage = "../hisglobal/images/cdac1.psd.gif"; // InitPage back ground Image
	private String rightFrameBackImage = "../../hisglobal/images/cdac1.psd.gif"; // back ground image to be used in
	// transaction in right frame

	private String sessionExpired = "10"; // time in seconds after which session will bw expired
	private String refreshTime = "200"; // time in seconds after which header page will be refereshed

	// /////Getter
	public String getHeaderImage()
	{
		return this.headerImage;
	}

	public String getHeaderNewImage()
	{
		return this.headerNewImage;
	}

	public String getLeafMenuColor()
	{
		return this.leafMenuColor;
	}

	public String getLeafMenuFontSize()
	{
		return this.leafMenuFontSize;
	}

	public String getMenuPageBackColor()
	{
		return this.menuPageBackColor;
	}

	public String getHighLightColor()
	{
		return this.highLightColor;
	}

	public String getMinusImage()
	{
		return this.minusImage;
	}

	public String getPlusImage()
	{
		return this.plusImage;
	}

	public String getTopMenuColor()
	{
		return this.topMenuColor;
	}

	public String getTopMenuFont()
	{
		return this.topMenuFont;
	}

	public String getLeafMenuFont()
	{
		return this.leafMenuFont;
	}

	public String getInitPageImage()
	{
		return this.initPageImage;
	}

	public String getRightFrameBackImage()
	{
		return this.rightFrameBackImage;
	}

	public String getTopMenuFontSize()
	{
		return this.topMenuFontSize;
	}

	public String getSessionExpired()
	{
		return this.sessionExpired;
	}

	public String getRefreshTime()
	{
		return this.refreshTime;
	}

}
