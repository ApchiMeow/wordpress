package core;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.concurrent.TimeUnit;

import controls.WebTypifiedElement;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public abstract class BaseTest {

	private static Logger log;
	private static LocalDateTime timePoint = LocalDateTime.now();
	private static String name = timePoint.get(ChronoField.YEAR_OF_ERA) + "-" + timePoint.getMonth() + "-" + timePoint.getDayOfMonth() + "_"+ timePoint.getHour() + "-" + timePoint.getMinute() + "-" + timePoint.getSecond();
	private static String testName;
	protected static WebDriver driver;
	private static String url;
	private static String login;
	private static String password;

	//принимаю название дочернего класса и передаю его для имени лога в инит блоке
	{
		testName = getClass().getSimpleName();
		String logPath = "src/test/resources/Logs/Test_" + testName + "_" + name + "/Log_" + testName + "_" + name + ".log";
		System.setProperty("logFilename", logPath);
		log = LogManager.getLogger(WebTypifiedElement.class);
	}

	@BeforeClass
	public void setup(){
		File configFile = new File("src/test/resources/config.xml");
		log.info("Open config file: " + configFile.getPath());
		parceXML(configFile);
		log.info("Test name: " + testName);
		log.info("Open browser");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		log.info("Navigate to: " + url);
		driver.get(url);
	}
	
	@AfterClass
	public void close(){
		takeScreenshot();
		driver.quit();
	}
	
	public static void takeScreenshot(){
		try{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("src/test/resources/Logs/" + "Test_" + testName + "_" + name + "/Screen_" + testName + "_" +  name + ".png"));
			log.info("Screenshot name is: " + "Screen_" + testName + "_" + name);
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	public static void parceXML(File configFile){
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;

			dBuilder = dbFactory.newDocumentBuilder();

			Document doc = dBuilder.parse(configFile);
			doc.getDocumentElement().normalize();

			XPath xPath =  XPathFactory.newInstance().newXPath();

			String expression = "/config/configuration";
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(
					doc, XPathConstants.NODESET);

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node nNode = nodeList.item(i);
				log.info("Reading " + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					log.info("Configuration ID : " + eElement.getAttribute("id"));
					log.info("URL : "
							+ eElement
							.getElementsByTagName("url")
							.item(0)
							.getTextContent());
					url = eElement.getElementsByTagName("url").item(0).getTextContent();
					log.info("Login : "
							+ eElement
							.getElementsByTagName("login")
							.item(0)
							.getTextContent());
					login = eElement.getElementsByTagName("login").item(0).getTextContent();
					log.info("Password : "
							+ eElement
							.getElementsByTagName("password")
							.item(0)
							.getTextContent());
					password = eElement.getElementsByTagName("password").item(0).getTextContent();
					log.info("Browser : "
							+ eElement
							.getElementsByTagName("browser")
							.item(0)
							.getTextContent());
					if(eElement.getElementsByTagName("browser").item(0).getTextContent().equals("Firefox")){
                        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
						driver = new FirefoxDriver();
					} else if(eElement.getElementsByTagName("browser").item(0).getTextContent().equals("Chrome")){
                        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
						driver = new ChromeDriver();
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
	}

	public static String getLogin() {
		return login;
	}

	public static String getPassword() {
		return password;
	}
}
