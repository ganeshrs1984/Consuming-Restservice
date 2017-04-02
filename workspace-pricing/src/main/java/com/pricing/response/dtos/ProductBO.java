package com.pricing.response.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"status",
    "id",
    "name",
    "current_price",
    "error_message",
    "message"
    
})

public class ProductBO {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("status")
    private int status;
    @JsonProperty("name")
    private String name;
    @JsonProperty("current_price")
    private Price currentPrice;
    @JsonProperty("error_message")
    private String error;
    @JsonProperty("message")
    private String message;
    
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("current_price")
    public Price getCurrentPrice() {
        return currentPrice;
    }

    @JsonProperty("current_price")
    public void setCurrentPrice(Price currentPrice) {
        this.currentPrice = currentPrice;
    }

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toString(){
		return "status=" + status + " productId=" + id + " name=" +name + " error=" + error + " message="+message;
	}
	
}
