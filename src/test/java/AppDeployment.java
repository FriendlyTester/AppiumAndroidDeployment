import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by richard on 21/11/2015.
 */
public class AppDeployment
{
    @Test
    public void DeployApp() throws IOException, InterruptedException
    {
        //https://discuss.appium.io/t/launching-and-stopping-appium-server-programmtically/700
        //Via Terminal. adb devices | tail -n +2 | cut -sf 1 | xargs -I {} adb -s {} install <Path to apk>

        AppiumService appiumService = new AppiumService();
        Assert.assertTrue(appiumService.killAllAppiumServers());

        ADBService adbService = new ADBService();
        List<AndroidDevice> deviceList = adbService.getAndroidDevices();
        deviceList = Utils.AddPortsToDevices(deviceList);

        //Start X appium servers
        appiumService.startAppiumServers(deviceList);

        //Install app
        for (AndroidDevice device : deviceList)
        {
            DriverFactory  driverFactory = new DriverFactory();
            AndroidDriver driver = driverFactory.create(device);
        }

        Assert.assertTrue(appiumService.killAllAppiumServers());
    }

}
