package com.Library.Management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Library.Management.Entities.Member;
import com.Library.Management.Repository.userRepository;

@Service
public class MemberService {
	@Autowired
	private userRepository repository;
	
	public List<Member> findAllUser(){
		return repository.findAll();
	}
	
	public Member findById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Member saveMember(Member member) {
		return repository.save(member);
	}
	
	
}
