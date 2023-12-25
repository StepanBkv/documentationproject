package com.documentation.volume.service;

import com.documentation.volume.DTO.ValueDto;
import com.documentation.volume.model.Contingent;
import com.documentation.volume.model.Speciality;
import com.documentation.volume.model.Version;
import com.documentation.volume.model.discipline.Discipline;
import com.documentation.volume.model.discipline.DisciplineGeneral;
import com.documentation.volume.repository.ContingentRepository;
import com.documentation.volume.repository.SpecialityRepository;
import com.documentation.volume.repository.VersionRepository;
import com.documentation.volume.repository.discipline.ControlTypeRepository;
import com.documentation.volume.repository.discipline.DisciplineGeneralRepository;
import com.documentation.volume.repository.discipline.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValueServiceImpl implements ValueService{
    @Autowired
    private VersionRepository versionRepository;
    @Autowired
    private SpecialityRepository specialityRepository;

    @Autowired
    private ContingentRepository contingentRepository;

    @Autowired
    private DisciplineGeneralRepository disciplineGeneralRepository;

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Autowired
    private ControlTypeRepository controlTypeRepository;

    @Override
    public ValueDto read(Long id) {
        ValueDto valueDto = new ValueDto();
        Optional<DisciplineGeneral> optionalDisciplineGeneral = disciplineGeneralRepository.findById(id);
        DisciplineGeneral disciplineGeneral = optionalDisciplineGeneral.isPresent() ? optionalDisciplineGeneral.get() : null;
        valueDto.setId(id);
        if (disciplineGeneral != null){
            Optional<Contingent> optionalContingent = contingentRepository.findById(disciplineGeneral.getContingentId());
            Contingent contingent = optionalContingent.isPresent() ? optionalContingent.get() : null;
            Optional<Speciality> optionalSpeciality = specialityRepository.findById(disciplineGeneral.getSpecialityId());
            Speciality speciality = optionalSpeciality.isPresent() ? optionalSpeciality.get() : null;
            Optional<Version> optionalVersion = versionRepository.findById(disciplineGeneral.getVersionId());
            Version version = optionalVersion.isPresent() ? optionalVersion.get() : null;
            Optional<Discipline> optionalDiscipline = disciplineRepository.findById(id);
            Discipline discipline = optionalDiscipline.isPresent() ? optionalDiscipline.get() : null;
            valueDto.setDiscipline_name(discipline.getDisciplineName());
            valueDto.setDisciplineCode(discipline.getDisciplineCode());
            valueDto.setAcademicYear(version.getAcademicYear());
            valueDto.setSpecialityCode(speciality.getSpeciality_code());
            valueDto.setContingentContract(contingent.getContingent_contract());
            valueDto.setContingentBudget(contingent.getContingent_budget());
            valueDto.setVersion_id(Math.toIntExact(disciplineGeneral.getVersionId()));
            Integer contingentAll = contingent.getContingent_budget()+contingent.getContingent_contract();
            //Высчитываем объёмы
            valueDto.setBudgetValueLecture((contingent.getContingent_budget()*contingent.getNumber_lecture_streams()*discipline.getLecture())/contingentAll);
            valueDto.setContractValueLecture((contingent.getContingent_contract()*contingent.getNumber_lecture_streams()*discipline.getLecture())/contingentAll);
            valueDto.setBudgetValueLaboratory((contingent.getContingent_budget()*contingent.getNumber_subgroups()*discipline.getLaboratory())/contingentAll);
            valueDto.setContractValueLaboratory((contingent.getContingent_contract()*contingent.getNumber_subgroups()*discipline.getLaboratory())/contingentAll);
            List <String> controlType = List.of(discipline.getControlType().getName().split("/"));
            for(String word: controlType){
                if (word.equals("зачёт")){
                    valueDto.setOffset(Double.valueOf(contingent.getNumber_groups())*2);
                }
                if (word.equals("экзамен")){
                    valueDto.setConsultation_exam(Double.valueOf(contingentAll)/4);
                    valueDto.setExam(Double.valueOf(contingentAll)*0.3);
                }
            }
            valueDto.setBudget(Double.valueOf(valueDto.getBudgetValueLaboratory()+ valueDto.getBudgetValueLecture()
                    +(valueDto.getOffset()+valueDto.getConsultation_exam()+ valueDto.getExam())*contingent.getContingent_budget()/contingentAll));
            valueDto.setContract(Double.valueOf(valueDto.getContractValueLaboratory()+ valueDto.getContractValueLecture()
                    +(valueDto.getOffset()+valueDto.getConsultation_exam()+ valueDto.getExam())*contingent.getContingent_contract()/contingentAll));
        }
            valueDto.setValueAll(valueDto.getBudget()+valueDto.getContract());
        return valueDto;
    }

}
