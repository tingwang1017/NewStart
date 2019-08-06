package com.test.mobile;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by tingtwang on 05/14/2019
 **/
public class SampleSauceTestAndroid {
    public final String USERNAME = "stubhub_sh";
    public final String ACCESS_KEY = "c2d7ad88-366e-4be9-a13b-047540ef0a4c";
    public final String url = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

    /*public static void main(String[] args) throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Samsung Galaxy S8 GoogleAPI Emulator");
        capabilities.setCapability("platformVersion", "8.1");
        capabilities.setCapability("app", "sauce-storage:Stubhub.apk");
        capabilities.setCapability("browserName", "");
        capabilities.setCapability("deviceOrientation", "portrait");
        capabilities.setCapability("appiumVersion", "1.12.1");

        System.out.println(url);

        WebDriver driver = new AndroidDriver(new URL(url), capabilities);

        *//**
         * Test Actions here...
         *//*

        driver.quit();
    }*/

    @Test
    public void sampleTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Samsung Galaxy S8 GoogleAPI Emulator");
        capabilities.setCapability("platformVersion", "8.1");
        capabilities.setCapability("app", "sauce-storage:Stubhub.apk");
        capabilities.setCapability("browserName", "");
        capabilities.setCapability("deviceOrientation", "portrait");
        capabilities.setCapability("appiumVersion", "1.12.1");

        System.out.println(url);

        WebDriver driver = new AndroidDriver(new URL(url), capabilities);

        /**
         * Test Actions here...
         */

        driver.quit();
    }
}
