import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by richard on 22/11/2015.
 */
public class ADBService
{
    public List<AndroidDevice> getAndroidDevices() throws IOException
    {
        List<AndroidDevice> finalDeviceList = new ArrayList<AndroidDevice>();

        //Find out how many Android devices connected.
        //Get there IDs
        Process proc = Runtime.getRuntime().exec("adb devices");
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(proc.getInputStream()));
        List<String> devices = new ArrayList<String>();

        String line = "";
        while((line = reader.readLine()) != null) {
            devices.add(line);
        }

        //Remove the adb echo and empty line
        devices.remove(0);
        devices.remove(devices.size()-1);

        //Tidy up the device names
        for (int i = 0; i < devices.size(); i++)
        {
            devices.set(i,devices.get(i).replace("\t", ""));
            devices.set(i, devices.get(i).replace("device", ""));
            finalDeviceList.add(new AndroidDevice(devices.get(i), 4724));
        }

        return finalDeviceList;
    }
}
