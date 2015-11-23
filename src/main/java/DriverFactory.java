import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import models.AndroidDevice;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by richard on 22/11/2015.
 */
public class DriverFactory
{
    public AndroidDriver create(AndroidDevice device) throws MalformedURLException
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device.DeviceName);
        capabilities.setCapability("udid", device.DeviceName);
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/richard/Downloads/Priority-20150921_Ref_1_debug.apk");

        //Need to set wait for Activity

        return new AndroidDriver(new URL(String.format("http://127.0.0.1:%s/wd/hub", device.AppiumPort)), capabilities);
    }
}
