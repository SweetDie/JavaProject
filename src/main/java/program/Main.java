package program;

import models.Role;
import org.hibernate.Session;
import org.hibernate.query.Query;
import services.RoleService;
import utils.HibernateSessionUtils;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");
        Session context = HibernateSessionUtils.getSessionFactory().openSession();
        RoleService roleService = new RoleService(context);
//        System.out.print("Enter role: ");
//        Scanner in = new Scanner(System.in);
//        String name = in.nextLine();
//        Role role = new Role();
//        role.setName(name);
//        context.saveOrUpdate(role);
        String userInput = "";
        do {
            System.out.println("Choose action");
            System.out.println("1: create");
            System.out.println("2: getAll");
            System.out.println("3: update");
            System.out.println("4: delete");
            System.out.println("5: exit");
            Scanner in = new Scanner(System.in);
            userInput = in.nextLine();


            switch (userInput) {
                case "create":
                    System.out.println("create");
                    break;
                case "getAll":
                    for(Role role: roleService.GetAllRoles()){
                        System.out.println(role);
                    }
                    break;
                case "update":
                    System.out.println("update");
                    break;
                case "delete":
                    System.out.print("Enter role name: ");
                    String name = in.nextLine();
                    roleService.DeleteRole(name);
                    break;
            }
        } while (!userInput.equals("exit"));

        context.close();
    }
}
