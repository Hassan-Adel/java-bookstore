package model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Book {
    @Id @GeneratedValue
    private Long id;

    @Column(length = 200)
    @NotNull @Size(min = 1, max = 200)
    private String title;

    @Column(length = 1000)
    @Size(min = 1, max = 10000)
    private String description;

    @Column(name = "unit_cost")
    @NotNull @Min(1)
    private Float unitCost;

    private String isbn;

    @Column(name = "publication_date")
    @Temporal(TemporalType.DATE)
    @Past
    private Date publicationDate;

    @Column(name = "nb-of-pages")
    private Integer nbOfPages;

    @Column(name = "image-url")
    private String imageUrl;

    private Language language;

    public Long getId() {
        return id;
    }

    public Book setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Book setDescription(String description) {
        this.description = description;
        return this;
    }

    public Float getUnitCost() {
        return unitCost;
    }

    public Book setUnitCost(Float unitCost) {
        this.unitCost = unitCost;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public Book setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
        return this;
    }

    public Integer getNbOfPages() {
        return nbOfPages;
    }

    public Book setNbOfPages(Integer nbOfPages) {
        this.nbOfPages = nbOfPages;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Book setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Language getLanguage() {
        return language;
    }

    public Book setLanguage(Language language) {
        this.language = language;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", unitCost=" + unitCost +
                ", isbn='" + isbn + '\'' +
                ", publicationDate=" + publicationDate +
                ", nbOfPages=" + nbOfPages +
                ", imageUrl='" + imageUrl + '\'' +
                ", language=" + language +
                '}';
    }
}
