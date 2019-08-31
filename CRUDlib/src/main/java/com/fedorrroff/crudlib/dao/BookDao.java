package com.fedorrroff.crudlib.dao;

import com.fedorrroff.crudlib.model.Book;

import java.util.List;

public interface BookDao {

    void addBook(Book book);

    void updateBook(Book book);

    void deleteBook(int id);

    Book getBook(int id);

    List<Book> listBooks();

}
