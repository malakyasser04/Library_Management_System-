package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class binarysearch {
    public static int binarySearchbyTitle(LinkedList<books> arr, String x) {
        int left = 0;
        int right = arr.size() - 1;
        while (left <= right) {
            int mid = left +(right-left)/2;
            int result = x.toLowerCase().compareTo(arr.get(mid).getTitle().toLowerCase());
            System.out.println("I will compare it with: "+arr.get(mid).getTitle());
            if (result == 0)//found
            {
                return mid;
            }

            if (result>0)
                left =mid+1;
            else
                right=mid-1;
        }
        System.out.println("Not found in the library");
        return -1;
}


    public static int binarySearchbyIDNEW(LinkedList<books> arr, String x) {
        int left = 0;
        int right = arr.size() - 1;
        while (left <= right) {
            int mid = left +(right-left)/2;
            int result = x.toLowerCase().compareTo(String.valueOf(arr.get(mid).getId()));

            if (result == 0)//found
            {
                return mid;
            }

            if (result>0)
                left =mid+1;
            else
                right=mid-1;
        }
        System.out.println("Book not found in the system");
        return -1;
    }

    public static int binarySearchbyIDNEWmem(LinkedList<member> arr, String x) {
        int left = 0;
        int right = arr.size() - 1;
        while (left <= right) {
            int mid = left +(right-left)/2;
            int result = x.toLowerCase().compareTo(String.valueOf(arr.get(mid).getMemberid()));

            if (result == 0)//found
            {
                return mid;
            }

            if (result>0)
                left =mid+1;
            else
                right=mid-1;
        }
        System.out.println("Member not found in the system");
        return -1;
    }

    //sort due date of loans
    public static LinkedList<loan> mergeSort(LinkedList<loan> arr) {
        if (arr.size() <= 1) {
            return arr;
        }
        int mid = arr.size() / 2;
        LinkedList<loan> left = new LinkedList<loan>(arr.subList(0, mid));
        LinkedList<loan> right = new LinkedList<loan>(arr.subList(mid, arr.size()));

        mergeSort(left);
        mergeSort(right);

        return merge(arr, left, right);
    }

    public static LinkedList<loan> merge(LinkedList<loan> sorted, LinkedList<loan> left, LinkedList<loan> right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getIssueDate().compareTo(right.get(j).getIssueDate()) <= 0) {
                sorted.set(k++, left.get(i++));
            } else {
                sorted.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            sorted.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            sorted.set(k++, right.get(j++));
        }

        return sorted;
    }

    //sort title of books
    public static LinkedList<books> mergeSortBooks(LinkedList<books> arr) {
        if (arr.size() <= 1) {
            return arr;
        }
        int mid = arr.size() / 2;
        LinkedList<books> left = new LinkedList<books>(arr.subList(0, mid));
        LinkedList<books> right = new LinkedList<books>(arr.subList(mid, arr.size()));

        mergeSortBooks(left);
        mergeSortBooks(right);

        return mergeBooks(arr, left, right);
    }

    public static LinkedList<books> mergeBooks(LinkedList<books> sorted, LinkedList<books> left, LinkedList<books> right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getTitle().compareTo(right.get(j).getTitle()) <= 0) {
                sorted.set(k++, left.get(i++));
            } else {
                sorted.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            sorted.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            sorted.set(k++, right.get(j++));
        }

        return sorted;
    }

    public static LinkedList<member> mergeSortMembers(LinkedList<member> arr) {
        if (arr.size() <= 1) {
            return arr;
        }
        int mid = arr.size() / 2;
        LinkedList<member> left = new LinkedList<member>(arr.subList(0, mid));
        LinkedList<member> right = new LinkedList<member>(arr.subList(mid, arr.size()));

        mergeSortMembers(left);
        mergeSortMembers(right);

        return mergeMembers(arr, left, right);
    }

    public static LinkedList<member> mergeMembers(LinkedList<member> sorted, LinkedList<member> left, LinkedList<member> right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getName().compareTo(right.get(j).getName()) <= 0) {
                sorted.set(k++, left.get(i++));
            } else {
                sorted.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            sorted.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            sorted.set(k++, right.get(j++));
        }

        return sorted;
    }


}
