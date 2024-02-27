package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        int choice = 0;

        while (choice != 3) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login as Student ");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose Option(1-3) : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter your NIM :");
                    String nim = scanner.next();
                    library.mahasiswaLogin(nim);
                    break;
                case 2:
                    System.out.print("Enter your username : ");
                    String username = scanner.next();
                    System.out.print("Enter your password :");
                    String password = scanner.next();
                    library.adminLogin(username, password);
                    break;
                case 3:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}

class Library {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";
    private static final String[] MAHASISWA_CREDENTIALS = {"202310370311240"};

    public void mahasiswaLogin(String nim) {
        boolean found = false;
        for (String credential : MAHASISWA_CREDENTIALS) {
            if (credential.equals(nim)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Successful Login as Student.");
        } else {
            System.out.println("User Not Found.");
        }
    }

    public void adminLogin(String username, String password) {
        if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
            System.out.println("Successful Login as Admin.");
        } else {
            System.out.println("Admin User Not Found.");
        }
    }
}
