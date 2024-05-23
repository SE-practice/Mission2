import java.time.Year;
import java.util.HashMap;
import java.util.Map;

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

    private final Map<String, Book> bookRegistry = new HashMap<>();

    public void addBook(Book book) {
        if(bookRegistry.containsKey(book.getId())) {
            System.out.println(String.format("해당 ID(%s) 는 이미 존재합니다.",book.getId()));
            throw new IllegalArgumentException();
        }
        System.out.println(book+ "도서가 추가되었습니다.");
        bookRegistry.put(book.getId(), book);
    }

    public Book searchBook(String id){
        if(bookRegistry.containsKey(id)) {
            return bookRegistry.get(id);
        }
        System.out.println("검색된 도서가 없습니다.");
        throw new IllegalArgumentException();
    }


    public void deleteBook(String id) {
        if(bookRegistry.containsKey(id)) {
        	Book book = bookRegistry.get(id);
            bookRegistry.remove(id);
            System.out.println(book+ "도서를 삭제하였습니다.");
            return;
        }
        System.out.println(String.format("해당 ID(%s)의 도서를 찾을 수 없습니다.",id));
        throw new IllegalArgumentException();
        
    }
}