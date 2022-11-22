package com.example.springproject.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class CKOrderDetail implements Serializable {
    private Long orderId;
    private Long productId;

    public CKOrderDetail(Long orderId, Long productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public CKOrderDetail() {

    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        final Long prime = Long.valueOf(31);
       Long result = Long.valueOf(1);
        result = prime * result + orderId;
        result = prime * result + productId;
        return Math.toIntExact(result);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CKOrderDetail ckOrderDetail= (CKOrderDetail) obj;
        if (orderId != ckOrderDetail.orderId)
            return false;
        if (productId!= ckOrderDetail.productId)
            return false;
        return true;
    }
}
