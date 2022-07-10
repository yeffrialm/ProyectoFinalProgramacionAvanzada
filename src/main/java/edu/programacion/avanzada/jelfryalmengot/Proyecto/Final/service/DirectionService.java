package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.service;

import edu.aluismarte.diplomado.project.domain.Employee;
import edu.aluismarte.diplomado.project.repositories.EmployeeRepository;
import edu.aluismarte.diplomado.project.week9.FactoryPattern;
import edu.aluismarte.diplomado.project.week9.network.dto.EmployeeDTO;
import edu.aluismarte.diplomado.project.week9.network.request.CreateEmployeeRequest;
import edu.aluismarte.diplomado.project.week9.network.request.DeleteEmployeeRequest;
import edu.aluismarte.diplomado.project.week9.network.request.UpdateEmployeeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author aluis on 6/26/2022.
 */
@RequiredArgsConstructor
@Service
public class DirectionService {

    private final DirectionRepository directionRepository;

    public List<DirectionDTO> getDirection() {
        return directionRepository.findAll().stream().map(FactoryPattern.DirectionDTOFactory::toDirectionDTO).collect(Collectors.toList());
    }

    public DirectionDTO createDirection(CreateDirectionRequest createDirectionRequest) {
        Direction direction = FactoryPattern.DirectionFactory.toEmployee(createDirectionRequest);
        directionRepository.save(direction);
        return direction.toDTO();
    }

    public DirectionDTO updateDirection(UpdateDirectionRequest updateDirectionRequest) {
        Direction direction = directionRepository.findById(updateDirectionRequest.getId()).orElseThrow();
        direction.applyChanges(updateDirectionRequest);
        directionRepository.save(direction);
        return direction.toDTO();
    }

    public void delete(DeleteDirectionRequest deleteDirectionRequest) {
        directionRepository.deleteById(deleteDirectionRequest.getId());
    }

}
