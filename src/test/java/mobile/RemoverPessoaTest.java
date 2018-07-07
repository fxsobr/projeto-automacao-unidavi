package mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class RemoverPessoaTest {

    @Test
    public void removerPessoaComSucesso() throws MalformedURLException {
        File app = new File("C:/Users/suporte/IdeaProjects/projeto-automacao-unidavi/app/pessoas.apk");

        DesiredCapabilities capacidade = new DesiredCapabilities();
        capacidade.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");

        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capacidade);

        driver.findElement(By.id("android:id/search_button")).click();
        driver.findElement(By.id("android:id/search_src_text")).sendKeys("oioi");
        TouchAction action = new TouchAction(driver);
        LongPressOptions longPressOptions = new LongPressOptions();
        longPressOptions.withElement(new ElementOption().withElement(driver.findElement(By.id("android:id/text1")))).build();
        action.longPress(longPressOptions).perform();
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.id("android:id/button3")).click();
    }

}
