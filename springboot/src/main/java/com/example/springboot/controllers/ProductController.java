package com.example.springboot.controllers;

import com.example.springboot.dtos.ProductRecordDTO;
import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepository;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/products")
    //@Valid serve para fazer as validações que eu pedi (NotBlank e NotNull) entrem em vigor no "ProductRecordDTO"
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid  ProductRecordDTO productRecordDTO){
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDTO,productModel); // O primeiro parametro é o que vai ser convertido e o segundo parametro é o tipo que vai ser convertido
        //Neste caso o "productRecordDTO" vai ser convertido em "productModel"
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts(){

        List<ProductModel> productLis = productRepository.findAll();

        if(!productLis.isEmpty())
        {
            for (ProductModel product : productLis)
            {
                UUID id = product.getIdProduct();
                product.add(linkTo(methodOn(ProductController.class).getOneProduct(id)).withSelfRel());
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(productLis);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id")UUID id){

        Optional<ProductModel> product0 = productRepository.findById(id);

        if(product0.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");

        product0.get().add(linkTo(methodOn(ProductController.class).getAllProducts()).withRel("Product List"));

        return ResponseEntity.status(HttpStatus.OK).body(product0.get());
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id")UUID id,
                                                @RequestBody @Valid ProductRecordDTO productRecordDTO){

        Optional<ProductModel> product0 = productRepository.findById(id);

        if(product0.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");

        var productModel =product0.get();
        BeanUtils.copyProperties(productRecordDTO,productModel);

        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id")UUID id){

        Optional<ProductModel> product0 = productRepository.findById(id);

        if(product0.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");

     productRepository.delete(product0.get());

      return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfuly");
    }

}
