package com.javatechie.respository;

import com.javatechie.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByName(String name);

    List<Product> findByProductType(String productType);

    List<Product> findByPriceAndProductType(double price, String productType);

    //@Query(value = "SELECT * FROM PRODUCT_TBL WHERE price = ?1",nativeQuery = true)
    @Query("from Product p where p.price= ?1 ")
    //position based parameter
    //@Query("from PRODUCT_TABLE p where p.price= :price") //named parameter base index
    List<Product> getProductByPrice(double price);
}
