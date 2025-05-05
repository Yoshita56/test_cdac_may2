package hisglobal.utility.generictemplate;

import hisglobal.hisconfig.Config;
import hisglobal.utility.HisHTMLParserUtil;
import hisglobal.utility.generictemplate.GenericTemplateUtility.TempParameter;
import hisglobal.utility.servlets.ServletsUtilityConfig;
import hisglobal.vo.ParameterRangeMasterVO;
import hisglobal.vo.TemplateParameterMasterVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.Tag;
import org.htmlparser.Text;
import org.htmlparser.lexer.Lexer;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.scanners.Scanner;
import org.htmlparser.tags.Div;
import org.htmlparser.tags.InputTag;
import org.htmlparser.tags.OptionTag;
import org.htmlparser.tags.SelectTag;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.tags.TextareaTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.visitors.NodeVisitor;

/**
 * @copyright CDAC
 * @developer Pragya Sharma
 */

public class TemplateDesignerUtility 
{
	public static class Template
	{
		private String templateId;
		private int templateType;
		private int rowCount;
		private int colCount;
		private Cell[][] cellArray;	// cellArray - >Matrix or Array of Arrays of Cells
		protected Map<String, ParameterRangeMasterVO> mapRange;
		private String genderType;
		
		private Template(){}
		
		public static Template getTemplate(String _tempId, String _tempType, List<TemplateParameterMasterVO> _lstTempParaVO, Map<String , ParameterRangeMasterVO> _mapParaRange, InformationControlBean _infoBean, String _genderType)
		{
			Template temp =  new Template();
			temp.templateId = _tempId;
			temp.templateType = Integer.parseInt(_tempType);
			temp.mapRange = _mapParaRange;
			temp.genderType = _genderType;
			int rows=0;
			int cols=0;
			for(TemplateParameterMasterVO vo:_lstTempParaVO)
			{
				if(rows<Integer.parseInt(vo.getRow())) rows=Integer.parseInt(vo.getRow());
				if(cols<(Integer.parseInt(vo.getCol()) + Integer.parseInt(vo.getColspan())-1) ) cols=Integer.parseInt(vo.getCol())+Integer.parseInt(vo.getColspan())-1;
			}
			temp.rowCount = rows;
			temp.colCount = cols;
			
			// Setting Cell Array
			temp.cellArray = new Cell[temp.rowCount][temp.colCount];
			for(int i=0;i<temp.rowCount;i++)
				for(int j=0;j<temp.colCount;j++)
					temp.cellArray[i][j] = new Cell(i+1,j+1,temp);
			for(TemplateParameterMasterVO vo:_lstTempParaVO)
			{
				int r=Integer.parseInt(vo.getRow());
				int c=Integer.parseInt(vo.getCol());
				Parameter p=null;
				if(vo.getControlType().equals(Integer.toString(CONTROL_TYPES_INFORMATION)))
					p = new Parameter(vo, _genderType, _infoBean);
				else
					p = new Parameter(vo, _genderType);
				temp.cellArray[r-1][c-1].parameter = p;
				temp.cellArray[r-1][c-1].haveParameter = YES_NO_FLAG_YES;
				for(int i=1;i<p.getColspan();i++)
					temp.cellArray[r-1][c-1+i].isVisible = YES_NO_FLAG_NO;
			}			
			return temp;
		}
		
		public static Template getTemplate(String _tempId, String _tempType, List<TemplateParameterMasterVO> _lstTempParaVO, Map<String , ParameterRangeMasterVO> _mapParaRange, InformationControlBean _infoBean, String _genderType, Map<String, String> _mapParaValues)
		{
			Template temp =  new Template();
			temp.templateId = _tempId;
			temp.templateType = Integer.parseInt(_tempType);
			temp.mapRange = _mapParaRange;
			temp.genderType = _genderType;
			int rows=0;
			int cols=0;
			for(TemplateParameterMasterVO vo:_lstTempParaVO)
			{
				if(rows<Integer.parseInt(vo.getRow())) rows=Integer.parseInt(vo.getRow());
				if(cols<(Integer.parseInt(vo.getCol()) + Integer.parseInt(vo.getColspan())-1) ) cols=Integer.parseInt(vo.getCol())+Integer.parseInt(vo.getColspan())-1;
			}
			temp.rowCount = rows;
			temp.colCount = cols;
			
			// Setting Cell Array
			temp.cellArray = new Cell[temp.rowCount][temp.colCount];
			for(int i=0;i<temp.rowCount;i++)
				for(int j=0;j<temp.colCount;j++)
					temp.cellArray[i][j] = new Cell(i+1,j+1,temp);
			for(TemplateParameterMasterVO vo:_lstTempParaVO)
			{
				int r=Integer.parseInt(vo.getRow());
				int c=Integer.parseInt(vo.getCol());
				String paraValue = _mapParaValues.get(vo.getParaId());
				Parameter p;
				if(vo.getControlType().equals(Integer.toString(CONTROL_TYPES_INFORMATION)))
					p = new Parameter(vo, _genderType, _infoBean);
				else if(paraValue!=null)
					p = new Parameter(vo, _genderType, paraValue);
				else
					p = new Parameter(vo, _genderType);
				temp.cellArray[r-1][c-1].parameter = p;
				temp.cellArray[r-1][c-1].haveParameter = YES_NO_FLAG_YES;
				for(int i=1;i<p.getColspan();i++)
					temp.cellArray[r-1][c-1+i].isVisible = YES_NO_FLAG_NO;
			}			
			return temp;
		}

		public String generateTemplate() throws Exception
		{
			NodeList lst =  new NodeList();
			TableTag tbl = new TableTag();
			tbl.setAttribute("width","100%");
			tbl.setAttribute("border","0");
			tbl.setAttribute("cellpadding","0");
			tbl.setAttribute("cellspacing","1");			
				
			for(int i=0; i<this.rowCount; i++)
			{
				TableRow tr = new TableRow();
				HisHTMLParserUtil.setParent(tr,tbl);
				for(int j=0; j<this.colCount; j++)
				{
					Cell cell = this.cellArray[i][j];			
					if( cell.isVisible == YES_NO_FLAG_YES)
					{
						cell.create(tr);
					}
				}
			}
			Scanner scanner = tbl.getThisScanner();
			Lexer lex = new Lexer();			
			scanner.scan(tbl,lex, lst);
			lst.add(tbl);		
			return lst.toHtml()+"<script>setAllPARAMETERDesignTimeSetting();</script>";
		}
		
		public String generateTemplateView(String _viewMode) throws Exception
		{
			String temp = null;
			if(_viewMode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_SHORT_SUMMARIZED_REPORT))
			{
				StringBuffer strBuff = new StringBuffer();
				strBuff.append("<div align='left'>");
				for(int i=0; i<this.rowCount; i++)
				{
					for(int j=0; j<this.colCount; j++)
					{
						Cell cell = this.cellArray[i][j];			
						if( cell.isVisible == YES_NO_FLAG_YES)
						{
							strBuff.append(cell.createView(new TableRow(), _viewMode));
						}
					}
				}
				strBuff.append("</div>");
				temp = strBuff.toString();
			}
			else
			{
				NodeList lst =  new NodeList();
				TableTag tbl = new TableTag();
				tbl.setAttribute("width","100%");
				tbl.setAttribute("border","0");
				tbl.setAttribute("cellpadding","0");
				tbl.setAttribute("cellspacing","1");			
				for(int i=0; i<this.rowCount; i++)
				{
					TableRow tr = new TableRow();
					HisHTMLParserUtil.setParent(tr,tbl);
					for(int j=0; j<this.colCount; j++)
					{
						Cell cell = this.cellArray[i][j];			
						if( cell.isVisible == YES_NO_FLAG_YES)
						{
							cell.createView(tr, _viewMode);
						}
					}
				}
				Scanner scanner = tbl.getThisScanner();
				Lexer lex = new Lexer();			
				scanner.scan(tbl,lex, lst);
				lst.add(tbl);		
				temp = lst.toHtml();
			}
			return temp;
		}

		public int getRowCount()
		{
			return rowCount;
		}
		public void setRowCount(int rowCount)
		{
			this.rowCount = rowCount;
		}
		public int getColCount()
		{
			return colCount;
		}
		public void setColCount(int colCount)
		{
			this.colCount = colCount;
		}
		public Cell[][] getCellArray()
		{
			return cellArray;
		}
		public void setCellArray(Cell[][] cellArray)
		{
			this.cellArray = cellArray;
		}

		public String getTemplateId()
		{
			return templateId;
		}

		public void setTemplateId(String templateId)
		{
			this.templateId = templateId;
		}

		public int getTemplateType()
		{
			return templateType;
		}

		public void setTemplateType(int templateType)
		{
			this.templateType = templateType;
		}

		public String getGenderType()
		{
			return genderType;
		}

