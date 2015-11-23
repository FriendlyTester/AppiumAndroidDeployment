package services;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import models.AndroidDevice;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by richard on 22/11/2015.
 */
public class AppiumService
{
    public List<AppiumDriverLocalService> appiumServicesRunning= new ArrayList<AppiumDriverLocalService>();

    public boolean startAppiumServers(List<AndroidDevice> devicesAndPorts)
    {
        for (AndroidDevice device : devicesAndPorts)
        {
            AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingPort(device.AppiumPort));
            service.start();
            appiumServicesRunning.add(service);
        }

        for (AppiumDriverLocalService service : appiumServicesRunning)
        {
            if (!service.isRunning())
            {
                return false;
            }
        }

        return true;
    }

    public void stopAppiumServers()
    {
        for (AppiumDriverLocalService service : appiumServicesRunning)
        {
            service.stop();
        }
    }
}
