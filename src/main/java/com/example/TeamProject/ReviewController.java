package com.example.TeamProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReviewController {
    @Autowired
    private ReviewRateService reviewRateService;

    @RequestMapping("/review/{idx}")
    public String review(@PathVariable int idx, Model model) {
        model.addAttribute("")
    }
}
