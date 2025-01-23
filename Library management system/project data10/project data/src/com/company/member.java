package com.company;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Scanner;
import java.time.LocalDate;

public class member implements Serializable {

    public class requests{
        int memID;
        int bookID;

        @Override
        public String toString() {
            return "requests{" +
                    "memID=" + memID +
                    ", bookID=" + bookID +
                    '}';
        }
    }

    private int memberid;
    private String name;
    private String contactinfo;

    public member(int memberid, String name, String contactinfo) {
        this.memberid = memberid;
        this.name = name;
        this.contactinfo = contactinfo;
    }

    public int getMemberid() {
        return memberid;
    }

    public void setMemberid(int memberid) {
        this.memberid = memberid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactinfo() {
        return contactinfo;
    }

    public void setContactinfo(String contactinfo) {
        this.contactinfo = contactinfo;
    }

    public void borrowBook(){
        Scanner ob = new Scanner(System.in);
        String booktoBorrow;
        int searchResult;
        loan newLoan;
        requests newreq = new requests();

        System.out.println("Hi " + this.getName());
        System.out.println("Choose the book you want to borrow by entering its name.");

        LinkedList<books> tempBooks = (LinkedList<books>) Catalogue.listOfBooks.clone();
        LinkedList<books> sortedBooks = binarysearch.mergeSortBooks(tempBooks);

        for (int i = 0; i < sortedBooks.size(); i++) { //display the books in the library sorted by title ASC
            System.out.println(sortedBooks.get(i));
        }

        booktoBorrow = ob.nextLine();
        searchResult = binarysearch.binarySearchbyTitle(sortedBooks, booktoBorrow.toLowerCase());//index of book to borrow
        System.out.println(searchResult);
        if (searchResult != -1) {
            if (sortedBooks.get(searchResult).getAvailabilityStatus() == 1){
                System.out.println("I am borrowing the book with id " + sortedBooks.get(searchResult).getId());
                newLoan = new loan(sortedBooks.get(searchResult).getId(),this.getMemberid(),LocalDate.now(), LocalDate.now().plusDays(3));
                library.listOFLoans.add(newLoan);
                sortedBooks.get(searchResult).setAvailabilityStatus(0);
                System.out.println("Here is your loan added to the list of loans.");
                System.out.println(library.listOFLoans.getLast());

                //Update the original list of books
                for(books book : Catalogue.listOfBooks){
                    if (book.getId() == sortedBooks.get(searchResult).getId()){
                        book.setAvailabilityStatus(0);
                    }
                }
            }
            else {
                System.out.println(sortedBooks.get(searchResult).getTitle() + " isn't available to borrow.");
                System.out.println("A borrow request will be created.");
                newreq.bookID = sortedBooks.get(searchResult).getId();
                newreq.memID = this.getMemberid();

                sortedBooks.get(searchResult).getRequestsQ().enqueue(newreq);

                System.out.println("Request is created.");
                System.out.println("Here is your request added to the queue for " + sortedBooks.get(searchResult).getTitle());
                System.out.println(sortedBooks.get(searchResult).getRequestsQ().print());
            }
        }
        else {
            System.out.println("Book isn't found in the library");
            systemInterface.mainMenu();
        }
    }

    public void returnBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the book id to return:");
        int id;
        boolean found = false;
        int indexOfBooktoReturn;
        int loanIndex;

        id = scanner.nextInt();

        for (int i=0; i<library.listOFLoans.size(); i++) {
            if (library.listOFLoans.get(i).getBookId() == id) {
                loanIndex = i;
                found = true;
                System.out.println("I found the loan");

                indexOfBooktoReturn = binarysearch.binarySearchbyIDNEW(Catalogue.listOfBooks,String.valueOf(id));
                if(indexOfBooktoReturn != -1){
                    Catalogue.listOfBooks.get(indexOfBooktoReturn).setAvailabilityStatus(1);
                    library.listOFLoans.remove(loanIndex);

                    if(library.listOFLoans.size()==0){
                        System.out.println("list of loans is empty!");
                    }
                    else {
                        System.out.println("Here is the list of the current loans in the system");
                        for (loan loan1 : library.listOFLoans){
                            System.out.println(loan1);
                        }
                    }

                    System.out.println("Here is the returned book: " + Catalogue.listOfBooks.get(indexOfBooktoReturn));
                    System.out.println("Book with ID " + id + " has been returned.");

                    for (loan loan1 : library.listOFLoans){
                        System.out.println("Here is the updated loans list");
                        System.out.println(loan1);
                    }
                }
            }
            if (found == true) {
                break; // Exit the loop once the loan is found, book returned and loan removed
            }
            else found =false;
        }

        if (!found) {
            System.out.println("Book with ID " + id + " not found in the list of loans.");
        }

    }

    @Override
    public String toString() {
        return "member{" +
                "memberid=" + memberid +
                ", name='" + name + '\'' +
                ", contactinfo='" + contactinfo + '\'' +
                '}';
    }
}