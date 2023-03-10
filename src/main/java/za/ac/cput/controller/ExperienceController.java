package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.factory.ExperienceFactory;
import za.ac.cput.model.Experience;
import za.ac.cput.service.ExperienceServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("api/v1/graduate-recruitment-portal-api/experience/")
public class ExperienceController {
    private final ExperienceServiceImpl experienceService;

    @Autowired
    public ExperienceController(ExperienceServiceImpl experienceService) {
        this.experienceService = experienceService;
    }

    @PostMapping("save")
    public ResponseEntity<Experience> save(@Valid @RequestBody Experience experience) {
        Experience newExperience = ExperienceFactory.build(experience.getExperienceId(), experience.getJobTitle(), experience.getAssumedRole(), experience.getStartDate(), experience.getEndDate());
        Experience experienceSaved = this.experienceService.save(newExperience);
        return ResponseEntity.ok(experienceSaved);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Experience> read(@PathVariable String id) {
        Experience readExperience= this.experienceService.read(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Experience not found"));
        return ResponseEntity.ok(readExperience);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(Experience experience) {
        this.experienceService.delete(experience);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        this.experienceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("find-all")
    public ResponseEntity<List<Experience>> findAll() {
        List<Experience> findAllTeamList = this.experienceService.findAll();
        return ResponseEntity.ok(findAllTeamList);
    }

}
