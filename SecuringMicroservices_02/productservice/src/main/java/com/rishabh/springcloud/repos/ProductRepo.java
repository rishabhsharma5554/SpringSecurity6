package com.rishabh.springcloud.repos;

import com.rishabh.springcloud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
