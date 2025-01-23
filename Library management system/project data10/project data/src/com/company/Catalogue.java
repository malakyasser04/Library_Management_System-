package com.company;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public class Catalogue {
    public static LinkedList<books> listOfBooks = new LinkedList<>();

    public static void displayCatalogue() {
        if (listOfBooks.isEmpty()) {
            System.out.println("Catalogue is empty.");
        } else {
            LinkedList<books> temp = (LinkedList<books>) listOfBooks.clone();
            LinkedList<books> sorted;

            sorted = binarysearch.mergeSortBooks(temp);
            System.out.println("Catalogue:");
            for (books book : sorted) {
                System.out.println(book);
            }
        }
    }

    public static void addBooks(){
        Scanner ob = new Scanner(System.in);
        int id;
        String newTitle;
        String newAuthorName;
        String genre;
        int status;
        books newBook;

        System.out.println("1.Enter the id of book");
        id = ob.nextInt();
        System.out.println("2.Enter the title of book");
        ob.nextLine();
        newTitle = ob.nextLine();
        System.out.println("3.Enter the name of Author");
        newAuthorName = ob.nextLine();
        System.out.println("4.Enter the genre of the book");
        genre = ob.nextLine();
        System.out.println("5.Enter  the status of the book");
        status = ob.nextInt();

        newBook = new books(id, newTitle, newAuthorName, genre, status);

        if(Catalogue.listOfBooks.add(newBook)){
        System.out.println("added succsessfully!");
        systemInterface.mainMenu();
    }
        else{
            System.out.println("Error occured. Try again later!");
            systemInterface.mainMenu();
        }
    }

    public static void updateOptions(int index){
        Scanner ob = new Scanner(System.in);
        int x;
        String update;

        System.out.println("What do you want to update?\n1.id\n2.title\n3.author\n4.genre\n5.Availabilty Status\n6.Exit");
        x = ob.nextInt();

        switch (x){
            case 1:
                System.out.println("1.Enter the id of book");
                x = ob.nextInt();
                Catalogue.listOfBooks.get(index).setId(x);
                updateOptions(index);
                break;
            case 2:
                System.out.println("2.Enter the title of book");
                ob.nextLine();
                update = ob.nextLine();
                System.out.println(Catalogue.listOfBooks.get(index).getTitle());
                Catalogue.listOfBooks.get(index).setTitle(update);
                System.out.println(Catalogue.listOfBooks.get(index).getTitle());
                updateOptions(index);
                break;
            case 3:
                System.out.println("3.Enter the name of Author");
                ob.nextLine();
                update = ob.nextLine();
                Catalogue.listOfBooks.get(index).setAuthorName(update);
                updateOptions(index);
                break;
            case 4:
                System.out.println("4.Enter the genre of the book");
                ob.nextLine();
                update= ob.nextLine();
                Catalogue.listOfBooks.get(index).setGenre(update);
                updateOptions(index);
                break;
            case 5:
                System.out.println("5.Enter  the status of the book");
                x= ob.nextInt();
                Catalogue.listOfBooks.get(index).setAvailabilityStatus(x);
                Catalogue.listOfBooks.get(index).getAvailabilityStatus();
                updateOptions(index);
                break;
            case 6:
                systemInterface.displayLibrarianMenu();
            default:
                System.out.println("Enter a valid option");
        }
    }

    public static void updateBook(int method){
        Scanner ob = new Scanner(System.in);
        int bookIndex;
        int id;
        String title;

        if (method == 1) {// update by Id
            System.out.println("Enter the id of the book");
            id = ob.nextInt();
            bookIndex = binarysearch.binarySearchbyIDNEW(Catalogue.listOfBooks, String.valueOf(id));
            if (bookIndex != -1){
            System.out.println("Found the book you want to update!");
            updateOptions(bookIndex);
            }
        }
        else if (method == 2){
            System.out.println("Enter the title of the book");
            title = ob.nextLine();
            bookIndex = binarysearch.binarySearchbyTitle(Catalogue.listOfBooks, title);
            if (bookIndex != -1) {
                System.out.println("Found the book you want to update!");
                updateOptions(bookIndex);
            }
        }
    }

    public static void displayMembers(){
        LinkedList<member> temp = (LinkedList<member>) library.listOfMembers.clone();
        LinkedList<member> sorted;

        sorted = binarysearch.mergeSortMembers(temp);

        for(member m:sorted){
            System.out.println(m);
        }
    }

    public static void manageQueueRequests(){
        Scanner ob = new Scanner(System.in);
        int option;
        int idtoHandle;
        books handle;
        loan newLoan;
        LocalDate issueNew = LocalDate.now();

        for (books book: Catalogue.listOfBooks){//display the queue requests of each book
            System.out.println(book.getTitle() + " has the following requests:");
            System.out.println(book.getRequestsQ().print());
        }

        System.out.println("Here is the availability of each book: ");// display the availability of each book
        for (books book: Catalogue.listOfBooks){
            System.out.println("The availability of " + book.getTitle() + " " + book.getAvailabilityStatus());
        }

        System.out.println("Do you want to handle a request?\n1.Yes\n2.No");
        option = ob.nextInt();
        if(option == 1){
            System.out.println("Enter the id of the book you want to handle its requests.");
            option = ob.nextInt();
            idtoHandle = binarysearch.binarySearchbyIDNEW(Catalogue.listOfBooks,String.valueOf(option));
            handle = Catalogue.listOfBooks.get(idtoHandle);

            if (handle.getAvailabilityStatus() == 1) {
                //dequeue a request from the book's queue
                System.out.println("You will handle the book with id " + idtoHandle + " and title " + handle.getTitle());
                System.out.println(handle.getRequestsQ().print());
                handle.getRequestsQ().dequeue();
                System.out.println("Queue of " + handle.getTitle() + " after dequeueing:");
                System.out.println(handle.getRequestsQ().print());

                //create a new loan and add it to list of loans
                newLoan = new loan(handle.getId(),((member.requests) library.dequeuedReq).memID,issueNew,issueNew.plusDays(3));
                library.listOFLoans.add(newLoan);

                for (loan loan1 : library.listOFLoans){
                    System.out.println("Here is the updated loans list");
                    System.out.println(loan1);
                }

            }
            else {
                System.out.println("Book isn't still not available to borrow!");
            }
            systemInterface.mainMenu();
        }
        else if(option == 2){
            systemInterface.mainMenu();
        }
        else {
            System.out.println("Invalid input");
            systemInterface.mainMenu();
        }
    }
}
