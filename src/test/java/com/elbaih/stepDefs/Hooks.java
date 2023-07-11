package com.elbaih.stepDefs;

import io.cucumber.java.Before;
import utilities.RestAssuredExtension;

public class Hooks {
    static RestAssuredExtension restAssuredExtension;
    @Before
    public void initialize(){
        restAssuredExtension =new RestAssuredExtension();
    }
}
