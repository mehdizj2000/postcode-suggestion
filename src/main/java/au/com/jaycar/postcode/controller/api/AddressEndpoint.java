package au.com.jaycar.postcode.controller.api;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.jaycar.postcode.data.domain.Address;
import au.com.jaycar.postcode.data.repo.AddressRepo;

@RestController
@RequestMapping("/api/v1")
public class AddressEndpoint {

    private AddressRepo addressRepo;
    

    @CrossOrigin("*")
    @GetMapping("/search/{term}")
    public List<Address> suggestAddress(@PathVariable("term") String search, Pageable pageable) {
	return addressRepo.findByPostcodeOrLocality(StringUtils.upperCase(search), pageable).getContent();
    }

    public AddressRepo getAddressRepo() {
	return addressRepo;
    }

    @Autowired
    public void setAddressRepo(AddressRepo addressRepo) {
	this.addressRepo = addressRepo;
    }

}
