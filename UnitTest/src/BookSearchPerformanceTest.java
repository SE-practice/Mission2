
import org.junit.jupiter.api.Test;


import java.time.Year;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BookSearchPerformanceTest {
    private static Book bookManager = new Book();

    static {
        List<Book> bookList = new LinkedList<>();
        for(int i = 0; i < 100000; i++){
            Book book = new Book(String.valueOf(i), "자바 기초", "Jane", Year.of(2021));
            bookList.add(book);
        }
        bookManager.addBatchBook(bookList);
    }


    @Test
    void testSearchBook(){
        long start = System.currentTimeMillis();
        System.out.println("검색 결과:");
        System.out.println(bookManager.searchBook("35746"));
        long end = System.currentTimeMillis();
        System.out.println("검색 시간: " + (end-start) + "ms");
    }

    @Test
    void testBinarySearchBook(){
        long start = System.currentTimeMillis();
        System.out.println("검색 결과:");
        System.out.println(bookManager.search_bs("35782"));
        long end = System.currentTimeMillis();
        System.out.println("검색 시간: " + (end-start) + "ms");
    }
}
