package TestNG;

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
