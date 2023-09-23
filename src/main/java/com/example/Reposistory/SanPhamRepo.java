package com.example.Reposistory;

import com.example.Entity.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SanPhamRepo {

    private static final String HASH_KEY = "SanPham";

    @Autowired
    private RedisTemplate template;

    public SanPham save(SanPham sanPham){
        template.opsForHash().put(HASH_KEY,sanPham.getId(),sanPham);
        return sanPham;
    }

    public List<SanPham> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public SanPham findProductById(int id){
        return (SanPham) template.opsForHash().get(HASH_KEY,id);
    }


    public String deleteProduct(int id){
        System.out.println("deleted !!!!");
        template.opsForHash().delete(HASH_KEY,id);
        return "product removed !!";
    }

}
