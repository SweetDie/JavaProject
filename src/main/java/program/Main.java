package program;

import models.Role;
import org.hibernate.Session;
import services.RoleService;
import utils.HibernateSessionUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main.main");
        Session context = HibernateSessionUtils.getSessionFactory().openSession();
        RoleService roleService = new RoleService(context);
        String userInput = "";

        do {
            try {
                System.out.println("Choose action");
                System.out.println("create");
                System.out.println("getAll");
                System.out.println("update");
                System.out.println("delete");
                System.out.println("exit");
                Scanner in = new Scanner(System.in);
                userInput = in.nextLine();

                switch (userInput) {
                    case "create":
                        System.out.print("Enter role name: ");
                        String roleName = in.nextLine();
                        Role newRole = new Role();
                        newRole.setName(roleName);
                        roleService.CreateRole(newRole);
                        System.out.println("Role " + newRole.getName() + " created");
                        break;
                    case "getAll":
                        for (Role role : roleService.GetAllRoles()) {
                            System.out.println("Id: " + role.getId() + "\tName: " + role.getName());
                        }
                        break;
                    case "update":
                        System.out.print("Enter role id: ");
                        int id = in.nextInt();
                        in.nextLine();
                        Role role = roleService.GetById(id);
                        System.out.print("Enter new Name: ");
                        String name = in.nextLine();
                        role.setName(name);
                        roleService.UpdateRole(role);
                        System.out.println("Role update success");
                        break;
                    case "delete":
                        System.out.print("Enter role id: ");
                        id = in.nextInt();
                        in.nextLine();
                        roleService.DeleteRole(id);
                        System.out.println("Role deleted");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        } while (!userInput.equals("exit"));

    }
}
