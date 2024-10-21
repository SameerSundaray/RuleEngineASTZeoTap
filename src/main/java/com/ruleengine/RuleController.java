package com.ruleengine.controller;

import com.ruleengine.Rule;
import com.ruleengine.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class RuleController {
    @Autowired
    private RuleRepository ruleRepository;

    @PostMapping("/create")
    public Rule createRule(@RequestBody Rule rule) {
        return ruleRepository.save(rule);
    }

    @GetMapping("/")
    public List<Rule> getAllRules() {
        return ruleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Rule getRule(@PathVariable Long id) {
        return ruleRepository.findById(id).orElse(null);
    }
}

