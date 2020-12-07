package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgB {
        @DataProvider(name = "methodA")
        public  Object[][] dataMethod() {
            return new Object[][]{
                    {"用户名a", "密码a", "断言a"},
                    {"用户名b", "密码b", "断言b"},
                    {"用户名c", "密码c", "断言c"}
            };
        }
        @Test(dataProvider = "methodA")
        public void MethodA(String name, String pwd, String ast)
        {
            System.out.println("输入用户名：" +name);
            System.out.println("输入密码：" +pwd);
            System.out.println("点击登录按钮.");
            System.out.println("断言：" + ast);
            System.out.println("=======================================");
        }

}
