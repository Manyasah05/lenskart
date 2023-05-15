package entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table ( name ="ProductAddress")
@RequiredArgsConstructor
@Getter
@Setter


public class address {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long addressId;

    private String state;

    private String  city;
    private String pinCode;
    private String flatNumber;
    @ManyToOne (fetch = FetchType.EAGER)
    private CustomerEntity customer;


}
