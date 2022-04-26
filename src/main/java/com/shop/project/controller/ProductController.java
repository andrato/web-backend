package com.shop.project.controller;

import com.shop.project.domain.Animal;
import com.shop.project.domain.Category;
import com.shop.project.domain.Product;
import com.shop.project.service.AnimalService;
import com.shop.project.service.CategoryService;
import com.shop.project.service.ImageService;
import com.shop.project.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/products")
public class ProductController
{
    @Autowired
    ProductService productService;

    @Autowired
    ImageService imageService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    AnimalService animalService;

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping
    public ModelAndView productsList()
    {
        ModelAndView modelAndView = new ModelAndView("10_products");
        List<Product> products = productService.findAll();
        List<Animal> animals = animalService.findAll();
        modelAndView.addObject("products",products);
        modelAndView.addObject("animals",animals);
        return modelAndView;
    }

    @GetMapping("/info/{id}")
    public String showById(@PathVariable String id, Model model)
    {
        model.addAttribute("product",
                productService.findById(Long.valueOf(id)));
        List<Animal> animals = animalService.findAll();
        model.addAttribute("animals",animals);
        return "11_productInfo";
    }

    @RequestMapping("/delete/{id}")
    public String deleteProductById(@PathVariable String id)
    {
        productService.deleteById(Long.valueOf(id));
        return "redirect:/products";
    }

    @RequestMapping("/new")
    public String addProduct(Model model)
    {
        List<Category> categoriesAll = categoryService.findAll();
        List<Animal> animalsAll = animalService.findAll();

        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoriesAll);
        model.addAttribute("animals", animalsAll);
        return "12_productForm";
    }

    @PostMapping()
    public String saveOrUpdate(@ModelAttribute Product product,
                               BindingResult bindingResult,
                               @RequestParam("imagefile") MultipartFile file)
    {
        if (bindingResult.hasErrors())
        {
            return "12_productform";
        }

        Product savedProduct = productService.save(product);
        imageService.saveImageFile(Long.valueOf(savedProduct.getId()), file);
        return "redirect:/products" ;
    }


    @GetMapping("/update/{id}")
    public String editProduct(@PathVariable String id, Model model)
    {
        Product product = productService.findById(Long.valueOf(id));
        List<Animal> animals = animalService.findAll();
        List<Category> categories = categoryService.findAll();

        model.addAttribute("animals",animals);
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);

        return "12_productForm";
    }

    @GetMapping("/animals/{id}")
    public ModelAndView showProductsByAnimal(@PathVariable String id)
    {
        ModelAndView modelAndView = new ModelAndView("10_products");
        List<Product> products = productService.findByAnimalId(Long.valueOf(id));

        List<Animal> animals = animalService.findAll();
        modelAndView.addObject("products",products);
        modelAndView.addObject("animals",animals);
        return modelAndView;
    }
}
