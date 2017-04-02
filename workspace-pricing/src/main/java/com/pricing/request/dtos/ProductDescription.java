
package com.pricing.request.dtos;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "bullet_description",
    "general_description"
})
public class ProductDescription {

    @JsonProperty("title")
    private String title;
    @JsonProperty("bullet_description")
    private List<String> bulletDescription = null;
    @JsonProperty("general_description")
    private String generalDescription;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("bullet_description")
    public List<String> getBulletDescription() {
        return bulletDescription;
    }

    @JsonProperty("bullet_description")
    public void setBulletDescription(List<String> bulletDescription) {
        this.bulletDescription = bulletDescription;
    }

    @JsonProperty("general_description")
    public String getGeneralDescription() {
        return generalDescription;
    }

    @JsonProperty("general_description")
    public void setGeneralDescription(String generalDescription) {
        this.generalDescription = generalDescription;
    }

}
