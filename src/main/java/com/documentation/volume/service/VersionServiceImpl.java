package com.documentation.volume.service;

import com.documentation.volume.DTO.VersionDto;
import com.documentation.volume.mapper.VersionMapper;

import com.documentation.volume.model.Version;
import com.documentation.volume.repository.VersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VersionServiceImpl implements VersionService{

    @Autowired
    private VersionRepository versionRepository;
    @Autowired
    private VersionMapper versionMapper;
    @Override
    public VersionDto create(VersionDto versionDto) {
        Version version = versionMapper.toModel(versionDto);
        version = versionRepository.save(version);
        return versionMapper.toDto(version);
    }

    @Override
    public List<VersionDto> readAll() {
        List<Version> versions = versionRepository.findAll();

        return versions.stream().map(versionMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<VersionDto> findAllByDepartmentId(int id){
        List<Version> versions = versionRepository.findAllByDepartmentId(id);

        return versions.stream().map(versionMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public VersionDto read(int id) {
        Optional<Version> optionalVersion = versionRepository.findById(id);

        Version version = optionalVersion.isPresent() ? optionalVersion.get() : null;
        return versionMapper.toDto(version);
    }

    @Override
    public VersionDto update(VersionDto versionDto, int id) {
        if(versionRepository.existsById(id)){
            Version version = versionMapper.toModel(versionDto);
            version.setId(id);
            version = versionRepository.save(version);
            return versionMapper.toDto(version);
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        if (versionRepository.existsById(id)){
            versionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
