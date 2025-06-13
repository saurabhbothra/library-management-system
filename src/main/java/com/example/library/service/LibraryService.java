package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.BorrowTransaction;
import com.example.library.model.Member;

import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;
import java.util.UUID;

public class LibraryService {
    private final Map<String, Book> bookRepository = new HashMap<>();
    private final Map<String, Member> memberRepository = new HashMap<>();
    private final Map<String, BorrowTransaction> transactionRepository = new HashMap<>();

    public void addBook(Book book) {
        bookRepository.put(book.getIsbn(), book);
    }

    public void registerMember(Member member) {
        memberRepository.put(member.getMemberId(), member);
    }

    public boolean borrowBook(String memberId, String isbn) {
        Book book = bookRepository.get(isbn);
        if (book == null || book.getCopiesAvailable() <= 0) {
            return false;
        }
        book.setCopiesAvailable(book.getCopiesAvailable() - 1);

        BorrowTransaction transaction = new BorrowTransaction();
        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setMemberId(memberId);
        transaction.setIsbn(isbn);
        transaction.setBorrowDate(LocalDate.now());
        transaction.setDueDate(LocalDate.now().plusWeeks(2));
        transactionRepository.put(transaction.getTransactionId(), transaction);
        return true;
    }

    public boolean returnBook(String transactionId) {
        BorrowTransaction transaction = transactionRepository.get(transactionId);
        if (transaction == null || transaction.getReturnDate() != null) {
            return false;
        }
        transaction.setReturnDate(LocalDate.now());
        Book book = bookRepository.get(transaction.getIsbn());
        if (book != null) {
            book.setCopiesAvailable(book.getCopiesAvailable() + 1);
        }
        return true;
    }

    // Additional helper methods for testing or querying

    public Book getBook(String isbn) {
        return bookRepository.get(isbn);
    }

    public Member getMember(String memberId) {
        return memberRepository.get(memberId);
    }

    /**
     * Returns the internal transaction repository map.
     * This allows access to all borrow transactions keyed by transaction ID.
     */
    public Map<String, BorrowTransaction> getTransactionRepository() {
        return transactionRepository;
    }

    public BorrowTransaction getTransaction(String transactionId) {
        return transactionRepository.get(transactionId);
    }
}
