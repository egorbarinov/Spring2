package com.egorbarinov.springleveltwo.springintegration.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema="orders", name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long orderId;
    @JsonProperty("username")
    private String username;
    @JsonProperty("address")
    private String address;
    @JsonProperty("details")
    @OneToMany(targetEntity = OrderDetails.class,
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(schema= "orders", name = "orders_details_by_id",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private List<OrderDetails> details;
}
