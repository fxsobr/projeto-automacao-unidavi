package web;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RemovePessoaTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void preCondicao(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\suporte\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @AfterMethod
    public void posCondicao(){
        driver.quit();
    }


    @Test
    public void removerPessoa(){
        driver.get("http://livrodeteste.com/otestadortecnico/app");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("adicionar")));
        driver.findElement(By.id("pesquisar")).click();
        driver.findElement(By.id("pesquisar")).sendKeys("nomeEditado");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("remover")));
        driver.findElement(By.id("remover")).click();

        Alert alerta = driver.switchTo().alert();
        assertEquals(alerta.getText(), "Deseja realmente remover?");
        alerta.accept();

    }

}
