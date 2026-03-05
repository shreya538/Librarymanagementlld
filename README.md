Project Description

This project is a Low-Level Design (LLD) implementation of a Library Management System using Java.
The system supports basic library functionalities such as adding books, registering members, borrowing books, returning books with fine calculation, searching books, and generating reports.


LibraryManagementLLD
│
├── src
│
├── com.kce.bean
│   ├── Book.java
│   ├── BorrowBook.java
│   └── Member.java
│
├── com.kce.service
│   └── LibraryService.java
│
└── com.kce.main
    └── LibraryApp.java

    Package Description

bean

Contains entity classes (data models)

service

Contains business logic for library operations

main

Contains the main class to run the application


Features
1️⃣ Add Book

Add a new book with:

Book ID

Title

Author

Number of copies

Each Book ID must be unique.

2️⃣ Register Member

Register a new library member with:

Member ID

Member Name

Each Member ID must be unique.

3️⃣ Borrow Book

Members can borrow books with the following rules:

Maximum 3 books per member

Book must have available copies

Borrow date is automatically recorded

4️⃣ Return Book

When a book is returned:

Available copies increase by 1

System checks for overdue fine

Fine Calculation
Due Period = 14 days
Fine = Rs.2 per overdue day

Example:

3 days overdue
Fine = 3 × 2 = Rs.6
5️⃣ Search Book

Users can search books by:

Title

Author

Supports partial keyword matching.

Example:

Search: Java
Results: Java Programming
6️⃣ Member Report

Displays books currently borrowed by a member including:

Book ID

Borrow Date

Due Date

7️⃣ Book Report

Displays:

Available copies

Members who borrowed the book

8️⃣ Top Borrowers

Displays members sorted by total number of books borrowed (descending order).


<img width="354" height="352" alt="image" src="https://github.com/user-attachments/assets/11a9714b-5747-42ba-bbc2-058efd266979" />

<img width="309" height="338" alt="image" src="https://github.com/user-attachments/assets/eb59a799-41af-423e-a4a7-fd82197b1d29" />

<img width="452" height="326" alt="image" src="https://github.com/user-attachments/assets/0ca8d141-4cef-4f43-be79-fd6e58ef7f06" />

<img width="466" height="311" alt="image" src="https://github.com/user-attachments/assets/e71d370b-7bef-4904-b282-34955bceb3b8" />

<img width="405" height="301" alt="image" src="https://github.com/user-attachments/assets/226e4169-976e-4833-9cc8-a50bc9fd9bf6" />

<img width="513" height="329" alt="image" src="https://github.com/user-attachments/assets/b2dca11f-04a2-4889-a082-f5c1d732ff9a" />


<img width="378" height="293" alt="image" src="https://github.com/user-attachments/assets/0546bb99-248b-4825-aee6-7883a4faaf7c" />


<img width="401" height="279" alt="image" src="https://github.com/user-attachments/assets/3ddb3cb4-5d90-4b54-a855-17238e3a1473" />

<img width="350" height="299" alt="image" src="https://github.com/user-attachments/assets/970ffa84-a668-4bb4-a0bb-360a6c3fc8a2" />

<img width="324" height="317" alt="image" src="https://github.com/user-attachments/assets/3ab8b427-95f3-4fd5-8c0b-cee20adb4bfe" />

<img width="279" height="278" alt="image" src="https://github.com/user-attachments/assets/c766ea46-c1fd-4af7-b732-0bd663c0e9af" />

<img width="255" height="330" alt="image" src="https://github.com/user-attachments/assets/2900d3c4-deb9-42d2-8397-ec3d439f98bf" />

<img width="380" height="574" alt="image" src="https://github.com/user-attachments/assets/4088d52c-8d46-4b32-8ddf-e28a1e3255f2" />
