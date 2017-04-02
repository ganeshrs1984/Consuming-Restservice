
package com.pricing.request.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "node_id",
    "wcs_id"
})
public class SalesClassificationNode {

    @JsonProperty("node_id")
    private String nodeId;
    @JsonProperty("wcs_id")
    private String wcsId;

    @JsonProperty("node_id")
    public String getNodeId() {
        return nodeId;
    }

    @JsonProperty("node_id")
    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    @JsonProperty("wcs_id")
    public String getWcsId() {
        return wcsId;
    }

    @JsonProperty("wcs_id")
    public void setWcsId(String wcsId) {
        this.wcsId = wcsId;
    }

}
