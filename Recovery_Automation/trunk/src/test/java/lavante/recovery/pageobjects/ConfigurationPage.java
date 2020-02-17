


	package lavante.recovery.pageobjects;
    import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import lavante.recovery.utilities.LavanteUtils;

	public class ConfigurationPage {
		
		LavanteUtils lavanteUtils=new LavanteUtils();
		public ConfigurationPage(WebDriver driver){
			lavanteUtils.driver=driver;
		}
		//Configuration link
		@FindBy(linkText="Configuration")
		private WebElement configurationLink;
		public WebElement configurationLink(){
			return configurationLink;
		}
		
		
}
	
	
