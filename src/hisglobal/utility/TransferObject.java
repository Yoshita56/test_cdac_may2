package hisglobal.utility;

import java.io.Serializable;

/**
 *All the Value Object (VO) Classes must implement this Interface.
 *
 * @author Ajay Kumar Gupta <br> Copyright ©C-DAC Noida
 *
 *
 */
public interface TransferObject extends Serializable {

	/**
	 * set the Message String which should be displayed in the UI Screen.
	 * @param MSGSTR
	 */
	public void setStrMsgString(String MSGSTR);

	/**
	 * 
	 * @param MSGTYPE <b>0</b> No Error, <b>1</b> Error, <b>2</b> Warning
	 */
	public void setStrMsgType(String MSGTYPE);
	
	/**
	 * get Message Type
	 * @return MSGTYPE
	 */
	public String getStrMsgType();
	
	/**
	 * get Message String
	 * @return MSGSTR
	 */
	public String getStrMsgString();
}
