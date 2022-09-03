package com.ecommerce.library.service;

import com.ecommerce.library.dto.ProductDto;
import com.ecommerce.library.model.Category;
import com.ecommerce.library.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    /* Admin */
    List<ProductDto> findAll();
    ProductDto getById(Long id);
    Product save(MultipartFile imageProduct, ProductDto productDto);
    Product update(MultipartFile imageProduct, ProductDto productDto);
    void deleteById(Long id);
    void enableById(Long id);
    Page<ProductDto> pageProduct (int pageNo);
    Page<ProductDto> searchProduct(int pageNo, String keyword);

    /* Customer */

    List<ProductDto> getAllProducts();

    List<ProductDto> listViewProducts();

    Product getProductById(Long id);

    List<ProductDto> getRelatedProducts(Long categoryId);

    List<ProductDto> getProductInCategory(Long id);

    List<ProductDto> filterHighPrice();

    List<ProductDto> filterLowPrice();





}
