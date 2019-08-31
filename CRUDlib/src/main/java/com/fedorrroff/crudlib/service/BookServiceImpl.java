package com.fedorrroff.crudlib.service;

import com.fedorrroff.crudlib.dao.BookDao;
import com.fedorrroff.crudlib.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional
    public void addBook(Book book) {

        this.bookDao.addBook(book);

    }

    @Override
    @Transactional
    public void updateBook(Book book) {

        this.bookDao.updateBook(book);

    }

    @Override
    @Transactional
    public void deleteBook(int id) {

        this.bookDao.deleteBook(id);

    }

    @Override
    @Transactional
    public Book getBook(int id) {

        return this.bookDao.getBook(id);

    }

    @Override
    @Transactional
    public List<Book> listBooks() {

        return this.bookDao.listBooks();

    }
}
