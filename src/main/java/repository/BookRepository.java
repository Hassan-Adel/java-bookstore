package repository;

import model.Book;
import utilities.NumberGenerator;
import utilities.TextUtil;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.transaction.Transactional.TxType.REQUIRED;

@Transactional(SUPPORTS)
public class BookRepository {

    @PersistenceContext(unitName = "bookStorePU")
    private EntityManager em;

    @Inject
    TextUtil textUtil;

    @Inject
    NumberGenerator numberGenerator;

    public Book find(@NotNull @Min(1) Long id){
        return em.find(Book.class, id);
    }

    @Transactional(REQUIRED)
    public Book create(@NotNull Book book){
        book.setTitle(textUtil.sanatize(book.getTitle()));
        book.setIsbn(numberGenerator.generateNumber());
        em.persist(book);
        return book;
    }

    @Transactional(REQUIRED)
    public void delete(@NotNull @Min(1) Long id){
        em.remove(em.getReference(Book.class, id));
    }

    public List<Book> findAll(){
        TypedQuery<Book> query = em.createQuery("SELECT b FROM  Book b ORDER BY b.title DESC", Book.class);
        return query.getResultList();
    }

    public Long countAll(){
        TypedQuery<Long> query = em.createQuery("SELECT COUNT(b) FROM Book b", Long.class);
        return query.getSingleResult();
    }
}
