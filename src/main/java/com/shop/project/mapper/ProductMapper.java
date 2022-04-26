package com.shop.project.mapper;

import com.shop.project.domain.Product;
import com.shop.project.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper extends EntityMapper<ProductDto, Product>{

}
