package com.skillForgeAcademy.models.category.infrastructure.config;


import com.skillForgeAcademy.models.category.domain.ports.input.CategoryServicePort;
import com.skillForgeAcademy.models.category.domain.ports.output.CategoryPersistencePort;
import com.skillForgeAcademy.models.category.domain.service.CategoryServiceImpl;
import com.skillForgeAcademy.models.category.infrastructure.PostgresAdapter.adapter.CategoryPostgresAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfig {
    @Bean
    public CategoryPersistencePort categoryPersistence(){
        return new CategoryPostgresAdapter();
    }

    @Bean
    public CategoryServicePort categoryService(){
        return new CategoryServiceImpl(categoryPersistence());
    }


}
