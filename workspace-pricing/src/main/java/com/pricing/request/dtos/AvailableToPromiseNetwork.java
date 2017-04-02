
package com.pricing.request.dtos;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "product_id",
    "id_type",
    "available_to_promise_quantity",
    "street_date",
    "availability",
    "online_available_to_promise_quantity",
    "stores_available_to_promise_quantity",
    "availability_status",
    "multichannel_options"
})
public class AvailableToPromiseNetwork {

    @JsonProperty("product_id")
    private String productId;
    @JsonProperty("id_type")
    private String idType;
    @JsonProperty("available_to_promise_quantity")
    private Float availableToPromiseQuantity;
    @JsonProperty("street_date")
    private String streetDate;
    @JsonProperty("availability")
    private String availability;
    @JsonProperty("online_available_to_promise_quantity")
    private Float onlineAvailableToPromiseQuantity;
    @JsonProperty("stores_available_to_promise_quantity")
    private Float storesAvailableToPromiseQuantity;
    @JsonProperty("availability_status")
    private String availabilityStatus;
    @JsonProperty("multichannel_options")
    private List<String> multichannelOptions = null;

    @JsonProperty("product_id")
    public String getProductId() {
        return productId;
    }

    @JsonProperty("product_id")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    @JsonProperty("id_type")
    public String getIdType() {
        return idType;
    }

    @JsonProperty("id_type")
    public void setIdType(String idType) {
        this.idType = idType;
    }

    @JsonProperty("available_to_promise_quantity")
    public Float getAvailableToPromiseQuantity() {
        return availableToPromiseQuantity;
    }

    @JsonProperty("available_to_promise_quantity")
    public void setAvailableToPromiseQuantity(Float availableToPromiseQuantity) {
        this.availableToPromiseQuantity = availableToPromiseQuantity;
    }

    @JsonProperty("street_date")
    public String getStreetDate() {
        return streetDate;
    }

    @JsonProperty("street_date")
    public void setStreetDate(String streetDate) {
        this.streetDate = streetDate;
    }

    @JsonProperty("availability")
    public String getAvailability() {
        return availability;
    }

    @JsonProperty("availability")
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @JsonProperty("online_available_to_promise_quantity")
    public Float getOnlineAvailableToPromiseQuantity() {
        return onlineAvailableToPromiseQuantity;
    }

    @JsonProperty("online_available_to_promise_quantity")
    public void setOnlineAvailableToPromiseQuantity(Float onlineAvailableToPromiseQuantity) {
        this.onlineAvailableToPromiseQuantity = onlineAvailableToPromiseQuantity;
    }

    @JsonProperty("stores_available_to_promise_quantity")
    public Float getStoresAvailableToPromiseQuantity() {
        return storesAvailableToPromiseQuantity;
    }

    @JsonProperty("stores_available_to_promise_quantity")
    public void setStoresAvailableToPromiseQuantity(Float storesAvailableToPromiseQuantity) {
        this.storesAvailableToPromiseQuantity = storesAvailableToPromiseQuantity;
    }

    @JsonProperty("availability_status")
    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    @JsonProperty("availability_status")
    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    @JsonProperty("multichannel_options")
    public List<String> getMultichannelOptions() {
        return multichannelOptions;
    }

    @JsonProperty("multichannel_options")
    public void setMultichannelOptions(List<String> multichannelOptions) {
        this.multichannelOptions = multichannelOptions;
    }

}
