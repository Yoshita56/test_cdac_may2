package in.cdac.mhealth.global.dao;

public class QueryParam {

	private Object value=null;
	private int type=0;
	
	public QueryParam(Object value, int type) {
		super();
		this.value = value;
		this.type = type;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString(){
		String val = String.valueOf(this.value);
		if (this.value.equals("")){
			val = "-";
		}
		return val + "@" + this.type;
	}
}
