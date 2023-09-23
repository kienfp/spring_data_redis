package com.example.Controller;

import com.example.Entity.SanPham;
import com.example.Reposistory.SanPhamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@org.springframework.stereotype.Controller
//@ResponseBody
public class Controller {
    @Autowired
    private SanPhamRepo sanPhamRepo;

    @PostMapping("add")
    public String save(@ModelAttribute("sp") SanPham sanPham) {
        sanPhamRepo.save(sanPham);
        return "redirect:/hienthi";
    }

    @GetMapping("/detail/{id}")
    private String detail(Model model,@PathVariable("id") int id) {
        SanPham sanPham = this.sanPhamRepo.findProductById(id);
        model.addAttribute("sp",sanPham);
        return "detail";
    }

    @GetMapping("hienthi")
    public String getAllProducts(Model model) {
        model.addAttribute("sp",new SanPham());
        model.addAttribute("list",this.sanPhamRepo.findAll());
        this.sanPhamRepo.findAll().forEach(x-> System.out.println(x.toString()));
        return "index";
    }
    @GetMapping("getall")
    @ResponseBody
    public List<SanPham> getAllProducts() {
        return sanPhamRepo.findAll();
    }
    @GetMapping("find/{id}")
    public SanPham findProduct(@PathVariable int id) {
        return sanPhamRepo.findProductById(id);
    }
    @GetMapping("/delete/{id}")
    @CacheEvict(key = "#id",value = "SanPham")
    public String remove(@PathVariable int id)   {
        sanPhamRepo.deleteProduct(id);
        return "redirect:/hienthi";
    }
}
