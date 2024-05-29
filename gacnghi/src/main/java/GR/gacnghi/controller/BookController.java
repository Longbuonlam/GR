package GR.gacnghi.controller;

import GR.gacnghi.entity.Book;
import GR.gacnghi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService service;

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute Book book) {
        final Date current = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        book.setCreatedAt(current);
        service.save(book);
        System.out.println("Save new book to database: " + book);
        return "redirect:/gacnghi.admin.book_list";
    }

    @GetMapping("/gacnghi.admin.book_list")
    public ModelAndView getAllBook(){
        List<Book> list = service.getAllBook();
        return new ModelAndView("BookList", "book",list);
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        Book book = service.getBookById(id);
        model.addAttribute("book",book);
        return "BookEdit";
    }

    @PostMapping("/saveEditBook")
    public String saveEditBook(@ModelAttribute Book book) {
        Date update =new Date();
        update = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        book.setCreatedAt(update);
        service.save(book);
        return "redirect:/gacnghi.admin.book_list";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id")int id) {
        service.deleteById(id);
        return "redirect:/gacnghi.admin.book_list";
    }
}
