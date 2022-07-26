package com.homework.homeworkSpring.Controller;

import com.homework.homeworkSpring.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@RestController
public class ProductController {
    private List<Product> productList;
    private Product product;

    public ProductController(Product product){
        this.product = product;
    }
    @Value("${product.second.name:null}")
    private String name;
    @Value("${product.second.price:0}")
    private double price;
    @Value("${product.second.id:0}")
    private long id;

    @PostConstruct
    public void init(){
        Product p = new Product(price,id,name);
        productList = new ArrayList<>();
        productList.add(p);
        productList.add(this.product);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<HttpStatus> addProduct(@RequestBody Product product){
        productList.add(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProductList(){
        return ResponseEntity.ok(productList);
    }

    @DeleteMapping("deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(name="id") Long id){
        Product p = productList.stream()
                .filter(product -> product.getId()==id)
                .findFirst().orElse(null);
        if(p == null){
            return new ResponseEntity<>("Id Yok"
                    ,HttpStatus.BAD_REQUEST);
        }
        productList.remove(p);
        //return ResponseEntity.ok("Aferin");
        return new ResponseEntity<>("Aferin",HttpStatus.CREATED);
    }

    @PutMapping("/updateProduct")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void updateProduct(@RequestBody Product uProduct){
        Product p = productList.stream()
                .filter(product -> product.getId()==uProduct.getId())
                .findFirst().get();
        p.setName(uProduct.getName());
        p.setPrice(uProduct.getPrice());
        //return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
