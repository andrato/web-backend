package com.shop.project.service;

import com.shop.project.domain.Product;
import com.shop.project.domain.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService
{
    ProductService productService;

    @Autowired
    public ImageServiceImpl(ProductService productService)
    {

        this.productService = productService;
    }

    @Override
//    @Transactio
    public void saveImageFile(Long productId, MultipartFile file)
    {
        try
        {
            Product product = productService.findById(productId);

            Byte[] byteObjects = new Byte[file.getBytes().length];
            int i = 0;
            for (byte b : file.getBytes())
            {
                byteObjects[i++] = b;
            }

            ProductInfo productInfo = product.getProductInfo();
            if (productInfo == null)
            {
                productInfo = new ProductInfo();
            }

            productInfo.setImage(byteObjects);
            product.setProductInfo(productInfo);
            productInfo.setProduct(product);
            productService.save(product);
        }
        catch (IOException e)
        {
            // TBD
        }
    }
}
