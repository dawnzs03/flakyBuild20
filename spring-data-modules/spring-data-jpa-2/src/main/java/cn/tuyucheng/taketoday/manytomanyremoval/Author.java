package cn.tuyucheng.taketoday.manytomanyremoval;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @Column(name = "name")
   private String name;

   @ManyToMany(mappedBy = "authors")
   private Set<Book> books = new HashSet<>();

   // standard getters and setters

   public Author() {
   }

   public Author(String name) {
      this.name = name;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Set<Book> getBooks() {
      return books;
   }

   public void setBooks(Set<Book> books) {
      this.books = books;
   }

   @PreRemove
   private void removeBookAssociations() {
      for (Book book : this.books) {
         book.getAuthors().remove(this);
      }
   }
}