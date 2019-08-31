package com.fedorrroff.crudlib.dao;

import com.fedorrroff.crudlib.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{

    private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book book) {

        Session session = this.sessionFactory.getCurrentSession();
        session.persist(book);

    }

    @Override
    public void updateBook(Book book) {

        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
        logger.info("Book successfully update. Book details: " + book);

    }

    @Override
    public void deleteBook(int id) {

        Session session = this.sessionFactory.getCurrentSession();
        Book book = session.load(Book.class, id);

        if (book != null) {
            session.delete(book);
        }

        logger.info("Book successfully removed. Book details: " + book);

    }

    @Override
    public Book getBook(int id) {

        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.get(Book.class, id);
        return book;
    }

    @Override
    public List<Book> listBooks() {

        Session session = this.sessionFactory.getCurrentSession();
        List<Book> bookList = session.createQuery("from Book").list();

        return bookList;
    }
}
