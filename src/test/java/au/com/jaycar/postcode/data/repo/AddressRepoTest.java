package au.com.jaycar.postcode.data.repo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//import static org.hamcrest.Matchers;
//import org.hamcrest.MatcherAssert;

import au.com.jaycar.postcode.data.domain.Address;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
class AddressRepoTest {

    @Autowired
    AddressRepo addressRepo;

    @Test
    void testFindByPostCodeOrLocality() {
	
	Pageable pageable = PageRequest.of(0, 5);

	Page<Address> optAddr = addressRepo.findByPostcodeOrLocality("2099", pageable);

	assertNotNull(optAddr);
	
	assertFalse(optAddr.isEmpty());

	log.info(ToStringBuilder.reflectionToString(optAddr.getContent(), ToStringStyle.JSON_STYLE));
    }

}
