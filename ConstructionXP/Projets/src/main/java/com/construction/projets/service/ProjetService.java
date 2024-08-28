package com.construction.projets.service;

import com.construction.projets.dto.ProjetDTO;
import com.construction.projets.mapper.ProjetMapper;
import com.construction.projets.model.Projet;
import com.construction.projets.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjetService {

    @Autowired
    private ProjetRepository projetRepository;

    @Autowired
    private ProjetMapper projetMapper;

    public List<ProjetDTO> getAllProjets() {
        return projetRepository.findAll()
                .stream()
                .map(projetMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProjetDTO getProjetById(Long id) {
        return projetRepository.findById(id)
                .map(projetMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Projet not found"));
    }

    public ProjetDTO createProjet(ProjetDTO projetDTO) {
        Projet projet = projetMapper.toEntity(projetDTO);
        Projet savedProjet = projetRepository.save(projet);
        return projetMapper.toDto(savedProjet);
    }

    public ProjetDTO updateProjet(Long id, ProjetDTO projetDTO) {
        return projetRepository.findById(id)
                .map(projet -> {
                    projet.setName(projetDTO.getName());
                    projet.setDescription(projetDTO.getDescription());
                    projet.setStartDate(projetDTO.getStartDate());
                    projet.setEndDate(projetDTO.getEndDate());
                    projet.setBudget(projetDTO.getBudget());
                    Projet updatedProjet = projetRepository.save(projet);
                    return projetMapper.toDto(updatedProjet);
                })
                .orElseThrow(() -> new RuntimeException("Projet not found"));
    }

    public void deleteProjet(Long id) {
        projetRepository.deleteById(id);
    }
}
