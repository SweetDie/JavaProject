package program;

import models.Role;
import org.hibernate.Session;
import utils.HibernateSessionUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");
        Session context = HibernateSessionUtils.getSessionFactory().openSession();
        System.out.print("Enter role: ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        Role role = new Role();
        role.setName(name);
        context.saveOrUpdate(role);

        context.close();
    }
}
