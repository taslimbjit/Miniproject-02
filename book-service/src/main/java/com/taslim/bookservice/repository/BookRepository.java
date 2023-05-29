package com.taslim.bookservice.repository;

import com.taslim.bookservice.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository  extends JpaRepository<BookEntity,Long> {
    public List<BookEntity> findByAuthorNameContaining(String authorName);
    public BookEntity findByAuthorNameAndBookName(String authorName, String bookName);
}
