package com.Library.Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Library.Management.Entities.Books;
import com.Library.Management.Entities.Member;
import com.Library.Management.Repository.BookRepository;
import com.Library.Management.Repository.userRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired 
	private userRepository userRepository;
	public List<Books> findAll(){
		return bookRepository.findAll();
	}
	
	public Books findById(int id) {
		return bookRepository.findById(id).orElse(null);
	}
	
	public Books save(Books books) {
		return bookRepository.save(books);
	}
	
	public void deleteById(int id) {
		userRepository.deleteById(id);
	}
	
	public Books borrowBook(Integer b_id,Integer u_id) {
		Books books=this.findById(b_id);
		Member member=userRepository.findById(u_id).orElse(null);
		if (member!=null&& books!=null&&!books.isBorrowed()) {
			books.setMember(member);
			books.setBorrowed(true);
			return save(books);
		}
		return null;
		
	}
	
	public Books returnBook(int b_id) {
		Books book=findById(b_id);
		if (book!=null&&book.isBorrowed()) {
			book.setBorrowed(false);
			book.setMember(null);
			return save(book);
		}
		return null;
	}
	public List<Books> findByPublication(String publication) {
		
		List<Books> list=(List<Books>) bookRepository.findByPublication(publication);
		if (list==null) {
			return null;
		}
		return list;
	}
	
}
