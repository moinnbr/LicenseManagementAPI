package com.webbfontaine.training.license.managament.service;
import com.webbfontaine.training.license.managament.entity.Ministry;
import com.webbfontaine.training.license.managament.repository.MinistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class MinistryService {
    @Autowired
    private MinistryRepository ministryRepository;
    @Cacheable(value = "ministryCacheId", key = "#id", unless = "#result == null")
    public Optional<Ministry> getMinistryById(Long id) {
        return ministryRepository.findById(id);
    }

    public Ministry createMinistry(Ministry ministry) {
        return ministryRepository.save(ministry);
    }
    public Ministry updateMinistry(Long id, Ministry updatedMinistry) {
        return ministryRepository.findById(id)
                .map(existingMinistry -> {
                    existingMinistry.setName(updatedMinistry.getName());
                    existingMinistry.setDescription(updatedMinistry.getDescription());
                    return ministryRepository.save(existingMinistry);
                })
                .orElseThrow(() -> new RuntimeException("Ministry not found with id " + id));
    }
    @CacheEvict(value = "ministryCacheId", key = "#id")
    public void deleteMinistry(Long id) {
        ministryRepository.deleteById(id);
    }
    public List<Ministry> getAllMinistries() {
        return ministryRepository.findAll();
    }
}
