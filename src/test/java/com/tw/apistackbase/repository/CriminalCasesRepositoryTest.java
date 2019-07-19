package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.CriminalCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CriminalCasesRepositoryTest {
    @Autowired
    private CriminalCasesRepository criminalCasesRepository;
//    @Autowired
//    private CaseDetailRepository caseDetailRepository;
//    @Autowired
//    private ProcuratorateRepository procuratorateRepository;
    @Test
    public void should_add_criminal_case_when_give_vaild_criminal_case(){
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setCaseName("AAA");
        criminalCase.setIncidentTime(563363732);
        CriminalCase criminalCase1 = criminalCasesRepository.save(criminalCase);
        assertSame("AAA",criminalCase1.getCaseName());
    }
    @Test
    public void should_not_add_criminal_case_when_give_unvaild_criminal_case(){
        CriminalCase criminalCase = new CriminalCase();
        Assertions.assertThrows(Exception.class,()->{
            criminalCasesRepository.saveAndFlush(criminalCase);
        });
    }
    @Test
    public void should_return_specific_criminal_cases_when_query_function(){
        CriminalCase criminalCase = criminalCasesRepository.findById(1L).orElse(null);
        assertSame("BBBB",criminalCase.getCaseName());
        assertEquals(123143223,criminalCase.getIncidentTime());
    }
    @Test
    public void should_return_all_criminal_cases_when_query_function(){
        List<CriminalCase> criminalCases = criminalCasesRepository.findAll(new Sort(Sort.Direction.DESC,"incidentTime"));
        List<CriminalCase> sortedCriminalCases=criminalCases.stream().sorted(Comparator.comparingLong(CriminalCase::getIncidentTime).reversed()).collect(Collectors.toList());
        assertEquals(sortedCriminalCases,criminalCases);
    }
    @Test
    public void should_return_all_criminal_cases_when_find_by_caseName_function(){
        List<CriminalCase> criminalCases = criminalCasesRepository.findAllByCaseName("BBBB");
        assertEquals(2,criminalCases.size());
    }
    @Test
    public void should_return_delete_criminal_case_when_delete_function(){
        criminalCasesRepository.deleteById(1L);
        List<CriminalCase> criminalCases = criminalCasesRepository.findAll();
        assertEquals(2,criminalCases.size());
    }
//    @Test
//    public void should_specific_criminalCase_with_caseDetail_when_query_function(){
//        CriminalCase criminalCase = criminalCasesRepository.findById(Long.valueOf(1)).orElse(null);
//        Assertions.assertEquals("IHIUGIBUKB",criminalCase.getCaseDetail().getObjectiveDescription());
//        Assertions.assertEquals("DHOUHUIUYG",criminalCase.getCaseDetail().getSubjectiveDescription());
//    }
//    @Test
//    public void should_specific_criminalCase_with_procuratorate_when_query_function(){
//        CriminalCase criminalCase = criminalCasesRepository.findById(Long.valueOf(1)).orElse(null);
//        Assertions.assertEquals("LLLL",criminalCase.getProcuratorate().getName());
//    }
    @Before
    public void setUp() throws Exception {
        List<CriminalCase> criminalCases = new ArrayList<>();
        criminalCases.add(new CriminalCase("BBBB",123143223));
        criminalCases.add(new CriminalCase("BBBB",123143224));
        criminalCases.add(new CriminalCase("CCCC",764832224));
//        criminalCases.add(new CriminalCase("DDDD",640839224,new Procuratorate("UUUU")));
        criminalCasesRepository.saveAll(criminalCases);
//        caseDetailRepository.save(new CaseDetail("YGY","IUKB"));
    }
}