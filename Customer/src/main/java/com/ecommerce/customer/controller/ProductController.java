package com.ecommerce.customer.controller;

import com.ecommerce.library.dto.CategoryDto;
import com.ecommerce.library.dto.ProductDto;
import com.ecommerce.library.model.Category;
import com.ecommerce.library.model.Product;
import com.ecommerce.library.service.CategoryService;
import com.ecommerce.library.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/products")
    public String products(Model model) {
        List<CategoryDto> categoryDtoList = categoryService.getCategoryAndProduct();
        List<ProductDto> products = productService.getAllProducts();
        List<ProductDto> listViewProducts = productService.listViewProducts();
        model.addAttribute("categories", categoryDtoList);
        model.addAttribute("viewProducts", listViewProducts);
        model.addAttribute("products", products);
        return "shop";
    }

    @GetMapping("/find-product/{id}")
    public String findProductById(@PathVariable("id") Long id, Model model) {
        Product product = productService.getProductById(id);
        Long categoryId = product.getCategory().getId();
        List<ProductDto> productDtoList = productService.getRelatedProducts(categoryId);
        model.addAttribute("product", product);
        model.addAttribute("relatedProduct", productDtoList);
        return "product-detail";
    }

    @GetMapping("/product-in-category/{id}")
    public String getProductsInCategory(@PathVariable Long id, Model model) {
        Category category = categoryService.findById(id);
        List<CategoryDto> categoryDtoList = categoryService.getCategoryAndProduct();
        List<ProductDto> products =productService.getProductInCategory(id);
        model.addAttribute("category", category);
        model.addAttribute("categories", categoryDtoList);
        model.addAttribute("products", products);
        return "product-in-category";
    }
}
