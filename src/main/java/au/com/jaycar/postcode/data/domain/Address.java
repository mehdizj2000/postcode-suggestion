package au.com.jaycar.postcode.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Address {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "POSTCODE")
    private String postcode;

    @Column(name = "SUBURB")
    private String locality;

//    @Column(name = "STATE")
//    private String state;
    
    @Column(name="LONGITUDE")
    private String longitude;
    
    @Column(name="LATITUDE")
    private String latitude;

}
