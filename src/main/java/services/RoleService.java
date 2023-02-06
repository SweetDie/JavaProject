package services;

import models.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionUtils;
import viewmodels.RoleCreateVM;

import java.util.List;

public class RoleService {
    private final Session context;

    public RoleService(Session context) {
        this.context = context;
    }

    public Role GetById(int id){
        Role role = context.get(Role.class, id);
        return role;
    }

    public Role GetByName(String name){
        Role role = context.load(Role.class, name);
        return role;
    }

    public void CreateRole(RoleCreateVM model){
        Role role = new Role();
        role.setName(model.getName());
        context.save(role);
    }

    public List<Role> GetAllRoles(){
        Query query = context.createQuery("FROM Role");
        List<Role> list = query.list();
        return list;
    }

    public void UpdateRole(Role model) {
        context.update(model);
    }

    public void DeleteRole(Role model) {
        Transaction tx = context.beginTransaction();
        context.remove(model);
        tx.commit();
    }

    public void DeleteRole(int id) {
        Role role = this.GetById(id);
        this.DeleteRole(role);
    }

    public void DeleteRole(String name) {
        Role role = this.GetByName(name);
        System.out.print("Role: ");
        System.out.println(role);
        this.DeleteRole(role);
    }
}
