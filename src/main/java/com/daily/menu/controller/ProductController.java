package com.daily.menu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daily.menu.api.ProductApi;
import com.daily.menu.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ProductController {
	
    @Autowired 
    private ProductService productService;

    @ApiOperation(value = "Register a product")
    @ApiResponses(value = {
    	    @ApiResponse(code = 200, message = "Product registered successfully"),
    	    @ApiResponse(code = 403, message = "You don't have permission to access this resource."),
    	    @ApiResponse(code = 500, message = "An exception was thrown"),
    	})
    //TODO: PostMapping add
    //TODO: refactor with some like @RequestMapping("/api/product")
    @RequestMapping(value = "/product", method =  RequestMethod.POST) 
    public ProductApi Post(@Valid @RequestBody ProductApi api) {
        return productService.save(api);
    }
    
//    @ResponseBody
//    @RequestMapping(value = "/product/{id}", method =  RequestMethod.PUT)
//    public ProductApi Put(@Valid @RequestBody ProductApi api, @PathVariable("id") Long id){
//        return productService.save(api);
//    }    
    
    @ApiOperation(value = "Returns a list of products")
    @ApiResponses(value = {
    	    @ApiResponse(code = 200, message = "A product list was successfully returned"),
    	    @ApiResponse(code = 403, message = "You don't have permission to access this resource."),
    	    @ApiResponse(code = 500, message = "An exception was thrown"),
    	})
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public List<ProductApi> Get() {
        return productService.getAllProducts();
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
