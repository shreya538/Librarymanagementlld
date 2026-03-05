package com.kce.bean;

import java.time.LocalDate;

public class BorrowBook {

	    private int bookId;
	    private int memberId;
	    private LocalDate borrowDate;

	    public BorrowBook(int bookId, int memberId, LocalDate borrowDate) {
	    	
	        this.bookId = bookId;
	        this.memberId = memberId;
	        this.borrowDate = borrowDate;
	    }

	    public int getBookId() {
	        return bookId;
	    }

	    public int getMemberId() {
	        return memberId;
	    }

	    public LocalDate getBorrowDate() {
	        return borrowDate;
	    }
	}