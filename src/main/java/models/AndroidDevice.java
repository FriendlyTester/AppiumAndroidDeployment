package models;

/**
 * Created by richard on 21/11/2015.
 */
public class AndroidDevice
{
    public String DeviceName;
    public int AppiumPort;

    public AndroidDevice(String deviceName, int appiumPort)
    {
        DeviceName = deviceName;
        AppiumPort = appiumPort;
    }
}
