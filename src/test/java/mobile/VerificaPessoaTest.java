package mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class VerificaPessoaTest {

    @Test
    public void verificaPessoaComSucesso() throws Exception{
        DesiredCapabilities capacidade = new DesiredCapabilities();
        capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");

        capacidade.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.eliasnogueira.workshop");
        capacidade.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "activities.ListActivity");

        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capacidade);

        driver.findElement(By.id("android:id/search_button")).click();
        driver.findElement(By.id("android:id/search_src_text")).sendKeys("umapessoa");
        driver.findElement(By.id("android:id/text1")).click();
        assertEquals(driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_nome")).getAttribute("text"),"umapessoa");
        assertEquals(driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_endereco")).getAttribute("text"),"UNDIAVI");
        assertEquals(driver.findElement(By.id("com.eliasnogueira.workshop:id/txt_hobbies")).getAttribute("text"),"OI");
        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        driver.findElement(By.id("com.eliasnogueira.workshop:id/refresh")).click();
        assertTrue(driver.findElement(By.id("com.eliasnogueira.workshop:id/fab")).isDisplayed());

    }

}
