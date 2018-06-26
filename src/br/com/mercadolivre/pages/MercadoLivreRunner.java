package br.com.mercadolivre.pages;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercadoLivreRunner {

	private WebDriver driver;
	private MercadoLivre mercado;
	
	@Before
	public void inicializa() {
		this.driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		mercado = new MercadoLivre(driver);
	}
	
	@Test
	public void pesquisaProduto() {
		
		mercado.visita();
		
		mercado.pesquisaProduto("Celular");
		
		mercado.listaPreco();


	}
	
	
	@Test
	public void pesquisaProdutoComPaginacao() throws IOException {
		
		mercado.visita();
		
		mercado.pesquisaProduto("Celular");
		
		mercado.proximaPagina();
		
		mercado.tiraPrint();

	}
	
    @After
    public void encerra() {
        driver.close();
    }
	
	
}
