package org.acme.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@NamedQueries(value =  {@NamedQuery(name = "ShoppingCart.findAll",
                                    query = "SELECT c " +
                                            "FROM ShoppingCart c " +
                                            "LEFT JOIN FETCH c.cartItems item LEFT " +
                                            "JOIN FETCH item.product"),
                        @NamedQuery(name = "ShoppingCart.findById",
                                    query = "SELECT c " +
                                            "FROM ShoppingCart c " +
                                            "LEFT JOIN FETCH c.cartItems item " +
                                            "LEFT JOIN FETCH item.product " +
                                            "WHERE c.id = ?1")})
public class ShoppingCart {

}
