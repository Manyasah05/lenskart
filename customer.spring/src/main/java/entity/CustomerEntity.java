package entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "CustomerTable")
public class CustomerEntity {
    @Id
    private long id;


    @Column(name = "Customer Name")
    private String name;

    private String email;
    private String number;
    private String city;
    @OneToMany (fetch = FetchType.EAGER)
    @JoinColumn (name = "AddressId")
    private entity.address address;
}
