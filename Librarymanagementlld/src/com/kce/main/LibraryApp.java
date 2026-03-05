package com.kce.main;

import com.kce.service.LibraryService;
import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LibraryService service = new LibraryService();

        while (true) {

            System.out.println("\n---- LIBRARY MENU ----");
            System.out.println("1 Add Book");
            System.out.println("2 Register Member");
            System.out.println("3 Borrow Book");
            System.out.println("4 Return Book");
            System.out.println("5 Search Book");
            System.out.println("6 Member Report");
            System.out.println("7 Book Report");
            System.out.println("8 Top Borrowers");
            System.out.println("9 Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Book ID: ");
                    int bid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Copies: ");
                    int copies = sc.nextInt();
                    service.addBook(bid, title, author, copies);
                    break;

                case 2:
                    System.out.print("Member ID: ");
                    int mid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    service.registerMember(mid, name);
                    break;

                case 3:
                    System.out.print("Member ID: ");
                    int m1 = sc.nextInt();
                    System.out.print("Book ID: ");
                    int b1 = sc.nextInt();
                    service.borrowBook(m1, b1);
                    break;

                case 4:
                    System.out.print("Member ID: ");
                    int m2 = sc.nextInt();
                    System.out.print("Book ID: ");
                    int b2 = sc.nextInt();
                    service.returnBook(m2, b2);
                    break;

                case 5:
                    sc.nextLine();
                    System.out.print("Keyword: ");
                    String key = sc.nextLine();
                    service.searchBook(key);
                    break;

                case 6:

                    System.out.print("Member ID: ");
                    int memberId = sc.nextInt();
                    service.memberReport(memberId);
                    break;

                case 7:
                    System.out.print("Book ID: ");
                    int b3 = sc.nextInt();
                    service.bookReport(b3);
                    break;

                case 8:
                    service.topBorrowers();
                    break;

                case 9:
                    System.exit(0);
            }
        }
    }
}