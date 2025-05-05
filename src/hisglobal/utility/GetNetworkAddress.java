package hisglobal.utility;

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

public class GetNetworkAddress {
	
	public static void main(String a[]){
		System.out.println("MAC Address: "+GetNetworkAddress.GetAddress("mac"));
		System.out.println("IP Address: "+GetNetworkAddress.GetAddress("ip"));
	}

	/**
	 * Function to return IP/MAC Address
	 * @param addressType : Pass "ip" for IP address and "mac" for MAC Address
	 * @return : String with IP or MAC Address
	 */
    public static String GetAddress(String addressType) {
        String address = "";
        InetAddress lanIp = null;
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