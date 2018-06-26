package br.com.mercadolivre.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;

import net.thucydides.core.Thucydides;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;


public class MercadoLivre {

    private WebDriver driver;
      
    public MercadoLivre(WebDriver driver) {
        this.driver = driver;
    }
	
    public void visita() {
        driver.manage().window().maximize();
        driver.get("https://www.mercadolivre.com.br/");
    }

	public void pesquisaProduto(String Produto) {

		WebElement pesquisa = driver.findElement(By.name("as_word"));
		pesquisa.sendKeys(Keys.ENTER, Produto, Keys.ENTER);

	}

	public void listaPreco() {
		for(int n = 1;n<6;n++) {
			WebElement titulo = driver.findElement(By.xpath("(//span[@class='main-title'])["+ n +"]"));
			WebElement preco = driver.findElement(By.xpath("(//span[@class='price__fraction'])["+ n +"]"));
			System.out.println(titulo.getText());
			System.out.println("Preço:" + preco.getText());
		}

		
	}

	public void proximaPagina() {
		WebElement next = driver.findElement(By.xpath("//li[@class='pagination__next']"));
		next.click();	    
	    Actions action = new Actions(driver);
	    action.sendKeys(Keys.END).build().perform();

	    action.sendKeys(Keys.PAGE_UP).build().perform();
//	    Keyboard keyboard = ((HasInputDevices) driver).getKeyboard();
//	    keyboard.pressKey(Keys.END);
	    
	    
	}

	public void tiraPrint() throws IOException {
	
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	FileUtils.copyFile(scrFile, new File("screenshot.png"));
		
	}
	
	
	
	
	
}
