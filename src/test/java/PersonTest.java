import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PersonTest {

    @BeforeTest
    public void beforeTest(){
        System.out.println("Тест запущен!");
        currentTime();
    }

    @Test(dataProvider = "ageProvider")
    public void isTeenagerTest(int age, boolean expected) {
        boolean result = Person.isTeenager(age);
        Assert.assertEquals(result, expected);

    }

    @DataProvider(name = "ageProvider")
    public Object[][] ageProvider() {
        return new Object[][]{
                {20, false},
                {19, true},
                {18, true},
                {14, true},
                {13, true},
                {12, false},
                {0, false},
                {-1, false}
        };
    }
    @AfterTest
    public void afterTest(){
        System.out.println("Тест завершен!");
        currentTime();
    }

    public void currentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/mm/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }
}
