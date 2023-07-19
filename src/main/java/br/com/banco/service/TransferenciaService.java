package br.com.banco.service;

import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransferenciaService {

    private final TransferenciaRepository transferenciaRepository;

    public TransferenciaService(TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }

    public List<Transferencia> getTransferenciasByContaId(
            Integer contaId, LocalDate startDate, LocalDate endDate, String nomeOperadorTransacao) {

        Specification<Transferencia> specification = Specification.where((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("conta").get("idConta"), contaId));

        if (startDate != null) {
            LocalDateTime startDateTime = startDate.atStartOfDay();
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.greaterThanOrEqualTo(root.get("dataTransferencia"), startDateTime));
        }

        if (endDate != null) {
            LocalDateTime endDateTime = endDate.atStartOfDay().plusDays(1);
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.lessThanOrEqualTo(root.get("dataTransferencia"), endDateTime));
        }

        if (nomeOperadorTransacao != null) {
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("nomeOperadorTransacao"), nomeOperadorTransacao));
        }

        return transferenciaRepository.findAll(specification);
    }
}
