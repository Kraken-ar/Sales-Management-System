package app.Classes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.util.Enumeration;



public class DeviceInfo {

    // Method to get the MAC Address
    public static String getMacAddress() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface ni = interfaces.nextElement();
                byte[] mac = ni.getHardwareAddress();
                if (mac != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < mac.length; i++) {
                        sb.append(String.format("%02X", mac[i]));
                        if (i < mac.length - 1) {
                            sb.append("-");
                        }
                    }
                    return sb.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to get the Hard Disk Serial Number (Windows)
    public static String getHardDiskSerialNumber() {
        return executeCommand("wmic diskdrive get serialnumber");
    }

    // Method to get the CPU Serial Number (Windows)
    public static String getCpuSerialNumber() {
        return executeCommand("wmic cpu get processorid");
    }

    // Method to get the Motherboard Serial Number (Windows)
    public static String getMotherboardSerialNumber() {
        return executeCommand("wmic baseboard get serialnumber");
    }

    // Helper method to execute a command and return the result
    private static String executeCommand(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                // Filter out empty lines and headers
                if (!line.trim().isEmpty() && !line.toLowerCase().contains(command.split(" ")[2].toLowerCase())) {
                    result.append(line.trim());
                }
            }
            reader.close();
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
