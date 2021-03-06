/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import static org.testng.Assert.*;

import mobile.page_objects.NovoEditarPO;
import mobile.page_objects.TelaPrincipalPO;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

/**
 *
 * @author suporte
 */
public class AdicionarPessoaTest {
    
    @Test
    public void adicionarPessoaComSucesso() throws MalformedURLException{
        File app = new File("C:/Users/suporte/IdeaProjects/projeto-automacao-unidavi/app/pessoas.apk");
        
        DesiredCapabilities capacidade = new DesiredCapabilities();
        capacidade.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        
        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capacidade);

        TelaPrincipalPO telaPrincipalPO = new TelaPrincipalPO(driver);
        NovoEditarPO novoEditarPO = new NovoEditarPO(driver);

        telaPrincipalPO.clicarEmAdicionar();
        novoEditarPO.preencherNomePessoa("Marcelo");
        novoEditarPO.preencherEnderecoPessoa("UNIDAVI");
        novoEditarPO.preencherHobbiePessoa("OIOI");
        novoEditarPO.clicarEmSalvar();
        telaPrincipalPO.pesquisar("Marcelo");

    }
    
}
