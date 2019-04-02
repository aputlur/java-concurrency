package org.springboot.starter.web.rest;

import org.springboot.starter.web.model.Question;
import org.springboot.starter.web.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SurveyRestController {

    @Autowired
    private SurveyService service;

    @GetMapping("/surveys/{id}/questions")
    public List<Question> getSurveyId(@PathVariable String id) {
        return service.retrieveQuestions(id);
    }

    @GetMapping("/surveys/{id}/questions/{questionId}")
    public Question getQuestionById(@PathVariable String id, @PathVariable String questionId) {
        return service.retrieveQuestion(id, questionId);
    }

    @PostMapping("/surveys/{id}/questions")
    public ResponseEntity<Void> createQuestionById(@PathVariable String id, @RequestBody Question newQuestion) {

        Question question = service.addQuestion(id, newQuestion);
        final URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}").buildAndExpand(question.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/surveys/{id}/questions/{questionId}")
    public ResponseEntity<Void> deleteQuestionById(@PathVariable String id, @PathVariable String questionId) {
        if (service.retrieveQuestion(id, questionId) != null) {
            service.deleteQuestion(id, questionId);
            return ResponseEntity.accepted().build();
        }

        return ResponseEntity.notFound().build();

    }

}
