package Selenium;

import DriverFrameWork.BrowserTypes;
import DriverFrameWork.Browsers;
import TestNG.TestNgA;
import org.apache.log4j.Logger;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sun.awt.windows.WEmbeddedFrame;

import java.util.Set;

public class TestMethodA {
    private WebDriver driver;
    String url = "C:\\新建文件夹\\BeyondSofter_HTML\\BeyondSofter_HTML\\BeyondSofter_HTML\\selenium_html\\index.html";
    String url2 = "C:\\新建文件夹\\BeyondSofter_HTML\\BeyondSofter_HTML\\BeyondSofter_HTML\\selenium_html\\dragAndDrop.html";
    @BeforeClass
    public  void  methodA() throws InterruptedException {
    Browsers browsers = new Browsers(BrowserTypes.chrome);
    driver = Browsers.drivers;
    driver.get(url);
    sleep(3);
}
@Test
public  void methodB() throws InterruptedException {
    Logger logger = Logger.getLogger(TestMethodA.class);
    logger.info("测试log4j");
   //浏览器指定窗口大小
    Dimension demension = new Dimension(500,300);
    driver.manage().window().setSize(demension);
    sleep(3);

    //浏览器最大化
    driver.manage().window().maximize();
    sleep(3);

    //浏览器后退
    driver.navigate().back();
    sleep(3);

    //浏览器前进
    driver.navigate().forward();
    sleep(3);

    driver.navigate().refresh();
    sleep(3);
}
@Test
public  void methodC() throws InterruptedException {
    //获取当前网页Title
    String title = driver.getTitle();
    System.out.println("当前网页的标题为："+title);
    System.out.println("==============================================");
    sleep(3);

    //获取当前网页Url
    String url = driver.getCurrentUrl();
    System.out.println("当前网页的Url"+url);
    System.out.println("==================================================");
    sleep(3);

    // 获取当前按钮 text 通过 ‘name’属性  【控件名称】
    WebElement elementA = driver.findElement(By.name("kj"));
    String text = elementA.getText();
    System.out.println("当前元素文本为："+text);
    System.out.println("==================================================");
    sleep(3);
    //获取元素对应属性值
    String attributeValue = elementA.getAttribute("name");
    System.out.println("当前元素属性值为："+attributeValue);
    System.out.println("==================================================");
    sleep(3);
}
@Test  //文本框操作
public void methodD() throws InterruptedException {
    WebElement ele = driver.findElement(By.id("user"));
    ele.clear();
    sleep(3);
    ele.sendKeys("BeyondSofter");
    sleep(3);
}

@Test // 下拉选择框的处理
public  void methodE() throws InterruptedException {
    WebElement ele = driver.findElement(By.xpath("//div[@id=\"select\"]/select[@id=\"moreSelect\"]"));
    Select select = new Select(ele);
    select.selectByIndex(1);
    sleep(3);
    select.selectByValue("vivo");
    sleep(3);
    select.selectByVisibleText("meizu");
    sleep(3);
}

@Test //单选框的处理
public  void methodF() throws InterruptedException {
    WebElement ele = driver.findElement(By.className("OpelA"));
    ele.click();
    sleep(3);

    Boolean isCheckA = ele.isSelected();
    System.out.println("Opel单选框是否选中：" + isCheckA);
    sleep(2);
    Assert.assertTrue(isCheckA);
    System.out.println("==================================");
}

    @Test //复选框的处理
    public  void methodG() throws InterruptedException {
        WebElement ele = driver.findElement(By.name("checkboxC"));
        ele.click();
        sleep(3);

       if(!ele.isSelected()) {
           ele.click();
       }
        System.out.println("==================================");
    }
    @Test // Alert 警告弹窗的处理
    public  void methodH() throws InterruptedException {
        WebElement ele = driver.findElement(By.className("alertA"));
        String windowHandle = driver.getWindowHandle();
        ele.click();
        sleep(3);
        Alert alert = driver.switchTo().alert();
        String txt = alert.getText();
        System.out.println("警告框文本："+txt);
        alert.accept();
        sleep(3);
        driver.switchTo().window(windowHandle);
    }

