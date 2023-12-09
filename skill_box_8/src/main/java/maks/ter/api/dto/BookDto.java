package maks.ter.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;

@JsonSerialize
public class BookDto {

    @JsonSerialize
    Long id;

    @JsonSerialize
    String title;

    @JsonSerialize
    BigDecimal price;

    @JsonSerialize
    BigDecimal oldPrice;

    @JsonSerialize
    String fioAuthor;

    public BookDto(Long id, String title, BigDecimal price, BigDecimal oldPrice, String fioAuthor) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.oldPrice = oldPrice;
        this.fioAuthor = fioAuthor;
    }
}
