package com.thread_count.app.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    final private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/products", method = { RequestMethod.GET, RequestMethod.POST } , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> products() throws IOException {
        ArrayList<byte[]> bytes = new ArrayList<>();
        BufferedInputStream inputStream = new BufferedInputStream(new URL("https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcS_ws5OkKddKr8cwVfMDMPX4_QaoHB1koVvrdpM3kyTyHglKZvo8MDpbJtoAtH3GopDjtJtOP1vqRI&usqp=CAc").openStream());
        byte pic[] = new byte[inputStream.available()];
//        bytes.add(pic);
//        bytes.add(pic);
//        bytes.add(pic);
//        bytes.add(pic);
//        bytes.add(pic);
        Product product = new Product();
        product.setName("Shoe");
        product.setDescription("Sport Shoe");
        product.setSize("Small");
        product.setMaterial("Leather");
        product.setImages(bytes);
        product.setColor("red");
        product.setOriginalPrice(new BigDecimal("100"));
        product.setDiscountPrice(new BigDecimal("100"));
        productService.save(product);
        productService.save(product);
        productService.save(product);
        productService.save(product);
        productService.save(product);
        productService.save(product);
        return productService.getAllProducts();
    }

    @RequestMapping( value = "/addProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Product> addProduct(@RequestBody Product product ) {
        productService.save(product);
        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }

    // Delete Product
    @RequestMapping( value = "/deleteProduct", method = { RequestMethod.POST, RequestMethod.GET })
    public void deleteProduct(@RequestParam int id){
        productService.delete(id);
    }

    // Get Product
    @RequestMapping( value = "/getProduct", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Product> getProduct(@RequestParam int id ) {
        Product product = productService.getProduct(id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    // Edit Product Info
    @RequestMapping( value = "/updateProductInfo", method = { RequestMethod.POST, RequestMethod.GET })
    public ResponseEntity<Product> editProductInfo( @RequestBody Product product ){
        productService.editProduct(product);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
}
