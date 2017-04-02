
package com.pricing.request.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "is_assortment",
    "is_kit_master"
})
public class BundleComponents {

    @JsonProperty("is_assortment")
    private Boolean isAssortment;
    @JsonProperty("is_kit_master")
    private Boolean isKitMaster;

    @JsonProperty("is_assortment")
    public Boolean getIsAssortment() {
        return isAssortment;
    }

    @JsonProperty("is_assortment")
    public void setIsAssortment(Boolean isAssortment) {
        this.isAssortment = isAssortment;
    }

    @JsonProperty("is_kit_master")
    public Boolean getIsKitMaster() {
        return isKitMaster;
    }

    @JsonProperty("is_kit_master")
    public void setIsKitMaster(Boolean isKitMaster) {
        this.isKitMaster = isKitMaster;
    }

}
