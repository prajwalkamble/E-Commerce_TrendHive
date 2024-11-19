package com.productservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productservice.dto.ProductRequest;
import com.productservice.dto.ProductVO;
import com.productservice.entity.ProductEntity;
import com.productservice.exception.ProductExceptionCustom;
import com.productservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductServiceInterface {
	
	@Autowired
	ProductRepository productRepository;
	
	private static final Logger Log = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Override
	public List<ProductVO> findAll() {
		Log.info("Fetching all products");
		List<ProductEntity> products = productRepository.findAll();
		
		List<ProductVO> productVOS = products.parallelStream().map(product -> {
			ProductVO productVO = new ProductVO();
			productVO.setProductId(product.getProductId());
			productVO.setProductName(product.getProductName());
			productVO.setProductDescription(product.getProductDescription());
			productVO.setProductPrice(product.getProductPrice());
			productVO.setProductCategory(product.getProductCategory());
			productVO.setProductBrand(product.getProductBrand());
			productVO.setProductSKU(product.getProductSKU());
			productVO.setProductStatus(product.getProductStatus());
			productVO.setProductCreatedAt(product.getProductCreatedAt());
			productVO.setProductUpdatedAt(product.getProductUpdatedAt());
			
			return productVO;
		}).collect(Collectors.toList());
		
		return productVOS;
	}

	@Override
	public ProductVO findById(Long productId) throws ProductExceptionCustom {
		Optional<ProductEntity> product = productRepository.findById(productId);
		
		if(!product.isPresent()) {
			Log.info("Product with ID " + productId + " not found.");
			throw new ProductExceptionCustom("Product with ID " + productId + " not found.");
		} else {
			ProductVO productVO = new ProductVO();
			productVO.setProductId(product.get().getProductId());
			productVO.setProductName(product.get().getProductName());
			productVO.setProductDescription(product.get().getProductDescription());
			productVO.setProductPrice(product.get().getProductPrice());
			productVO.setProductCategory(product.get().getProductCategory());
			productVO.setProductBrand(product.get().getProductBrand());
			productVO.setProductSKU(product.get().getProductSKU());
			productVO.setProductStatus(product.get().getProductStatus());
			productVO.setProductCreatedAt(product.get().getProductCreatedAt());
			productVO.setProductUpdatedAt(product.get().getProductUpdatedAt());
			
			return productVO;
		}
	}

	@SuppressWarnings("unused")
	@Override
	public ProductVO save(ProductRequest productRequest) throws ProductExceptionCustom {
		Log.info("Saving/Updating product with name: {}", productRequest.getProductName());
		
		if(productRequest == null) {
			throw new ProductExceptionCustom("Product request cannot be null");
		}
		
		 ProductEntity productEntity = new ProductEntity();
     
		 if(productRequest.getProductId() > 0) {
			 productEntity.setProductId(productRequest.getProductId());
		 }
		 productEntity.setProductName(productRequest.getProductName());
		 productEntity.setProductDescription(productRequest.getProductDescription());
		 productEntity.setProductPrice(productRequest.getProductPrice());
		 productEntity.setProductCategory(productRequest.getProductCategory());
		 productEntity.setProductBrand(productRequest.getProductBrand());
		 productEntity.setProductSKU(productRequest.getProductSKU());
		 productEntity.setProductStatus(productRequest.getProductStatus());
		 productEntity.setProductCreatedAt(productRequest.getProductCreatedAt());
		 productEntity.setProductUpdatedAt(productRequest.getProductUpdatedAt());
		 
		 ProductEntity productResponse = productRepository.save(productEntity);
		 
		 ProductVO productVO = null;
		 
		 if(productResponse != null) {
			 productVO = new ProductVO();
			 productVO.setProductId(productEntity.getProductId());
			 productVO.setProductName(productEntity.getProductName());
			 productVO.setProductDescription(productEntity.getProductDescription());
			 productVO.setProductPrice(productEntity.getProductPrice());
			 productVO.setProductCategory(productEntity.getProductCategory());
			 productVO.setProductBrand(productEntity.getProductBrand());
			 productVO.setProductSKU(productEntity.getProductSKU());
			 productVO.setProductStatus(productEntity.getProductStatus());
			 productVO.setProductCreatedAt(productEntity.getProductCreatedAt());
			 productVO.setProductUpdatedAt(productEntity.getProductUpdatedAt());
		 }
		
		return productVO;
	}

	@Override
	public String delete(Long productId) throws ProductExceptionCustom {
		Log.info("Input to ProductServiceImpl.delete, id: {}", productId);
		
		if(productId < 0) {
			throw new ProductExceptionCustom("Invalid Product ID");
		}
		
		try {
			productRepository.deleteById(productId);
		} catch(Exception e) {
			Log.info("Exception while deleting product", e);
			throw new ProductExceptionCustom("Exception while deleting product");
		}
		return "Product has been deleted successfully";
	}

	@Override
	public ProductVO findByName(String productName) throws ProductExceptionCustom {
		ProductEntity product = productRepository.findByName(productName);
		
		if(product == null) {
			Log.info("Product with name {}, does not exists.", productName);
			throw new ProductExceptionCustom("Product with name " + productName + " does not exists.");			
		}
		
		return convertToProductVO(product);
	}

	@Override
	public ProductVO findProductByName(String productName) throws ProductExceptionCustom {
		ProductEntity product = productRepository.findByName(productName);
		
		if(product == null) {
			Log.info("Product with name {}, does not exists.", productName);
			throw new ProductExceptionCustom("Product with name " + productName + " does not exists.");			
		}
		
		return convertToProductVO(product);
	}

	@Override
	public void deleteProductByName(String productName) throws ProductExceptionCustom {
		ProductEntity product = productRepository.findProductByNameCustom(productName);
		
		if(product == null) {
			Log.info("Product with name {} does not exists.", productName);
			throw new ProductExceptionCustom("Product with name " + productName + " does not exists.");
		}
		
		productRepository.delete(product);
		Log.info("Product with name {} deleted successfully", productName);
	}

	@Override
	public ProductVO update(Long productId, ProductRequest productRequest) throws ProductExceptionCustom {
		// Log the update attempt
    Log.info("Updating product with ID: {}", productId);

    // Validate that the product exists
    Optional<ProductEntity> existingProductOpt = productRepository.findById(productId);
    if (existingProductOpt.isEmpty()) {
        Log.error("Product with ID: {} not found for update", productId);
        throw new ProductExceptionCustom("Product with ID " + productId + " not found.");
    }

    // Fetch existing product entity
    ProductEntity existingProduct = existingProductOpt.get();

    // Update fields only if the new values are provided (non-null)
    if (productRequest.getProductName() != null) {
        existingProduct.setProductName(productRequest.getProductName());
    }
    if (productRequest.getProductDescription() != null) {
        existingProduct.setProductDescription(productRequest.getProductDescription());
    }
    if (productRequest.getProductPrice() != null) {
        existingProduct.setProductPrice(productRequest.getProductPrice());
    }
    if (productRequest.getProductCategory() != null) {
        existingProduct.setProductCategory(productRequest.getProductCategory());
    }
    if (productRequest.getProductBrand() != null) {
        existingProduct.setProductBrand(productRequest.getProductBrand());
    }
    if (productRequest.getProductSKU() != null) {
        existingProduct.setProductSKU(productRequest.getProductSKU());
    }
    if (productRequest.getProductStatus() != null) {
        existingProduct.setProductStatus(productRequest.getProductStatus());
    }

    // Update timestamp
    existingProduct.setProductUpdatedAt(new java.util.Date());

    // Save the updated entity to the database
    ProductEntity updatedProduct = productRepository.save(existingProduct);

    // Convert updated entity to VO
    ProductVO updatedProductVO = convertToProductVO(updatedProduct);

    // Log success
    Log.info("Product with ID: {} updated successfully", productId);

    return updatedProductVO;
	}
	
	//Helper method to convert ProductEntity to ProductVO
	private ProductVO convertToProductVO(ProductEntity productEntity) {
		ProductVO productVO = new ProductVO();
		productVO.setProductId(productEntity.getProductId());
		productVO.setProductName(productEntity.getProductName());
		productVO.setProductDescription(productEntity.getProductDescription());
		productVO.setProductPrice(productEntity.getProductPrice());
		productVO.setProductCategory(productEntity.getProductCategory());
		productVO.setProductBrand(productEntity.getProductBrand());
		productVO.setProductSKU(productEntity.getProductSKU());
		productVO.setProductStatus(productEntity.getProductStatus());
		productVO.setProductCreatedAt(productEntity.getProductCreatedAt());
		productVO.setProductUpdatedAt(productEntity.getProductUpdatedAt());
		
		return productVO;
	}

}
