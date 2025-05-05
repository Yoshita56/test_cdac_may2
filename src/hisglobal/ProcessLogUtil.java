/*
 Name		Amit Kumar Ateria
 */
package hisglobal;

import hisglobal.transactionmgnt.HisDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * Global Class for all kind of His Utilities. The Class contains Various
 * utility methods which are used in various part of HIS Project.
 * 
 * @author Amit Kumar Ateria <br>
 *         Copyright ©C-DAC Noida
 * 
 */
public  class ProcessLogUtil 
{

	private String moduleName = "";
	private String fileName = "";
	//All Threshold in Seconds
	public static final   String PROCESS_LOG_TRANS_LOAD_THRESHOLD_SECONDS = "2";
	public static final String PROCESS_LOG_TRANS_SAVE_THRESHOLD_SECONDS = "5";
	public static final String PROCESS_LOG_TRANS_RESPONSE_THRESHOLD_SECONDS = "5";
	
	public static final String PROCESS_LOG_MASTERS_LOAD_THRESHOLD_SECONDS = "2";
	public static final String PROCESS_LOG_MASTERS_SAVE_THRESHOLD_SECONDS = "3";
	public static final String PROCESS_LOG_MASTERS_RESPONSE_THRESHOLD_SECONDS = "3";
	
	public static final String PROCESS_LOG_REPORTS_LOAD_THRESHOLD_SECONDS = "2";	
	public static final String PROCESS_LOG_REPORTS_DAILY_LISTING_GENERATE_THRESHOLD_SECONDS = "5";
	public static final String PROCESS_LOG_REPORTS_DAILY_STATS_GENERATE_THRESHOLD_SECONDS = "5";
	public static final String PROCESS_LOG_REPORTS_MONTHLY_LISTING_GENERATE_THRESHOLD_SECONDS = "10";
	public static final String PROCESS_LOG_REPORTS_MNTHLY_DSS_GENERATE_THRESHOLD_SECONDS = "10";
	public static final String PROCESS_LOG_REPORTS_YEARLY_LISTING_GENERATE_THRESHOLD_SECONDS = "20";
	public static final String PROCESS_LOG_REPORTS_YEARLY_DSS_GENERATE_THRESHOLD_SECONDS = "20";
	
	/**
	 * Constructor
	 * 
	 * @param moduleName
	 *            -The Current Working Module.
	 * @param fileName -
	 *            The Current Working Java File.
	 */
	public ProcessLogUtil(String moduleName, String fileName) {
		this.moduleName = moduleName;
		this.fileName = fileName;
	}

