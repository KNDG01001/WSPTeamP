package com.example.TeamProject.Borrow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @GetMapping("/BorrowList/{userId}")
    public String getBorrowsByUser(@PathVariable String userId, Model model) {
        model.addAttribute("borrows",borrowService.getBorrowsByUser(userId));
        return "BorrowList";
}
    @PostMapping("/borrow")
    public String borrowBook(@RequestParam String userId, @RequestParam long bookId) {
        borrowService.borrowBook(userId, bookId);
        return "redirect:/BorrowList/"+userId;
    }
    @PostMapping("/return")
    public String returnBook(@RequestParam String userId, @RequestParam long bookId) {
        borrowService.returnBook(userId, bookId);
        return "redirect:/BorrowList/"+ userId;
    }
}
