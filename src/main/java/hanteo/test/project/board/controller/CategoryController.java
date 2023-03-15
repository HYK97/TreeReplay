package hanteo.test.project.board.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import hanteo.test.project.board.service.CategoryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("find-id/{id}")
    public String findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @GetMapping("find-name/{name}")
    public String findByName(@PathVariable String name) {
        return categoryService.findByName(name);
    }

}
