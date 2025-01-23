package com.company;

import java.util.Scanner;

    public class systemInterface {
        public static void displayMemberMenu(){
            int option;
            String booktoBorrow;
            String requsetname;
            Scanner ob = new Scanner(System.in);
            String memName;
            String memContact;
            member newmem;
            int indexMem = 0;
            int memnewid;

            System.out.println("Hi Member!");

            //get the member id to use it in creating loan
            System.out.println("Are you 1.New 2.Old member?");
            option = ob.nextInt();
            ob.nextLine();

            if(option == 1){ //new
                System.out.println("Enter your name");
                memName = ob.nextLine();
                System.out.println("Enter your contact info");
                memContact = ob.nextLine();
                System.out.println("Enter your id");
                memnewid = ob.nextInt();

                newmem = new member(memnewid,memName, memContact);

                System.out.println("Here is your id " + memnewid);
                library.listOfMembers.add(newmem);
            }
            else if (option == 2){ //old
                System.out.println("Please enter your id");
                int x = ob.nextInt();
                int result = binarysearch.binarySearchbyIDNEWmem(library.listOfMembers,String.valueOf(x));

                if (result != -1){ //found member
                    indexMem = result;
                    newmem = library.listOfMembers.get(indexMem);
                    System.out.println("Result of binary search for member: " + newmem.getName());
                }
                else { //not found member
                    System.out.println("Member doesn't exist!");
                    mainMenu();
                }
            }

            else {
                System.out.println("Invalid Input");
                mainMenu();
            }

            newmem = library.listOfMembers.get(indexMem);

            System.out.println("Choose what you want to do:\n1.Display books in the library.\n2.Display borrowed books.\n3.Borrow book.\n4.Return book.\n5.Exit");
            option= ob.nextInt();
            if (option == 1){
                Catalogue.displayCatalogue();
                displayMemberMenu();
            }
            if (option == 2){
// go to lone class search by member id to get his books and print it
            }
            if (option == 3){
                newmem.borrowBook();
                displayMemberMenu();
            }
            if (option == 4){
                newmem.returnBook();
                displayMemberMenu();
            }
            if (option == 5){
                mainMenu();
            }
            else {
                System.out.println("Invalid Input!");
                mainMenu();;
            }
        }

        public static void displayLibrarianMenu(){
            int option1;
            Scanner ob = new Scanner(System.in);

            System.out.println("Hi Librarian!");
            System.out.println("Choose what you want to do:\n1.Add new book.\n2.Update book details.\n3.View book loans.\n4.Pending book requests.\n5.Display Members\n6.Exit.");
            option1=ob.nextInt();

            if (option1==1){
                Catalogue.addBooks();
                displayLibrarianMenu();
            }
            else if(option1 == 2){
                System.out.println("Choose how to look for the book to update:\n1.Id.\n2.Title");
                int x = ob.nextInt();
                Catalogue.updateBook(x);
                displayLibrarianMenu();
            }
            else if (option1==3){
                loan.displayLoans();
                displayLibrarianMenu();
            }
            else if (option1==4){
                //pending book requests
                Catalogue.manageQueueRequests();
                displayLibrarianMenu();
            }
            else if (option1==5){
                Catalogue.displayMembers();
                displayLibrarianMenu();
            }
            else if (option1 == 6) {
                mainMenu();
            }
            else {
                System.out.println("invalid input!");
                mainMenu();
            }
        }

        public static void mainMenu(){
            int who;
            Scanner ob = new Scanner(System.in);

            System.out.println("Welcome to Library Management System");
            System.out.println("Please choose who are you:\n1.Member \n2.Librarian\n3.Exit");
            who = ob.nextInt();

            if(who == 1){ //member
                displayMemberMenu();
            }
            else if (who == 2){ //librarian
               displayLibrarianMenu();
            }
            else if (who == 3){ //librarian
                exit();
            }
            else{
                System.out.println("Not a valid input!");
                systemInterface.mainMenu();
            }
        }

        public static void exit(){
            LibraryFiles.writefile(0); //save loans
            LibraryFiles.writefile(1); //save members
            System.exit(0);
        }
    }


