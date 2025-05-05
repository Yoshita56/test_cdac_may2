package hisglobal.transactionutil;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpSession;
  
public abstract class TransInterface implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5778951610516883088L;
	public static final String nextprevcolor = "green";
	abstract public void setHttpSession(HttpSession session);
	abstract public void setCombo(String[] cmb);
	abstract public String getMasterName();
 
	/*
	 * User Has to specify the name of master( user friendly ) so it will display on all pages. 	  
     * 
     * */

	abstract public String[] getColumnHeader();

	/*
	 * User Has to specify the columns header of main query  
	 * 
	 * */

	abstract public String[] getSearchField();

	/*
	 * getSearchField() values will be displayed in search combo of list page
	 * 
	 */

	public int getRecord_per_page(){
		return 15;
	}

	/*
	 * User Has to specify the record_per_page want to display on list page
	 * 
	 * */

	public int getPage_per_block(){
		return 10;
	}

	/*
	 * User Has to specify the page_per_block  want to display on the list page
	 * 
	 * */

	abstract public String[] getComboQuery();

	/*
	 * query for combo  like below 
	 * first combo is not dependant on any other combo but second combo is depended on 
	 * GNUM_GENDER_CODE=#1#
	 * first combo it will take the value of first combo
	 * 
	 * comboQuery[0] = "SELECT GNUM_GENDER_CODE,GSTR_GENDER_NAME from GBLT_GENDER_MST WHERE GBL_ISVALID=1";
	 * comboQuery[1] = "SELECT GNUM_GENDER_CODE,GSTR_GENDER_NAME from GBLT_GENDER_MST WHERE GBL_ISVALID=1 and GNUM_GENDER_CODE=#1# ";
	 * 
	 * */

	abstract public String getMainQuery(String cmb[]);
 
	/*
	 * User Has to provide a main query in main query first column(index)
	 *  will be primary key and value is assign to checkbox
	 * and if multiple primary key than user has to concatenate with @ sign 
	 * 
	 * */

	abstract public String[] getComboHeader();

	/*
	 * public String[]	getComboHeader(); 
	 * 
	 * user has to specify the name of combo header and it will return array of string 
	 */	

	public String getButtons(){
		return "";
	}

	/*
	 *getButtons() method is the button link which will be going to display in master listing page
	 * 
	 */

	abstract public String getJsFiles();

	/*
	 *getJsFiles() method is the address of js files when developer wants to includes own js files
	 * 
	 */
	
	public String getHeaderNote(){
		String strMsg = "";
		return strMsg;
	}
	
	/*
	 * getHeaderNote() gives the note which user wants to display at header.
	 * 
	 */
	
	public String getFooterNote(){
		String strMsg = "Press ALT+CTRL+S TO Show Or Hide Search";
		return strMsg;
	}
	
	/*
	 * getFooterNote() gives the note which user wants to display at bottom.
	 * 
	 */
	
	public String[] getRowStatus(){
		String[] str = {"","1","",""};
		return str;
	}
	/*
	 * user has to give four values i.e 
	 * [0] = value, on which condition has to be checked.
	 * [1] = column, column no. which tells value of which entity has to be checked. [start with 1]
	 * [2] = color, color which the user wants to display note in.
	 * [3] = note, note which user wants to give. 
	 * 
	 */

	//public int getNo_of_primary_keys();
	/*
	 * this function returns the number of primary keys main query can have.
	 */
	
	public int getNo_of_combo(){
		return 7;
	}
	
	/**
	 * Used to sort the data
	 * @return
	 */
	abstract public String[] getOrderBy(); 
	
	/**
	 * specify the query
	 * @return
	 */
	public String[] getDeleteQuery() {
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public List<?> getDeleteData(String chk) {
		return null;
	}
	/*
	 * user has to provide view query like example below
	 * 	viewQuery = "SELECT HRGNUM_PUK puk, INITCAP(HRGSTR_FNAME),HRGDT_DOB,HRGSTR_FHNAME FROM HRGT_PATIENT_DTL WHERE HRGNUM_PUK=?";
	 */
	public String getViewQuery() {
		return null;
	}

	/*
	 * User has to provide view header like below this example
	 * first index shows the view header and second index will be type of control like  
	  * 
	 viewHdr.add("Patient CrNo");
	 viewHdr.add("D");  // default
	 viewHdr.add("Name");
	 viewHdr.add("T");  // textarea
	 viewHdr.add("Birth Date");
	 viewHdr.add("R");  // radiobutton
	 viewHdr.add("Father Name");
	 
	 */
	public List<?> getViewHeader() {
		return null;
	}

	/*
	 *  this function returns the number of combos which should come in a row.
	 */
	
	abstract public String getEventState();
	/*
	 * this function returns the name of user's JS function.
	 */
	
	abstract public String[] getUserDefinedButtons();
	/*
	 * this function creates buttons for the button panel as per user choice.
	 */
	
	abstract public String[] getDbButtons();
	/*
	 * this function creates buttons for the button panel as per database.
	 */
	
	abstract public int getMinPanelButton();
	/*
	 * this function returns the minimum no. of buttons which must be present on left side button panel.
	 */
	
	abstract public String getButtonConfiguration();
	/*
	 * this function returns the position of button panel i.e. Right, Left or Both. 
	 */
	
	abstract public String getMenuOption();
	/*
	 * this function returns the choice of menu i.e. either Tiles or Frames. In case of Tiles, put tiles entry
	 * into your struts config.xml
	 */
	
	abstract public String getComboEventState();
	
	/* this method is used for combo reset choice.
	 * 0 means combo will be reset after previous combo changes 
	 * and 1 means combo will not reset on previous combo change
	 */
	
	public String[] getComboReset(){
		return null;
	}
	/*
	 * this function tell that desk should open in full page or not
	 * If value is 0 means desk should open in specified area 
	 * If value is 1 means that desk should open in full screen-hiding menu frame
	 * 
	 */
	public String getVisibilityMode(){
		return "0";
	}
	/*
	 * this function shows extra information in pagination header
	 *  
	 */
	public String[] getExtraInformationName(){
		return null;
	}
	/*
	 * this function gets the query to shows extra information in pagination header
	 * 
	 */
	public String[] getExtraInformationQuery(){
		return null;
	}
	/*
	 * this function gets the query to shows extra information in pagination header
	 * 
	 */
	public String[] getExtraInformationQuery(String cmb[]){
		return null;
	}
	public String[] getButtonIcons()
	{
		/*String[] str = {"icon-default.png"};
		return str;*/
		return null;
	}
	public String showHelp()
	{
		/*String[] str = {"icon-default.png"};
		return str;*/
		return "";
	}

}
