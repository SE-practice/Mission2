
import org.junit.jupiter.api.Test;


import java.time.Year;

public class BookSearchPerformanceTest {
    private static Book bookManager = new Book();

    static {
        for(int i = 0; i < 1000000; i++){
            Book book = new Book(String.valueOf(i), "자바 기초", "Jane", Year.of(2021));
            bookManager.addBook(book);
        }
    }


    @Test
    void testSearchBook(){
        long start = System.currentTimeMillis();
        System.out.println("검색 결과:");
        System.out.println(bookManager.searchBook("357846"));
        long end = System.currentTimeMillis();
        System.out.println("검색 시간: " + (end-start) + "ms");
    }

    @Test
    void testBinarySearchBook(){
        long start = System.currentTimeMillis();
        System.out.println("검색 결과:");
        System.out.println(bookManager.search_bs("357826"));
        long end = System.currentTimeMillis();
        System.out.println("검색 시간: " + (end-start) + "ms");
    }
}
