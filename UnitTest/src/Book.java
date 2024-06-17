import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

public class Book {


    private String id;

    private String title;
    private String author;
    private Year publishYear;


    public Book(String id, String title, String author, Year publishYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
    }

    public Book(){
        this.id = "";
        this.title = "";
        this.author = "";
        this.publishYear = Year.of(2021);
    }

    public String getId() {
        return this.id;
    }


    public String toString() {
        return String.format("""
Book{id: '%s', 제목: '%s', 저자: '%s', 출판년도: %d}""", this.id, this.title, this.author, this.publishYear.getValue());
    }

    private final LinkedList<Book> bookRegistry = new LinkedList<>();

    public void addBook(Book book) {
        for (Book b : bookRegistry) {
            if (b.getId().equals(book.getId())) {
                System.out.println(String.format("해당 ID(%s) 는 이미 존재합니다.", book.getId()));
                throw new IllegalArgumentException();
            }
        }
        bookRegistry.sort(Comparator.comparing(Book::getId));
        System.out.println(book + " 도서가 추가되었습니다.");
        bookRegistry.add(book);
    }

    public void addBatchBook(List<Book> books) {
        for (Book book : books) {
            for (Book b : bookRegistry) {
                if (b.getId().equals(book.getId())) {
                    System.out.println(String.format("해당 ID(%s) 는 이미 존재합니다.", book.getId()));
                    throw new IllegalArgumentException();
                }
            }
            bookRegistry.add(book);
        }
        bookRegistry.sort(Comparator.comparing(Book::getId));
    }

    public Book searchBook(String id) {
        for (Book book : bookRegistry) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        System.out.println("검색된 도서가 없습니다.");
        throw new IllegalArgumentException();
    }

    public Book search_bs(String id) {
        int left = 0;
        int right = bookRegistry.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (bookRegistry.get(mid).getId().equals(id)) {
                return bookRegistry.get(mid);
            } else if (bookRegistry.get(mid).getId().compareTo(id) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("검색된 도서가 없습니다.");
        throw new IllegalArgumentException();
    }

    public void deleteBook(String id) {
        for (Book book : bookRegistry) {
            if (book.getId().equals(id)) {
                bookRegistry.remove(book);
                System.out.println(book + " 도서를 삭제하였습니다.");
                return;
            }
        }
        System.out.println(String.format("해당 ID(%s)의 도서를 찾을 수 없습니다.", id));
        throw new IllegalArgumentException();
    }
}