    @Test // Confirm 警告弹窗的处理
    public  void methodI() throws InterruptedException {
        WebElement ele = driver.findElement(By.xpath("//div[@id=\"confirmA\"]/input"));
        String windowHandle = driver.getWindowHandle();
        ele.click();
        sleep(3);

        Alert alert = driver.switchTo().alert();
        System.out.println("警告框文本1"+alert.getText());
        sleep(3);
        alert.dismiss();
        System.out.println("警告框文本2"+alert.getText());
        sleep(3);
        alert.accept();
        sleep(3);
        driver.switchTo().window(windowHandle);
        sleep(3);

    }
    @Test // Prompt // 警告输入框的处理
    public  void methodJ() throws InterruptedException {
        WebElement ele = driver.findElement(By.xpath("//div[@id=\"promptA\"]/input"));
        String windowHandle = driver.getWindowHandle();
        ele.click();
        sleep(3);

        Alert alert = driver.switchTo().alert();
        System.out.println("警告输入狂文本："+alert.getText());
        alert.sendKeys("Selenium测试");
        sleep(3);
        alert.accept();
        sleep(3);
        driver.switchTo().window(windowHandle);
        sleep(3);
    }
    @Test //JS 滚动窗处理
    public  void methodK() throws InterruptedException {
        WebElement ele = driver.findElement(By.id("loadA"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",ele);
        sleep(3);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        sleep(3);
    }
    @Test // 上传文件方法
    public  void methodL() throws InterruptedException {
        String path = "C:\\新建文件夹\\BeyondSofter_HTML\\BeyondSofter_HTML\\SeleniumBase.PNG";
        WebElement ele = driver.findElement(By.id("loadA"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",ele);
        ele.sendKeys(path);
    }
    @Test // 多窗口句柄操作
    public void methodM() throws InterruptedException {
    WebElement ele = driver.findElement(By.linkText("Open new window"));
    String winHandle = driver.getWindowHandle();
    ele.click();
    sleep(3);
    Set<String> handles = driver.getWindowHandles();
    for(String win: handles)
    {
        if(win.equals(winHandle))
        {
            continue;
        }
        driver.switchTo().window(win); //切换到新打开的page
    }
    sleep(3);
    WebElement element = driver.findElement(By.id("kw"));
    sleep(3);
    element.sendKeys("测试");
    sleep(3);
    }
    @Test // 鼠标悬浮操作场景
    public void methodN() throws InterruptedException{
        WebElement ele2 = driver.findElement(By.id("loadA"));
        scrollIntoView(ele2);
        WebElement ele = driver.findElement(By.className("over"));
        Actions actions = new Actions(driver);
        actions.moveToElement(ele).perform();
        sleep(3);
        WebElement element = driver.findElement(By.className("display"));
        Assert.assertTrue(element.isDisplayed());
        sleep(3);
    }
    @Test // 动态方法检索等待
    public void methodT() {
        WebElement ele = driver.findElement(By.className("wait"));
        scrollIntoView(ele);
        ele.click();
        driverWait(By.className("red"));
        WebElement element = driver.findElement(By.className("red"));
        System.out.println("检查‘wait for display’ 文本是否正常显示：" + element.isDisplayed());
    }

   @Test  // Actions 模拟鼠标选择多个选项
    public void methodV() throws InterruptedException {
       // 下拉列表选择 1 、4 Value
       driverWait(By.xpath("//option[contains(@label,\"emmental\")]"));
       WebElement element = driver.findElement(By.xpath("//option[contains(@label,\"emmental\")]"));
       Actions actions = new Actions(driver);
       scrollIntoView(element);
       driverWait(By.xpath("//option[contains(@label,\"cheddar\")]"));
       WebElement element2 = driver.findElement(By.xpath("//option[contains(@label,\"cheddar\")]"));
       actions.keyDown(Keys.CONTROL).click(element).click(element2).keyUp(Keys.CONTROL).perform();
       sleep(5);

   }
    @Test // 表单 frame / iframe
    public void methodX() throws InterruptedException {
        WebElement element2 = driver.findElement(By.id("user"));
        WebElement ele = driver.findElement(By.name("aa"));
        String winHandle = driver.getWindowHandle();
        driverWait(By.xpath("//iframe[@name=\"aa\"]"));
        scrollIntoView(ele);
        driver.switchTo().frame(ele);
        WebElement element = driver.findElement(By.id("userA"));
        element.sendKeys("测试框架页");
        sleep(5);
        driver.switchTo().window(winHandle);
        scrollIntoView(element2);
        element2.clear();
        element2.sendKeys("selenium测试中");
        sleep(3);

    }
   public  void driverWait(By by)
   {
       WebDriverWait wait = new WebDriverWait(driver,10);
       wait.until(ExpectedConditions.presenceOfElementLocated(by));
   }
    public  void scrollIntoView(WebElement ele)
    {
       JavascriptExecutor js = (JavascriptExecutor)driver;
       js.executeScript("arguments[0].scrollIntoView(true);",ele);
    }
    public void sleep(int t) throws InterruptedException {
        Thread.sleep(1000*t);
    }
  /*  // 自定义封装等待
    public void driverOwnWait(final By by) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
                withTimeout(300, TimeUnit.SECONDS).
                pollingEvery(1, TimeUnit.SECONDS).
                ignoring(NoSuchElementException.class).
                withMessage("Time loading succeed");
        wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
    }*/
    @AfterMethod
    public void AfterRun() throws InterruptedException {
        driver.quit();
        sleep(3);
        }
    @Test
    public void methodY() throws InterruptedException {
        Thread.sleep(3000);
        driver.get(url2);
        WebElement elementA = driver.findElement(By.id("drag"));
        WebElement elementB = driver.findElement(By.xpath("//h1"));

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(elementA, 400, 400).perform();
        Thread.sleep(3000);

        actions.dragAndDrop(elementA, elementB).perform();
        Thread.sleep(3000);
    }
    public void methodZ() throws InterruptedException {
    }
}
