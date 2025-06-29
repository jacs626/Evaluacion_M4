package com.healthtrack;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


class SeleniumTest {

    @Test
    void pruebaActualizarPeso() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--user-data-dir=/tmp/chrome-profile");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("http://localhost:8081");
            Thread.sleep(1000);

            WebElement pesoElemento = driver.findElement(By.tagName("p"));
            System.out.println("Peso inicial: " + pesoElemento.getText());

            WebElement input = driver.findElement(By.name("peso"));
            input.sendKeys("80");

            WebElement boton = driver.findElement(By.tagName("button"));
            boton.click();

            Thread.sleep(1000);
            WebElement nuevoPeso = driver.findElement(By.tagName("p"));
            System.out.println("Peso actualizado (deberia ser 80): " + nuevoPeso.getText());

        } finally {
            driver.quit();
        }
    }
}
