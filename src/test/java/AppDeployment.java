import io.appium.java_client.android.AndroidDriver;
import models.AndroidDevice;
import org.junit.Assert;
import org.junit.Test;
import services.ADBService;
import services.AppiumService;

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

            //Login
            //This is where you would put that logs you in.
        }

        Assert.assertTrue(appiumService.killAllAppiumServers());
    }

}
