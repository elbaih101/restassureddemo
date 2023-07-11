package com.elbaih.stepDefs;

import io.cucumber.java.Before;
import org.testng.asserts.SoftAssert;
import utilities.RestAssuredExtension;

public class Hooks {
    public static RestAssuredExtension restAssuredExtension;
    public static SoftAssert assrt ;
    @Before
    public  void initialize(){
        restAssuredExtension =new RestAssuredExtension();
        assrt =new SoftAssert();
    }
}
