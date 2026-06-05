package com.hosys.backend.controller;

import com.hosys.backend.entity.MenuCategory;
import com.hosys.backend.service.MenuCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class MenuCategoryController {

    private final MenuCategoryService menuCategoryService;

    @GetMapping
    public List<MenuCategory> getAllCategories() {
        return menuCategoryService.getAllCategories();
    }

    @PostMapping
    public MenuCategory createCategory(@RequestBody MenuCategory category) {
        return menuCategoryService.saveCategory(category);
    }
}