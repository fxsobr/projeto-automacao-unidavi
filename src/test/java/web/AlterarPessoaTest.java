package web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class AlterarPessoaTest {

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
    public void editarPessoa(){
        driver.get("http://livrodeteste.com/otestadortecnico/app");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("adicionar")));
        driver.findElement(By.id("pesquisar")).click();
        driver.findElement(By.id("pesquisar")).sendKeys("Marcelo");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("editar")));
        driver.findElement(By.id("editar")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".w3-btn.w3-teal")));
        driver.findElement(By.id("nome")).clear();
        driver.findElement(By.id("nome")).sendKeys("nomeEditado");
        driver.findElement(By.id("hobbies")).clear();
        driver.findElement(By.id("hobbies")).sendKeys("hobbieEditado");
        driver.findElement(By.cssSelector(".w3-btn.w3-teal")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("adicionar")));
        driver.findElement(By.id("pesquisar")).click();
        driver.findElement(By.id("pesquisar")).sendKeys("nomeEditado");

        assertEquals(driver.findElement(By.id("nome")).getText(), "nomeEditado");


    }

}
