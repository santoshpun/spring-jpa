package com.santosh.springjpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santosh.springjpa.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
