package com.company;

import com.company.books;

import java.time.LocalDate;

public class Main  {
    public static void main(String[] args) {
        //LibraryFiles.readfile(0);//load loans data into the system
        LibraryFiles.readfile(1);//load members into the system

        for (int i=0; i<library.listOfMembers.size(); i++){
            System.out.println(library.listOfMembers.get(i));
        }

       LocalDate issueDate1 = LocalDate.now().plusDays(1);
        LocalDate issueDate2 = LocalDate.now().plusDays(5);
        LocalDate issueDate3 = LocalDate.now().minusDays(1);

        loan loan1 = new loan(1,1,1,issueDate1,issueDate1);
        loan loan2 = new loan(2,2,2,issueDate2,issueDate2);
        loan loan3 = new loan(3,3,3,issueDate3,issueDate1);

        library.listOFLoans.add(loan1);
        library.listOFLoans.add(loan2);
        library.listOFLoans.add(loan3);

        books trial = new books(1,"Harry Potter", "J.K Rowling", "Fantasy", 1);
        books trial2 = new books(2,"It Ends with Us", "J.K Rowling", "Fantasy", 0);
        books trial3 = new books(3,"Annie", "J.K Rowling", "Fantasy", 1);


        Catalogue.listOfBooks.add(trial);
        Catalogue.listOfBooks.add(trial2);
        Catalogue.listOfBooks.add(trial3);

        for (int i=0; i<Catalogue.listOfBooks.size(); i++){
            System.out.println(Catalogue.listOfBooks.get(i));
        }

        systemInterface.mainMenu();


    }
}

