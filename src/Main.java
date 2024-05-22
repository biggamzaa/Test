import java.util.ArrayList;
import java.util.Scanner;

class Member {
    private String name;
    private String email;
    private String password;

    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

public class Main {
    private static ArrayList<Member> members = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Register Member");
            System.out.println("2. View Members");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // consume the newline

            switch (option) {
                case 1:
                    registerMember(scanner);
                    break;
                case 2:
                    viewMembers();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void registerMember(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Member member = new Member(name, email, password);
        members.add(member);
        System.out.println("Member registered successfully.");
    }

    private static void viewMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered.");
        } else {
            for (Member member : members) {
                System.out.println(member);
            }
        }
    }
}
