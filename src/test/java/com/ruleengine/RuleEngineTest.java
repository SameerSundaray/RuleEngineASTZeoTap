package com.ruleengine;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class RuleEngineTest {

    @Test
    public void testCreateRule() {
        RuleEngine engine = new RuleEngine();
        Node rule = engine.createRule("age > 30 AND department = 'Sales'");

        assertNotNull(rule);
        assertEquals("operator", rule.type);
        assertNotNull(rule.left);
        assertNotNull(rule.right);
    }

    @Test
    public void testEvaluateRule() {
        RuleEngine engine = new RuleEngine();
        Node rule = engine.createRule("age > 30 AND department = 'Sales'");

        Map<String, Object> data = new HashMap<>();
        data.put("age", 35);
        data.put("department", "Sales");

        boolean result = engine.evaluateRule(rule, data);
        assertTrue(result); 
    }

    @Test
    public void testEvaluateRuleFails() {
        RuleEngine engine = new RuleEngine();
        Node rule = engine.createRule("age > 30 AND department = 'Sales'");

        Map<String, Object> data = new HashMap<>();
        data.put("age", 25);
        data.put("department", "Sales");

        boolean result = engine.evaluateRule(rule, data);
        assertFalse(result); 
    }
}

