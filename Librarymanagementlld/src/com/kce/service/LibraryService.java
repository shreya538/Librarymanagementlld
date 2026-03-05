package com.kce.service;

import com.kce.bean.Book;
import com.kce.bean.Member;
import com.kce.bean.BorrowBook;

import java.util.ArrayList;
import java.time.LocalDate;

public class LibraryService {

    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();
    ArrayList<BorrowBook> borrowBooks = new ArrayList<>();

    public void addBook(int id, String title, String author, int copies) {

        Book b = new Book(id, title, author, copies);
        books.add(b);
        
        System.out.println("Book added successfully");
    }

    public void registerMember(int id, String name) {

        Member m = new Member(id, name);
        members.add(m);

        System.out.println("Member registered successfully");
    }

    public void borrowBook(int memberId, int bookId) {

        Book book = null;

        for (Book b : books) {
            if (b.getBookId() == bookId) {
                book = b;
                break;
            }
        }

        if (book == null) {
            System.out.println("Book not found");
            return;
        }

        if (book.getCopies() <= 0) {
            System.out.println("No copies available");
            return;
        }

        int count = 0;

        for (BorrowBook bb : borrowBooks) {
            if (bb.getMemberId() == memberId) {
                count++;
            }
        }

        if (count >= 3) {
            System.out.println("Member already borrowed 3 books");
            return;
        }

        BorrowBook bb = new BorrowBook(bookId, memberId, LocalDate.now());
        borrowBooks.add(bb);

        book.setCopies(book.getCopies() - 1);

        System.out.println("Book borrowed successfully");
    }

    public void returnBook(int memberId, int bookId) {

        BorrowBook record = null;

        for (BorrowBook b : borrowBooks) {
            if (b.getMemberId() == memberId && b.getBookId() == bookId) {
                record = b;
                break;
            }
        }

        if (record == null) {
            System.out.println("Borrow record not found");
            return;
        }

        LocalDate borrowDate = record.getBorrowDate();
        LocalDate today = LocalDate.now();

        int days = today.getDayOfYear() - borrowDate.getDayOfYear();

        if (days > 14) {
            int fine = (days - 14) * 2;
            System.out.println("Fine: Rs." + fine);
        } else {
            System.out.println("No fine");
        }

        for (Book b : books) {
            if (b.getBookId() == bookId) {
                b.setCopies(b.getCopies() + 1);
                break;
            }
        }

        borrowBooks.remove(record);

        System.out.println("Book returned successfully");
    }

    public void searchBook(String key) {

        for (Book b : books) {

            if (b.getTitle().toLowerCase().contains(key.toLowerCase())
                    || b.getAuthor().toLowerCase().contains(key.toLowerCase())) {

                System.out.println(
                        b.getBookId() + " " +
                        b.getTitle() + " " +
                        b.getAuthor() + " Copies: " +
                        b.getCopies()
                );
            }
        }
    }

    public void memberReport(int memberId) {

        boolean found = false;

        for (BorrowBook bb : borrowBooks) {

            if (bb.getMemberId() == memberId) {

                LocalDate borrowDate = bb.getBorrowDate();
                LocalDate dueDate = borrowDate.plusDays(14);

                System.out.println("Book ID : " + bb.getBookId());
                System.out.println("Borrow Date : " + borrowDate);
                System.out.println("Due Date : " + dueDate);
                
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books borrowed by this member");
        }
    }
   
    public void bookReport(int bookId) {

        for (Book b : books) {

            if (b.getBookId() == bookId) {
                System.out.println("Available Copies : " + b.getCopies());
            }
        }

        System.out.println("Borrowed By Members:");

        for (BorrowBook bb : borrowBooks) {

            if (bb.getBookId() == bookId) {
                System.out.println("Member ID : " + bb.getMemberId());
            }
        }
    }
 
   public void topBorrowers() {

    ArrayList<Integer> memberIds = new ArrayList<>();
    ArrayList<Integer> borrowCount = new ArrayList<>();

    for (BorrowBook bb : borrowBooks) {

        int memberId = bb.getMemberId();

        if (memberIds.contains(memberId)) {

            int index = memberIds.indexOf(memberId);
            borrowCount.set(index, borrowCount.get(index) + 1);

        } else {

            memberIds.add(memberId);
            borrowCount.add(1);
        }
    }

    for (int i = 0; i < memberIds.size(); i++) {
        System.out.println("Member ID : " + memberIds.get(i) +
                "  Total Borrowed : " + borrowCount.get(i));
    }
}
   
}