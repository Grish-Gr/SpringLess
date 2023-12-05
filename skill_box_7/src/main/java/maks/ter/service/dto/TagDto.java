package maks.ter.service.dto;

public class TagDto {

    public String name;
    public String slug;
    public Long countBook;

    public TagDto(String name, String slug, Long countBook) {
        this.name = name;
        this.slug = slug;
        this.countBook = countBook;
    }

    public String tagSize() {
        if (countBook < 10) {
            return "Tag_sm";
        } else if (countBook < 30) {
            return "Tag_md";
        } else {
            return "Tag_xl";
        }
    }
}
