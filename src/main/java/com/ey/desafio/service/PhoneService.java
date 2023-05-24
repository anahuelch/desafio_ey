package com.ey.desafio.service;

import com.ey.desafio.model.Phone;
import com.ey.desafio.repository.PhoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class PhoneService implements IPhoneService{
    private final PhoneRepository phoneRepository;

    @Override
    public List<Phone> createPhones(List<Phone> phones) {

        return phoneRepository.saveAll(phones);
    }
}
