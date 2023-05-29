package com.taslim.bookservice.service.impl;

import com.taslim.bookservice.entity.BookEntity;
import com.taslim.bookservice.exception.BookNameAuthorNameAlreadyExistsExcepion;
import com.taslim.bookservice.model.BookRequestModel;
import com.taslim.bookservice.repository.BookRepository;
import com.taslim.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;



    @Override
    public ResponseEntity<Object> createBook(BookRequestModel bookRequestModel) {

        BookEntity alreadyExist= bookRepository.findByAuthorNameAndBookName( bookRequestModel.getAuthorName(),  bookRequestModel.getBookName());
        if (alreadyExist != null){
            throw new BookNameAuthorNameAlreadyExistsExcepion("Book Name and Author Name Already Exist.");
        }


        BookEntity bookEntity = BookEntity.builder()
                .authorName(bookRequestModel.getAuthorName())
                .bookName(bookRequestModel.getBookName())
                .price(bookRequestModel.getPrice())
                .build();
        BookEntity savedBook= bookRepository.save(bookEntity);

        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);

    }

    @Override
    public List<BookEntity> getAllBooks() {
        List <BookEntity> books= bookRepository.findAll();
        return books ;
    }



    @Override
    public Optional<BookEntity> getBook(Long bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public List<BookEntity> getBookByAuthorName(String authorName) {
        return bookRepository.findByAuthorNameContaining(authorName);
    }

    @Override
    public BookEntity updateBook(Long bookId ,BookRequestModel bookRequestModel) {
            BookEntity bookEntity = BookEntity.builder()
                    .id(bookId)
                    .authorName(bookRequestModel.getAuthorName())
                    .bookName(bookRequestModel.getBookName())
                    .price(bookRequestModel.getPrice())
                    .build();

            BookEntity savedValue= bookRepository.save(bookEntity);

            return savedValue;

        }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public BookEntity findByAuthorNameAndBookName(String authorName, String bookName) {
        return bookRepository.findByAuthorNameAndBookName( authorName,  bookName);
    }
}
