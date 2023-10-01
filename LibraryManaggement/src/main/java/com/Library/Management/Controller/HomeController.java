package com.Library.Management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Library.Management.Entities.Books;
import com.Library.Management.Entities.Member;
import com.Library.Management.service.BookService;
import com.Library.Management.service.MemberService;

@RestController
@RequestMapping("/api")
public class HomeController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private BookService bookService;

	@GetMapping("/users")
	public List<Member> getAllUser() {
		return memberService.findAllUser();
	}

	@PostMapping("/users")
	public Member addUser(@RequestBody Member user) {
		return memberService.saveMember(user);
	}

	@GetMapping("/books")
	public List<Books> getAllBooks() {
		return bookService.findAll();
	}

	@GetMapping("/books/{id}")
	public Books getBook(@PathVariable Integer id) {
		return bookService.findById(id);
	}
	
	@GetMapping("/books/byPublication/{publicationName}")
	public List<Books> getBookByPublication(@PathVariable String publicationName) {
		return bookService.findByPublication(publicationName);
	}

	@PostMapping("/books")
	public Books addBook(@RequestBody Books book) {
		return bookService.save(book);
	}

	@PutMapping("/books/{id}")
	public Books updateBook(@PathVariable Integer id, @RequestBody Books book) {
		// Additional logic to ensure you're updating the correct book
		return bookService.save(book);
	}

	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable Integer id) {
		bookService.deleteById(id);
	}

	@PostMapping("/books/{bookId}/borrow/{userId}")
	public ResponseEntity<Books> borrowBook(@PathVariable Integer bookId, @PathVariable Integer userId) {
		Books borrowedBook = bookService.borrowBook(bookId, userId);
		if (borrowedBook != null) {
			return ResponseEntity.ok(borrowedBook);
		} else {
			return ResponseEntity.badRequest().build(); // or a more descriptive error response
		}
	}

	@PostMapping("/books/{bookId}/return")
	public ResponseEntity<Books> returnBook(@PathVariable Integer bookId) {
		Books returnedBook = bookService.returnBook(bookId);
		if (returnedBook != null) {
			return ResponseEntity.ok(returnedBook);
		} else {
			return ResponseEntity.badRequest().build(); // or a more descriptive error response
		}
	}
}
