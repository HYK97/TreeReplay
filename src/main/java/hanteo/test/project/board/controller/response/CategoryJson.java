package hanteo.test.project.board.controller.response;

import java.util.ArrayList;
import java.util.List;

import hanteo.test.project.board.entity.Category;

public class CategoryJson {
    private final Long id;
    private final String name;
    private final String boardName;
    private final Long parentId;
    private final Boolean isLeafNode;
    private final List<CategoryJson> childCategory = new ArrayList<>();

    public CategoryJson(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.parentId = category.getParentId();
        this.isLeafNode = category.getLeafNode();
        this.boardName = category.getBoardName();
    }

    public List<CategoryJson> getChildCategory() {
        return childCategory;
    }
}
