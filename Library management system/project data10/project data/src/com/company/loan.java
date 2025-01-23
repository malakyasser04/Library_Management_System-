package com.company;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public class loan implements Serializable {
    private static int id = 0;
        private int loanId;
        private int bookId ;
        private int memberId;
        private LocalDate issueDate;
        private LocalDate returnDate;

    public loan(int loanId, int bookId, int memberId, LocalDate issueDate, LocalDate returnDate) {
        this.loanId = loanId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public loan(int bookId, int memberId, LocalDate issueDate, LocalDate returnDate) {
            this.bookId = bookId;
            this.memberId = memberId;
            this.issueDate = issueDate;
            this.returnDate = returnDate;
            this.setLoanId();
        }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId() {
        this.loanId = id + 1;
        id = id + 1;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public static void displayLoans(){
        Scanner ob = new Scanner(System.in);
        int option;
        LinkedList<loan> sortedLoans;

        System.out.println("Do you want to sort loans by Due Date?");
        System.out.println("1.Yes\n2.No");
        option= ob.nextInt();

        if (option == 1){
            //sort by due date ASC
            LinkedList<loan> temp = (LinkedList<loan>) library.listOFLoans.clone();
            sortedLoans = binarysearch.mergeSort(temp);

            System.out.println("Here is the sorted loans");
            for(loan sorted: sortedLoans){
                System.out.println(sorted);
            }
        }

        if(option == 2) {
            System.out.println("I am in NO!");
            for (int i = 0; i < library.listOFLoans.size(); i++) {
                System.out.println(library.listOFLoans.get(i));
            }
        }

    }

    @Override
    public String toString() {
        return "loan{" +
                "loanId=" + loanId +
                ", bookId=" + bookId +
                ", memberId=" + memberId +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                '}';
    }
}