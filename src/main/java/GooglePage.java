import javax.inject.Inject;

import org.openqa.selenium.WebDriver;

import com.mokona.core.Element;
import com.mokona.core.MokonaPage;
import com.mokona.element.Button;
import com.mokona.element.TextField;

public class GooglePage extends MokonaPage {

	@Inject 
	private WebDriver driver;
	
	@Element(selector = "#lst-ib")
	TextField searchInput;

	@Element(selector = "[name=\"btnK\"]")
	Button searchButton;

	public void search(String textToSearch) {
		driver.get("https://www.google.com.br/?gws_rd=ssl");
		searchInput.set(textToSearch);
		searchButton.click();
	}

	public static void main(String[] args) {
		new GooglePage().search("bohrer");
	}

	@Override
	public void goTo() {
		
	}

}
