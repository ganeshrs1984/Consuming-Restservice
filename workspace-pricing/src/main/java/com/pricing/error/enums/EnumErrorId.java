package com.pricing.error.enums;

public enum EnumErrorId {
	
	 TD("TECHNICAL_DIFFICULTY"),
	 ICC("INVALID_CURRENCY_CODE"),
	 IP("INVALID_PRICE"),
	 FE("FORMAT_EXCEPTION"),
	 DP("DUPLICATE"),
	 PNF("PRODUCT_ID_NOT_FOUND"),
	 IPD("INVALID_PRODUCTID");
	
	    private String value;

	    EnumErrorId(String value) {
	        this.value = value;
	    }
	    
	    String getError(){	    	
			return value;	    	
	    }
	    
}
