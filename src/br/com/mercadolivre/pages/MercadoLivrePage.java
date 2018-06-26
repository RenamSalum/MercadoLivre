package br.com.mercadolivre.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MercadoLivrePage {

	@FindBy(name = "as_word")
	WebElement campoPesquisa;
	
	@FindBy(xpath = "//form[@class='nav-search']")
	WebElement campoPesquisa2;
	
	@FindBy(xpath = "//input[@class = 'nav-search-input']")
	WebElement campoPesquisa3;
	
	
}
