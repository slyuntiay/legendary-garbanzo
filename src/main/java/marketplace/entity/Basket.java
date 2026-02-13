package marketplace.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import marketplace.dto.basketDto.BasketRequestDto;
import marketplace.service.customerService.CustomerService;
import marketplace.service.productService.ProductService;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@Entity
//@Table
////public class Basket extends BaseEntity {
////
//////    @ManyToOne
//////    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
//////    private Customer customer;
//////
//////    @ManyToOne
//////    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
//////    private Product product;
//////
//////    @Column(nullable = false)
//////    private int quantity;
//////
//////    public Basket(BasketRequestDto basketRequestDto, CustomerService customerService, ProductService productService) {
//////        this.customer = customerService.find(basketRequestDto.getClientId()).orElseThrow();
//////        this.product = productService.find(basketRequestDto.getProductId()).orElseThrow();
//////        this.quantity = basketRequestDto.getQuantity();
//////    }
//////}
