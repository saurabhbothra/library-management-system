package tests.java.com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.BorrowTransaction;
import com.example.library.model.Member;
import com.example.library.service.LibraryService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryServiceTest {

    private LibraryService libraryService;

    @BeforeEach
    public void setup() {
        libraryService = new LibraryService();
    }

    @Test
    public void testAddAndRetrieveBook() {
        Book book = new Book("ISBN123", "Effective Java", "Joshua Bloch", 5);
        libraryService.addBook(book);

        Book retrieved = libraryService.getBook("ISBN123");
        assertNotNull(retrieved);
        assertEquals("Effective Java", retrieved.getTitle());
        assertEquals(5, retrieved.getCopiesAvailable());
    }

    @Test
    public void testRegisterAndRetrieveMember() {
        Member member = new Member("M001", "Alice");
        libraryService.registerMember(member);

        Member retrieved = libraryService.getMember("M001");
        assertNotNull(retrieved);
        assertEquals("Alice", retrieved.getName());
    }

    @Test
    public void testBorrowBookSuccess() {
        Book book = new Book("ISBN123", "Effective Java", "Joshua Bloch", 2);
        libraryService.addBook(book);
        Member member = new Member("M001", "Alice");
        libraryService.registerMember(member);

        boolean borrowed = libraryService.borrowBook("M001", "ISBN123");
        assertTrue(borrowed);

        Book updatedBook = libraryService.getBook("ISBN123");
        assertEquals(1, updatedBook.getCopiesAvailable());
    }

    @Test
    public void testBorrowBookFail_NoCopies() {
        Book book = new Book("ISBN123", "Effective Java", "Joshua Bloch", 0);
        libraryService.addBook(book);
        Member member = new Member("M001", "Alice");
        libraryService.registerMember(member);

        boolean borrowed = libraryService.borrowBook("M001", "ISBN123");
        assertFalse(borrowed);
    }

    @Test
    public void testReturnBookSuccess() {
        Book book = new Book("ISBN123", "Effective Java", "Joshua Bloch", 1);
        libraryService.addBook(book);
        Member member = new Member("M001", "Alice");
        libraryService.registerMember(member);

        boolean borrowed = libraryService.borrowBook("M001", "ISBN123");
        assertTrue(borrowed);

        // Get the transaction ID
        BorrowTransaction transaction = libraryService.getTransaction(
                libraryService.getTransactionRepository().keySet().iterator().next());

        boolean returned = libraryService.returnBook(transaction.getTransactionId());
        assertTrue(returned);

        Book updatedBook = libraryService.getBook("ISBN123");
        assertEquals(1, updatedBook.getCopiesAvailable());
    }

    @Test
    public void testReturnBookFail_AlreadyReturned() {
        Book book = new Book("ISBN123", "Effective Java", "Joshua Bloch", 1);
        libraryService.addBook(book);
        Member member = new Member("M001", "Alice");
        libraryService.registerMember(member);

        boolean borrowed = libraryService.borrowBook("M001", "ISBN123");
        assertTrue(borrowed);

        BorrowTransaction transaction = libraryService.getTransaction(
                libraryService.getTransactionRepository().keySet().iterator().next());

        boolean returnedFirst = libraryService.returnBook(transaction.getTransactionId());
        assertTrue(returnedFirst);

        boolean returnedSecond = libraryService.returnBook(transaction.getTransactionId());
        assertFalse(returnedSecond);
    }
}
