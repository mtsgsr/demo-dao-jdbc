package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("SELLER");

        System.out.println("TEST 1: Seller findById");
        Seller seller = sellerDao.findById(3);

        System.out.println("\nTEST 2: Seller findByDepartment");
        Department department = new Department(2, null);
        List<Seller> listSeller = sellerDao.findByDepartment(department);
        for (Seller obj : listSeller){
            System.out.println(obj);
        }

        System.out.println("\nTEST 3: Seller findAll");
        listSeller = sellerDao.findAll();
        for (Seller obj : listSeller){
            System.out.println(obj);
        }

        System.out.println("\nTEST 4: Seller insert");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted: new id = " + newSeller.getId());

        System.out.println("\nTEST 5: Seller update");
        seller = sellerDao.findById(1);
        seller.setName("Martha Wayne");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println("\n TEST 6: Seller delete");
        System.out.println("Enter id for deletion: ");
        int sellerId = sc.nextInt();
        sellerDao.deleteById(sellerId);
        System.out.println("Delete completed");

        System.out.println("\n----------------------------------------------------------------------------");

        System.out.println("DEPARTMENT");

        System.out.println("TEST 1: findById");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);

        System.out.println("\nTEST 2: findAll");
        List<Department> listDepartment = departmentDao.findAll();
        for (Department d : listDepartment) {
            System.out.println(d);
        }

        System.out.println("\nTEST 3: insert");
        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted: new id = " + newDepartment.getId());

        System.out.println("\nTEST 4: update");
        Department dep2 = departmentDao.findById(1);
        dep2.setName("Food");
        departmentDao.update(dep2);
        System.out.println("Update completed");

        System.out.println("\nTEST 5: delete");
        System.out.print("Enter id for deletion: ");
        int departmentId = sc.nextInt();
        departmentDao.deleteById(departmentId);
        System.out.println("Delete completed");

        sc.close();
    }
}