package com.daily.menu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.daily.menu.api.ProductApi;
import com.daily.menu.entity.Product;
import com.daily.menu.repository.ProductRepository;
import com.daily.menu.service.ProductService;

@RestController
public class ProductController {
	
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired 
    private ProductService productService;

    @RequestMapping(value = "/product", method =  RequestMethod.POST)
    public ProductApi Post(@Valid @RequestBody ProductApi api) {
        return productService.save(api);
    }
    
    @ResponseBody
    @RequestMapping(value = "/product/{id}", method =  RequestMethod.PUT)
    public Product Put(@Valid @RequestBody Product product, @PathVariable("id") String id)
    {
        return productRepository.save(product);
    }    
    
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public List<Product> Get() {
        return productRepository.findAll();
    }



//    @RequestMapping(value = "/pessoa/{id}", method =  RequestMethod.PUT)
//    public ResponseEntity<Pessoa> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Pessoa newPessoa)
//    {
//        Optional<Pessoa> oldPessoa = _pessoaRepository.findById(id);
//        if(oldPessoa.isPresent()){
//            Pessoa pessoa = oldPessoa.get();
//            pessoa.setNome(newPessoa.getNome());
//            _pessoaRepository.save(pessoa);
//            return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
//        }
//        else
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
//    {
//        Optional<Pessoa> pessoa = _pessoaRepository.findById(id);
//        if(pessoa.isPresent()){
//            _pessoaRepository.delete(pessoa.get());
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        else
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
}
