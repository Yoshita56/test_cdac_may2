package hisglobal.masterutil;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpSession;
  
public interface MasterInterface extends Serializable{

	public static final String nextprevcolor = "white";
	public static final String nextprevcolorReports = "green";
		
	public void setHttpSession(HttpSession session);
	
	public boolean reportInterFaceRequired();
	
	/* Master Name can be appended with row status if needed
	 * For row status user has to give four values i.e 
	 * [0] = value, on which condition has to be checked.
	 * [1] = column, column no. which tells value of which entity has to be checked. [start with 1]
	 * [2] = color, color which the user wants to display note in.
	 * [3] = note, note which user wants to give. 
	 * e.g Master Name#4^Drug^Drugs^Pink
	 */
	public String getMasterName();
 
	/*
	 * User Has to specify the name of master( user friendly ) so it will display on all pages 
	 * 
	 *
     * 
     * 
     * 
     * */

	/*
	 public int getNo_of_column();

	 /*
	 * User Has to specify the number of columns of the main query  
	 * 
	 * */

	 String[] getColumnHeader();

	/*
	 * User Has to specify the columns header of main query  
	 * 
	 * */

	public String[] getSearchField();

	/*
	 * getSearchField() values will be displayed in search combo of list page
	 * 
	 */

	public int getRecord_per_page();

	/*
	 * User Has to specify the record_per_page want to display on list page
	 * 
	 * */

	public int getPage_per_block();

	/*
	 * User Has to specify the page_per_block  want to display on the list page
	 * 
	 * */

	public String[] getComboQuery();

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

	public String getMainQuery(String cmb[]);
 
	/*
	 * User Has to provide a main query in main query first column(index)
	 *  will be primary key and value is assign to checkbox
	 * and if multiple primary key than user has to concatenate with $ sign 
	 * 
	 * */

	public String[] getComboHeader();

	/*
	 * public String[]	getComboHeader(); 
	 * 
	 * user has to specify the name of combo header and it will return array of string 
	 */

	public String getViewQuery();

	/*
	 * user has to provide view query like example below
	 * 	viewQuery = "SELECT HRGNUM_PUK puk, INITCAP(HRGSTR_FNAME),HRGDT_DOB,HRGSTR_FHNAME FROM HRGT_PATIENT_DTL WHERE HRGNUM_PUK=?";
	 */

	public List<String> getViewHeader();

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

	public String[] getOrderBy();

	/*
	 * getOrderBy() method return the value which user want to
	 *  sort data, order by used to sort data ascending or descending order , 
	 * first index must be provided by user and first index will be default 
	 * order of asc 
	 * 
	 * 
	 */

	public String[] getDeleteQuery();

	/*  
	 * deletQuery = "UPDATE HRGT_PATIENT_DTL " + "SET  GBL_ISVALID='MOHIT'"
	 * "where HRGNUM_PUK=? ";
	 * 
	 */

	public String getButtons();

	/*
	 *getButtons() method is the button link which will be going to display in master listing page
	 * 
	 */

	public String getJsFiles();

	/*
	 *getJsFiles() method is the address of js files when developer wants to includes own js files
	 * 
	 */
	/*
	 *@getColsWidth() this method is used to define the width of columns in report
	 * 
	 */
	public String[] getColsWidth();
	
	public String isGlobal();

	
}
