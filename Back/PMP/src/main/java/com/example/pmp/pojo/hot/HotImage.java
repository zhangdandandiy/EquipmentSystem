package com.example.pmp.pojo.hot;

/**
 * @author Dandan
 * @date 2024/1/29 13:36
 **/
public class HotImage extends Object {

    private Long id;

    /**
     * 专案
     */
    private String Product;

    /**
     * 线体类型
     */
    private String LineType;

    /**
     * 图片资源
     */
    private String ImageURL;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setProduct(String Product) {
        this.Product = Product;
    }

    public String getProduct() {
        return Product;
    }

    public void setLineType(String LineType) {
        this.LineType = LineType;
    }

    public String getLineType() {
        return LineType;
    }

    public void setImageURL(String ImageURL) {
        this.ImageURL = ImageURL;
    }

    public String getImageURL() {
        return ImageURL;
    }

}
