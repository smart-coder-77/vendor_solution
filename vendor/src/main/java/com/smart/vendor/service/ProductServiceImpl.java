package com.smart.vendor.service;

import com.smart.vendor.entity.Order;
import com.smart.vendor.entity.Product;
import com.smart.vendor.exception.ProductIdNotFoundException;
import com.smart.vendor.exception.ProductNotSavedException;
import com.smart.vendor.model.OrderDto;
import com.smart.vendor.model.ProductDto;
import com.smart.vendor.repository.ProductRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author Choudhury Subham on 21-06-2022
 */
@Service
public class ProductServiceImpl implements  ProductService{
    @Autowired
    private ProductRepo productRepo;

    @Override
    public String productSave(ProductDto productDto) {
        if (productDto.getProductName()!=null){
            Product product = new Product();
            product.setProductName(productDto.getProductName());
            product.setProductPrice(productDto.getProductPrice());
            productRepo.save(product);
            return "Product "+ productDto.getProductName()+"saved successfully";
        }else{
            throw  new ProductNotSavedException("Product "+ productDto.getProductName()+" Not Saved,Please enter a valid Product");
        }
    }

    @Override
    public ProductDto getProductById(Long id) {
        Product product= productRepo.findById(id).orElseThrow(
                ()->new ProductIdNotFoundException("Product "+ id +" NotFound Exception")
        );
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setProductName(product.getProductName());
        productDto.setProductPrice(product.getProductPrice());
        return productDto;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> product = productRepo.findAll();
        if (product.size()>0){
            return product;
        }else {
            throw new ProductIdNotFoundException("Product Not Found");
        }
    }

    @Override
    public String removeProduct(Long id) {
        ProductDto productDto= getProductById(id);
        productRepo.deleteById(productDto.getProductId());
        return "Product"+id+"Removed successfully";
    }

    @Override
    public String updateProduct(ProductDto product) {
        ProductDto productDto= getProductById(product.getProductId());
        productDto.setProductPrice(product.getProductPrice());
        productDto.setProductName(product.getProductName());
        ModelMapper modelMapper = new ModelMapper();
        Product product1 = modelMapper.map(productDto, Product.class);
        productRepo.save(product1);
        return "Product "+product.getProductName()+ " Updated successfully";
    }
}
