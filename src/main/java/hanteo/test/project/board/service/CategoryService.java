package hanteo.test.project.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import hanteo.test.project.board.controller.response.CategoryJson;
import hanteo.test.project.board.entity.Category;

@Service
public class CategoryService {

    //ID 저장 Map
    private final Map<Long, Category> categoryIdMap = new ConcurrentHashMap<>();
    //이름별 저장 Map
    private final Map<String, Map<Long, Category>> categoryNameMap = new ConcurrentHashMap<>();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final Long NO_PARENT_ID = null;

    public void addCategory(Category category) {
        categoryIdMap.put(category.getId(), category);
        addCategoryToNameMap(category);
        updateParentCategory(category);
    }

    private void addCategoryToNameMap(Category category) {
        String name = category.getName();
        Long id = category.getId();
        if (categoryNameMap.containsKey(name)) {
            categoryNameMap.get(name).put(id, category);
        } else {
            Map<Long, Category> categoryMap = new ConcurrentHashMap<>();
            categoryMap.put(id, category);
            categoryNameMap.put(name, categoryMap);
        }
    }

    private void updateParentCategory(Category category) {
        Long parentId = category.getParentId();
        if (parentId != NO_PARENT_ID) {
            Category parentCategory = categoryIdMap.get(parentId);
            parentCategory.getChildIds().add(category.getId());
        }
    }

    public String findById(Long id) {
        if (categoryIdMap.get(id) == null) {
            throw new IllegalArgumentException("해당 키가 존재하지 않습니다. : %d".formatted(id));
        }
        Category category = categoryIdMap.get(id);

        return gson.toJson(convertToCategoryJson(category));
    }

    /**
     * 재귀를 통해서 Category를 객체 그래프로 탐색 할 수 있는 CategoryJson객체로 변환
     * @param category
     * @return
     */
    private CategoryJson convertToCategoryJson(Category category) {
        if (category == null) {
            return null;
        }
        CategoryJson categoryJson = new CategoryJson(category);
        for (Long childId : category.getChildIds()) {
            Category child = categoryIdMap.get(childId);
            CategoryJson childJson = convertToCategoryJson(child);
            categoryJson.getChildCategory().add(childJson);
        }
        return categoryJson;
    }

    public String findByName(String name) {
        if (categoryNameMap.get(name) == null) {
            throw new IllegalArgumentException(String.format("해당 키가 존재하지 않습니다. : %s",name));
        }
        Map<Long, Category> longCategoryHashMap = categoryNameMap.get(name);
        List<CategoryJson> result = new ArrayList<>();
        for (Long id : longCategoryHashMap.keySet()) {
            Category category = longCategoryHashMap.get(id);
            result.add(convertToCategoryJson(category));
        }
        return gson.toJson(result);
    }

}
