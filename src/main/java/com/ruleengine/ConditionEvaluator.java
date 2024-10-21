package com.ruleengine;

import java.util.Map;

public class ConditionEvaluator {
    public boolean evaluateCondition(String condition, Map<String, Object> data) {
        String[] parts = condition.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Condition must be in the format: <field> <operator> <value>");
        }

        String field = parts[0];
        String operator = parts[1];
        String value = parts[2];

        Object fieldValue = data.get(field);
        
        switch (operator) {
            case "==":
                return fieldValue != null && fieldValue.toString().equals(value);
            case "!=":
                return fieldValue != null && !fieldValue.toString().equals(value);
            case ">":
                return compareValues(fieldValue, value) > 0;
            case "<":
                return compareValues(fieldValue, value) < 0;
            case ">=":
                return compareValues(fieldValue, value) >= 0;
            case "<=":
                return compareValues(fieldValue, value) <= 0;
            default:
                throw new UnsupportedOperationException("Operator not supported: " + operator);
        }
    }

    private int compareValues(Object fieldValue, String value) {
        if (fieldValue instanceof Number) {
            return Double.compare(((Number) fieldValue).doubleValue(), Double.parseDouble(value));
        } else {
            return fieldValue.toString().compareTo(value);
        }
    }
}
