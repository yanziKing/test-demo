package TestNG;

import org.apache.log4j.Logger;
import org.testng.annotations.*;

public class TestNgA {
    @BeforeMethod
    public void MethodA()
    {
        System.out.println("This is MethodA");
    }
    @Test
    public void MethodB()
    {
        Logger logger = Logger.getLogger(TestNgA.class);
        logger.info("这时方法B");
        System.out.println("This is MethodB");
    }
    @Test
    public void MethodC()
    {
        System.out.println("This is MethodC");
    }
    @AfterMethod
    public void MethodD()
    {
        System.out.println("This is MethodD");
    }
}
