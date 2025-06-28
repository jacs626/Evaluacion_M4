package com.healthtrack;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class SeleniumTest {

    @Test
    void pruebaActualizarPeso() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

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
