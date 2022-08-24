package com.ecommerce.library.repository;

import com.ecommerce.library.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /*Admin*/

    List<Product> findProductsByDescriptionContains(String keyword);

    /*Customer*/
    List<Product> findAllByActivatedTrue();

    List<Product> findTop4ByActivatedTrue();
}
