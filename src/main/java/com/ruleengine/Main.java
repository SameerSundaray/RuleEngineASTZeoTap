package com.ruleengine;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        RuleEngine ruleEngine = new RuleEngine();
        
        Node rule1 = ruleEngine.createRule("age >= 18");
        Node rule2 = ruleEngine.createRule("age < 18");
        
        Map<String, Object> data = new HashMap<>();
        data.put("age", 20);

        boolean result1 = ruleEngine.evaluateRule(rule1, data);
        System.out.println("Evaluating rule1 (age >= 18): " + result1);
        
        boolean result2 = ruleEngine.evaluateRule(rule2, data);
        System.out.println("Evaluating rule2 (age < 18): " + result2);
        
        if (result1) {
            System.out.println("Action: Allow access");
        } else if (result2) {
            System.out.println("Action: Deny access");
        }
    }
}
