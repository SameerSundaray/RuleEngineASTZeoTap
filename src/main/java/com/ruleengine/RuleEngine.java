package com.ruleengine;

import java.util.Map;

public class RuleEngine {

    public Node createRule(String ruleString) {
        Node left = new Node("operand", "age > 30");
        Node right = new Node("operand", "department = 'Sales'");
        return new Node("operator", left, right); 
    }

    public Node combineRules(Node... rules) {
        if (rules.length == 0) return null;
        Node combined = rules[0];
        for (int i = 1; i < rules.length; i++) {
            combined = new Node("operator", combined, rules[i]);  
        }
        return combined;
    }

    public boolean evaluateRule(Node root, Map<String, Object> data) {
        if (root == null) return false;

        if (root.type.equals("operand")) {
            String condition = (String) root.value;
            return evaluateCondition(condition, data);
        }

        boolean leftResult = evaluateRule(root.left, data);
        boolean rightResult = evaluateRule(root.right, data);
        if (root.type.equals("operator")) {
            return leftResult && rightResult;  
        }
        return false;
    }

    private boolean evaluateCondition(String condition, Map<String, Object> data) {
        if (condition.equals("age > 30")) {
            return (int) data.get("age") > 30;
        } else if (condition.equals("department = 'Sales'")) {
            return data.get("department").equals("Sales");
        }
        return false;
    }

    public static void main(String[] args) {
        RuleEngine engine = new RuleEngine();
        Node rule1 = engine.createRule("age > 30 AND department = 'Sales'");
        Map<String, Object> testData = Map.of(
            "age", 35,
            "department", "Sales"
        );
        boolean result = engine.evaluateRule(rule1, testData);
        System.out.println("Rule evaluation result: " + result);
    }
}
