package hanteo.test.project.common;

import org.springframework.stereotype.Service;

import hanteo.test.project.board.entity.Category;
import hanteo.test.project.board.service.CategoryService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostDataGenerator {
    private final CategoryService categoryService;

    @PostConstruct
    public void initialize() {
        categoryService.addCategory(new Category(1L, "남자", null, null, false));
        categoryService.addCategory(new Category(2L, "엑소", null, 1L, false));
        categoryService.addCategory(new Category(3L, "공지사항", "1", 2L, true));
        categoryService.addCategory(new Category(4L, "첸", "2", 2L, true));
        categoryService.addCategory(new Category(5L, "백현", "3", 2L, true));
        categoryService.addCategory(new Category(6L, "시우민", "4", 2L, true));
        categoryService.addCategory(new Category(7L, "방탄소년단", null, 1L, false));
        categoryService.addCategory(new Category(8L, "공지사항", "5", 7L, true));
        categoryService.addCategory(new Category(9L, "익명게시판", "6", 7L, true));
        categoryService.addCategory(new Category(10L, "뷔", "7", 7L, true));
        categoryService.addCategory(new Category(11L, "여자", null, null, false));
        categoryService.addCategory(new Category(12L, "블랙핑크", null, 11L, false));
        categoryService.addCategory(new Category(13L, "공지사항", "8", 12L, true));
        categoryService.addCategory(new Category(14L, "익명게시판", "6", 12L, true));
        categoryService.addCategory(new Category(15L, "로제", "9", 12L, true));
    }
}
