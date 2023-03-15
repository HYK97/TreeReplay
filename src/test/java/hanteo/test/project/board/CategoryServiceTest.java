package hanteo.test.project.board;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hanteo.test.project.board.entity.Category;
import hanteo.test.project.board.service.CategoryService;

public class CategoryServiceTest {

    private CategoryService categoryService;

    @BeforeEach
    public void setUp() {
        categoryService = new CategoryService();
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
        categoryService.addCategory(new Category(16L, "제니", "10", 12L, true));
        categoryService.addCategory(new Category(17L, "리사", "11", 12L, true));
    }

    @Test
    public void testFindById() {
        // Given
        Long id = 1L;
        String expected = "{\n"
            + "  \"id\": 1,\n"
            + "  \"name\": \"남자\",\n"
            + "  \"isLeafNode\": false,\n"
            + "  \"childCategory\": [\n"
            + "    {\n"
            + "      \"id\": 2,\n"
            + "      \"name\": \"엑소\",\n"
            + "      \"parentId\": 1,\n"
            + "      \"isLeafNode\": false,\n"
            + "      \"childCategory\": [\n"
            + "        {\n"
            + "          \"id\": 3,\n"
            + "          \"name\": \"공지사항\",\n"
            + "          \"boardName\": \"1\",\n"
            + "          \"parentId\": 2,\n"
            + "          \"isLeafNode\": true,\n"
            + "          \"childCategory\": []\n"
            + "        },\n"
            + "        {\n"
            + "          \"id\": 4,\n"
            + "          \"name\": \"첸\",\n"
            + "          \"boardName\": \"2\",\n"
            + "          \"parentId\": 2,\n"
            + "          \"isLeafNode\": true,\n"
            + "          \"childCategory\": []\n"
            + "        },\n"
            + "        {\n"
            + "          \"id\": 5,\n"
            + "          \"name\": \"백현\",\n"
            + "          \"boardName\": \"3\",\n"
            + "          \"parentId\": 2,\n"
            + "          \"isLeafNode\": true,\n"
            + "          \"childCategory\": []\n"
            + "        },\n"
            + "        {\n"
            + "          \"id\": 6,\n"
            + "          \"name\": \"시우민\",\n"
            + "          \"boardName\": \"4\",\n"
            + "          \"parentId\": 2,\n"
            + "          \"isLeafNode\": true,\n"
            + "          \"childCategory\": []\n"
            + "        }\n"
            + "      ]\n"
            + "    },\n"
            + "    {\n"
            + "      \"id\": 7,\n"
            + "      \"name\": \"방탄소년단\",\n"
            + "      \"parentId\": 1,\n"
            + "      \"isLeafNode\": false,\n"
            + "      \"childCategory\": [\n"
            + "        {\n"
            + "          \"id\": 8,\n"
            + "          \"name\": \"공지사항\",\n"
            + "          \"boardName\": \"5\",\n"
            + "          \"parentId\": 7,\n"
            + "          \"isLeafNode\": true,\n"
            + "          \"childCategory\": []\n"
            + "        },\n"
            + "        {\n"
            + "          \"id\": 9,\n"
            + "          \"name\": \"익명게시판\",\n"
            + "          \"boardName\": \"6\",\n"
            + "          \"parentId\": 7,\n"
            + "          \"isLeafNode\": true,\n"
            + "          \"childCategory\": []\n"
            + "        },\n"
            + "        {\n"
            + "          \"id\": 10,\n"
            + "          \"name\": \"뷔\",\n"
            + "          \"boardName\": \"7\",\n"
            + "          \"parentId\": 7,\n"
            + "          \"isLeafNode\": true,\n"
            + "          \"childCategory\": []\n"
            + "        }\n"
            + "      ]\n"
            + "    }\n"
            + "  ]\n"
            + "}";
        // When
        String result = categoryService.findById(id);

        // Then
        assertThat(expected).isEqualTo(result);
    }

    @Test
    public void testFindByName() {
        // Given
        String searchName = "블랙핑크";
        String expected = "[\n"
            + "  {\n"
            + "    \"id\": 12,\n"
            + "    \"name\": \"블랙핑크\",\n"
            + "    \"parentId\": 11,\n"
            + "    \"isLeafNode\": false,\n"
            + "    \"childCategory\": [\n"
            + "      {\n"
            + "        \"id\": 16,\n"
            + "        \"name\": \"제니\",\n"
            + "        \"boardName\": \"10\",\n"
            + "        \"parentId\": 12,\n"
            + "        \"isLeafNode\": true,\n"
            + "        \"childCategory\": []\n"
            + "      },\n"
            + "      {\n"
            + "        \"id\": 17,\n"
            + "        \"name\": \"리사\",\n"
            + "        \"boardName\": \"11\",\n"
            + "        \"parentId\": 12,\n"
            + "        \"isLeafNode\": true,\n"
            + "        \"childCategory\": []\n"
            + "      },\n"
            + "      {\n"
            + "        \"id\": 13,\n"
            + "        \"name\": \"공지사항\",\n"
            + "        \"boardName\": \"8\",\n"
            + "        \"parentId\": 12,\n"
            + "        \"isLeafNode\": true,\n"
            + "        \"childCategory\": []\n"
            + "      },\n"
            + "      {\n"
            + "        \"id\": 14,\n"
            + "        \"name\": \"익명게시판\",\n"
            + "        \"boardName\": \"6\",\n"
            + "        \"parentId\": 12,\n"
            + "        \"isLeafNode\": true,\n"
            + "        \"childCategory\": []\n"
            + "      },\n"
            + "      {\n"
            + "        \"id\": 15,\n"
            + "        \"name\": \"로제\",\n"
            + "        \"boardName\": \"9\",\n"
            + "        \"parentId\": 12,\n"
            + "        \"isLeafNode\": true,\n"
            + "        \"childCategory\": []\n"
            + "      }\n"
            + "    ]\n"
            + "  }\n"
            + "]";
        // When
        String result = categoryService.findByName(searchName);

        // Then
        assertThat(expected).isEqualTo(result);
    }

}