package hanteo.test.project.board.entity;

import java.util.HashSet;

/**
 * Category를 트리형태로 리플레잉 할수있도록 함
 */
public class Category {
    private final Long id;
    private final String name;
    private final String boardName;
    private final Long parentId;
    private final Boolean isLeafNode;
    private final HashSet<Long> childIds = new HashSet<>();

    public Category(Long id, String name, String boardName, Long parentId, Boolean isLeafNode) {
        this.id = id;
        this.name = name;
        this.boardName = boardName;
        this.parentId = parentId;
        this.isLeafNode = isLeafNode;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBoardName() {
        return boardName;
    }

    public Long getParentId() {
        return parentId;
    }

    public Boolean getLeafNode() {
        return isLeafNode;
    }

    public HashSet<Long> getChildIds() {
        return childIds;
    }

}