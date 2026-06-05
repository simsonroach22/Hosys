package com.hosys.backend.service;

import com.hosys.backend.entity.MenuCategory;
import com.hosys.backend.repository.MenuCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuCategoryService {

    private final MenuCategoryRepository menuCategoryRepository;

    public List<MenuCategory> getAllCategories() {
        return menuCategoryRepository.findAll();
    }

    public MenuCategory saveCategory(MenuCategory category) {
        return menuCategoryRepository.save(category);
    }
}