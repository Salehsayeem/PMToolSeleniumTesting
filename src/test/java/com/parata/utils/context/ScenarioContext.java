package com.parata.utils.context;

import com.parata.constants.CONTEXT;

import java.util.HashMap;
import java.util.Map;


/*
    3/8/2021 James Smith
    The purpose of this class is to share data points between test steps within a scenario
    Relies on the CONTEXT file within constants to enumerate what datapoints are storable
    As more tests are developed that need new values shared, add values to the CONTEXT enum
*/
public class ScenarioContext {
 
 private  Map<String, Object> scenarioContext;
 
     public ScenarioContext(){
         scenarioContext = new HashMap<>();
     }
 
     public String setContext(CONTEXT key, Object value) {
         scenarioContext.put(key.toString(), value);
         return null;
     }
 
     public Object getContext(CONTEXT key){
         return scenarioContext.get(key.toString());
     }
 
     public Boolean isContains(CONTEXT key){
         return scenarioContext.containsKey(key.toString());
     }
 
}