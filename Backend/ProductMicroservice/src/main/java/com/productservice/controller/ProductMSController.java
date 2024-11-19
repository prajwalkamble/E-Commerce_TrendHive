package com.productservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.productservice.dto.ProductRequest;
import com.productservice.dto.ProductVO;
import com.productservice.exception.ProductExceptionCustom;
import com.productservice.service.ProductServiceInterface;

@RestController
@RequestMapping("/api/v1/products")
@Validated
public class ProductMSController {
	
	@Autowired
	private ProductServiceInterface productService;
	
	private static final Logger Log = LoggerFactory.getLogger(ProductMSController.class);
	
	// Fetch all products
	@GetMapping
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<List<ProductVO>> getAllProducts() {
		List<ProductVO> products = null;

    try {
        Log.info("Inside ProductController and calling the getAllProducts method...");
        products = productService.findAll();

        if (products == null || products.isEmpty()) {
            Log.warn("No products found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }

        return new ResponseEntity<>(products, HttpStatus.OK); // 200 OK

    } catch (DataAccessException dae) {
        // Handling database-related exceptions
        Log.error("Database error while fetching products", dae);
        return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE); // 503 Service Unavailable

    } catch (IllegalStateException ise) {
        // Handling application-specific exceptions
        Log.error("Illegal state encountered while fetching products", ise);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 400 Bad Request

    } catch (Exception e) {
        // Catch-all for unexpected exceptions
        Log.error("Unexpected error occurred while fetching products", e);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500 Internal Server Error
    }
	}
	
	// Fetch product by ID
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<ProductVO> getProductbyId(@PathVariable("id") Long productId) {
		try {
      Log.info("Fetching product with ID: {}", productId);

      ProductVO product = productService.findById(productId);
      if (product == null) {
          Log.warn("No product found with ID: {}", productId);
          return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
      }

      return new ResponseEntity<>(product, HttpStatus.OK); // 200 OK

	  } catch (IllegalArgumentException iae) {
	      Log.error("Invalid product ID provided: {}", productId, iae);
	      return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 400 Bad Request
	
	  } catch (Exception e) {
	      Log.error("Unexpected error occurred while fetching product by ID: {}", productId, e);
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500 Internal Server Error
	  }
	}
	
	// Fetch product by Name
	@GetMapping("/name/{name}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<ProductVO> getProductByName(@PathVariable("name") String productName) {
		try {
      Log.info("Fetching product with name: {}", productName);

      ProductVO product = productService.findByName(productName);
      if (product == null) {
          Log.warn("No product found with name: {}", productName);
          return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
      }

      return new ResponseEntity<>(product, HttpStatus.OK); // 200 OK

	  } catch (IllegalArgumentException iae) {
	      Log.error("Invalid product name provided: {}", productName, iae);
	      return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 400 Bad Request
	
	  } catch (Exception e) {
	      Log.error("Unexpected error occurred while fetching product by name: {}", productName, e);
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500 Internal Server Error
	  }
	}
	
	// Save or create a new product
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<ProductVO> saveProduct(@RequestBody ProductRequest productRequest) {
		try {
      Log.info("Saving a new product: {}", productRequest.getProductName());
      
      ProductVO savedProduct = productService.save(productRequest);
      
      return new ResponseEntity<>(savedProduct, HttpStatus.CREATED); // 201 Created
	  } catch (DataIntegrityViolationException dive) {
	      Log.error("Data integrity violation while saving product: {}", productRequest.getProductName(), dive);
	  
	      return new ResponseEntity<>(HttpStatus.CONFLICT); // 409 Conflict
	  } catch (IllegalArgumentException iae) {
	      Log.error("Invalid input data for product: {}", productRequest.getProductName(), iae);
	      
	      return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 400 Bad Request
	  } catch (Exception e) {
	      Log.error("Unexpected error occurred while saving product: {}", productRequest.getProductName(), e);
	      
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500 Internal Server Error
	  }
	}
	
	// Update a product
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<ProductVO> updateProduct(@PathVariable("id") Long productId, @RequestBody ProductRequest productRequest) {
		try {
      Log.info("Updating product with ID: {}", productId);
      
      ProductVO updatedProduct = productService.update(productId, productRequest);
      
      return new ResponseEntity<>(updatedProduct, HttpStatus.OK); // 200 OK
	  } catch (IllegalArgumentException iae) {
	      Log.error("Invalid input data for updating product with ID: {}", productId, iae);
	      return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 400 Bad Request
	  } catch (Exception e) {
	      Log.error("Unexpected error occurred while updating product with ID: {}", productId, e);
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500 Internal Server Error
	  }
	}
	
	// Delete product by ID
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId) {
		try {
      Log.info("Deleting product with ID: {}", productId);
      productService.delete(productId);
      return new ResponseEntity<>("Product deleted successfully with ID: " + productId, HttpStatus.OK); // 200 OK

	  } catch (ProductExceptionCustom pnfe) {
	      Log.error("Product not found with ID: {}", productId, pnfe);
	      return new ResponseEntity<>("No product found with ID: " + productId, HttpStatus.NOT_FOUND); // 404 Not Found
	
	  } catch (Exception e) {
	      Log.error("Unexpected error occurred while deleting product by ID: {}", productId, e);
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500 Internal Server Error
	  }
	}
	
	// Delete product by Name
	@DeleteMapping("/name/{name}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteProductByName(@PathVariable("name") String productName) {
		try {
      Log.info("Deleting product with name: {}", productName);

      productService.deleteProductByName(productName);
      return new ResponseEntity<>("Product deleted successfully with name: " + productName, HttpStatus.OK); // 200 OK

	  } catch (ProductExceptionCustom pnfe) {
	      Log.error("Product not found with name: {}", productName, pnfe);
	      return new ResponseEntity<>("No product found with name: " + productName, HttpStatus.NOT_FOUND); // 404 Not Found
	
	  } catch (Exception e) {
	      Log.error("Unexpected error occurred while deleting product by name: {}", productName, e);
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500 Internal Server Error
	  }
	}
}
