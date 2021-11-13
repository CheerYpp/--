package ypp.SpringFlow.flowDome.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    private static final long serialVersionUID=2L;
    private String phoneNumber;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zipCode;
}
