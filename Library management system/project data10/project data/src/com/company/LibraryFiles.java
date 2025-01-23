package com.company;

import com.company.books;
import com.company.library;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class LibraryFiles {
        public static void writefile(int type){
            if (type == 0) {
                try {
                    File f = new File("list of loans");
                    FileOutputStream fileOut = new FileOutputStream(f);
                    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                    objectOut.writeObject(library.listOFLoans);
                    objectOut.close();
                    System.out.println("Loans were succesfully written to a file");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (type == 1) {
                try {
                    FileOutputStream fileOut = new FileOutputStream("list of members");
                    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                    objectOut.writeObject(library.listOfMembers);
                    objectOut.close();
                    System.out.println("Members were succesfully written to a file");

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    ex.printStackTrace();
                }
            }
        }

        public static void readfile(int type) {
            if (type == 0) {
                try {
                    FileInputStream fileIn = new FileInputStream("list of loans");
                    ObjectInputStream objectIn = new ObjectInputStream(fileIn);

                    library.listOFLoans = (LinkedList<loan>) objectIn.readObject();
                    objectIn.close();

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
            if (type == 1) {
                try {
                    FileInputStream fileIn = new FileInputStream("list of members");
                    ObjectInputStream objectIn = new ObjectInputStream(fileIn);

                    library.listOfMembers = (LinkedList<member>) objectIn.readObject();
                    objectIn.close();

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        }
    }