	public static String startTransation(String menuId,String processName,String shortName,String tokenStatus,HttpServletRequest request,String puk)
	{
		HisDAO daoObj = null;
		
		String strProcName = "{call pkg_trans_log_util.dml_log_trans(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String transid = "";
		String strErr ;
		String cr="0";
		String deviceType="1";//1-Desktop,2-Mobile
		String ipaddress="0.0.0.0";
		ipaddress=GetAddress("ip");
		if(ipaddress!=null)
			ipaddress=ipaddress;
		else
			ipaddress="0.0.0.0";
		if(request.getHeader("User-Agent").contains("Mobi")) 
		{
			deviceType="2";
		} 
		if(puk!=null && !puk.equals("") )
			cr=puk;
			
		
		String hospCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
		String seatId=request.getSession().getAttribute("SEATID").toString();
		
		try 
		{
			daoObj = new HisDAO("HisGlobal","ProcessLogUtil");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", hospCode,2);
			daoObj.setProcInValue(nProcIndex, "process_id", menuId,3);
			daoObj.setProcInValue(nProcIndex, "processname", processName,4);
			daoObj.setProcInValue(nProcIndex, "transid", "0",5);
			daoObj.setProcInValue(nProcIndex, "seatid", seatId,6);
			daoObj.setProcInValue(nProcIndex, "tokenstatus", tokenStatus,7);
			daoObj.setProcInValue(nProcIndex, "puk", cr,8);
			daoObj.setProcInValue(nProcIndex, "trans_type", "4",9);
			daoObj.setProcInValue(nProcIndex, "devicetype", deviceType,10);
			daoObj.setProcInValue(nProcIndex, "ipaddress", ipaddress,11);
			daoObj.setProcInValue(nProcIndex, "shortname", shortName,12);
			daoObj.setProcOutValue(nProcIndex, "generatedtransid", 1,13);
			daoObj.setProcInValue(nProcIndex, "host", GetAddress("host"),14);
			daoObj.setProcOutValue(nProcIndex, "err", 1,15);

			daoObj.executeProcedureByPosition(nProcIndex);

			transid = daoObj.getString(nProcIndex, "generatedtransid");
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr==null)
				strErr = "";
			
			if (strErr.equals(""))
			{
				request.getSession().setAttribute("TRANS_ID", transid);
				request.getSession().setAttribute("PUK_CR", puk);
			}				
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
		return transid;
	}
	public static void completeTransation(String menuId,String tokenStatus,HttpServletRequest request,String puk)
	{
		HisDAO daoObj = null;
		
		String strProcName = "{call pkg_trans_log_util.dml_log_trans(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		
		String hospCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
		String seatId=request.getSession().getAttribute("SEATID").toString();
		
		try 
		{
			String transIdReq=request.getSession().getAttribute("TRANS_ID").toString();

			daoObj = new HisDAO("HisGlobal","ProcessLogUtil");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "2",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", hospCode,2);
			daoObj.setProcInValue(nProcIndex, "process_id", menuId,3);
			daoObj.setProcInValue(nProcIndex, "processname", "",4);
			daoObj.setProcInValue(nProcIndex, "transid", transIdReq,5);
			daoObj.setProcInValue(nProcIndex, "seatid", seatId,6);
			daoObj.setProcInValue(nProcIndex, "tokenstatus", tokenStatus,7);
			daoObj.setProcInValue(nProcIndex, "puk", puk,8);
			daoObj.setProcInValue(nProcIndex, "trans_type", "4",9);
			daoObj.setProcInValue(nProcIndex, "devicetype", "",10);
			daoObj.setProcInValue(nProcIndex, "ipaddress", "",11);	
			daoObj.setProcInValue(nProcIndex, "shortname", "",12);			
			daoObj.setProcOutValue(nProcIndex, "generatedtransid", 1,13);
			daoObj.setProcInValue(nProcIndex, "host", GetAddress("host"),14);
			daoObj.setProcOutValue(nProcIndex, "err", 1,15);
			
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";				
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void beforeSave(String menuId,String tokenStatus,HttpServletRequest request,String puk)
	{
		HisDAO daoObj = null;
		
		String strProcName = "{call pkg_trans_log_util.dml_log_trans(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		
		String hospCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
		String seatId=request.getSession().getAttribute("SEATID").toString();
		
		try 
		{
			String transIdReq=request.getSession().getAttribute("TRANS_ID").toString();

			daoObj = new HisDAO("HisGlobal","ProcessLogUtil");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "3",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", hospCode,2);
			daoObj.setProcInValue(nProcIndex, "process_id", menuId,3);
			daoObj.setProcInValue(nProcIndex, "processname", "",4);
			daoObj.setProcInValue(nProcIndex, "transid", transIdReq,5);
			daoObj.setProcInValue(nProcIndex, "seatid", seatId,6);
			daoObj.setProcInValue(nProcIndex, "tokenstatus", tokenStatus,7);
			daoObj.setProcInValue(nProcIndex, "puk", puk,8);
			daoObj.setProcInValue(nProcIndex, "trans_type", "4",9);
			daoObj.setProcInValue(nProcIndex, "devicetype", "",10);
			daoObj.setProcInValue(nProcIndex, "ipaddress", "",11);	
			daoObj.setProcInValue(nProcIndex, "shortname", "",12);	
			daoObj.setProcOutValue(nProcIndex, "generatedtransid", 1,13);
			daoObj.setProcInValue(nProcIndex, "host", GetAddress("host"),14);
			daoObj.setProcOutValue(nProcIndex, "err", 1,15);
			
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";				
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
	}
	public static void afterSave(String menuId,String tokenStatus,HttpServletRequest request,String puk)
	{
		HisDAO daoObj = null;
		
		String strProcName = "{call pkg_trans_log_util.dml_log_trans(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		
		String hospCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
		String seatId=request.getSession().getAttribute("SEATID").toString();
		
		try 
		{
			String transIdReq=request.getSession().getAttribute("TRANS_ID").toString();

			daoObj = new HisDAO("HisGlobal","ProcessLogUtil");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "modeval", "4",1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", hospCode,2);
			daoObj.setProcInValue(nProcIndex, "process_id", menuId,3);
			daoObj.setProcInValue(nProcIndex, "processname", "",4);
			daoObj.setProcInValue(nProcIndex, "transid", transIdReq,5);
			daoObj.setProcInValue(nProcIndex, "seatid", seatId,6);
			daoObj.setProcInValue(nProcIndex, "tokenstatus", tokenStatus,7);
			daoObj.setProcInValue(nProcIndex, "puk", puk,8);
			daoObj.setProcInValue(nProcIndex, "trans_type", "4",9);
			daoObj.setProcInValue(nProcIndex, "devicetype", "",10);
			daoObj.setProcInValue(nProcIndex, "ipaddress", "",11);	
			daoObj.setProcInValue(nProcIndex, "shortname", "",12);	
			daoObj.setProcOutValue(nProcIndex, "generatedtransid", 1,13);			
			daoObj.setProcInValue(nProcIndex, "host", GetAddress("host"),14);
			daoObj.setProcOutValue(nProcIndex, "err", 1,15);
			
			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";				
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			if (daoObj != null) 
			{
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	/*
	 * public static void main(String a[]){
	 * System.out.println("MAC Address: "+GetNetworkAddress.GetAddress("mac"));
	 * System.out.println("IP Address: "+GetNetworkAddress.GetAddress("ip")); }
	 */

	/**
	 * Function to return IP/MAC Address
	 * @param addressType : Pass "ip" for IP address and "mac" for MAC Address, "remotehost" server ip
	 * @return : String with IP or MAC Address
	 */
    public static String GetAddress(String addressType) {
        String address = "";
        InetAddress lanIp=null,host = null;
        
        try {

            String ipAddress = null;
            Enumeration<NetworkInterface> net = null;
            net = NetworkInterface.getNetworkInterfaces();

            while (net.hasMoreElements()) {
                NetworkInterface element = net.nextElement();
                Enumeration<InetAddress> addresses = element.getInetAddresses();

                if(element.getHardwareAddress()!=null)
                {
                while (addresses.hasMoreElements()  && element.getHardwareAddress().length > 0 && !isVMMac(element.getHardwareAddress())) {
                    InetAddress ip = addresses.nextElement();
                    host=ip.getLocalHost();
                    if (ip instanceof Inet4Address) {

                        if (ip.isSiteLocalAddress()) {
                            ipAddress = ip.getHostAddress();
                            lanIp = InetAddress.getByName(ipAddress);
                        }

                    }
                }

                }
            }

            if (lanIp == null)
                return "0.0.0.0";

            if (addressType.equalsIgnoreCase("ip")) {

                address = lanIp.toString().replaceAll("^/+", "");

            } else if (addressType.equalsIgnoreCase("mac")) {

                address = getMacAddress(lanIp);

            } else if (addressType.equalsIgnoreCase("host")) {

                address = host.toString();

            } else {

                throw new Exception("Specify \"ip\" or \"mac\"");

            }

        } catch (UnknownHostException ex) {

            ex.printStackTrace();

        } catch (SocketException ex) {

            ex.printStackTrace();

        } catch (Exception ex) {

            ex.printStackTrace();

        }

        return address;

    }

    /**
     * Function to get MAC address
     * @param ip
     * @return
     */
    private static String getMacAddress(InetAddress ip) {
        String address = null;
        try {

            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            address = sb.toString();

        } catch (SocketException ex) {

            ex.printStackTrace();

        }

        return address;
    }

    /**
     * Function to exclude VM address
     * @param mac
     * @return
     */
    private static boolean isVMMac(byte[] mac) {
        if(null == mac) return false;
        byte invalidMacs[][] = {
                {0x00, 0x05, 0x69},             //VMWare
                {0x00, 0x1C, 0x14},             //VMWare
                {0x00, 0x0C, 0x29},             //VMWare
                {0x00, 0x50, 0x56},             //VMWare
                {0x08, 0x00, 0x27},             //Virtualbox
                {0x0A, 0x00, 0x27},             //Virtualbox
                {0x00, 0x03, (byte)0xFF},       //Virtual-PC
                {0x00, 0x15, 0x5D}              //Hyper-V
        };

        for (byte[] invalid: invalidMacs){
            if (invalid[0] == mac[0] && invalid[1] == mac[1] && invalid[2] == mac[2]) return true;
        }

        return false;
    }

    
    
    /**
	 * Method in case of Java 5 or below by parsing on output of ipconfig on cmd (on Windows OS)
	 * @return
	 * @throws IOException
	 */

	private static String getMacAddressJava5() throws IOException {
		String s=null;
		String command = "ipconfig /all";
		Process pid = Runtime.getRuntime().exec(command);
		BufferedReader in = new BufferedReader(new InputStreamReader(pid.getInputStream()));
		Pattern p = Pattern.compile(".*Physical Address.*: (.*)");
		while (true) {
			String line = in.readLine();
			if (line == null)
				break;
			Matcher m = p.matcher(line);
			if (m.matches()) {
				s= m.group(1);
			}
		}

		return s;
	}
	
	

}