package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.CaseDetail;
import com.tw.apistackbase.entity.CriminalCase;
import com.tw.apistackbase.entity.Procuratorate;
import com.tw.apistackbase.entity.Prosecutor;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProcuratorateRepositoryTest {
    @Autowired
    private ProcuratorateRepository procuratorateRepository;
    @Test
    public void should_procuratorate_when_query_function(){
       Procuratorate procuratorate=procuratorateRepository.findById(1L).orElse(null);
       assertEquals("AAAA",procuratorate.getName());
    }
    @Test
    public void should_procuratorate_with_prosecutors_when_query_function(){
        Procuratorate procuratorate=procuratorateRepository.findById(1L).orElse(null);
        assertEquals(2,procuratorate.getProsecutors().size());
    }
    @Before
    public void setUp() throws Exception {
        List<Procuratorate> procuratorates = new ArrayList<>();
        List<Prosecutor> prosecutors = new ArrayList<>();
        prosecutors.add(new Prosecutor("RLULE"));
        prosecutors.add(new Prosecutor("Varua"));
        procuratorates.add(new Procuratorate("AAAA",prosecutors));
        procuratorates.add(new Procuratorate("BBBB"));
        procuratorateRepository.saveAll(procuratorates);
    }
}