package hisglobal.masterutil;
import org.apache.struts.action.ActionForm;

public class GenericFormBean extends ActionForm {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String combo[] = null;
	
	String hmode = "";
	
	String record_per_page = "";
	
	String page_per_block = "";
	
	String no_of_combo = "";
	
	String no_of_column = "";
	
	String actual_page_block = "";
	
	String nextBlock = "";
	
	String prevBlock = "";
	
	String divisionId = "";
	
	String divid = "";
	
	String comboValue = "";
	
	String cnt_page = "";
	
	String comboHeader[] = null;
	
	String search_field[] = null;
	
	public String chk[] = null;
	
	public final String[] getChk() {
		return chk;
	}
	
	public final void setChk(String[] chk) {
		this.chk = chk;
	}
	
	public final String[] getSearchField() {
		return search_field;
	}
	
	public final String[] getComboHeader() {
		return comboHeader;
	}
	
	public final String[] getCombo() {
		return combo;
	}
	
	
	
	public final void setCombo(String[] combo) {
		this.combo = combo;
	}
	
	public final String getActual_page_block() {
		return actual_page_block;
	}
	
	public void setActual_page_block(String actual_page_block) {
		this.actual_page_block = actual_page_block;
	}
	
	public final String getComboValue() {
		return comboValue;
	}
	
	public final void setComboValue(String comboValue) {
		this.comboValue = comboValue;
	}
	
	public final String getDivid() {
		return divid;
	}
	
	public final void setDivid(String divid) {
		this.divid = divid;
	}
	
	public final String getDivisionId() {
		return divisionId;
	}
	
	public final void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}
	
	public final String getNextBlock() {
		return nextBlock;
	}
	
	public final void setNextBlock(String nextBlock) {
		this.nextBlock = nextBlock;
	}
	
	public final String getNo_of_column() {
		return no_of_column;
	}
	
	public final void setNo_of_column(String no_of_column) {
		this.no_of_column = no_of_column;
	}
	
	public final String getNo_of_combo() {
		return no_of_combo;
	}
	
	public final void setNo_of_combo(String no_of_combo) {
		this.no_of_combo = no_of_combo;
	}
	
	public final String getPage_per_block() {
		return page_per_block;
	}
	
	public final void setPage_per_block(String page_per_block) {
		this.page_per_block = page_per_block;
	}
	
	public final String getPrevBlock() {
		return prevBlock;
	}
	
	public final void setPrevBlock(String prevBlock) {
		this.prevBlock = prevBlock;
	}
	
	public final String getRecord_per_page() {
		return record_per_page;
	}
	
	public final void setRecord_per_page(String record_per_page) {
		this.record_per_page = record_per_page;
	}
	 
	public final String[] getSearch_field() {
		return search_field;
	}
	
	public final void setSearch_field(String[] search_field) {
		this.search_field = search_field;
	}
	
	public final void setCnt_page(String cnt_page) {
		this.cnt_page = cnt_page;
	}
	
	public final void setComboHeader(String[] comboHeader) {
		this.comboHeader = comboHeader;
	}
	
}
