package hanteo.test.project.board.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hanteo.test.project.board.service.CategoryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping(path = "find-id/{id}", produces = "application/json; charset=utf-8")
    public ResponseEntity<String> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body( categoryService.findById(id));
    }

    @GetMapping(path = "find-name/{name}", produces = "application/json; charset=utf-8")
    public String findByName(@PathVariable String name) {
        return categoryService.findByName(name);
    }

}
