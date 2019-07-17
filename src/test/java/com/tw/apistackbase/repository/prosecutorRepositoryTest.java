package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Procuratorate;
import com.tw.apistackbase.entity.Prosecutor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class prosecutorRepositoryTest {
    @Autowired
    private ProsecutorRepository prosecutorRepository;
    @Test
    public void should_procuratorate_when_query_function(){
        Prosecutor prosecutor=prosecutorRepository.findById(Long.valueOf(1)).orElse(null);
        assertEquals("AAAA",prosecutor.getName());
    }
    @Before
    public void setUp() throws Exception {
        List<Prosecutor> prosecutors = new ArrayList<>();
        prosecutors.add(new Prosecutor("AAAA"));
        prosecutors.add(new Prosecutor("BBBB"));
        prosecutorRepository.saveAll(prosecutors);
    }

}