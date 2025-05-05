package hisglobal.vo;

import hisglobal.utility.Entry;

import java.util.List;

public class TemplateRepresentationClass extends ValueObject {
	private String htmlObjectName;
	private String htmlObjectValue;
	private List<Entry> options;
	private int rowNo;
	private int colNo;
	private int colspan = 1;
	private int rowspan = 1;
	private String htmlObjectType;
	private String idc;
	private String classString;
	private String width;
	private String align;
	private String isHidden;
	private String name;//used in case of mandatory dtl
	private String value;
	public String getName() {
		return name;
	}

	public void setName(String mandatoryName) {
		this.name = mandatoryName;
	}

	public String getIsHidden() {
		return isHidden;
	}

	public void setIsHidden(String isHidden) {
		this.isHidden = isHidden;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getClassString() {
		return classString;
	}

	public void setClassString(String classString) {
		this.classString = classString;
	}

	public String getIdc() {
		return idc;
	}

	public void setIdc(String idc) {
		this.idc = idc;
	}

	public String getHtmlObjectName() {
		return htmlObjectName;
	}

	public void setHtmlObjectName(String htmlObjectName) {
		this.htmlObjectName = htmlObjectName;
	}

	public String getHtmlObjectValue() {
		return htmlObjectValue;
	}

	public void setHtmlObjectValue(String htmlObjectValue) {
		this.htmlObjectValue = htmlObjectValue;
	}

	public int getRowNo() {
		return rowNo;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}

	public int getColNo() {
		return colNo;
	}

	public void setColNo(int colNo) {
		this.colNo = colNo;
	}

	public String getHtmlObjectType() {
		return htmlObjectType;
	}

	public void setHtmlObjectType(String htmlObjectType) {
		this.htmlObjectType = htmlObjectType;
	}

	public TemplateRepresentationClass(String htmlObjectName, int rowNo,
			int colNo, String htmlObjectType) {
		super();
		this.htmlObjectName = htmlObjectName;
		this.rowNo = rowNo;
		this.colNo = colNo;
		this.htmlObjectType = htmlObjectType;
	}

	public TemplateRepresentationClass() {
		// TODO Auto-generated constructor stub
	}

	public List<Entry> getOptions() {
		return options;
	}

	public void setOptions(List<Entry> options) {
		this.options = options;
	}

	public int getColspan() {
		return colspan;
	}

	public void setColspan(int colspan) {
		this.colspan = colspan;
	}

	public int getRowspan() {
		return rowspan;
	}

	public void setRowspan(int rowspan) {
		this.rowspan = rowspan;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
