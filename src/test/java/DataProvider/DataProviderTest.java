package DataProvider;

import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;


public class DataProviderTest extends DataProviderBaseTest{
    @Test(dataProvider = "RegistrationPageDataProvider", dataProviderClass = ExcelDataProvider.class, testName = "RegistrationPageTests")
    public static void registrationPageTest(Map<String, String> inputMatrix){
        DemoqaRegistration demoqaRegistration = new DemoqaRegistration(driver);
        demoqaRegistration.firstName.sendKeysWithoutValidation(inputMatrix.get("First Name"));
        demoqaRegistration.lastName.sendKeysWithoutValidation(inputMatrix.get("Last Name"));

        String martialStatus = inputMatrix.get("Marital Status");
        if(martialStatus.equals("Single")){
            demoqaRegistration.single.click();
        } else if(martialStatus.equals("Married")){
            demoqaRegistration.married.click();
        } else if(martialStatus.equals("Divorced")){
            demoqaRegistration.divorced.click();
        }

        String hobby = inputMatrix.get("Hobby");
        if(hobby.equals("Dance")){
            demoqaRegistration.dance.click();
        } else if(hobby.equals("Reading")){
            demoqaRegistration.readingg.click();
        } else if(hobby.equals("Cricket")){
            demoqaRegistration.cricket.click();
        }

        demoqaRegistration.chooseCountry(inputMatrix.get("Country"));
        String[] date = inputMatrix.get("Date of Birth").split("/");
        System.out.println(inputMatrix.get("Date of Birth"));
        demoqaRegistration.chooseMonth(date[0]);
        demoqaRegistration.chooseDay(date[1]);
        demoqaRegistration.chooseYear(20+date[2]); // тут костыли

        demoqaRegistration.phone.sendKeysWithoutValidation(inputMatrix.get("Phone Number"));
        demoqaRegistration.username.sendKeysWithoutValidation(inputMatrix.get("Username"));
        demoqaRegistration.email.sendKeysWithoutValidation(inputMatrix.get("E-mail"));
        demoqaRegistration.description.sendKeysWithoutValidation(inputMatrix.get("About Yourself"));
        demoqaRegistration.password_2.sendKeysWithoutValidation(inputMatrix.get("Password"));
        demoqaRegistration.confirm_password_password_2.sendKeysWithoutValidation(inputMatrix.get("Confirm Password"));

        //чтобы не засорять бд
        //demoqaRegistration.submitButton.click();

        driver.get(driver.getCurrentUrl());
    }
}
