import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;

import java.io.IOException;
import java.util.List;

/**
 * Created by richard on 22/11/2015.
 */
public class AppiumService
{
    public boolean killAllAppiumServers()
    {
        //Kill all appium servers
        try
        {
            Process proc1 = Runtime.getRuntime().exec("killall -9 node");
        }
        catch (IOException exception)
        {
            return false;
        }

        return true;
    }

    public boolean startAppiumServers(List<AndroidDevice> devicesAndPorts)
    {
        try
        {
            for (AndroidDevice devicessss : devicesAndPorts)
            {
                //Process startAppiumProcess = Runtime.getRuntime().exec(String.format("appium -p %s --log /Users/richard/Downloads/appiumlog%s", devicessss.AppiumPort, devicessss.AppiumPort));
                CommandLine command = new CommandLine("/Applications/Appium.app/Contents/Resources/node/bin/node");
                command.addArgument("/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js", false);
                command.addArgument("--address", false);
                command.addArgument("127.0.0.1");
                command.addArgument("--port", false);
                command.addArgument(String.valueOf(devicessss.AppiumPort));
                command.addArgument("--full-reset", false);
                DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
                DefaultExecutor executor = new DefaultExecutor();
                executor.setExitValue(1);
                executor.execute(command, resultHandler);

                Thread.sleep(5000); //Nasty wait to give Appium time to kick in, will seek to improve this
                System.out.println("Appium server started");
            }
        }

        catch (InterruptedException e)
        {
         return false;
        }

        catch (ExecuteException e)
        {
            return false;
        }

        catch (IOException e)
        {
            return false;
        }

        return true;
    }
}
