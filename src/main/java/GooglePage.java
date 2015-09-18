import com.mokona.core.Element;
import com.mokona.core.MokonaPage;
import com.mokona.element.Button;
import com.mokona.element.TextField;

public class GooglePage extends MokonaPage {

	@Element(css = "#lst-ib")
	private TextField searchInput;

	@Element(css = "[name=\"btnG\"]")
	private Button searchButton;

	public void search(String textToSearch) {
		searchInput.set(textToSearch);
		searchButton.click();
	}

	public static void main(String[] args) {
		GooglePage page = new GooglePage();
		page.goTo();
		page.search("bohrer");
	}

	public String getUri() {
		return "https://www.google.com.br/?gws_rd=ssl";
	}

}