		public void setGenderType(String genderType)
		{
			this.genderType = genderType;
		}		
	}

	public static class Cell
	{
		private Template objTemplate;
		private int row;
		private int col;
		private boolean isVisible;
		private boolean haveParameter;
		private Parameter parameter;
		
		public Cell(int r, int c, Template t)
		{
			this.objTemplate = t;
			this.row = r;
			this.col = c;
			this.isVisible = YES_NO_FLAG_YES;
			this.haveParameter = YES_NO_FLAG_NO;
			this.parameter = null;
		}
		
		public void create(Tag _parent) throws Exception
		{
			if( this.isVisible == YES_NO_FLAG_YES )
			{
				if(this.haveParameter == YES_NO_FLAG_NO)
					this.createEmptyCell(_parent);
				else if(this.parameter!=null)
					this.createParaTempWise(_parent);
			}
		}
		
		public void createEmptyCell(Tag _parent) throws Exception
		{
			TableColumn mainTd = new TableColumn();
			HisHTMLParserUtil.setParent(mainTd,_parent);
			mainTd.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
			mainTd.setAttribute("align","center");
			mainTd.setAttribute("valign","top");
			mainTd.setAttribute("colspan","1");
			mainTd.setAttribute("width",(100/this.objTemplate.colCount)+"%");
			mainTd.setAttribute("height","100%");
			mainTd.setAttribute("class","tdfont");
		}

		public void createParaTempWise(Tag _parent) throws Exception
		{
			TableColumn td;
			String al;
			switch(this.objTemplate.templateType)
			{
				case TEMPLATE_TYPE_NORMAL:
					switch(this.parameter.controlType)
					{
						case CONTROL_TYPES_LABEL:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createLabel(td);
							break;
						case CONTROL_TYPES_COMMENT:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createComment(td);
							break;
						case CONTROL_TYPES_TEXTBOX:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							al = this.parameter.align;
							this.parameter.align = ALIGN_RIGHT;
							this.parameter.colspan = 1;
							this.createLabel(td);					
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.parameter.align = ALIGN_LEFT;
							this.createTextBox(td);
							this.parameter.align = al;
							this.parameter.colspan = 2;
							break;
						case CONTROL_TYPES_TEXTAREA:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							al = this.parameter.align;
							this.parameter.align = ALIGN_RIGHT;
							this.parameter.colspan = 1;
							this.createLabel(td);					
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.parameter.align = ALIGN_LEFT;
							this.createTextArea(td);
							this.parameter.align = al;
							this.parameter.colspan = 2;
							break;
						case CONTROL_TYPES_COMBO:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							al = this.parameter.align;
							this.parameter.align = ALIGN_RIGHT;
							this.parameter.colspan = 1;
							this.createLabel(td);					
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.parameter.align = ALIGN_LEFT;
							this.createCombo(td);
							this.parameter.align = al;
							this.parameter.colspan = 2;
							break;
						case CONTROL_TYPES_RADIO:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							al = this.parameter.align;
							this.parameter.align = ALIGN_RIGHT;
							this.parameter.colspan = 1;
							this.createLabel(td);					
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.parameter.align = ALIGN_LEFT;
							this.createRadio(td);
							this.parameter.align = al;
							this.parameter.colspan = 2;
							break;
						case CONTROL_TYPES_YESNO:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							al = this.parameter.align;
							this.parameter.align = ALIGN_RIGHT;
							this.parameter.colspan = 1;
							this.createLabel(td);					
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.parameter.align = ALIGN_LEFT;
							this.createYesNo(td);
							this.parameter.align = al;
							this.parameter.colspan = 2;
							break;
						case CONTROL_TYPES_CHECKBOX:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							al = this.parameter.align;
							this.parameter.align = ALIGN_RIGHT;
							this.parameter.colspan = 1;
							this.createLabel(td);					
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.parameter.align = ALIGN_LEFT;
							this.createCheckBox(td);
							this.parameter.align = al;
							this.parameter.colspan = 2;
							break;
						case CONTROL_TYPES_FORMULATED:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							al = this.parameter.align;
							this.parameter.align = ALIGN_RIGHT;
							this.parameter.colspan = 1;
							this.createLabel(td);					
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.parameter.align = ALIGN_LEFT;
							this.createFormulated(td);
							this.parameter.align = al;
							this.parameter.colspan = 2;
							break;
						case CONTROL_TYPES_INFORMATION:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createInformation(td);
							break;
						case CONTROL_TYPES_DURATION:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							al = this.parameter.align;
							this.parameter.align = ALIGN_RIGHT;
							this.parameter.colspan = 1;
							this.createLabel(td);					
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.parameter.align = ALIGN_LEFT;
							this.createDuration(td);
							this.parameter.align = al;
							this.parameter.colspan = 2;
							break;
						case CONTROL_TYPES_DATE:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							al = this.parameter.align;
							this.parameter.align = ALIGN_RIGHT;
							this.parameter.colspan = 1;
							this.createLabel(td);					
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.parameter.align = ALIGN_LEFT;
							this.createDate(td);
							this.parameter.align = al;
							this.parameter.colspan = 2;
							break;
						case CONTROL_TYPES_TIME:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							al = this.parameter.align;
							this.parameter.align = ALIGN_RIGHT;
							this.parameter.colspan = 1;
							this.createLabel(td);					
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.parameter.align = ALIGN_LEFT;
							this.createTime(td);
							this.parameter.align = al;
							this.parameter.colspan = 2;
							break;
						case CONTROL_TYPES_IMAGEVIEW:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createImageView(td);
							break;
					}		
					break;

				case TEMPLATE_TYPE_MATRIX:
					switch(this.parameter.controlType)
					{
						case CONTROL_TYPES_LABEL:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createLabel(td);
							break;
						case CONTROL_TYPES_COMMENT:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createComment(td);
							break;
						case CONTROL_TYPES_TEXTBOX:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createTextBox(td);
							break;
						case CONTROL_TYPES_TEXTAREA:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createTextArea(td);
							break;
						case CONTROL_TYPES_COMBO:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createCombo(td);
							break;
						case CONTROL_TYPES_RADIO:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createRadio(td);
							break;
						case CONTROL_TYPES_YESNO:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createYesNo(td);
							break;
						case CONTROL_TYPES_CHECKBOX:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createCheckBox(td);
							break;
						case CONTROL_TYPES_FORMULATED:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createFormulated(td);
							break;
						case CONTROL_TYPES_INFORMATION:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createInformation(td);
							break;
						case CONTROL_TYPES_DURATION:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createDuration(td);
							break;
						case CONTROL_TYPES_DATE:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createDate(td);
							break;
						case CONTROL_TYPES_TIME:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createTime(td);
							break;
						case CONTROL_TYPES_IMAGEVIEW:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createImageView(td);
							break;
					}		
					break;
					
				case TEMPLATE_TYPE_CONSENT:
					switch(this.parameter.controlType)
					{
						case CONTROL_TYPES_LABEL:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createLabel(td);
							break;
						case CONTROL_TYPES_COMMENT:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createComment(td);
							break;
						case CONTROL_TYPES_TEXTBOX:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createTextBox(td);
							break;
						case CONTROL_TYPES_TEXTAREA:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createTextArea(td);
							break;
						case CONTROL_TYPES_COMBO:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createCombo(td);
							break;
						case CONTROL_TYPES_RADIO:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createRadio(td);
							break;
						case CONTROL_TYPES_YESNO:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createYesNo(td);
							break;
						case CONTROL_TYPES_CHECKBOX:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createCheckBox(td);
							break;
						case CONTROL_TYPES_FORMULATED:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createFormulated(td);
							break;
						case CONTROL_TYPES_INFORMATION:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createInformation(td);
							break;
						case CONTROL_TYPES_DURATION:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createDuration(td);
							break;
						case CONTROL_TYPES_DATE:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createDate(td);
							break;
						case CONTROL_TYPES_TIME:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createTime(td);
							break;
						case CONTROL_TYPES_IMAGEVIEW:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createImageView(td);
							break;
					}
					break;
					
				case TEMPLATE_TYPE_GUIDELINE:
					switch(this.parameter.controlType)
					{
						case CONTROL_TYPES_COMMENT:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createComment(td);
							break;
						case CONTROL_TYPES_IMAGEVIEW:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.createImageView(td);
							break;
					}		
					break;		
			}
		}
		
		// Creating Label
		public void createLabel(TableColumn _parent) throws Exception
		{
			_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
			_parent.setAttribute("align","center");
			_parent.setAttribute("valign","top");
			_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
			_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
			_parent.setAttribute("height","100%");
			_parent.setAttribute("class","tdfonthead");

			String h="<div id='"+LABEL_DIV_STARTS_WITH+this.parameter.paraId+"' align='"+this.parameter.align+"' ";	
			if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_HIDDEN)) 
				h+=" style='display:none;' ";
			h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";

			if(this.parameter.bold==TRUE_FALSE_True)h+="<b>";
			if(this.parameter.italic==TRUE_FALSE_True)h+="<i>";
			if(this.parameter.underlined==TRUE_FALSE_True)h+="<u>";
			h+="<font color='"+this.parameter.color+"' size='"+this.parameter.fontsize+"'";
			if(this.parameter.language.equalsIgnoreCase(LANGUAGE_HINDI))	h+=" face='"+LANGUAGE_HINDI_FONT+"'";
			h+=">"+TemplateDesignerUtility.convertSpace(this.parameter.displayValue)+"</font>";
			if(this.parameter.underlined==TRUE_FALSE_True)h+="</u>";
			if(this.parameter.italic==TRUE_FALSE_True)h+="</i>";
			if(this.parameter.bold==TRUE_FALSE_True)h+="</b>";
			h+="</font></div>";
			Parser parser = new Parser(h);
			NodeList list = parser.parse(null);
			_parent.setChildren(list);
		}
		
		// Creating Comment
		public void createComment(TableColumn _parent) throws Exception
		{
			_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
			_parent.setAttribute("align","center");
			_parent.setAttribute("valign","top");
			_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
			_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
			_parent.setAttribute("height","100%");
			_parent.setAttribute("class","tdfonthead");

			String h="<div align='"+this.parameter.align+"' ";	
			if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_HIDDEN)) 
				h+=" style='display:none;' ";
			h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";

			if(this.parameter.bold==TRUE_FALSE_True)h+="<b>";
			if(this.parameter.italic==TRUE_FALSE_True)h+="<i>";
			if(this.parameter.underlined==TRUE_FALSE_True)h+="<u>";
			h+="<font color='"+this.parameter.color+"' size='"+this.parameter.fontsize+"'";
			if(this.parameter.language.equalsIgnoreCase(LANGUAGE_HINDI))	h+=" face='"+LANGUAGE_HINDI_FONT+"'";
			h+=">"+TemplateDesignerUtility.convertSpace(this.parameter.displayValue)+"</font>";
			if(this.parameter.underlined==TRUE_FALSE_True)h+="</u>";
			if(this.parameter.italic==TRUE_FALSE_True)h+="</i>";
			if(this.parameter.bold==TRUE_FALSE_True)h+="</b>";
			h+="</font></div>";
			Parser parser = new Parser(h);
			NodeList list = parser.parse(null);
			_parent.setChildren(list);
		}
		
		// Creating Text Box
		public void createTextBox(TableColumn _parent) throws Exception
		{
			_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
			_parent.setAttribute("align","center");
			_parent.setAttribute("valign","top");
			_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
			_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
			_parent.setAttribute("height","100%");
			_parent.setAttribute("class","tdfont");

			String name = PARAMETER_INITIAL_NAME + this.parameter.paraId + SEP_IN_PARA_NAMEID_TEMPID + this.parameter.paraParent + SEP_IN_PARA_NAMEID_TEMPID + this.objTemplate.templateId;
			
			String h="<div align='"+this.parameter.align+"' ";	
			if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_HIDDEN)) 
				h+=" style='display:none;' ";
			h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";

			h+="<input type='text' tabindex='1' name='"+name+"' ";
			h+="id='C:"+this.parameter.isCompulsory+"&R:"+this.parameter.isRange+"&G:"+this.parameter.genderType+"' ";
			h+="maxlength='"+this.parameter.maxlength+"' value='"+this.parameter.defaultValue+"' ";
			if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_DISABLED) 
					|| this.parameter.genderType.equalsIgnoreCase(GENDER_TYPES_PRESENTATION_DISABLED)) 
				h+="disabled='disabled' ";
			h+="size='"+this.parameter.size+"' onkeypress='return ("+this.parameter.validationFunction+"(this,event) && notSpecChar(this,event))' ";
			if(this.parameter.getHaveDependent().equalsIgnoreCase(YES_NO_VALUE_YES))
			{
				h+="onchange=\"validatePARAMETERDependentFormula(this,event,'"+this.parameter.dependentParaId+"','"+this.parameter.formula+"','"+this.parameter.formulaOutput+"');\" ";
			}
			
			String onblurFunc ="validatePARAMETERRegExp(this,event,'"+this.parameter.format+"','"+this.parameter.regularExpression+"');";
			if(this.parameter.isRange.equalsIgnoreCase(YES_NO_VALUE_YES))
			{
				ParameterRangeMasterVO rngVO = this.objTemplate.mapRange.get(this.parameter.paraId);
				if(rngVO!=null)
				{
					onblurFunc+="validatePARAMETERRange(this,event,'"+rngVO.getLowValue()+"','"+rngVO.getHighValue()+"');";
					h+="onblur=\""+onblurFunc+"\" />";
					h+="<font color='#000000'>("+rngVO.getLowValue()+"-"+rngVO.getHighValue()+")"+rngVO.getUnitOfMeasure()+"</font>";
				}
				else
					h+="onblur=\""+onblurFunc+"\" />";
			}
			else
				h+="onblur=\""+onblurFunc+"\" />";
			h+="</font></div>";
			Parser parser = new Parser(h);
			NodeList list = parser.parse(null);
			_parent.setChildren(list);
		}

		// Creating Text Area
		public void createTextArea(TableColumn _parent) throws Exception
		{
			_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
			_parent.setAttribute("align","center");
			_parent.setAttribute("valign","top");
			_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
			_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
			_parent.setAttribute("height","100%");
			_parent.setAttribute("class","tdfont");

			String name = PARAMETER_INITIAL_NAME + this.parameter.paraId + SEP_IN_PARA_NAMEID_TEMPID + this.parameter.paraParent + SEP_IN_PARA_NAMEID_TEMPID + this.objTemplate.templateId;
			
			String h="<div align='"+this.parameter.align+"' ";	
			if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_HIDDEN)) 
				h+=" style='display:none;' ";
			h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";
			
			h+="<textarea tabindex='1' name='"+name+"' ";
			h+="id='C:"+this.parameter.isCompulsory+"&G:"+this.parameter.genderType+"' ";
			if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_DISABLED) 
					|| this.parameter.genderType.equalsIgnoreCase(GENDER_TYPES_PRESENTATION_DISABLED)) 
				h+="disabled='disabled' ";
			h+="onkeypress='return ("+this.parameter.validationFunction+"(this,event) && notSpecChar(this,event) && validateTextareaLength(this,event,"+this.parameter.maxlength+"))' ";
			h+="rows='"+this.parameter.rowsize+"' cols='"+this.parameter.colsize+"' >"+this.parameter.defaultValue+"</textarea>";
			h+="</font></div>";
			Parser parser = new Parser(h);
			NodeList list = parser.parse(null);
			_parent.setChildren(list);
		}
		
		// Creating Combo
		public void createCombo(TableColumn _parent) throws Exception
		{
			_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
			_parent.setAttribute("align","center");
			_parent.setAttribute("valign","top");
			_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
			_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
			_parent.setAttribute("height","100%");
			_parent.setAttribute("class","tdfont");

			String name = PARAMETER_INITIAL_NAME + this.parameter.paraId + SEP_IN_PARA_NAMEID_TEMPID + this.parameter.paraParent + SEP_IN_PARA_NAMEID_TEMPID + this.objTemplate.templateId;
			
			String h="<div align='"+this.parameter.align+"' ";	
			if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_HIDDEN)) 
				h+=" style='display:none;' ";
			h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";
			
			h+="<select tabindex='1' name='"+name+"' id='C:"+this.parameter.isCompulsory+"&G:"+this.parameter.genderType+"' ";
			h+="onchange=\"setPARAMETERChildPresentation(this,event,'"+this.parameter.childPresentation+"','"+this.parameter.childPresentationOn+"');\" ";
			if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_DISABLED) 
					|| this.parameter.genderType.equalsIgnoreCase(GENDER_TYPES_PRESENTATION_DISABLED)) 
				h+="disabled='disabled' ";
			h+=" >";
			h+="<option value=''>Select Value</option>";
			if(this.parameter.sourceFlag==SOURCE_FLAG_STATIC)
			{
				String[] options=this.parameter.paraOptions.split(SEP_IN_PARA_OPTIONS);
				for(int j=0;j<options.length;j++)
				{
					h+="<option value='"+options[j].split(SEP_IN_PARA_OPTIONS_LABEL_VALUE)[0]+"' ";
					if(options[j].split(SEP_IN_PARA_OPTIONS_LABEL_VALUE)[0].equalsIgnoreCase(this.parameter.defaultValue))
						h+=" selected='true' ";
					h+=">"+options[j].split(SEP_IN_PARA_OPTIONS_LABEL_VALUE)[1]+"</option>";
				}
			}
			else if(this.parameter.sourceFlag==SOURCE_FLAG_DYNAMIC)
			{
				String[] options=this.parameter.tableQuery.split(SEP_IN_PARA_OPTIONS);
				for(int j=0;j<options.length;j++)
				{
					h+="<option value='"+options[j].split(SEP_IN_PARA_OPTIONS_LABEL_VALUE)[0]+"' ";
					if(options[j].split(SEP_IN_PARA_OPTIONS_LABEL_VALUE)[0].equalsIgnoreCase(this.parameter.defaultValue))
						h+=" selected='true' ";
					h+=">"+options[j].split(SEP_IN_PARA_OPTIONS_LABEL_VALUE)[1]+"</option>";
				}				
			}
			h+="</select>";
			h+="</font></div>";
			Parser parser = new Parser(h);
			NodeList list = parser.parse(null);
			_parent.setChildren(list);
		}
		
		// Creating Radio Buttons
		public void createRadio(TableColumn _parent) throws Exception
		{
			_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
			_parent.setAttribute("align","center");
			_parent.setAttribute("valign","top");
			_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
			_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
			_parent.setAttribute("height","100%");
			_parent.setAttribute("class","tdfont");
			_parent.setAttribute("nowrap","nowrap");

			String name = PARAMETER_INITIAL_NAME + this.parameter.paraId + SEP_IN_PARA_NAMEID_TEMPID + this.parameter.paraParent + SEP_IN_PARA_NAMEID_TEMPID + this.objTemplate.templateId;
			
			String h="<div align='"+this.parameter.align+"' ";	
			if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_HIDDEN)) 
				h+=" style='display:none;' ";
			h+="><font color='#000000' size='"+this.parameter.fontsize+"'";
			if(this.parameter.language.equalsIgnoreCase(LANGUAGE_HINDI))	h+=" face='"+LANGUAGE_HINDI_FONT+"'";
			else h+=" face='Verdana, Arial, Helvetica, sans-serif'";
			h+=">";
			
			if(this.parameter.sourceFlag==SOURCE_FLAG_STATIC)
			{
				String[] options = this.parameter.paraOptions.split(SEP_IN_PARA_OPTIONS);
				for(int j=0;j<options.length;j++)
				{
					h+="<input type='radio' tabindex='1' name='"+name+"' ";
					h+="id='C:"+this.parameter.isCompulsory+"&G:"+this.parameter.genderType+"' ";
					h+="onclick=\"setPARAMETERChildPresentation(this,event,'"+this.parameter.childPresentation+"','"+this.parameter.childPresentationOn+"');\" ";
					if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_DISABLED) 
							|| this.parameter.genderType.equalsIgnoreCase(GENDER_TYPES_PRESENTATION_DISABLED)) 
						h+="disabled='disabled' ";
					h+="value='"+options[j].split(SEP_IN_PARA_OPTIONS_LABEL_VALUE)[0]+"' ";
					if(options[j].split(SEP_IN_PARA_OPTIONS_LABEL_VALUE)[0].equalsIgnoreCase(this.parameter.defaultValue))
						h+=" checked='true' ";
					h+="/>"+options[j].split(SEP_IN_PARA_OPTIONS_LABEL_VALUE)[1];
					if((j+1) < options.length) h+="";//<br>";
				}
			}
			else if(this.parameter.sourceFlag==SOURCE_FLAG_DYNAMIC)
			{
				String[] options = this.parameter.tableQuery.split(SEP_IN_PARA_OPTIONS);
				for(int j=0;j<options.length;j++)
				{
					h+="<input type='radio' tabindex='1' name='"+name+"' ";
					h+="id='C:"+this.parameter.isCompulsory+"&G:"+this.parameter.genderType+"' ";
					h+="onclick=\"setPARAMETERChildPresentation(this,event,'"+this.parameter.childPresentation+"','"+this.parameter.childPresentationOn+"');\" ";
					if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_DISABLED) 
							|| this.parameter.genderType.equalsIgnoreCase(GENDER_TYPES_PRESENTATION_DISABLED)) 
						h+="disabled='disabled' ";
					h+="value='"+options[j].split(SEP_IN_PARA_OPTIONS_LABEL_VALUE)[0]+"' ";
					if(options[j].split(SEP_IN_PARA_OPTIONS_LABEL_VALUE)[0].equalsIgnoreCase(this.parameter.defaultValue))
						h+=" checked='true' ";
					h+="/>"+options[j].split(SEP_IN_PARA_OPTIONS_LABEL_VALUE)[1];
					if((j+1) < options.length) h+="";//<br>";
				}
			}
			h+="</font></div>";
			Parser parser = new Parser(h);
			NodeList list = parser.parse(null);
			_parent.setChildren(list);

		}
		
		// Creating YesNo
		public void createYesNo(TableColumn _parent) throws Exception
		{
			_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
			_parent.setAttribute("align","center");
			_parent.setAttribute("valign","top");
			_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
			_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
			_parent.setAttribute("height","100%");
			_parent.setAttribute("class","tdfont");

			String name = PARAMETER_INITIAL_NAME + this.parameter.paraId + SEP_IN_PARA_NAMEID_TEMPID + this.parameter.paraParent + SEP_IN_PARA_NAMEID_TEMPID + this.objTemplate.templateId;
			
			String h="<div align='"+this.parameter.align+"' ";	
			if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_HIDDEN)) 
				h+=" style='display:none;' ";
			h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";
			
			h+="<input type='radio' tabindex='1' name='"+name+"' ";
			h+="id='C:"+this.parameter.isCompulsory+"&G:"+this.parameter.genderType+"' ";
			h+="onclick=\"setPARAMETERChildPresentation(this,event,'"+this.parameter.childPresentation+"','"+this.parameter.childPresentationOn+"');\" ";
			if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_DISABLED) 
					|| this.parameter.genderType.equalsIgnoreCase(GENDER_TYPES_PRESENTATION_DISABLED)) 
				h+="disabled='disabled' ";
			
			if(this.parameter.defaultValue.equalsIgnoreCase("yes"))
				h+="value='yes' checked='true' />Yes";
			else
				h+="value='yes' />Yes";
			h+="<input type='radio' tabindex='1' name='"+name+"' ";
			h+="id='C:"+this.parameter.isCompulsory+"&G:"+this.parameter.genderType+"' ";
			h+="onclick=\"setPARAMETERChildPresentation(this,event,'"+this.parameter.childPresentation+"','"+this.parameter.childPresentationOn+"');\" ";
			if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_DISABLED) 
					|| this.parameter.genderType.equalsIgnoreCase(GENDER_TYPES_PRESENTATION_DISABLED)) 
				h+="disabled='disabled' ";
			if(this.parameter.defaultValue.equalsIgnoreCase("no"))
				h+="value='no' checked='true' />No";
			else
				h+="value='no' />No";
			h+="</font></div>";
			Parser parser = new Parser(h);
			NodeList list = parser.parse(null);
			_parent.setChildren(list);
		}
		
		// Creating CheckBox
		public void createCheckBox(TableColumn _parent) throws Exception
		{
			_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
			_parent.setAttribute("align","center");
			_parent.setAttribute("valign","top");
			_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
			_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
			_parent.setAttribute("height","100%");
			_parent.setAttribute("class","tdfont");

			String name = PARAMETER_INITIAL_NAME + this.parameter.paraId + SEP_IN_PARA_NAMEID_TEMPID + this.parameter.paraParent + SEP_IN_PARA_NAMEID_TEMPID + this.objTemplate.templateId;
			
			String h="<div align='"+this.parameter.align+"' ";	
			if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_HIDDEN)) 
				h+=" style='display:none;' ";
			h+="><font color='#000000' size='"+this.parameter.fontsize+"'";
			if(this.parameter.language.equalsIgnoreCase(LANGUAGE_HINDI))	h+=" face='"+LANGUAGE_HINDI_FONT+"'";
			else h+=" face='Verdana, Arial, Helvetica, sans-serif'";
			h+=">";
			
			if(this.parameter.sourceFlag==SOURCE_FLAG_STATIC)
			{
				String[] options=this.parameter.paraOptions.split(SEP_IN_PARA_OPTIONS_LABEL_VALUE);
				h+="<input type='checkbox' tabindex='1' name='"+name+"' ";
				h+="id='C:"+this.parameter.isCompulsory+"&G:"+this.parameter.genderType+"' ";
				h+="onclick=\"setPARAMETERChildPresentation(this,event,'"+this.parameter.childPresentation+"','"+this.parameter.childPresentationOn+"');\" ";
				if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_DISABLED) 
						|| this.parameter.genderType.equalsIgnoreCase(GENDER_TYPES_PRESENTATION_DISABLED)) 
					h+="disabled='disabled' ";
				h+="value='"+options[0]+"' ";
				if(options[0].equalsIgnoreCase(this.parameter.defaultValue))
					h+=" checked='true' ";	
				h+=" />"+options[1];
			}
			else if(this.parameter.sourceFlag==SOURCE_FLAG_DYNAMIC)
			{
				String[] options=this.parameter.tableQuery.split(SEP_IN_PARA_OPTIONS_LABEL_VALUE);
				h+="<input type='checkbox' tabindex='1' name='"+name+"' ";
				h+="id='C:"+this.parameter.isCompulsory+"&G:"+this.parameter.genderType+"' ";
				h+="onclick=\"setPARAMETERChildPresentation(this,event,'"+this.parameter.childPresentation+"','"+this.parameter.childPresentationOn+"');\" ";
				if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_DISABLED) 
						|| this.parameter.genderType.equalsIgnoreCase(GENDER_TYPES_PRESENTATION_DISABLED)) 
					h+="disabled='disabled' ";
				h+="value='"+options[0]+"' ";
				if(options[0].equalsIgnoreCase(this.parameter.defaultValue))
					h+=" checked='true' ";	
				h+=" />"+options[1];
			}
			h+="</font></div>";
			Parser parser = new Parser(h);
			NodeList list = parser.parse(null);
			_parent.setChildren(list);
		}
		
		// Creating Text Box
		public void createFormulated(TableColumn _parent) throws Exception
		{
			_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
			_parent.setAttribute("align","center");
			_parent.setAttribute("valign","top");
			_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
			_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
			_parent.setAttribute("height","100%");
			_parent.setAttribute("class","tdfont");

			String name = PARAMETER_INITIAL_NAME + this.parameter.paraId + SEP_IN_PARA_NAMEID_TEMPID + this.parameter.paraParent + SEP_IN_PARA_NAMEID_TEMPID + this.objTemplate.templateId;
			
			String h="<div align='"+this.parameter.align+"' ";	
			if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_HIDDEN)) 
				h+=" style='display:none;' ";
			h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";

			h+="<input type='text' tabindex='1' name='"+name+"' id='"+this.parameter.dependentParaId+SEP_VAL_IN_PARA+this.parameter.formula+SEP_VAL_IN_PARA+this.parameter.formulaOutput+"' ";
			h+="value='"+this.parameter.defaultValue+"' size='"+this.parameter.size+"' disabled='disabled' />";
			h+="</font></div>";
			Parser parser = new Parser(h);
			NodeList list = parser.parse(null);
			_parent.setChildren(list);
		}
		
		// Creating Information
		public void createInformation(TableColumn _parent) throws Exception
		{
			_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
			_parent.setAttribute("align","center");
			_parent.setAttribute("valign","top");
			_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
			_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
			_parent.setAttribute("height","100%");
			_parent.setAttribute("class","tdfont");

			String h="<div align='"+this.parameter.align+"' ";	
			if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_HIDDEN)) 
				h+=" style='display:none;' ";
			h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";

			//h+="<b>&nbsp;"+this.parameter.defaultValue+"</b>";
			if(this.parameter.bold==TRUE_FALSE_True)h+="<b>";
			if(this.parameter.italic==TRUE_FALSE_True)h+="<i>";
			if(this.parameter.underlined==TRUE_FALSE_True)h+="<u>";
			h+="<font color='"+this.parameter.color+"' size='"+this.parameter.fontsize+"'";
			if(this.parameter.language.equalsIgnoreCase(LANGUAGE_HINDI))	h+=" face='"+LANGUAGE_HINDI_FONT+"'";
			h+=">"+TemplateDesignerUtility.convertSpace(this.parameter.defaultValue)+"</font>";
			if(this.parameter.underlined==TRUE_FALSE_True)h+="</u>";
			if(this.parameter.italic==TRUE_FALSE_True)h+="</i>";
			if(this.parameter.bold==TRUE_FALSE_True)h+="</b>";
			h+="</font></div>";
			Parser parser = new Parser(h);
			NodeList list = parser.parse(null);
			_parent.setChildren(list);
		}

		// Creating Duration
		public void createDuration(TableColumn _parent) throws Exception
		{
			_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
			_parent.setAttribute("align","center");
			_parent.setAttribute("valign","top");
			_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
			_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
			_parent.setAttribute("height","100%");
			_parent.setAttribute("class","tdfont");
			_parent.setAttribute("noWrap","noWrap");

			String name = PARAMETER_INITIAL_NAME + this.parameter.paraId + SEP_IN_PARA_NAMEID_TEMPID + this.parameter.paraParent + SEP_IN_PARA_NAMEID_TEMPID + this.objTemplate.templateId;
			
			String h="<div align='"+this.parameter.align+"' ";	
			if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_HIDDEN)) 
				h+=" style='display:none;' ";
			h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";

			h+="<input type='hidden' name='"+name+"' ";
			h+="id='C:"+this.parameter.isCompulsory+"&R:"+this.parameter.isRange+"&G:"+this.parameter.genderType+"' ";
			h+="value='"+this.parameter.defaultValue+"' />";

			String defaultValueforCount="", defaultValueforDur="";
			if(!this.parameter.defaultValue.equalsIgnoreCase(""))
			{
				String[] options=this.parameter.paraOptions.split(SEP_IN_PARA_OPTIONS);
				for(int j=0;j<options.length;j++)
				{
					String durVal = options[j].split(SEP_IN_PARA_OPTIONS_LABEL_VALUE)[0];
					if(durVal.equalsIgnoreCase(this.parameter.defaultValue.substring(this.parameter.defaultValue.length()-durVal.length(),this.parameter.defaultValue.length())))
					{
						defaultValueforDur=durVal;
						String countVal = this.parameter.defaultValue.replace(durVal,"");
						defaultValueforCount=countVal.replace(" ","");
						break;
					}
				}
			}
			
			h+="<input type='text' tabindex='1' maxlength='"+this.parameter.maxlength+"' value='"+defaultValueforCount+"' ";
			if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_DISABLED) 
					|| this.parameter.genderType.equalsIgnoreCase(GENDER_TYPES_PRESENTATION_DISABLED)) 
				h+="disabled='disabled' ";
			h+="size='4' onkeypress='return ("+this.parameter.validationFunction+"(this,event) && notSpecChar(this,event))' ";
			h+="onchange=\"validatePARAMETERDuartionValueSet(this,event,'"+this.parameter.paraId+"');\" />";

			h+="<select tabindex='1' ";
			if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_DISABLED) 
					|| this.parameter.genderType.equalsIgnoreCase(GENDER_TYPES_PRESENTATION_DISABLED)) 
				h+="disabled='disabled' ";
			h+="onchange=\"validatePARAMETERDuartionValueSet(this,event,'"+this.parameter.paraId+"');\" >";
			h+="<option value=''>Select</option>";
			String[] options=this.parameter.paraOptions.split(SEP_IN_PARA_OPTIONS);
			for(int j=0;j<options.length;j++)
			{
				h+="<option value='"+options[j].split(SEP_IN_PARA_OPTIONS_LABEL_VALUE)[0]+"' ";
				if(options[j].split(SEP_IN_PARA_OPTIONS_LABEL_VALUE)[0].equalsIgnoreCase(defaultValueforDur))
					h+=" selected='true' ";
				h+=">"+options[j].split(SEP_IN_PARA_OPTIONS_LABEL_VALUE)[1]+"</option>";
			}
			h+="</select>";

			h+="</font></div>";
			Parser parser = new Parser(h);
			NodeList list = parser.parse(null);
			_parent.setChildren(list);
		}

		// Creating Date
		public void createDate(TableColumn _parent) throws Exception
		{
			_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
			_parent.setAttribute("align","center");
			_parent.setAttribute("valign","top");
			_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
			_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
			_parent.setAttribute("height","100%");
			_parent.setAttribute("class","tdfont");

			String name = PARAMETER_INITIAL_NAME + this.parameter.paraId + SEP_IN_PARA_NAMEID_TEMPID + this.parameter.paraParent + SEP_IN_PARA_NAMEID_TEMPID + this.objTemplate.templateId;
			
			String h="<div align='"+this.parameter.align+"' ";	
			if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_HIDDEN)) 
				h+=" style='display:none;' ";
			h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";

			//<html:text name="ANCDeliveryDetailFB" property="birthDate" value="dd-mm-yyyy" tabindex="1" maxlength="10" size="11" onfocus="DateValidator.setupOnFocus(this)"></html:text>

			h+="<input type='text' tabindex='1' name='"+name+"' ";
			h+="id='C:"+this.parameter.isCompulsory+"&R:"+this.parameter.isRange+"&G:"+this.parameter.genderType+"' ";
			h+="maxlength='10' value='"+this.parameter.defaultValue+"' ";
			if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_DISABLED) 
					|| this.parameter.genderType.equalsIgnoreCase(GENDER_TYPES_PRESENTATION_DISABLED)) 
				h+="disabled='disabled' ";
			h+="size='11' onfocus='DateValidator.setupOnFocus(this)' />";
			h+="</font></div>";
			Parser parser = new Parser(h);
			NodeList list = parser.parse(null);
			_parent.setChildren(list);
		}

		// Creating Time
		public void createTime(TableColumn _parent) throws Exception
		{
			_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
			_parent.setAttribute("align","center");
			_parent.setAttribute("valign","top");
			_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
			_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
			_parent.setAttribute("height","100%");
			_parent.setAttribute("class","tdfont");

			String name = PARAMETER_INITIAL_NAME + this.parameter.paraId + SEP_IN_PARA_NAMEID_TEMPID + this.parameter.paraParent + SEP_IN_PARA_NAMEID_TEMPID + this.objTemplate.templateId;
			
			String h="<div align='"+this.parameter.align+"' ";	
			if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_HIDDEN)) 
				h+=" style='display:none;' ";
			h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";

			//<html:text name="ANCDeliveryDetailFB" property="birthTime" value="hh:mm" tabindex="1" maxlength="5" size="6" onfocus="TimeValidator.setupOnFocus(this)"></html:text>						

			h+="<input type='text' tabindex='1' name='"+name+"' ";
			h+="id='C:"+this.parameter.isCompulsory+"&R:"+this.parameter.isRange+"&G:"+this.parameter.genderType+"' ";
			h+="maxlength='5' value='"+this.parameter.defaultValue+"' ";
			if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_DISABLED) 
					|| this.parameter.genderType.equalsIgnoreCase(GENDER_TYPES_PRESENTATION_DISABLED)) 
				h+="disabled='disabled' ";
			h+="size='6' onfocus='TimeValidator.setupOnFocus(this)' />";
			h+="</font></div>";
			Parser parser = new Parser(h);
			NodeList list = parser.parse(null);
			_parent.setChildren(list);
		}

		// Creating Image View
		public void createImageView(TableColumn _parent) throws Exception
		{
			_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
			_parent.setAttribute("align","center");
			_parent.setAttribute("valign","top");
			_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
			_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
			_parent.setAttribute("height","100%");
			_parent.setAttribute("class","tdfont");

			String h="<div align='"+this.parameter.align+"' ";	
			if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_HIDDEN)) 
				h+=" style='display:none;' ";
			h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";

			String path = ServletsUtilityConfig.SERVLET_DISPLAY_FILE_URL + "?" 
			+ ServletsUtilityConfig.FILE_PATH_WINDOWS + "=" + Config.GENERIC_TEMPLATE_HTML_DOCUMENT_FILE_STORAGE_PATH_WINDOWS + "&" 
			+ ServletsUtilityConfig.FILE_PATH_LINUX + "=" + Config.GENERIC_TEMPLATE_HTML_DOCUMENT_FILE_STORAGE_PATH_WINDOWS + "&" 
			+ ServletsUtilityConfig.FILE_NAME + "=" + Config.GENERIC_TEMPLATE_IMAGE_VIEW_FILE_STORAGE_NAME
			+ this.objTemplate.templateId + "_" + this.row + SEP_IMAGEVIEW_KEY_ROW_COL + this.col + this.parameter.defaultValue; 

			h+="<img alt='"+this.parameter.displayValue+"' title='"+this.parameter.displayValue+"' src='"+path+"'>";

			h+="</font></div>";
			Parser parser = new Parser(h);
			NodeList list = parser.parse(null);
			_parent.setChildren(list);
		}

		public int getRow()
		{
			return row;
		}
		public void setRow(int row)
		{
			this.row = row;
		}
		public int getCol()
		{
			return col;
		}
		public void setCol(int col)
		{
			this.col = col;
		}
		public boolean isVisible()
		{
			return isVisible;
		}
		public void setVisible(boolean isVisible)
		{
			this.isVisible = isVisible;
		}
		public boolean isHaveParameter()
		{
			return haveParameter;
		}
		public void setHaveParameter(boolean haveParameter)
		{
			this.haveParameter = haveParameter;
		}
		public Parameter getParameter()
		{
			return this.parameter;
		}
		public void setParameter(Parameter parameter)
		{
			this.parameter = parameter;
		}

		public String createView(Tag _parent, String _viewMode) throws Exception
		{
			String view = "";
			if( this.isVisible == YES_NO_FLAG_YES )
			{
				if(this.haveParameter == YES_NO_FLAG_NO)
					view = this.createEmptyCellView(_parent, _viewMode);
				else if(this.parameter!=null)
					view = this.createParaViewWise(_parent, _viewMode);
			}
			return view;
		}
		
		public String createEmptyCellView(Tag _parent, String _viewMode) throws Exception
		{
			String view = "";
			if(!_viewMode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_SHORT_SUMMARIZED_REPORT))
			{
				TableColumn mainTd = new TableColumn();
				HisHTMLParserUtil.setParent(mainTd,_parent);
				mainTd.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
				mainTd.setAttribute("align","center");
				mainTd.setAttribute("valign","top");
				mainTd.setAttribute("colspan","1");
				mainTd.setAttribute("width",(100/this.objTemplate.colCount)+"%");
				mainTd.setAttribute("height","100%");
				mainTd.setAttribute("class","tdfont");
			}
			return view;
		}

		public String createParaViewWise(Tag _parent, String _viewMode) throws Exception
		{
			String view = "";
			TableColumn td;
			String al;
			switch(this.objTemplate.templateType)
			{
				case TEMPLATE_TYPE_NORMAL:
					switch(this.parameter.controlType)
					{
						case CONTROL_TYPES_LABEL:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createLabelView(td, _viewMode);
							break;
						case CONTROL_TYPES_COMMENT:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createCommentView(td, _viewMode);
							break;
						case CONTROL_TYPES_TEXTBOX:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							al = this.parameter.align;
							this.parameter.align = ALIGN_RIGHT;
							this.parameter.colspan = 1;
							view = this.createLabelView(td, _viewMode);					
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.parameter.align = ALIGN_LEFT;
							view += this.createTextBoxView(td, _viewMode);
							this.parameter.align = al;
							this.parameter.colspan = 2;
							break;
						case CONTROL_TYPES_TEXTAREA:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							al = this.parameter.align;
							this.parameter.align = ALIGN_RIGHT;
							this.parameter.colspan = 1;
							view = this.createLabelView(td, _viewMode);					
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.parameter.align = ALIGN_LEFT;
							view += this.createTextAreaView(td, _viewMode);
							this.parameter.align = al;
							this.parameter.colspan = 2;
							break;
						case CONTROL_TYPES_COMBO:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							al = this.parameter.align;
							this.parameter.align = ALIGN_RIGHT;
							this.parameter.colspan = 1;
							view = this.createLabelView(td, _viewMode);					
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.parameter.align = ALIGN_LEFT;
							view += this.createComboView(td, _viewMode);
							this.parameter.align = al;
							this.parameter.colspan = 2;
							break;
						case CONTROL_TYPES_RADIO:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							al = this.parameter.align;
							this.parameter.align = ALIGN_RIGHT;
							this.parameter.colspan = 1;
							view = this.createLabelView(td, _viewMode);					
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.parameter.align = ALIGN_LEFT;
							view += this.createRadioView(td, _viewMode);
							this.parameter.align = al;
							this.parameter.colspan = 2;
							break;
						case CONTROL_TYPES_YESNO:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							al = this.parameter.align;
							this.parameter.align = ALIGN_RIGHT;
							this.parameter.colspan = 1;
							view = this.createLabelView(td, _viewMode);
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.parameter.align = ALIGN_LEFT;
							view += this.createYesNoView(td, _viewMode);
							this.parameter.align = al;
							this.parameter.colspan = 2;
							break;
						case CONTROL_TYPES_CHECKBOX:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							al = this.parameter.align;
							this.parameter.align = ALIGN_RIGHT;
							this.parameter.colspan = 1;
							view = this.createLabelView(td, _viewMode);					
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.parameter.align = ALIGN_LEFT;
							view += this.createCheckBoxView(td, _viewMode);
							this.parameter.align = al;
							this.parameter.colspan = 2;
							break;
						case CONTROL_TYPES_FORMULATED:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							al = this.parameter.align;
							this.parameter.align = ALIGN_RIGHT;
							this.parameter.colspan = 1;
							view = this.createLabelView(td, _viewMode);					
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.parameter.align = ALIGN_LEFT;
							view += this.createFormulatedView(td, _viewMode);
							this.parameter.align = al;
							this.parameter.colspan = 2;
							break;
						case CONTROL_TYPES_INFORMATION:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createInformationView(td, _viewMode);
							break;
						case CONTROL_TYPES_DURATION:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							al = this.parameter.align;
							this.parameter.align = ALIGN_RIGHT;
							this.parameter.colspan = 1;
							view = this.createLabelView(td, _viewMode);					
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.parameter.align = ALIGN_LEFT;
							view += this.createDurationView(td, _viewMode);
							this.parameter.align = al;
							this.parameter.colspan = 2;
							break;
						case CONTROL_TYPES_DATE:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							al = this.parameter.align;
							this.parameter.align = ALIGN_RIGHT;
							this.parameter.colspan = 1;
							view = this.createLabelView(td, _viewMode);					
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.parameter.align = ALIGN_LEFT;
							view = this.createDateView(td, _viewMode);
							this.parameter.align = al;
							this.parameter.colspan = 2;
							break;
						case CONTROL_TYPES_TIME:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							al = this.parameter.align;
							this.parameter.align = ALIGN_RIGHT;
							this.parameter.colspan = 1;
							view = this.createLabelView(td, _viewMode);					
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							this.parameter.align = ALIGN_LEFT;
							view += this.createTimeView(td, _viewMode);
							this.parameter.align = al;
							this.parameter.colspan = 2;
							break;
						case CONTROL_TYPES_IMAGEVIEW:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createImageViewView(td, _viewMode);
							break;
					}		
					break;

				case TEMPLATE_TYPE_MATRIX:
					switch(this.parameter.controlType)
					{
						case CONTROL_TYPES_LABEL:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createLabelView(td, _viewMode);
							break;
						case CONTROL_TYPES_COMMENT:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createCommentView(td, _viewMode);
							break;
						case CONTROL_TYPES_TEXTBOX:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createTextBoxView(td, _viewMode);
							break;
						case CONTROL_TYPES_TEXTAREA:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createTextAreaView(td, _viewMode);
							break;
						case CONTROL_TYPES_COMBO:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createComboView(td, _viewMode);
							break;
						case CONTROL_TYPES_RADIO:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createRadioView(td, _viewMode);
							break;
						case CONTROL_TYPES_YESNO:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createYesNoView(td, _viewMode);
							break;
						case CONTROL_TYPES_CHECKBOX:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createCheckBoxView(td, _viewMode);
							break;
						case CONTROL_TYPES_FORMULATED:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createFormulatedView(td, _viewMode);
							break;
						case CONTROL_TYPES_INFORMATION:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createInformationView(td, _viewMode);
							break;
						case CONTROL_TYPES_DURATION:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createDurationView(td, _viewMode);
							break;
						case CONTROL_TYPES_DATE:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createDateView(td, _viewMode);
							break;
						case CONTROL_TYPES_TIME:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createTimeView(td, _viewMode);
							break;
						case CONTROL_TYPES_IMAGEVIEW:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createImageViewView(td, _viewMode);
							break;
					}		
					break;
					
				case TEMPLATE_TYPE_CONSENT:
					switch(this.parameter.controlType)
					{
						case CONTROL_TYPES_LABEL:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createLabelView(td, _viewMode);
							break;
						case CONTROL_TYPES_COMMENT:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createCommentView(td, _viewMode);
							break;
						case CONTROL_TYPES_TEXTBOX:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createTextBoxView(td, _viewMode);
							break;
						case CONTROL_TYPES_TEXTAREA:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createTextAreaView(td, _viewMode);
							break;
						case CONTROL_TYPES_COMBO:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createComboView(td, _viewMode);
							break;
						case CONTROL_TYPES_RADIO:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createRadioView(td, _viewMode);
							break;
						case CONTROL_TYPES_YESNO:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createYesNoView(td, _viewMode);
							break;
						case CONTROL_TYPES_CHECKBOX:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createCheckBoxView(td, _viewMode);
							break;
						case CONTROL_TYPES_FORMULATED:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createFormulatedView(td, _viewMode);
							break;
						case CONTROL_TYPES_INFORMATION:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createInformationView(td, _viewMode);
							break;
						case CONTROL_TYPES_DURATION:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createDurationView(td, _viewMode);
							break;
						case CONTROL_TYPES_DATE:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createDateView(td, _viewMode);
							break;
						case CONTROL_TYPES_TIME:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createTimeView(td, _viewMode);
							break;
						case CONTROL_TYPES_IMAGEVIEW:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createImageViewView(td, _viewMode);
							break;
					}
					break;
					
				case TEMPLATE_TYPE_GUIDELINE:
					switch(this.parameter.controlType)
					{
						case CONTROL_TYPES_COMMENT:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createCommentView(td, _viewMode);
							break;
						case CONTROL_TYPES_IMAGEVIEW:
							td = new TableColumn();
							HisHTMLParserUtil.setParent(td, _parent);
							view = this.createImageViewView(td, _viewMode);
							break;
					}		
					break;		
			}
			return view;
		}
		
		// Creating Label
		public String createLabelView(TableColumn _parent, String _viewMode) throws Exception
		{
			String view = "";
			if(!_viewMode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_SHORT_SUMMARIZED_REPORT))
			{
				_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
				_parent.setAttribute("align","center");
				_parent.setAttribute("valign","top");
				_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
				_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
				_parent.setAttribute("height","100%");
				_parent.setAttribute("class","tdfonthead");
				String h="<div id='"+LABEL_DIV_STARTS_WITH+this.parameter.paraId+"' align='"+this.parameter.align+"' ";	
				h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";
				if(this.parameter.bold==TRUE_FALSE_True)h+="<b>";
				if(this.parameter.italic==TRUE_FALSE_True)h+="<i>";
				if(this.parameter.underlined==TRUE_FALSE_True)h+="<u>";
				h+="<font color='"+this.parameter.color+"' size='"+this.parameter.fontsize+"'";
				//if(this.parameter.language.equalsIgnoreCase(LANGUAGE_HINDI))	h+=" face='"+LANGUAGE_HINDI_FONT+"'";
				h+=">"+TemplateDesignerUtility.convertSpace(this.parameter.displayValue)+"</font>";
				if(this.parameter.underlined==TRUE_FALSE_True)h+="</u>";
				if(this.parameter.italic==TRUE_FALSE_True)h+="</i>";
				if(this.parameter.bold==TRUE_FALSE_True)h+="</b>";
				h+="</font></div>";
				Parser parser = new Parser(h);
				NodeList list = parser.parse(null);
				_parent.setChildren(list);
			}
			return view;
		}
		
		// Creating Comment
		public String createCommentView(TableColumn _parent, String _viewMode) throws Exception
		{
			String view = "";
			if(!_viewMode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_SHORT_SUMMARIZED_REPORT))
			{
				_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
				_parent.setAttribute("align","center");
				_parent.setAttribute("valign","top");
				_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
				_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
				_parent.setAttribute("height","100%");
				_parent.setAttribute("class","tdfonthead");
				String h="<div align='"+this.parameter.align+"' ";	
				h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";
				if(this.parameter.bold==TRUE_FALSE_True)h+="<b>";
				if(this.parameter.italic==TRUE_FALSE_True)h+="<i>";
				if(this.parameter.underlined==TRUE_FALSE_True)h+="<u>";
				h+="<font color='"+this.parameter.color+"' size='"+this.parameter.fontsize+"'";
				//if(this.parameter.language.equalsIgnoreCase(LANGUAGE_HINDI))	h+=" face='"+LANGUAGE_HINDI_FONT+"'";
				h+=">"+TemplateDesignerUtility.convertSpace(this.parameter.displayValue)+"</font>";
				if(this.parameter.underlined==TRUE_FALSE_True)h+="</u>";
				if(this.parameter.italic==TRUE_FALSE_True)h+="</i>";
				if(this.parameter.bold==TRUE_FALSE_True)h+="</b>";
				h+="</font></div>";
				Parser parser = new Parser(h);
				NodeList list = parser.parse(null);
				_parent.setChildren(list);
			}
			return view;
		}
		
		// Creating Text Box
		public String createTextBoxView(TableColumn _parent, String _viewMode) throws Exception
		{
			String view = "";
			if(!_viewMode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_SHORT_SUMMARIZED_REPORT))
			{
				_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
				_parent.setAttribute("align","center");
				_parent.setAttribute("valign","top");
				_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
				_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
				_parent.setAttribute("height","100%");
				_parent.setAttribute("class","tdfont");
				String h="<div align='"+this.parameter.align+"' ";	
				h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";
				if(this.parameter.paraValue!=null && !this.parameter.paraValue.equals(""))
				{
					h+=this.parameter.paraValue;
					if(this.parameter.isRange.equalsIgnoreCase(YES_NO_VALUE_YES))
					{
						ParameterRangeMasterVO rngVO = this.objTemplate.mapRange.get(this.parameter.paraId);
						if(rngVO!=null)
						{
							h+=" <font color='#000000'>("+rngVO.getLowValue()+"-"+rngVO.getHighValue()+")"+rngVO.getUnitOfMeasure()+"</font>";
						}
					}
				}
				h+="</font></div>";
				Parser parser = new Parser(h);
				NodeList list = parser.parse(null);
				_parent.setChildren(list);
			}
			else
			{
				if(this.parameter.paraValue!=null && !this.parameter.paraValue.equals(""))
				{
					ParameterRangeMasterVO rngVO = null;
					if(this.parameter.isRange.equalsIgnoreCase(YES_NO_VALUE_YES))
					{
						rngVO = this.objTemplate.mapRange.get(this.parameter.paraId);
					}
					view = getStyleParaValue(this.parameter, rngVO);
				}
			}
			return view;
		}

		// Creating Text Area
		public String createTextAreaView(TableColumn _parent, String _viewMode) throws Exception
		{
			String view = "";
			if(!_viewMode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_SHORT_SUMMARIZED_REPORT))
			{
				_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
				_parent.setAttribute("align","center");
				_parent.setAttribute("valign","top");
				_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
				_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
				_parent.setAttribute("height","100%");
				_parent.setAttribute("class","tdfont");
				String h="<div align='"+this.parameter.align+"' ";	
				h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";
				if(this.parameter.paraValue!=null && !this.parameter.paraValue.equals(""))
					h+=this.parameter.paraValue;
				h+="</font></div>";
				Parser parser = new Parser(h);
				NodeList list = parser.parse(null);
				_parent.setChildren(list);
			}
			else
			{
				if(this.parameter.paraValue!=null && !this.parameter.paraValue.equals(""))
					view = getStyleParaValue(this.parameter, null);
			}
			return view;
		}
		
		// Creating Combo
		public String createComboView(TableColumn _parent, String _viewMode) throws Exception
		{
			String view = "";
			if(!_viewMode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_SHORT_SUMMARIZED_REPORT))
			{
				_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
				_parent.setAttribute("align","center");
				_parent.setAttribute("valign","top");
				_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
				_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
				_parent.setAttribute("height","100%");
				_parent.setAttribute("class","tdfont");
				String h="<div align='"+this.parameter.align+"' ";	
				h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";
				if(this.parameter.paraValue!=null && !this.parameter.paraValue.equals(""))
					h+=this.parameter.paraValue;
				h+="</font></div>";
				Parser parser = new Parser(h);
				NodeList list = parser.parse(null);
				_parent.setChildren(list);
			}
			else
			{
				if(this.parameter.paraValue!=null && !this.parameter.paraValue.equals(""))
					view = getStyleParaValue(this.parameter, null);
			}
			return view;
		}
		
		// Creating Radio Buttons
		public String createRadioView(TableColumn _parent, String _viewMode) throws Exception
		{
			String view = "";
			if(!_viewMode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_SHORT_SUMMARIZED_REPORT))
			{
				_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
				_parent.setAttribute("align","center");
				_parent.setAttribute("valign","top");
				_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
				_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
				_parent.setAttribute("height","100%");
				_parent.setAttribute("class","tdfont");
				_parent.setAttribute("nowrap","nowrap");
				String h="<div align='"+this.parameter.align+"' ";	
				h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";
				if(this.parameter.paraValue!=null && !this.parameter.paraValue.equals(""))
					h+=this.parameter.paraValue;
				h+="</font></div>";
				Parser parser = new Parser(h);
				NodeList list = parser.parse(null);
				_parent.setChildren(list);
			}
			else
			{
				if(this.parameter.paraValue!=null && !this.parameter.paraValue.equals(""))
					view = getStyleParaValue(this.parameter, null);
			}
			return view;
		}
		
		// Creating YesNo
		public String createYesNoView(TableColumn _parent, String _viewMode) throws Exception
		{
			String view = "";
			if(!_viewMode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_SHORT_SUMMARIZED_REPORT))
			{
				_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
				_parent.setAttribute("align","center");
				_parent.setAttribute("valign","top");
				_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
				_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
				_parent.setAttribute("height","100%");
				_parent.setAttribute("class","tdfont");
				String h="<div align='"+this.parameter.align+"' ";	
				h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";
				if(this.parameter.paraValue!=null && !this.parameter.paraValue.equals(""))
					h+=this.parameter.paraValue;
				h+="</font></div>";
				Parser parser = new Parser(h);
				NodeList list = parser.parse(null);
				_parent.setChildren(list);
			}
			else
			{
				if(this.parameter.paraValue!=null && !this.parameter.paraValue.equals(""))
					view = getStyleParaValue(this.parameter, null);
			}
			return view;
		}
		
		// Creating CheckBox
		public String createCheckBoxView(TableColumn _parent, String _viewMode) throws Exception
		{
			String view = "";
			if(!_viewMode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_SHORT_SUMMARIZED_REPORT))
			{
				_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
				_parent.setAttribute("align","center");
				_parent.setAttribute("valign","top");
				_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
				_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
				_parent.setAttribute("height","100%");
				_parent.setAttribute("class","tdfont");
				String h="<div align='"+this.parameter.align+"' ";	
				h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";
				if(this.parameter.paraValue!=null && !this.parameter.paraValue.equals(""))
					h+=this.parameter.paraValue;
				h+="</font></div>";
				Parser parser = new Parser(h);
				NodeList list = parser.parse(null);
				_parent.setChildren(list);
			}
			else
			{
				if(this.parameter.paraValue!=null && !this.parameter.paraValue.equals(""))
					view = getStyleParaValue(this.parameter, null);
			}
			return view;
		}
		
		// Creating Text Box
		public String createFormulatedView(TableColumn _parent, String _viewMode) throws Exception
		{
			String view = "";
			if(!_viewMode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_SHORT_SUMMARIZED_REPORT))
			{
				_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
				_parent.setAttribute("align","center");
				_parent.setAttribute("valign","top");
				_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
				_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
				_parent.setAttribute("height","100%");
				_parent.setAttribute("class","tdfont");
				String h="<div align='"+this.parameter.align+"' ";	
				h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";
				if(this.parameter.paraValue!=null && !this.parameter.paraValue.equals(""))
					h+=this.parameter.paraValue;
				h+="</font></div>";
				Parser parser = new Parser(h);
				NodeList list = parser.parse(null);
				_parent.setChildren(list);
			}
			else
			{
				if(this.parameter.paraValue!=null && !this.parameter.paraValue.equals(""))
					view = getStyleParaValue(this.parameter, null);
			}
			return view;
		}
		
		// Creating Information
		public String createInformationView(TableColumn _parent, String _viewMode) throws Exception
		{
			String view = "";
			if(!_viewMode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_SHORT_SUMMARIZED_REPORT))
			{
				_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
				_parent.setAttribute("align","center");
				_parent.setAttribute("valign","top");
				_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
				_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
				_parent.setAttribute("height","100%");
				_parent.setAttribute("class","tdfont");
				String h="<div align='"+this.parameter.align+"' ";	
				h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";
				if(this.parameter.bold==TRUE_FALSE_True)h+="<b>";
				if(this.parameter.italic==TRUE_FALSE_True)h+="<i>";
				if(this.parameter.underlined==TRUE_FALSE_True)h+="<u>";
				h+="<font color='"+this.parameter.color+"' size='"+this.parameter.fontsize+"'";
				//if(this.parameter.language.equalsIgnoreCase(LANGUAGE_HINDI))	h+=" face='"+LANGUAGE_HINDI_FONT+"'";
				h+=">"+TemplateDesignerUtility.convertSpace(this.parameter.displayValue)+"</font>";
				if(this.parameter.underlined==TRUE_FALSE_True)h+="</u>";
				if(this.parameter.italic==TRUE_FALSE_True)h+="</i>";
				if(this.parameter.bold==TRUE_FALSE_True)h+="</b>";
				h+="</font></div>";
				Parser parser = new Parser(h);
				NodeList list = parser.parse(null);
				_parent.setChildren(list);
			}
			return view;
		}

		// Creating Duration
		public String createDurationView(TableColumn _parent, String _viewMode) throws Exception
		{
			String view = "";
			if(!_viewMode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_SHORT_SUMMARIZED_REPORT))
			{
				_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
				_parent.setAttribute("align","center");
				_parent.setAttribute("valign","top");
				_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
				_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
				_parent.setAttribute("height","100%");
				_parent.setAttribute("class","tdfont");
				_parent.setAttribute("noWrap","noWrap");
				String h="<div align='"+this.parameter.align+"' ";	
				h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";
				if(this.parameter.paraValue!=null && !this.parameter.paraValue.equals(""))
					h+=this.parameter.paraValue;
				h+="</font></div>";
				Parser parser = new Parser(h);
				NodeList list = parser.parse(null);
				_parent.setChildren(list);
			}
			else
			{
				if(this.parameter.paraValue!=null && !this.parameter.paraValue.equals(""))
					view = getStyleParaValue(this.parameter, null);
			}
			return view;
		}

		// Creating Date
		public String createDateView(TableColumn _parent, String _viewMode) throws Exception
		{
			String view = "";
			if(!_viewMode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_SHORT_SUMMARIZED_REPORT))
			{
				_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
				_parent.setAttribute("align","center");
				_parent.setAttribute("valign","top");
				_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
				_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
				_parent.setAttribute("height","100%");
				_parent.setAttribute("class","tdfont");
				String h="<div align='"+this.parameter.align+"' ";	
				h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";
				if(this.parameter.paraValue!=null && !this.parameter.paraValue.equals(""))
					h+=this.parameter.paraValue;
				h+="</font></div>";
				Parser parser = new Parser(h);
				NodeList list = parser.parse(null);
				_parent.setChildren(list);
			}
			else
			{
				if(this.parameter.paraValue!=null && !this.parameter.paraValue.equals(""))
					view = getStyleParaValue(this.parameter, null);
			}
			return view;
		}

		// Creating Time
		public String createTimeView(TableColumn _parent, String _viewMode) throws Exception
		{
			String view = "";
			if(!_viewMode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_SHORT_SUMMARIZED_REPORT))
			{
				_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
				_parent.setAttribute("align","center");
				_parent.setAttribute("valign","top");
				_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
				_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
				_parent.setAttribute("height","100%");
				_parent.setAttribute("class","tdfont");
				String h="<div align='"+this.parameter.align+"' ";	
				h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";
				if(this.parameter.paraValue!=null && !this.parameter.paraValue.equals(""))
					h+=this.parameter.paraValue;
				h+="</font></div>";
				Parser parser = new Parser(h);
				NodeList list = parser.parse(null);
				_parent.setChildren(list);
			}
			else
			{
				if(this.parameter.paraValue!=null && !this.parameter.paraValue.equals(""))
					view = getStyleParaValue(this.parameter, null);
			}
			return view;
		}

		// Creating Image View
		public String createImageViewView(TableColumn _parent, String _viewMode) throws Exception
		{
			String view = "";
			if(!_viewMode.equals(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_SHORT_SUMMARIZED_REPORT))
			{
				_parent.setAttribute("id",TEMPLATE_TD_STARTS_WITH+this.row+SEP_IN_PARA_ROW_COL+this.col);
				_parent.setAttribute("align","center");
				_parent.setAttribute("valign","top");
				_parent.setAttribute("colspan",Integer.toString(this.parameter.colspan));
				_parent.setAttribute("width",((100/this.objTemplate.colCount)*this.parameter.colspan)+"%");
				_parent.setAttribute("height","100%");
				_parent.setAttribute("class","tdfont");
				String h="<div align='"+this.parameter.align+"' ";	
				if(this.parameter.presentation.equalsIgnoreCase(PRESENTATION_TYPES_HIDDEN)) 
					h+=" style='display:none;' ";
				h+="><font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";
	
				String path = ServletsUtilityConfig.SERVLET_DISPLAY_FILE_URL + "?" 
				+ ServletsUtilityConfig.FILE_PATH_WINDOWS + "=" + Config.GENERIC_TEMPLATE_HTML_DOCUMENT_FILE_STORAGE_PATH_WINDOWS + "&" 
				+ ServletsUtilityConfig.FILE_PATH_LINUX + "=" + Config.GENERIC_TEMPLATE_HTML_DOCUMENT_FILE_STORAGE_PATH_WINDOWS + "&" 
				+ ServletsUtilityConfig.FILE_NAME + "=" + Config.GENERIC_TEMPLATE_IMAGE_VIEW_FILE_STORAGE_NAME
				+ this.objTemplate.templateId + "_" + this.row + SEP_IMAGEVIEW_KEY_ROW_COL + this.col + this.parameter.defaultValue; 
	
				h+="<img alt='"+this.parameter.displayValue+"' title='"+this.parameter.displayValue+"' src='"+path+"'>";
	
				h+="</font></div>";
				Parser parser = new Parser(h);
				NodeList list = parser.parse(null);
				_parent.setChildren(list);
			}
			return view;
		}

		// Applying Printing Style to Parameter Value
		private static String getStyleParaValue(Parameter _para, ParameterRangeMasterVO _rngVO)
		{
			String view="";
			boolean withinRange = true;
			if(_rngVO!=null)
			{
				try
				{
					Double lowVal = Double.parseDouble(_rngVO.getLowValue());
					Double highVal = Double.parseDouble(_rngVO.getHighValue());
					
					Double paraVal = Double.parseDouble(_para.paraValue);
					if(!(paraVal>=lowVal && paraVal<=highVal))
						withinRange=false;
				}
				catch (Exception e)
				{
					withinRange = true;
				}
			}
			view+="<font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'>";
			if(!withinRange) view += "<font color='#FF0000'>";
			if(_para.printingStyle==null || _para.printingStyle.equals(""))
			{
				view+="<b>"+_para.paraName + "</b>:" + _para.paraValue + "; ";
			}
			else
			{
				String strFinal = _para.printingStyle;
				// PARANAME
				strFinal = strFinal.replaceAll("PARANAME","<b>"+_para.paraName+"</b>");
				
				// PARAVAL
				strFinal = strFinal.replaceAll("PARAVAL",_para.paraValue);
				
				// Bold
				strFinal = strFinal.replaceAll("#B#","<b>");
				strFinal = strFinal.replaceAll("#EB#","</b>");

				// Italic
				strFinal = strFinal.replaceAll("#I#","<i>");
				strFinal = strFinal.replaceAll("#EI#","</i>");

				// Underlined
				strFinal = strFinal.replaceAll("#U#","<u>");
				strFinal = strFinal.replaceAll("#EU#","</u>");

				// IF-THEN
				while(strFinal.contains("IF#"))
				{
					strFinal = strFinal.replaceFirst("IF#", "#");
					String valToMatch = strFinal.substring(strFinal.indexOf("#")+1,strFinal.indexOf("#", strFinal.indexOf("#")+1));
					if(valToMatch.equals(_para.paraValue))
					{
						strFinal = strFinal.replaceFirst("#"+valToMatch+"#","");
						strFinal = strFinal.replaceFirst("THEN#","");
						strFinal = strFinal.replaceFirst("#","");
					}
					else
					{
						strFinal = strFinal.replaceFirst("#"+valToMatch+"#","");
						strFinal = strFinal.replaceFirst("THEN#","#");
						String valToReplace = strFinal.substring(strFinal.indexOf("#")+1,strFinal.indexOf("#", strFinal.indexOf("#")+1));
						strFinal = strFinal.replaceFirst("#"+valToReplace+"#","");
					}
				}
				//strFinal.replaceAll("PARANAME",_para.paraName);
				view += strFinal + "; ";
			}
			if(_rngVO!=null)
			{
				view+=" <font color='#000000'>("+_rngVO.getLowValue()+"-"+_rngVO.getHighValue()+")"+_rngVO.getUnitOfMeasure()+"</font>";
			}
			if(!withinRange) view += "</font>";
			view += "</font>";
			return view;
		}

	}
	
	public static class Parameter
	{
		// Parameter Position : Row and Col
		private int row;
		private int col;

		// Parameter Id and Name, Parameter Parent
		private String paraId;
		private String paraName;
		private String paraParent;
		private String paraValue;

		// Location Type, Colspan
		private String locationType;
		private int colspan;

		// Control Type 
		private int controlType; 
		// Display Value
		private String displayValue;

		// Control Properties
			// bold, i, u, color, align, validfunc, maxlen, format, re, defaultval
		private boolean bold;
		private boolean italic;
		private boolean underlined;
		private String color;
		private String maxlength;
		private String colsize;
		private String rowsize;
		private String validationFunction;
		private String defaultValue;
		private String regularExpression;
		private String format;
		private String formula;
		private String info;
		private String align;
		private String genderType;
		private String childPresentation;
		private String childPresentationOn;
		private String presentation;
		private String size;
		private String fontsize;
		private String language;
		private String formulaOutput;
		private String printingStyle;
		

		// Source Flag , Static Options, Dynamic Query
		private int sourceFlag;
		private String paraOptions;
		private String tableQuery;

		// Compulsory Flag
		private String isCompulsory;
		// Range Flag
		private String isRange;
		
		// Formulated Control
		private String haveDependent; 
		// have Dependent Para Id if a
		private String dependentParaId;

		public Parameter(int r, int c)
		{
			this.row = r;
			this.col = c;
			this.paraId = "";
			this.paraName = "";
			this.paraParent = "";
			this.paraValue = null;
			this.locationType = LOCATION_TYPES_CELL;
			this.colspan =1;
			this.controlType = NO_SELECT; 
			this.displayValue="";
			
			this.bold = TRUE_FALSE_False;
			this.italic = TRUE_FALSE_False;
			this.underlined = TRUE_FALSE_False;
			this.color = INITIAL_COLOR;
			this.align = ALIGN_CENTER;
			this.maxlength = "";
			this.colsize = "";
			this.rowsize = "";
			this.validationFunction = TEXT_VALIDATIONS_NONE;
			this.defaultValue = "";
			this.regularExpression = "";
			this.format = "";
			this.formula = "";
			this.info = "";
			this.genderType = GENDER_TYPES_NONE;
			this.childPresentation = CHILD_PRESENTATIONS_NORMAL;
			this.childPresentationOn = "";
			this.presentation = PRESENTATION_TYPES_NORMAL;
			this.size = "";
			this.fontsize = "";
			this.language = LANGUAGE_ENGLISH;
			this.formulaOutput = FORMULA_OUTPUT_TYPES_NONE;
			
			this.sourceFlag = SOURCE_FLAG_STATIC;
			this.paraOptions = "";
			this.tableQuery = "";
			this.haveDependent = YES_NO_VALUE_NO;
			this.dependentParaId = "";
			this.isCompulsory = YES_NO_VALUE_NO;
			this.isRange = YES_NO_VALUE_NO;
		}
		
		public Parameter(TemplateParameterMasterVO _vo, String _genderType)
		{
			this.row = Integer.parseInt(_vo.getRow());
			this.col = Integer.parseInt(_vo.getCol());
			this.paraId = _vo.getParaId();
			this.paraName = (_vo.getParaName()==null)?"":_vo.getParaName();
			this.paraParent = (_vo.getParentParaId()==null)?"":_vo.getParentParaId();
			this.locationType = _vo.getLocationType();
			this.colspan = Integer.parseInt(_vo.getColspan());
			this.controlType = Integer.parseInt(_vo.getControlType()); 
			this.displayValue = _vo.getDisplayValue();
			
			String props[] = _vo.getControlProps().split(SEP_VAL_IN_PROPS);
			int i=0;
			this.bold = Boolean.parseBoolean(props[i++]);
			this.italic = Boolean.parseBoolean(props[i++]);
			this.underlined = Boolean.parseBoolean(props[i++]);
			this.color = props[i++];
			this.maxlength = props[i++];
			this.colsize = props[i++];
			this.rowsize = props[i++];
			this.validationFunction = props[i++];
			this.defaultValue = props[i++];
			this.regularExpression = props[i++].replace("\\", "\\\\");
			this.format = props[i++];
			this.formula = props[i++];
			this.info = props[i++];
			this.align = props[i++];
			this.genderType = props[i++];
			this.childPresentation = props[i++];
			this.childPresentationOn = props[i++];
			this.presentation = props[i++];
			this.size = props[i++];
			this.fontsize = props[i++];
			this.printingStyle = props[i++];
			this.formulaOutput = props[i++];
			
			// Set Fontsize & Language Separately
			String[] splitted = this.fontsize.split(SEP_IN_FONT_SIZE_LANG);
			this.fontsize = splitted[0];
			if(splitted.length>1)	this.language = splitted[1];
			else	this.language = LANGUAGE_ENGLISH;
			
			this.sourceFlag = Integer.parseInt(_vo.getSourceFlag());
			this.paraOptions = _vo.getStaticOptions();
			this.tableQuery = _vo.getDynamicQuery();
			this.haveDependent = _vo.getHaveDependent();
			this.dependentParaId = _vo.getDependentParaId();
			this.isCompulsory = _vo.getIsCompulsory();
			this.isRange = _vo.getIsRange();
		}
		
		public Parameter(TemplateParameterMasterVO _vo, String _genderType, String _paraValue)
		{
			this.row = Integer.parseInt(_vo.getRow());
			this.col = Integer.parseInt(_vo.getCol());
			this.paraId = _vo.getParaId();
			this.paraName = (_vo.getParaName()==null)?"":_vo.getParaName();
			this.paraParent = (_vo.getParentParaId()==null)?"":_vo.getParentParaId();
			this.locationType = _vo.getLocationType();
			this.colspan = Integer.parseInt(_vo.getColspan());
			this.controlType = Integer.parseInt(_vo.getControlType()); 
			this.displayValue = _vo.getDisplayValue();
			
			String props[] = _vo.getControlProps().split(SEP_VAL_IN_PROPS);
			int i=0;
			this.bold = Boolean.parseBoolean(props[i++]);
			this.italic = Boolean.parseBoolean(props[i++]);
			this.underlined = Boolean.parseBoolean(props[i++]);
			this.color = props[i++];
			this.maxlength = props[i++];
			this.colsize = props[i++];
			this.rowsize = props[i++];
			this.validationFunction = props[i++];
			this.defaultValue = props[i++];
			this.regularExpression = props[i++].replace("\\", "\\\\");
			this.format = props[i++];
			this.formula = props[i++];
			this.info = props[i++];
			this.align = props[i++];
			this.genderType = props[i++];
			this.childPresentation = props[i++];
			this.childPresentationOn = props[i++];
			this.presentation = props[i++];
			this.size = props[i++];
			this.fontsize = props[i++];
			this.printingStyle = props[i++];
			this.formulaOutput = props[i++];
			// Set Fontsize & Language Separately
			String[] splitted = this.fontsize.split(SEP_IN_FONT_SIZE_LANG);
			this.fontsize = splitted[0];
			if(splitted.length>1)	this.language = splitted[1];
			else	this.language = LANGUAGE_ENGLISH;

			this.sourceFlag = Integer.parseInt(_vo.getSourceFlag());
			this.paraOptions = _vo.getStaticOptions();
			this.tableQuery = _vo.getDynamicQuery();
			this.haveDependent = _vo.getHaveDependent();
			this.dependentParaId = _vo.getDependentParaId();
			this.isCompulsory = _vo.getIsCompulsory();
			this.isRange = _vo.getIsRange();
			
			this.defaultValue = _paraValue;
			
			this.paraValue = _paraValue;
		}

		public Parameter(TemplateParameterMasterVO _vo, String _genderType, InformationControlBean _infoBean)
		{
			this.row = Integer.parseInt(_vo.getRow());
			this.col = Integer.parseInt(_vo.getCol());
			this.paraId = _vo.getParaId();
			this.paraName = (_vo.getParaName()==null)?"":_vo.getParaName();
			this.paraParent = (_vo.getParentParaId()==null)?"":_vo.getParentParaId();
			this.locationType = _vo.getLocationType();
			this.colspan = Integer.parseInt(_vo.getColspan());
			this.controlType = Integer.parseInt(_vo.getControlType()); 
			this.displayValue = _vo.getDisplayValue();
			
			String props[] = _vo.getControlProps().split(SEP_VAL_IN_PROPS);
			int i=0;
			this.bold = Boolean.parseBoolean(props[i++]);
			this.italic = Boolean.parseBoolean(props[i++]);
			this.underlined = Boolean.parseBoolean(props[i++]);
			this.color = props[i++];
			this.maxlength = props[i++];
			this.colsize = props[i++];
			this.rowsize = props[i++];
			this.validationFunction = props[i++];
			this.defaultValue = props[i++];
			this.regularExpression = props[i++].replace("\\", "\\\\");
			this.format = props[i++];
			this.formula = props[i++];
			this.info = props[i++];
			this.align = props[i++];
			this.genderType = props[i++];
			this.childPresentation = props[i++];
			this.childPresentationOn = props[i++];
			this.presentation = props[i++];
			this.size = props[i++];
			this.fontsize = props[i++];
			this.printingStyle = props[i++];
			this.formulaOutput = props[i++];
			// Set Fontsize & Language Separately
			String[] splitted = this.fontsize.split(SEP_IN_FONT_SIZE_LANG);
			this.fontsize = splitted[0];
			if(splitted.length>1)	this.language = splitted[1];
			else	this.language = LANGUAGE_ENGLISH;

			this.sourceFlag = Integer.parseInt(_vo.getSourceFlag());
			this.paraOptions = _vo.getStaticOptions();
			this.tableQuery = _vo.getDynamicQuery();
			this.haveDependent = _vo.getHaveDependent();
			this.dependentParaId = _vo.getDependentParaId();
			this.isCompulsory = _vo.getIsCompulsory();
			this.isRange = _vo.getIsRange();
			
			this.defaultValue = _infoBean.fetchInformation(this.info);			
		}
		
		public int getRow()
		{
			return row;
		}
		public void setRow(int row)
		{
			this.row = row;
		}
		public int getCol()
		{
			return col;
		}
		public void setCol(int col)
		{
			this.col = col;
		}
		public String getParaId()
		{
			return paraId;
		}
		public void setParaId(String paraId)
		{
			this.paraId = paraId;
		}
		public String getParaName()
		{
			return paraName;
		}
		public void setParaName(String paraName)
		{
			this.paraName = paraName;
		}
		public String getParaParent()
		{
			return paraParent;
		}
		public void setParaParent(String paraParent)
		{
			this.paraParent = paraParent;
		}
		public String getLocationType()
		{
			return locationType;
		}
		public void setLocationType(String locationType)
		{
			this.locationType = locationType;
		}
		public int getColspan()
		{
			return colspan;
		}
		public void setColspan(int colspan)
		{
			this.colspan = colspan;
		}
		public int getControlType()
		{
			return controlType;
		}
		public void setControlType(int controlType)
		{
			this.controlType = controlType;
		}
		public String getDisplayValue()
		{
			return displayValue;
		}
		public void setDisplayValue(String displayValue)
		{
			this.displayValue = displayValue;
		}
		public boolean getBold()
		{
			return bold;
		}
		public void setBold(boolean bold)
		{
			this.bold = bold;
		}
		public boolean getItalic()
		{
			return italic;
		}
		public void setItalic(boolean italic)
		{
			this.italic = italic;
		}
		public boolean getUnderlined()
		{
			return underlined;
		}
		public void setUnderlined(boolean underlined)
		{
			this.underlined = underlined;
		}
		public String getColor()
		{
			return color;
		}
		public void setColor(String color)
		{
			this.color = color;
		}
		public String getAlign()
		{
			return align;
		}
		public void setAlign(String align)
		{
			this.align = align;
		}
		public String getMaxlength()
		{
			return maxlength;
		}
		public void setMaxlength(String maxlength)
		{
			this.maxlength = maxlength;
		}
		public String getValidationFunction()
		{
			return validationFunction;
		}
		public void setValidationFunction(String validationFunction)
		{
			this.validationFunction = validationFunction;
		}
		public String getDefaultValue()
		{
			return defaultValue;
		}
		public void setDefaultValue(String defaultValue)
		{
			this.defaultValue = defaultValue;
		}
		public String getRegularExpression()
		{
			return regularExpression;
		}
		public void setRegularExpression(String regularExpression)
		{
			this.regularExpression = regularExpression;
		}
		public String getFormat()
		{
			return format;
		}
		public void setFormat(String format)
		{
			this.format = format;
		}
		public int getSourceFlag()
		{
			return sourceFlag;
		}
		public void setSourceFlag(int sourceFlag)
		{
			this.sourceFlag = sourceFlag;
		}
		public String getParaOptions()
		{
			return paraOptions;
		}
		public void setParaOptions(String paraOptions)
		{
			this.paraOptions = paraOptions;
		}
		public String getTableQuery()
		{
			return tableQuery;
		}
		public void setTableQuery(String tableQuery)
		{
			this.tableQuery = tableQuery;
		}
		public String getIsCompulsory()
		{
			return isCompulsory;
		}
		public void setIsCompulsory(String isCompulsory)
		{
			this.isCompulsory = isCompulsory;
		}
		public String getIsRange()
		{
			return isRange;
		}
		public void setIsRange(String isRange)
		{
			this.isRange = isRange;
		}

		public String getFormula()
		{
			return formula;
		}

		public void setFormula(String formula)
		{
			this.formula = formula;
		}
		
		public String getHaveDependent()
		{
			return haveDependent;
		}

		public void setHaveDependent(String haveDependent)
		{
			this.haveDependent = haveDependent;
		}

		public String getDependentParaId()
		{
			return dependentParaId;
		}

		public void setDependentParaId(String dependentParaId)
		{
			this.dependentParaId = dependentParaId;
		}

		public String getColsize()
		{
			return colsize;
		}

		public void setColsize(String colsize)
		{
			this.colsize = colsize;
		}

		public String getRowsize()
		{
			return rowsize;
		}

		public void setRowsize(String rowsize)
		{
			this.rowsize = rowsize;
		}

		public String getInfo()
		{
			return info;
		}

		public void setInfo(String info)
		{
			this.info = info;
		}

		public String getGenderType()
		{
			return genderType;
		}

		public void setGenderType(String genderType)
		{
			this.genderType = genderType;
		}

		public String getPresentation()
		{
			return presentation;
		}

		public void setPresentation(String presentation)
		{
			this.presentation = presentation;
		}

		public String getChildPresentation()
		{
			return childPresentation;
		}

		public void setChildPresentation(String childPresentation)
		{
			this.childPresentation = childPresentation;
		}

		public String getChildPresentationOn()
		{
			return childPresentationOn;
		}

		public void setChildPresentationOn(String childPresentationOn)
		{
			this.childPresentationOn = childPresentationOn;
		}

		public String getSize()
		{
			return size;
		}

		public void setSize(String size)
		{
			this.size = size;
		}

		public String getFontsize()
		{
			return fontsize;
		}

		public void setFontsize(String fontsize)
		{
			this.fontsize = fontsize;
		}

		public String getFormulaOutput()
		{
			return formulaOutput;
		}

		public void setFormulaOutput(String formulaOutput)
		{
			this.formulaOutput = formulaOutput;
		}

		public String getLanguage()
		{
			return language;
		}

		public void setLanguage(String language)
		{
			this.language = language;
		}

		public String getParaValue() {
			return paraValue;
		}

		public void setParaValue(String paraValue) {
			this.paraValue = paraValue;
		}

		public String getPrintingStyle() {
			return printingStyle;
		}

		public void setPrintingStyle(String printingStyle) {
			this.printingStyle = printingStyle;
		}
	}

	/**
	 * Suumarizing the Template Code
	 * @param _htmlCode HTML Code
	 * @param _mapParaValues Map of ParaId/Value
	 * @return Summarized Template Code
	 */
	public static String summarizeTemplate(String _htmlCode, Map<String, String> _mapParaValues, Map<String, TempParameter> _mapParaDtl, String _tempType)
	{
		String htmlCode="";
		try
		{
			Parser parser = new Parser(_htmlCode);
			NodeList list = parser.parse (null);
			
			// Collecting all Empty Labels
			class LabelNodeVisitor extends NodeVisitor
			{
				List<Tag> labelTagList; 
				public LabelNodeVisitor() {	this.labelTagList= new ArrayList<Tag>();	}
			    public void visitTag (Tag tag)
			    {
			    	if(tag.getAttribute("id")!=null && tag.getAttribute("id").startsWith(LABEL_DIV_STARTS_WITH))
			    		this.labelTagList.add(tag);
			    }
			    public List<Tag> getLabelTagList() {	return labelTagList;	}
				public void visitStringNode (Text string){}
			}
			LabelNodeVisitor lblVisitor=new LabelNodeVisitor();
			list.visitAllNodesWith(lblVisitor);
			List<Tag> allLabelTags = lblVisitor.getLabelTagList();
			for(Tag tag : allLabelTags)
			{
				String id=tag.getAttribute("id");				
				String paraId = id.substring(LABEL_DIV_STARTS_WITH.length());
				String value = getDependentValue(paraId,_mapParaDtl);
				if(value == null)
				{
					Node parent = tag.getParent();
					while(!parent.getClass().equals(TableColumn.class))
						parent =parent.getParent();
					parent.setChildren(new NodeList());
				}				
			}

			// Collecting All Value based Nodes
			class ParameterNodeVisitor extends NodeVisitor
			{
				List<Tag> paraTagList; 
				public ParameterNodeVisitor() {	this.paraTagList= new ArrayList<Tag>();	}
			    public void visitTag (Tag tag)
			    {
			    	if(tag.getAttribute("name")!=null && tag.getAttribute("name").startsWith(GenericTemplateConfig.PARAMETER_STARTS_WITH))
			    		this.paraTagList.add(tag);
			    }
			    public List<Tag> getParaTagList() {	return paraTagList;	}
				public void visitStringNode (Text string){}
			}	
			ParameterNodeVisitor paraVisitor=new ParameterNodeVisitor();
			list.visitAllNodesWith(paraVisitor);
			List<Tag> allParamTags = paraVisitor.getParaTagList();
			for(Tag tag : allParamTags)
			{
				String name=tag.getAttribute("name");
				name = name.split(SEP_IN_PARA_NAME_ID)[1];
				String id= name.split(SEP_IN_PARA_NAMEID_TEMPID)[0];
				String value=_mapParaValues.get(id);
				if(value == null)
				{
					if(_tempType.equalsIgnoreCase(GenericTemplateConfig.TEMPLATE_TYPE_NORMAL))
					{
						Node parent = tag.getParent();
						while(!parent.getClass().equals(TableColumn.class))
							parent =parent.getParent();
						Node prevTD = parent.getPreviousSibling();
						parent.setChildren(new NodeList());
						prevTD.setChildren(new NodeList());
					}
					else
					{
						Node parent = tag.getParent();
						while(!parent.getClass().equals(TableColumn.class))
							parent =parent.getParent();
						parent.setChildren(new NodeList());
					}
				}				
			}
			_htmlCode = list.toHtml();

			parser = new Parser(_htmlCode);
			list = parser.parse (null);
			
			class TDVisitor extends NodeVisitor
			{
				List<Tag> tdTagList; 
				public TDVisitor() {	this.tdTagList= new ArrayList<Tag>();	}
			    public void visitTag (Tag tag)
			    {
			    	if(tag.getAttribute("id")!=null && tag.getAttribute("id").startsWith(TEMPLATE_TD_STARTS_WITH))
			    		this.tdTagList.add(tag);
			    }
			    public List<Tag> getTdTagList() {	return tdTagList;	}
				public void visitStringNode (Text string){}
			}
			
			TDVisitor tdVisitor=new TDVisitor();
			list.visitAllNodesWith(tdVisitor);
			List<Tag> allTDTags = tdVisitor.getTdTagList();
			int rows=0;
			int cols=0;
			Map<String,Tag> mapTds = new HashMap<String, Tag>(); 
			for(Tag t : allTDTags)
			{
				String name = t.getAttribute("id").replace(TEMPLATE_TD_STARTS_WITH, "");
				int row = Integer.parseInt(name.split(SEP_IN_PARA_ROW_COL)[0]);
				int col = Integer.parseInt(name.split(SEP_IN_PARA_ROW_COL)[1]);
				int colspan = Integer.parseInt(t.getAttribute("colspan"));
				if(rows<row) rows=row;
				if(cols<(col+colspan-1)) cols= col + colspan-1;
				mapTds.put(row+SEP_IN_PARA_ROW_COL+col, t);
			}
			Tag[][] tagMat = new Tag[rows][cols];
			for(int i=0;i<rows;i++)
				for(int j=0;j<cols;j++)
				{
					String key = (i+1)+SEP_IN_PARA_ROW_COL+(j+1);
					Tag t = mapTds.get(key);
					tagMat[i][j]=t;
				}
			// Row Deletion
			Set<Integer> setDelRows = new HashSet<Integer>();
			for(int i=0;i<rows;i++)
			{
				boolean flag=true;
				for(int j=0;j<cols;j++)
				{
					if(tagMat[i][j]!=null && tagMat[i][j].getChildren()!=null && tagMat[i][j].getChildren().size()>0)
					{
						flag=false;
						break;
					}
				}
				if(flag)
				{
					Tag t=tagMat[i][0];
					Node tr = t.getParent();
					Node parent = tr.getParent();
					parent.getChildren().remove(tr);
					setDelRows.add(i);
				}
			}
			
			// Col Deletion
			for(int j=0;j<cols;j++)
			{
				boolean flag=true;
				for(int i=0;i<rows;i++)
				{
					if(!setDelRows.contains(i))
					{
						if(tagMat[i][j]==null || (tagMat[i][j]!=null && tagMat[i][j].getChildren()!=null 
								&& tagMat[i][j].getChildren().size()>0))
						{
							flag=false;
							break;
						}
					}
				}
				if(flag)
				{
					for(int i=0;i<rows;i++)
					{
						if(!setDelRows.contains(i))
						{
							Tag t=tagMat[i][j];
							Node tr = t.getParent();
							tr.getChildren().remove(t);
						}
					}
				}
			}
			htmlCode = list.toHtml();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return htmlCode; 
	}

	/**
	 * Getting first dependents value otherwise null 
	 * @return Getting first dependents value otherwise null
	 */
	private static String getDependentValue(String _paraId, Map<String, TempParameter> _mapParaDtl)
	{
		String value=null;
		if(_mapParaDtl!=null)
		{
			for(String paraId : _mapParaDtl.keySet())
			{
				TempParameter tempPara = _mapParaDtl.get(paraId);
				if(tempPara.getParaParentId()!=null && !tempPara.getParaParentId().trim().equals("") && tempPara.getParaParentId().contains(_paraId))
				{
					value = tempPara.getParaValue();
					break;
				}
			}
		}
		else
			value = " ";
		return value;
	}
	
	/** Filling Para Values in HTML File Code
	 * @param _htmlCode HTML Code from File
	 * @param _mapParaValues Map of ParaId/ Value
	 * @return HTML COde filled with Values
	 */
	public static String fillParameterValuesIntoHTMLCode(String _htmlCode, Map<String, String> _mapParaValues, Map<String, TempParameter> _mapParaDtl, String _mode, String _tempType, String _genderType)
	{
		try
		{
			if(_mode.equalsIgnoreCase(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_SUMMARIZED_REPORT))
				_htmlCode = summarizeTemplate(_htmlCode,_mapParaValues,_mapParaDtl,_tempType);
			if(_mapParaValues==null)	_mapParaValues=new HashMap<String, String>();
			//if(_mapParaValues!=null)
			{
				Parser parser = new Parser(_htmlCode);
				NodeList list = parser.parse (null);
				
				class ParamterNodeVisitor extends NodeVisitor
				{
					List paraTagList; 
					public ParamterNodeVisitor() {	this.paraTagList= new ArrayList();	}
				    public void visitTag (Tag tag)
				    {
				    	if(tag.getAttribute("name")!=null && tag.getAttribute("name").startsWith(GenericTemplateConfig.PARAMETER_STARTS_WITH))
				    		this.paraTagList.add(tag);
				    }
				    public List getParaTagList() {	return paraTagList;	}
					public void visitStringNode (Text string){}
				}
				
				ParamterNodeVisitor myVisitor=new ParamterNodeVisitor();
				list.visitAllNodesWith(myVisitor);
				List allParamTags = myVisitor.getParaTagList();
				for(int i=0;i<allParamTags.size();i++)
				{
					Tag tag =(Tag)allParamTags.get(i);
					String name=tag.getAttribute("name");
					name = name.split(SEP_IN_PARA_NAME_ID)[1];
					String id= name.split(SEP_IN_PARA_NAMEID_TEMPID)[0];
					String value=_mapParaValues.get(id);
					//if(value != null) setValueToTag(tag,value);
					setValueToTagOnMode(tag,value,_mode,_genderType);
				}
				_htmlCode = list.toHtml();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return _htmlCode;
	}
	
	private static void setValueToTagOnMode(Tag tag, String value, String _mode, String _genderType)
	{
		setPropertiesToTag(tag, _genderType, value);
		if(_mode.equalsIgnoreCase(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_EDITABLE))
		{
			if(value!=null)	setValueToTag(tag,value);
		}
		else if(_mode.equalsIgnoreCase(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_REPORT))
		{
			setValueToReportTag(tag,value);
		}
		else if(_mode.equalsIgnoreCase(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_SUMMARIZED_REPORT))
		{
			setValueToReportTag(tag,value);
		}
		else if(_mode.equalsIgnoreCase(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_EDITABLE_NON_ENTERED))
		{
			if(value!=null)	setValueToReportTag(tag,value);
		}
		else if(_mode.equalsIgnoreCase(GenericTemplateConfig.GENERIC_TEMPLATE_MODE_EDITABLE_FOCUS_ENTERED))
		{
			if(value!=null)	setValueNFocusToTag(tag,value);
		}
	}
	
	private static void setPropertiesToTag(Tag tag, String _genderType, String _value)
	{
		String presentation = PRESENTATION_TYPES_NORMAL;
		String elemId = null;
		String elemGenderType = null;
		if(tag.getAttribute("id")!=null)
		{				
			elemId = tag.getAttribute("id");
			if(elemId.indexOf("G:")!=-1)	elemGenderType=elemId.substring(elemId.indexOf("G:")+2);
			if(elemGenderType!=null && !_genderType.equalsIgnoreCase(Config.GENDER_TYPE_OTHER) && !elemGenderType.equalsIgnoreCase(GENDER_TYPES_NONE) 
				&& !_genderType.equalsIgnoreCase(elemGenderType))
			{
				elemGenderType = GENDER_TYPES_PRESENTATION_DISABLED;
				if(presentation.equalsIgnoreCase(PRESENTATION_TYPES_NORMAL))	presentation = PRESENTATION_TYPES_DISABLED; 
			}
		}
		if(tag instanceof InputTag)
		{
			if(tag.getAttribute("type").equalsIgnoreCase("text"))
			{
				if(presentation.equalsIgnoreCase(PRESENTATION_TYPES_DISABLED)) tag.setAttribute("disabled","disabled");
				if(elemId != null && elemGenderType!=null)	tag.setAttribute("id", elemId.substring(0, elemId.indexOf("G:")+2)+elemGenderType);
			}
			else if (tag.getAttribute("type").equalsIgnoreCase("radio"))
			{				
				if(presentation.equalsIgnoreCase(PRESENTATION_TYPES_DISABLED)) tag.setAttribute("disabled","disabled");
				if(elemId != null && elemGenderType!=null)	tag.setAttribute("id", elemId.substring(0, elemId.indexOf("G:")+2)+elemGenderType);
			}
			else if (tag.getAttribute("type").equalsIgnoreCase("checkbox"))
			{
				if(presentation.equalsIgnoreCase(PRESENTATION_TYPES_DISABLED)) tag.setAttribute("disabled","disabled");
				if(elemId != null && elemGenderType!=null)	tag.setAttribute("id", elemId.substring(0, elemId.indexOf("G:")+2)+elemGenderType);
			}
			else if(tag.getAttribute("type").equalsIgnoreCase("hidden"))
			{
				if(elemId != null && elemGenderType!=null)	tag.setAttribute("id", elemId.substring(0, elemId.indexOf("G:")+2)+elemGenderType);
				// Duration Case
				Node elemCountVal = tag.getNextSibling();
				Node elemDurVal = elemCountVal.getNextSibling();
				if(presentation.equalsIgnoreCase(PRESENTATION_TYPES_DISABLED))
				{
					((Tag)elemCountVal).setAttribute("disabled","disabled");
					((Tag)elemDurVal).setAttribute("disabled","disabled");
				}
			}
		}
		else if(tag instanceof TextareaTag)
		{
			if(presentation.equalsIgnoreCase(PRESENTATION_TYPES_DISABLED)) tag.setAttribute("disabled","disabled");
			if(elemId != null && elemGenderType!=null)	tag.setAttribute("id", elemId.substring(0, elemId.indexOf("G:")+2)+elemGenderType);
		}
		else if(tag instanceof SelectTag)
		{
			if(presentation.equalsIgnoreCase(PRESENTATION_TYPES_DISABLED)) tag.setAttribute("disabled","disabled");
			if(elemId != null && elemGenderType!=null)	tag.setAttribute("id", elemId.substring(0, elemId.indexOf("G:")+2)+elemGenderType);
		}
		if(_value!=null)
		{
			Node parent = tag;
			while(!parent.getClass().equals(Div.class))
				parent = parent.getParent();
			if(parent!=null)
				((Div)parent).setAttribute("style","display:block;");
		}
	}

	private static void setValueToTag(Tag tag,String value)
	{
		if(tag instanceof InputTag)
		{
			if(tag.getAttribute("type").equalsIgnoreCase("text"))
				tag.setAttribute("value",value);
			else if (tag.getAttribute("type").equalsIgnoreCase("radio"))
			{				
				if(tag.getAttribute("value").equalsIgnoreCase(value))
					tag.setAttribute("checked","true");
				else
					tag.removeAttribute("checked");
			}
			else if (tag.getAttribute("type").equalsIgnoreCase("checkbox"))
			{
				if(tag.getAttribute("value").equalsIgnoreCase(value))
					tag.setAttribute("checked","true");
				else
					tag.removeAttribute("checked");
			}
			else if(tag.getAttribute("type").equalsIgnoreCase("hidden"))
			{
				// Duration Case
				tag.setAttribute("value",value);
				Node elemCountVal = tag.getNextSibling();
				Node elemDurVal = elemCountVal.getNextSibling();
				
				OptionTag[] opts=((SelectTag)elemDurVal).getOptionTags();
				String defaultValueforCount="", defaultValueforDur="";
				if(!value.equalsIgnoreCase(""))
				{
					for(int o=0;o<opts.length;o++)
					{
						String durVal = opts[o].getAttribute("value");
						if(!durVal.equals("") && durVal.equalsIgnoreCase(value.substring(value.length()-durVal.length(),value.length())))
						{
							defaultValueforDur=durVal;
							String countVal = value.replace(durVal,"");
							defaultValueforCount=countVal.replace(" ","");
							break;
						}
					}
				}
				
				((Tag)elemCountVal).setAttribute("value",defaultValueforCount);
				for(int o=0;o<opts.length;o++)
					if(opts[o].getAttribute("value").equalsIgnoreCase(defaultValueforDur))
					{
						opts[o].setAttribute("selected","true");
						break;
					}
			}
		}
		else if(tag instanceof TextareaTag)
		{
			NodeList nl = new NodeList();
			nl.add(new TextNode(value));			
			tag.setChildren(nl);		
		}
		else if(tag instanceof SelectTag)
		{
			OptionTag[] opts=((SelectTag)tag).getOptionTags();
			for(int o=0;o<opts.length;o++)
				if(opts[o].getAttribute("value").equalsIgnoreCase(value))
				{
					opts[o].setAttribute("selected","true");
					break;
				}
		}
	}
	
	private static void setValueNFocusToTag(Tag tag,String value)
	{
		setValueToTag(tag,value);
		// Highlight
		Tag target = tag;
		while(!target.getTagName().equalsIgnoreCase("TD"))
			target = (Tag) target.getParent();
		target.setAttribute("class","applicationBackgroundColor");
	}

	private static void setValueToReportTag(Tag tag, String value)
	{
		Node parent = tag.getParent();
		if(value != null) value="<font color='#000000' size='2' face='Verdana, Arial, Helvetica, sans-serif'><b>&nbsp;"+TemplateDesignerUtility.convertSpace(value)+"</b></font>";
		else value="";
		NodeList newNodes=new NodeList();
		newNodes.add(new TextNode(value));
		parent.setChildren(newNodes);
	}
	
	// Coverting First & Last Spaces into &nbsp;
	private static String convertSpace(String _strSpaced)
	{
		String strNonSpaced = "";
		if(_strSpaced!=null && !_strSpaced.equalsIgnoreCase(""))
		{
			strNonSpaced = _strSpaced;
			if(strNonSpaced.substring(0,1).equalsIgnoreCase(" "))
				strNonSpaced = "&nbsp;" + strNonSpaced.substring(1);
			if(strNonSpaced.substring(strNonSpaced.length()-1,strNonSpaced.length()).equalsIgnoreCase(" "))
				strNonSpaced = strNonSpaced.substring(0,strNonSpaced.length()-1) + "&nbsp;";
		}
		return strNonSpaced;
	}
	
	//****************** Template Types	
	public static final int TEMPLATE_TYPE_NORMAL = 1;
	public static final int TEMPLATE_TYPE_MATRIX = 2;
	public static final int TEMPLATE_TYPE_CONSENT = 3;
	public static final int TEMPLATE_TYPE_GUIDELINE = 4;

	//****************** Separators
	public static final String SEP_IN_PARA_OPTIONS = "~";
	public static final String SEP_IN_PARA_OPTIONS_LABEL_VALUE = ":";
	public static final String SEP_VAL_PARA_FEATURES = "!";
	public static final String SEP_VAL_IN_PARA = "!###!";
	public static final String SEP_VAL_IN_PROPS = "&";
	public static final String SEP_IN_PARA_PARENT = "#";
	public static final String SEP_IN_PARA_ROW_COL = "&";
	public static final String SEP_IN_PARA_NAME_ID = "@";
	public static final String SEP_IN_PARA_NAMEID_TEMPID = "&";
	public static final String SEP_IN_PARA_DEPENDENTS = "#";
	public static final String SEP_IMAGEVIEW_KEY_ROW_COL = "_";
	public static final String SEP_IN_FONT_SIZE_LANG = ":";
		
	
	//****************** Control Type List
	public static final int NO_SELECT = -1;
	
	public static final int CONTROL_TYPES_LABEL = 1;
	public static final int CONTROL_TYPES_TEXTBOX = 2;
	public static final int CONTROL_TYPES_TEXTAREA = 3;
	public static final int CONTROL_TYPES_COMBO = 4;
	public static final int CONTROL_TYPES_RADIO = 5;
	public static final int CONTROL_TYPES_YESNO = 6;
	public static final int CONTROL_TYPES_CHECKBOX = 7;
	public static final int CONTROL_TYPES_COMMENT = 8;
	public static final int CONTROL_TYPES_FORMULATED = 9;
	public static final int CONTROL_TYPES_INFORMATION = 10;
	public static final int CONTROL_TYPES_DURATION = 11;
	public static final int CONTROL_TYPES_DATE = 12;
	public static final int CONTROL_TYPES_TIME = 13;
	public static final int CONTROL_TYPES_IMAGEVIEW = 14;


	//****************** Source Flag Value
	public static final int SOURCE_FLAG_STATIC = 1;
	public static final int SOURCE_FLAG_DYNAMIC = 2;
	
	//****************** Location/Spanning Type
	public static final String[] LOCATION_TYPES={"Cell","Pair","Half","Row","Custom"};
	
	public static final String LOCATION_TYPES_CELL = "0";
	public static final String LOCATION_TYPES_TOP = "1";
	public static final String LOCATION_TYPES_LEFTRIGHT = "2";
	public static final String LOCATION_TYPES_ROW = "3";
	public static final String LOCATION_TYPES_CUSTOM = "4";

		//******************* True False
	public static final boolean TRUE_FALSE_False=false;
	public static final boolean TRUE_FALSE_True=true;
	
	//******************* Initial Color
	public static final String INITIAL_COLOR = "#000000";
	
	//******************* Alignment
	public static final String ALIGN_CENTER = "center";
	public static final String ALIGN_LEFT = "left";
	public static final String ALIGN_RIGHT = "right";

	//******************* Gender Types
	public static final String[] GENDER_TYPES={"None","Male","Female"};
	
	public static final String GENDER_TYPES_NONE = "0";
	public static final String GENDER_TYPES_MALE = "1";
	public static final String GENDER_TYPES_FEMALE = "2";
	public static final String GENDER_TYPES_PRESENTATION_DISABLED = "D";
		
	//******************* Text Validation Function
	public static final String TEXT_VALIDATIONS_NONE = "validateNone";
	public static final String TEXT_VALIDATIONS_ALPHABETIC = "validateAlphaOnly";
	public static final String TEXT_VALIDATIONS_NUMERIC = "validateNumericOnly";
	public static final String TEXT_VALIDATIONS_POSITIVENUMERIC = "validatePositiveNumericOnly";
	public static final String TEXT_VALIDATIONS_ALPHANUMERIC = "validateAlphaNumOnly";
	public static final String TEXT_VALIDATIONS_INTEGERONLY = "validateIntegerOnly";
	public static final String TEXT_VALIDATIONS_POSITIVEINTEGERONLY = "validatePositiveIntegerOnly";
	
	//****************** Presentation Types
	public static final String PRESENTATION_TYPES_NORMAL = "0";
	public static final String PRESENTATION_TYPES_DISABLED = "1";
	public static final String PRESENTATION_TYPES_HIDDEN = "2";

	//****************** Children Presentation Types
	public static final String CHILD_PRESENTATIONS_NORMAL = "0";
	public static final String CHILD_PRESENTATIONS_DISABLEON = "1";
	public static final String CHILD_PRESENTATIONS_ENABLEON = "2";
	public static final String CHILD_PRESENTATIONS_HIDEON = "3";
	public static final String CHILD_PRESENTATIONS_SHOWON = "4";

	//****************** Formula Output Types
	public static final String FORMULA_OUTPUT_TYPES_NONE = "0";
	public static final String FORMULA_OUTPUT_TYPES_TRUNCATE = "1";
	public static final String FORMULA_OUTPUT_TYPES_ROUNDOFF = "2";
	public static final String FORMULA_OUTPUT_TYPES_TRUNCATETO1DECIMALPLACE = "3";
	public static final String FORMULA_OUTPUT_TYPES_ROUNDOFFTO1DECIMALPLACE = "4";
	public static final String FORMULA_OUTPUT_TYPES_TRUNCATETO2DECIMALPLACE = "5";
	public static final String FORMULA_OUTPUT_TYPES_ROUNDOFFTO2DECIMALPLACE = "6";
	public static final String FORMULA_OUTPUT_TYPES_TRUNCATETO5DECIMALPLACE = "7";
	public static final String FORMULA_OUTPUT_TYPES_ROUNDOFFTO5DECIMALPLACE = "8";
	public static final String FORMULA_OUTPUT_TYPES_CEIL = "9";
	public static final String FORMULA_OUTPUT_TYPES_FLOOR = "10";

	//******************* Yes No Flag Value
	public static final String YES_NO_VALUE_NO = "0";
	public static final String YES_NO_VALUE_YES = "1";

	//******************* Yes No Flag
	public static final boolean YES_NO_FLAG_NO = false;
	public static final boolean YES_NO_FLAG_YES = true;
	
	// ******************* Language
	public static final String LANGUAGE_HINDI = "Hin";
	public static final String LANGUAGE_ENGLISH = "Eng";
	public static final String LANGUAGE_HINDI_FONT = "Kruti Dev 010";

	//******************* Initial Parameter Prefix
	public static final String PARAMETER_INITIAL_NAME = GenericTemplateConfig.PARAMETER_STARTS_WITH;
	public static final String TEMPLATE_TD_STARTS_WITH = "tdTemplate@";
	public static final String LABEL_DIV_STARTS_WITH = "divLabel@";
}