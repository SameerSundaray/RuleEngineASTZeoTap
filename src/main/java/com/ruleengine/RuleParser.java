package com.ruleengine;

import java.util.ArrayList;
import java.util.List;

public class RuleParser {
    public List<Rule> parseRules(String rulesString) {
        List<Rule> rules = new ArrayList<>();
        String[] ruleStrings = rulesString.split(";"); // Assuming rules are separated by semicolons

        for (String ruleStr : ruleStrings) {
            String[] parts = ruleStr.split(",");
            if (parts.length < 3) continue; // Basic validation

            String name = parts[0].trim();
            String condition = parts[1].trim();
            String action = parts[2].trim();
            rules.add(new Rule(name, condition, action));
        }

        return rules;
    }
}
