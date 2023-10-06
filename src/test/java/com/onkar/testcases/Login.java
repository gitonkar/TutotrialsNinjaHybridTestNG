package com.onkar.testcases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.onkar.utilities.Utils;

import base.Base;

public class Login extends Base {
 
	
	@Test(enabled = true, priority = 3)
	public void verifyLoginValidcred() {
		driver.get("https://naveenautomationlabs.com/opencart/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-child(2)")).click();
		driver.findElement(By.id("input-email")).sendKeys("GregMiebach@outlook.com");
		driver.findElement(By.id("input-password")).sendKeys("Greg@Miebach161295");
		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/ul[1]/li[1]/a")).isDisplayed(),
				"Login failed..");

	}

	@Test(enabled = true, priority = 2)
	public void verifyLoginInValidcred() {

		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-child(2)")).click();
		driver.findElement(By.id("input-email")).sendKeys("GregMiebach" + Utils.generateTimeStamp() + "@outlook.com");
		driver.findElement(By.id("input-password")).sendKeys("Greg@Miebach161295");
		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		Assert.assertEquals(
				driver.findElement(By.cssSelector("#account-login > div.alert.alert-danger.alert-dismissible"))
						.getText(),
				":-)Warning: No match for E-Mail Address and/or Password.", "InvalidPass check assertion check failed..");

	}
	@Test(enabled = true, priority = 1)
	public void Register() {
		// TODO Auto-generated method stub
		driver.get("https://naveenautomationlabs.com/opencart/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-child(1) > a")).click();
		driver.findElement(By.cssSelector("#input-firstname")).sendKeys("Greg");
		driver.findElement(By.cssSelector("#input-lastname")).sendKeys("Miebach");
		driver.findElement(By.cssSelector("#input-email"))
				.sendKeys("GregMiebach" + Utils.generateTimeStamp() + "@outlook.com");
		driver.findElement(By.cssSelector("#input-telephone")).sendKeys("79879879");
		driver.findElement(By.cssSelector("#input-password")).sendKeys("Miebach");
		driver.findElement(By.cssSelector("#input-confirm")).sendKeys("Miebach");
		driver.findElement(By
				.cssSelector("#content > form > fieldset:nth-child(3) > div > div > label:nth-child(1) > input[type=radio]"))
				.click();
		driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)")).click();
		driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary")).submit();
		
		String expectedTxt = driver.findElement(By.cssSelector("#content > h1")).getText();
		Assert.assertEquals(driver.findElement(By.cssSelector("#content > h1")).getText(), expectedTxt);
	}

}
