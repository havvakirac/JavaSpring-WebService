package com.krc.webservice.demo.controller;

import com.krc.webservice.demo.entity.Product;
import com.krc.webservice.demo.repository.ProductRepository;
import com.krc.webservice.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public String Info(){
        return "The application is up!";
    }

    @GetMapping("/{id}")
    public Product detailProduct(@PathVariable(value = "id") int id){

        Product product= productRepository.findAll().stream().filter(x->x.getId()==id).findFirst().get();

        return product;
    }

    //Get productList by CategoryId
    @GetMapping("/getbycategory")
    public List<Product> getByCategoryId(int id){
        List<Product> productList=productRepository.findAll().stream().filter(x->x.getCategoryId()==id).collect(Collectors.toList());

        return productList;
    }

    @RequestMapping(value = "/createproduct",method = RequestMethod.POST)
    public String createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @RequestMapping(value = "/productlist",method = RequestMethod.GET)
    public List<Product> getProductList(){
        return productService.readProducts();
    }

    @RequestMapping(value = "/updateproduct",method = RequestMethod.PUT)
    public String updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }


    @RequestMapping(value = "/deleteproduct",method = RequestMethod.DELETE)
    public String deleteProduct(@RequestBody Product product){
        return productService.deleteProduct(product);
    }

}
