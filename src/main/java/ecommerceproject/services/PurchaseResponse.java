package ecommerceproject.services;

import lombok.Data;
import lombok.NonNull;

// Sends back Java class object as JSON
@Data
public class PurchaseResponse {
    @NonNull
    private String orderTrackingNumber;

    public PurchaseResponse(String orderTrackingNumber){
        this.orderTrackingNumber=orderTrackingNumber;
    }
}
