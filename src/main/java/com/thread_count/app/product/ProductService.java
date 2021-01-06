package com.thread_count.app.product;

import com.thread_count.app.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    final private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    // Get all products
    public List<Product> getAllProducts() {
        if (productRepo.findAll().size() > 0) {
            return productRepo.findAll();
        } else {
            return new ArrayList<Product>();
        }
    }

    // Save Product
    public Product save(Product product) {
        return productRepo.save(product);
    }

    // Get Product By Id
    public Product getProduct(int id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            return product;
        } else {
            return null;
        }
    }

    // Delete Product
    public void delete(int id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isPresent()) {
            productRepo.delete(optionalProduct.get());
        }
    }

    // Edit Product
    public Product editProduct(Product product) {
        Optional<Product> optionalProduct = productRepo.findById(product.getId());
        if (optionalProduct.isPresent()) {
            Product temp = optionalProduct.get();
            temp.setId(product.getId());
            temp.setName(product.getName());
            temp.setDescription(product.getDescription());
            temp.setSize(product.getSize());
            temp.setColor(product.getColor());
            temp.setMaterial(product.getMaterial());
            temp.setImages(product.getImages());
            temp.setOriginalPrice(product.getOriginalPrice());
            temp.setDiscountPrice(product.getDiscountPrice());
            temp = productRepo.save(product);
            return temp;
        } else {
            product = productRepo.save(product);
            return product;
        }
    }
}
