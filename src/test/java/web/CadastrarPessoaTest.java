package web;

import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CadastrarPessoaTest {

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
    public void cadastroComSucesso(){
        driver.get("http://livrodeteste.com/otestadortecnico/app");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("adicionar")));
        driver.findElement(By.id("adicionar")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".w3-btn.w3-teal")));
        driver.findElement(By.id("nome")).sendKeys("Bolinho");
        driver.findElement(By.name("endereco")).sendKeys("Rio do Oeste");
        driver.findElement(By.id("hobbies")).sendKeys("Comer");
        driver.findElement(By.cssSelector(".w3-btn.w3-teal")).click();
    }
}
