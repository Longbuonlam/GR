package GR.gacnghi.service;

import GR.gacnghi.entity.Book;
import GR.gacnghi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository theBookRepository) {
        bookRepository = theBookRepository;
    }
    public void save(Book theBook) {
        bookRepository.save(theBook);
    }
    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }
    public Book getBookById(int id) {
        return bookRepository.findById(id).get();
    }
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }

}
