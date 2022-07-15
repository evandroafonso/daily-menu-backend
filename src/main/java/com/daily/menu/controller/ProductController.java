package com.daily.menu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daily.menu.domain.model.Product;
import com.daily.menu.repository.ProductRepository;

@RestController
public class ProductController {
	
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public List<Product> Get() {
        return productRepository.findAll();
    }

    @RequestMapping(value = "/product", method =  RequestMethod.POST)
    public Product Post(@Valid @RequestBody Product product)
    {
        return productRepository.save(product);
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
