package com.endeymus.demo.controllers;

import com.endeymus.demo.entity.Letter;
import com.endeymus.demo.entity.WordAnalyzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Класс обрабатывающий запросы
 * @author Mark Shamray
 */
@RestController
@RequestMapping("/wordanalyzer")
public class WordController {

    @Autowired
    private WordAnalyzer analyzer;


    @GetMapping("/analyze")
    public Letter analyze(@RequestParam String word) {
        analyzer.find(word);
        return analyzer.getLetter();
    }

}
