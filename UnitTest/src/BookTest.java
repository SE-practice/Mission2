import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;

class BookTest {

	private Book bookManager;

    @BeforeEach
    void setUp() {
        bookManager = new Book();
    }

    @Test
    void testAddBook(){
    	Book book = new Book("1", "자바 기초", "Jane", Year.of(2021));

        bookManager.addBook(book);
        assertThrows(IllegalArgumentException.class, () -> bookManager.addBook(book));
        System.out.println("검색 결과:");
        System.out.println(bookManager.searchBook(book.getId()));
    }

    
    @Test
    void testSearchBook(){
        Book book1 = new Book("1", "자바 기초", "Jane", Year.of(2021));
        Book book2 = new Book("2", "소프트웨어 공학", "Tom", Year.of(2014));
        Book book3 = new Book("3", "분산 컴퓨팅", "Yoon", Year.of(2024));

        bookManager.addBook(book1);
        bookManager.addBook(book2);
        bookManager.addBook(book3);


        System.out.println("검색 결과:");
        System.out.println(bookManager.searchBook(book1.getId()));

        System.out.println("검색 결과:");
        System.out.println(bookManager.searchBook(book2.getId()));

        System.out.println("검색 결과:");
        System.out.println(bookManager.searchBook(book3.getId()));

        assertThrows(IllegalArgumentException.class, () -> bookManager.searchBook("4"));

    }
    

    @Test
    void testRemoveBook(){
        Book book1 = new Book("1", "자바 기초", "Jane", Year.of(2021));
        Book book2 = new Book("2", "소프트웨어 공학", "Tom", Year.of(2014));

        bookManager.addBook(book1);
        bookManager.addBook(book2);

        bookManager.deleteBook(book1.getId());
        assertThrows(IllegalArgumentException.class, () -> bookManager.deleteBook(book1.getId()));
        assertThrows(IllegalArgumentException.class, () -> bookManager.searchBook(book1.getId()));
    }
    
    

}
