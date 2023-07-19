package br.com.banco.service;

import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TransferenciaServiceTest {

    @Mock
    private TransferenciaRepository transferenciaRepository;

    @InjectMocks
    private TransferenciaService transferenciaService;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getTransferenciasByContaId() {
        Integer contaId = 1;
        LocalDate startDate = LocalDate.of(2023, 7, 1);
        LocalDate endDate = LocalDate.of(2023, 7, 31);
        String nomeOperadorTransacao = "Operador";

        List<Transferencia> transfers = new ArrayList<>();

        List<Transferencia> result = transferenciaService.getTransferenciasByContaId(contaId, startDate, endDate, nomeOperadorTransacao);

        assertEquals(transfers, result);
    }
}