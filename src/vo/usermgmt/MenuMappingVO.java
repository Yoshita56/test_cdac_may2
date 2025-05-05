package vo.usermgmt;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.internal.xr.ValueObject;

@XmlRootElement
public class MenuMappingVO extends ValueObject implements Serializable
{
	private static final long serialVersionUID = 3101L;

	private String menuId;
	private String menuName;
	private String menuUrl;
	private String cntPath;
	private String startMethod;
	private String endMethod;
	private String endMethodWebServiceUrl;
	private String shortName;
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getCntPath() {
		return cntPath;
	}
	public void setCntPath(String cntPath) {
		this.cntPath = cntPath;
	}
	public String getStartMethod() {
		return startMethod;
	}
	public void setStartMethod(String startMethod) {
		this.startMethod = startMethod;
	}
	public String getEndMethod() {
		return endMethod;
	}
	public void setEndMethod(String endMethod) {
		this.endMethod = endMethod;
	}
	public String getEndMethodWebServiceUrl() {
		return endMethodWebServiceUrl;
	}
	public void setEndMethodWebServiceUrl(String endMethodWebServiceUrl) {
		this.endMethodWebServiceUrl = endMethodWebServiceUrl;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	
}
