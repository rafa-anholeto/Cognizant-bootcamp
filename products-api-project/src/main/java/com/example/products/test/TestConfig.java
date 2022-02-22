package com.example.products.test;

import com.example.products.entities.Department;
import com.example.products.entities.Products;
import com.example.products.repositories.DepartmentRepository;
import com.example.products.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void run(String... args) throws Exception {

        Products p1 = new Products(null, "Sabonete líquido", 10.50);
        Products p2 = new Products(null, "Água sanitária Qboa", 7.80);
        Products p3 = new Products(null, "Detergente Ype", 3.50);
        Products p4 = new Products(null, "Carne contra-filé", 25.30);
        Products p5 = new Products(null, "Filé de frango temperado Perdigão", 13.50);
        Products p6 = new Products(null, "Batata doce inglesa", 6.75);

        productsRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6));

        Department d1 = new Department(null,1, "Higiene");
        Department d2 = new Department(null,2, "Carnes");
        Department d3 = new Department(null,3, "Legumes");

        departmentRepository.saveAll(Arrays.asList(d1,d2,d3));

        p1.setDepartment(d1);
        p2.setDepartment(d1);
        p3.setDepartment(d1);
        p4.setDepartment(d2);
        p5.setDepartment(d2);
        p6.setDepartment(d3);

        productsRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6));


    }
}
