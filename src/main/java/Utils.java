import java.util.List;

/**
 * Created by richard on 22/11/2015.
 */
public class Utils
{
    static int basePort = 4730;

    public static List<AndroidDevice> AddPortsToDevices(List<AndroidDevice> deviceList)
    {
        for (AndroidDevice device : deviceList)
        {
            device.AppiumPort = basePort + deviceList.indexOf(device);
        }

        return deviceList;
    }
}
