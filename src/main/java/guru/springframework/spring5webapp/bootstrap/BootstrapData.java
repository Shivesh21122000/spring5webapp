package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Processing started");

        Publisher pub = new Publisher();
        pub.setName("Shivesh");
        pub.setAddress("White Field");
        pub.setCity("Bangalore");
        pub.setZip("560066");

        publisherRepository.save(pub);
        System.out.println("Total publishers : " + publisherRepository.count());


        Author agatha = new Author("Agatha", "Christie");
        Book murderOfRoger = new Book("Murder of Roger", "12221");

        agatha.getBooks().add(murderOfRoger);
        murderOfRoger.getAuthors().add(agatha);

        authorRepository.save(agatha);
        bookRepository.save(murderOfRoger);

        Author chetan = new Author("Chetan", "Bhagat");
        Book OneIndianGirl = new Book("One Indian Girl", "1234");

        chetan.getBooks().add(OneIndianGirl);
        OneIndianGirl.getAuthors().add(chetan);

        authorRepository.save(chetan);
        bookRepository.save(OneIndianGirl);

        System.out.println("Total books :" + bookRepository.count());
        System.out.println("Ran Successfully");
    }
}
