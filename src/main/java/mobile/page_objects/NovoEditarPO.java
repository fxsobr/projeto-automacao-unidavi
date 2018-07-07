package mobile.page_objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class NovoEditarPO {

    @AndroidFindBy(id = "com.eliasnogueira.workshop:id/txt_nome")
    MobileElement nomePessoa;

    @AndroidFindBy(id = "com.eliasnogueira.workshop:id/txt_endereco")
    MobileElement enderecoPessoa;

    @AndroidFindBy(id = "com.eliasnogueira.workshop:id/txt_hobbies")
    MobileElement hobbiePessoa;

    @AndroidFindBy(id = "com.eliasnogueira.workshop:id/button")
    MobileElement botaoSalvar;

    @AndroidFindBy(id = "android:id/text1")
    MobileElement verificaNome;

    public NovoEditarPO(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void preencherNomePessoa(String nome){
        nomePessoa.sendKeys(nome);
    }


    public void preencherEnderecoPessoa(String endereco){
        enderecoPessoa.sendKeys(endereco);
    }


    public void preencherHobbiePessoa(String hobbie){
        hobbiePessoa.sendKeys(hobbie);
    }

    public void clicarEmSalvar(){
        botaoSalvar.click();
    }


}
